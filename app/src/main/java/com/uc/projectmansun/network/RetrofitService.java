package com.uc.projectmansun.network;

import com.google.gson.JsonObject;
import com.uc.projectmansun.model.response.DivisiResponse;
import com.uc.projectmansun.model.response.PeriodeResponse;
import com.uc.projectmansun.model.response.ProfilResponse;
import com.uc.projectmansun.model.response.ProkerResponse;
import com.uc.projectmansun.model.response.TaskResponse;
import com.uc.projectmansun.model.response.TokenResponse;
import com.uc.projectmansun.util.Constants;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private final ApiEndPoints api;
    private static RetrofitService service;
    private static final String TAG = "RetrofitService";

    public RetrofitService(String token) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        if (token.equals("")){
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                .addHeader("Accept", "application/json").build();
                return chain.proceed(request);
            });
        }else{
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", token)
                        .build();
                return chain.proceed(request);
            });
        }
        api = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
                .create(ApiEndPoints.class);
    }

    public static RetrofitService getInstance(String token){
        if (service == null){
            service = new RetrofitService(token);
        }else if (!token.equals("")){
            service = new RetrofitService(token);
        }
        return service;
    }

    public Call<TokenResponse> login(String email, String password){
        return api.login(email, password);
    }

    public Call<PeriodeResponse> getPeriode(){return api.getPeriode();}

    public Call<ProkerResponse> getProker(int id){
        return api.getProker(id);
    }

    public Call<ProfilResponse> getProfil(){
        return api.getProfil();
    }

    public Call<DivisiResponse> getDivisi(){
        return api.getDivisi();
    }

    public Call<TaskResponse> getTask(){
        return api.getTask();
    }

    public Call<JsonObject> logout(){
        return api.logout();
    }
}
