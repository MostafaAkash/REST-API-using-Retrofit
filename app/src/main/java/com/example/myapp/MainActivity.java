package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Adapter.PersonAdapter;
import com.example.myapp.Model.Person;
import com.example.myapp.Model.Search;
import com.example.myapp.ViewModel.PersonViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PersonAdapter.RecycleViewClickListener {
    public static final String EXTRA_ID="personId";
    public static final String EXTRA_NAME="personName";
    public static final String EXTRA_MOBILE_NUMBER="personMobileNumber";
    public static final String EXTRA_IMAGE_URL="imageUrl";
    public static final String EXTRA_PROFESSION="profession";

    private List<Person> personList;
    private RecyclerView recyclerView;
    private PersonAdapter personAdapter;
    private PersonViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intialization();


        Call<Search> personCall = viewModel.getAllFromSearchObject();
        personCall.enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Code " + response.code(), Toast.LENGTH_SHORT).show();
                }
                Search search = response.body();
                personList = search.getPersons();

                createRecycleView();

            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {


            }
        });


    }

    private void intialization() {
        personList = new ArrayList<>();
        viewModel = new PersonViewModel();
        recyclerView = findViewById(R.id.recycleViewIdMain);

    }

    private void createRecycleView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        personAdapter = new PersonAdapter(this, personList);
        personAdapter.setListenerOnRecycleView(this);
        recyclerView.setAdapter(personAdapter);

    }

    @Override
    public void onItemClickListenerOnRecycleView(int position) {
        Intent intent = new Intent(this,DetailsInfo.class);
        Person person = personList.get(position);
        intent.putExtra(EXTRA_ID,person.getId());
        intent.putExtra(EXTRA_NAME,person.getName());
        intent.putExtra(EXTRA_IMAGE_URL,person.getImageUrl());
        intent.putExtra(EXTRA_PROFESSION,person.getProfession());
        intent.putExtra(EXTRA_MOBILE_NUMBER,person.getMobileNumber());
        startActivity(intent);

    }
}
