package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.myapp.MainActivity.EXTRA_ID;
import static com.example.myapp.MainActivity.EXTRA_IMAGE_URL;
import static com.example.myapp.MainActivity.EXTRA_MOBILE_NUMBER;
import static com.example.myapp.MainActivity.EXTRA_NAME;
import static com.example.myapp.MainActivity.EXTRA_PROFESSION;

public class DetailsInfo extends AppCompatActivity {
    private ImageView imageView;
    private TextView textViewId;
    private TextView textViewName;
    private TextView textViewMobileNUmber;
    private TextView textViewProfession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info);

        intialization();

        Intent intent = getIntent();
        String id = intent.getStringExtra(EXTRA_ID);
        String name = intent.getStringExtra(EXTRA_NAME);
        String mobileNumber = intent.getStringExtra(EXTRA_MOBILE_NUMBER);
        String profession = intent.getStringExtra(EXTRA_PROFESSION);
        String imageUrl = intent.getStringExtra(EXTRA_IMAGE_URL);

        textViewId.setText(id);
        textViewName.setText(name);
        textViewMobileNUmber.setText(mobileNumber);
        textViewProfession.setText(profession);
        Glide.with(this).load(imageUrl).into(imageView);


    }

    private void intialization() {
        imageView = findViewById(R.id.imageViewInDetailsAc);
        textViewName = findViewById(R.id.showNameInDetailsAc);
        textViewMobileNUmber = findViewById(R.id.showMobileNumberInDetailsAc);
        textViewProfession = findViewById(R.id.showProfessionInDetailsAc);
        textViewId = findViewById(R.id.showIdInDetailsAc);
    }
}
