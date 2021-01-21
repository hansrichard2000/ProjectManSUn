package com.uc.projectmansun.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.uc.projectmansun.model.local.Divisi;
import com.uc.projectmansun.model.response.DivisiResponse;
import com.uc.projectmansun.network.RetrofitService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DivisiRepository {
    private static DivisiRepository divisiRepository;
    private RetrofitService apiService;
    private static final String TAG = "DivisiRepository";

    private DivisiRepository(String token) {
        Log.d(TAG, "DivisiRepository: "+ token);
        apiService = RetrofitService.getInstance(token);
    }

    public static DivisiRepository getInstance(String token){
        if (divisiRepository == null){
            divisiRepository = new DivisiRepository(token);
        }
        return divisiRepository;
    }

    public synchronized void resetInstance(){
        if (divisiRepository != null){
            divisiRepository = null;
        }
    }

    public MutableLiveData<List<Divisi>> getDivisi(int id){
        MutableLiveData<List<Divisi>> listDivisi = new MutableLiveData<>();

        apiService.getDivisi(id).enqueue(new Callback<DivisiResponse>() {
            @Override
            public void onResponse(Call<DivisiResponse> call, Response<DivisiResponse> response) {
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d(TAG, "onResponse" + response.body().getResults().size());
                        listDivisi.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<DivisiResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listDivisi;
    }
}
