package com.uc.projectmansun.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.uc.projectmansun.model.local.DivisiRoleUser;
import com.uc.projectmansun.model.local.Profil;
import com.uc.projectmansun.model.response.DivisiRoleUserResponse;
import com.uc.projectmansun.model.response.ProfilResponse;
import com.uc.projectmansun.network.RetrofitService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DivisiRoleUserRepository {
    private static DivisiRoleUserRepository divisiRoleUserRepository;
    private RetrofitService apiService;
    private static final String TAG = "DRU_Repository";

    private DivisiRoleUserRepository (String token){
        Log.d(TAG, "DivisiRoleUserRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static DivisiRoleUserRepository getInstance(String token){
        if (divisiRoleUserRepository == null){
            divisiRoleUserRepository = new DivisiRoleUserRepository(token);
        }

        return divisiRoleUserRepository;
    }

    public synchronized void resetInstance(){
        if (divisiRoleUserRepository != null){
            divisiRoleUserRepository = null;
        }
    }

    public MutableLiveData<List<DivisiRoleUser>> getDivisiRoleUser(){
        MutableLiveData<List<DivisiRoleUser>> listDivisiRoleUser = new MutableLiveData<>();

        apiService.getDivisiRoleUser().enqueue(new Callback<DivisiRoleUserResponse>() {
            @Override
            public void onResponse(Call<DivisiRoleUserResponse> call, Response<DivisiRoleUserResponse> response) {
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d(TAG, "onResponse: "+response.body().getResults().size());
                        listDivisiRoleUser.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<DivisiRoleUserResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listDivisiRoleUser;
    }

    public LiveData<String> logout(){
        MutableLiveData<String> message = new MutableLiveData<>();

        apiService.logout().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        try {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String msg = object.getString("message");
                            Log.d(TAG, "onResponse: " + msg);
                            message.postValue(msg);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

        return message;
    }
}

