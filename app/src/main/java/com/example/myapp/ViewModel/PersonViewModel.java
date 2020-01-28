package com.example.myapp.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.myapp.Model.Search;
import com.example.myapp.Repo.PersonRepository;

import retrofit2.Call;

public class PersonViewModel extends ViewModel {
    private PersonRepository repository;

    public PersonViewModel() {
        repository = new PersonRepository();
    }

    public Call<Search> getAllFromSearchObject()
    {
        return repository.getPersonCall();
    }
}
