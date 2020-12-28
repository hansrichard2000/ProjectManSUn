package com.uc.projectmansun.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.uc.projectmansun.model.local.Profil;
import com.uc.projectmansun.model.response.ProfilResponse;
import com.uc.projectmansun.network.RetrofitService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilRepository {
    private static ProfilRepository profilRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProfilRepository";

    private ProfilRepository (String token){
        Log.d(TAG, "ProfilRepository: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ProfilRepository getInstance(String token){
        if (profilRepository == null){
            profilRepository = new ProfilRepository(token);
        }

        return profilRepository;
    }

    public synchronized void resetInstance(){
        if (profilRepository != null){
            profilRepository = null;
        }
    }

    public MutableLiveData<List<Profil>> getProfil(){
        MutableLiveData<List<Profil>> listProfil = new MutableLiveData<>();

        apiService.getProfil().enqueue(new Callback<ProfilResponse>() {
            @Override
            public void onResponse(Call<ProfilResponse> call, Response<ProfilResponse> response) {
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d(TAG, "onResponse: "+response.body().getResults().size());
                        listProfil.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProfilResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listProfil;
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
