package com.uc.projectmansun.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.uc.projectmansun.model.local.Proker;
import com.uc.projectmansun.model.response.ProkerResponse;
import com.uc.projectmansun.network.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProkerRepository {
    private static ProkerRepository prokerRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProkerRepository";

    private ProkerRepository(String token){
        Log.d(TAG, "ProkerRepository: "+ token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ProkerRepository getInstance(String token){
        if (prokerRepository == null){
            prokerRepository = new ProkerRepository(token);
        }
        return prokerRepository;
    }

    public synchronized void resetInstance(){
        if (prokerRepository != null){
            prokerRepository = null;
        }
    }

    public MutableLiveData<List<Proker>> getProker(){
        MutableLiveData<List<Proker>> listProker = new MutableLiveData<>();

        apiService.getProker().enqueue(new Callback<ProkerResponse>() {
            @Override
            public void onResponse(Call<ProkerResponse> call, Response<ProkerResponse> response) {
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d(TAG, "onResponse" + response.body().getResults().size());
                        listProker.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<ProkerResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listProker;
    }
}
