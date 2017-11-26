package com.application.demo.network;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Shailesh on 24/11/17.
 */

public class Response {

    @SerializedName("response")
    private  LanguageResponse response;
    private  boolean success;

    public LanguageResponse getResponse() {
        return response;
    }

    public void setResponse(LanguageResponse response) {
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    private  boolean authenticated;



}
