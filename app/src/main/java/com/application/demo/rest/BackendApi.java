package com.application.demo.rest;

import com.application.demo.network.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Shailesh on 25/11/17.
 */

public class BackendApi {

    public static ApiInterface API;
    static{
       API =  ApiClient.getClient().create(ApiInterface.class);
    }

    public  interface ApiInterface {

        @GET("/task")
        Call<Response> getProgramingLanuages(@Query("page") int page);
    }
}
