package com.uc.projectmansun.network;

import com.google.gson.JsonObject;
import com.uc.projectmansun.model.response.DivisiResponse;
import com.uc.projectmansun.model.response.PeriodeResponse;
import com.uc.projectmansun.model.response.ProfilResponse;
import com.uc.projectmansun.model.response.ProkerResponse;
import com.uc.projectmansun.model.response.TaskResponse;
import com.uc.projectmansun.model.response.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiEndPoints {

    @POST("api-login")
    @FormUrlEncoded
    Call<TokenResponse> login(@Field("email") String email, @Field("password") String password);

    @GET("periode")
    Call<PeriodeResponse> getPeriode();

    @GET("periode/{periode}")
    Call<ProkerResponse> getProker(@Path("periode") int periodeId);

    @GET("proker/{proker}")
    Call<DivisiResponse> getDivisi(@Path("proker") int prokerId);

    @GET("divisi/{divisi}")
    Call<TaskResponse> getTask(@Path("divisi") int divisiId);

    @GET("jadwal")
    Call<TaskResponse> getJadwalTask();

    @GET("profil")
    Call<ProfilResponse> getProfil();

    @POST("api-logout")
    Call<JsonObject> logout();
}
