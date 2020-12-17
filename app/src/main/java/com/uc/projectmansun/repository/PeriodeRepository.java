package com.uc.projectmansun.repository;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.uc.projectmansun.model.local.Periode;
import com.uc.projectmansun.model.response.PeriodeResponse;
import com.uc.projectmansun.network.RetrofitService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeriodeRepository {
    private static PeriodeRepository periodeRepository;
    private RetrofitService apiService;
    private static final String TAG = "PeriodeRepository";

    private PeriodeRepository(String token) {
        Log.d(TAG, "PeriodeRepository: "+ token);
        apiService = RetrofitService.getInstance(token);
    }

    public static PeriodeRepository getInstance(String token){
        if (periodeRepository == null){
            periodeRepository = new PeriodeRepository(token);
        }
        return periodeRepository;
    }

    public synchronized void resetInstance(){
        if (periodeRepository != null){
            periodeRepository = null;
        }
    }

    public MutableLiveData<List<Periode>> getPeriode(){
        MutableLiveData<List<Periode>> listPeriode = new MutableLiveData<>();

        apiService.getPeriode().enqueue(new Callback<PeriodeResponse>() {
            @Override
            public void onResponse(Call<PeriodeResponse> call, Response<PeriodeResponse> response) {
                Log.d(TAG, "onResponse: "+response.code());
                if (response.isSuccessful()){
                    if (response.body() != null){
                        Log.d(TAG, "onResponse" + response.body().getResults().size());
                        listPeriode.postValue(response.body().getResults());
                    }
                }
            }

            @Override
            public void onFailure(Call<PeriodeResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return listPeriode;
    }

    public MutableLiveData<String> logout(){
        MutableLiveData<String> messsage = new MutableLiveData<>();

        apiService.logout().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()){
                    if (response.body()!=null){
                        try {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String msg = object.getString("message");
                            Log.d(TAG, "onResponse: " + msg);
                            messsage.postValue(msg);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        return messsage;
    }
}
