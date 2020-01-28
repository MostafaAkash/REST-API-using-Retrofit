package com.example.myapp.JPlaceHolder;

import com.example.myapp.Model.Search;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderObject {
    @GET("bins/15baeq")
    Call<Search> getAllItem();
}
