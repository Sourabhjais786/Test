package com.example.test;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("users")
    Call<List<ModelClass>> getName();
}
