package com.uc.projectmansun.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.uc.projectmansun.network.RetrofitService;

import org.json.JSONException;
import org.json.JSONObject;

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
