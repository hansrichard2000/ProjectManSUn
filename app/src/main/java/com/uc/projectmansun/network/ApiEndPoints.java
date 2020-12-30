package com.uc.projectmansun.network;

import com.google.gson.JsonObject;
import com.uc.projectmansun.model.response.PeriodeResponse;
import com.uc.projectmansun.model.response.ProfilResponse;
import com.uc.projectmansun.model.response.ProkerResponse;
import com.uc.projectmansun.model.response.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoints {

    @POST("api-login")
    @FormUrlEncoded
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @GET("periode")
    Call<PeriodeResponse> getPeriode();

    @GET("periode/{periode}")
    Call<ProkerResponse> getProker();

//    @GET("proker/{proker}")

    @GET("profil")
    Call<ProfilResponse> getProfil();

    @POST("api-logout")
    Call<JsonObject> logout();
}
