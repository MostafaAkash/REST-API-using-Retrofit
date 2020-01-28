package com.example.myapp.Repo;

import android.app.Application;

import com.example.myapp.DataSource.RetrofitClient;
import com.example.myapp.JPlaceHolder.JsonPlaceHolderObject;
import com.example.myapp.Model.Search;

import retrofit2.Call;
import retrofit2.Retrofit;

public class PersonRepository {
    private JsonPlaceHolderObject jsonPlaceHolderObject;
    private Call<Search>personCall;
    public PersonRepository()
    {
        Retrofit retrofit = RetrofitClient.getInstance();
        jsonPlaceHolderObject = retrofit.create(JsonPlaceHolderObject.class);
        personCall = jsonPlaceHolderObject.getAllItem();
    }

    public Call<Search> getPersonCall() {
        return personCall;
    }
}
