package com.wisma.jobhunter.Services;

import com.wisma.jobhunter.Services.Model.ServerDefaultResponse;
import com.wisma.jobhunter.Services.Model.Users;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Services {

    @FormUrlEncoded
    @POST("/api/reglog/login")
    Call<Users> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/api/reglog/register")
    Call<ServerDefaultResponse> register(
            @Field("nama") String nama,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            @Field("no_hp") String no_hp,
            @Field("bio") String bio,
            @Field("tanggal_lahir") String tanggal_lahir
    );
}
