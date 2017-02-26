package com.cybereyestudios.payitforward;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Samuel Rabinowitz on 2/25/2017.
 */

public interface PayItForwardApi {

    @POST("signup.php")
    @FormUrlEncoded
    Call<JsonElement> signUp(@Field("name") String name,
                             @Field("email") String email,
                             @Field("password") String password,
                             @Field("city_id") int city_id
    );

    @GET("cities.php")
    Call<ArrayList<City>> getCities();

    @POST("signin.php")
    @FormUrlEncoded
    Call<JsonElement> signIn(@Field("email") String email,
                             @Field("password") String password
    );

}
