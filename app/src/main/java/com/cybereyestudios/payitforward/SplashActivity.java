package com.cybereyestudios.payitforward;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PayItForwardApi client = retrofit.create(PayItForwardApi.class);

        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
