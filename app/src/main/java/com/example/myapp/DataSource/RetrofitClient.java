package com.example.myapp.DataSource;

import android.content.Context;

import com.example.myapp.JPlaceHolder.JsonPlaceHolderObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitClient {
    private static Retrofit  retrofit=null;
    public static Retrofit getInstance()
    {
        if(retrofit==null)
        {
            Gson gson = new GsonBuilder().serializeNulls().create();

             retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.myjson.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;

    }
}
