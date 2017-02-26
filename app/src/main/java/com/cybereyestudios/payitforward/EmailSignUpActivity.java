package com.cybereyestudios.payitforward;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmailSignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextNameSignUp, editTextEmailSignUp, editTextPasswordSignUp;
    Spinner spinnerCitySignUp;
    Button buttonSignUp;

    Retrofit retrofit;
    PayItForwardApi payItForwardApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sign_up);

        // Set up Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.BASE_URL))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        payItForwardApi = retrofit.create(PayItForwardApi.class);

        // Set up form
        editTextNameSignUp = (EditText) findViewById(R.id.editTextNameSignUp);
        editTextEmailSignUp = (EditText) findViewById(R.id.editTextEmailSignUp);
        editTextPasswordSignUp = (EditText) findViewById(R.id.editTextPasswordSignUp);
        spinnerCitySignUp = (Spinner) findViewById(R.id.spinnerCitySignUp);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(this);

        // Load cities into spinner
        Call<ArrayList<City>> call = payItForwardApi.getCities();
        call.enqueue(new Callback<ArrayList<City>>() {
            @Override
            public void onResponse(Call<ArrayList<City>> call, Response<ArrayList<City>> response) {
                if (response.isSuccessful()) {
                    ArrayAdapter adapter = new ArrayAdapter(EmailSignUpActivity.this, android.R.layout.simple_spinner_item, response.body());
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    spinnerCitySignUp.setAdapter(adapter);
                }
                else {
                    System.out.println(response.toString());
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Snackbar.make(findViewById(android.R.id.content), getString(R.string.generic_error), Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<City>> call, Throwable t) {
                Snackbar.make(findViewById(android.R.id.content), getString(R.string.connection_error), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSignUp) {
            final ProgressDialog progress = ProgressDialog.show(this, getString(R.string.signing_up), "", true);
            progress.show();

            Call<JsonElement> call = payItForwardApi.signUp(
                    editTextNameSignUp.getText().toString(),
                    editTextEmailSignUp.getText().toString(),
                    editTextPasswordSignUp.getText().toString(),
                    ((City) spinnerCitySignUp.getSelectedItem()).id
            );

            call.enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                    if (response.isSuccessful()) {
                        progress.dismiss();
                        Snackbar.make(findViewById(android.R.id.content), response.body().getAsJsonObject().get("message").getAsString(), Snackbar.LENGTH_SHORT).show();
                        startActivity(new Intent(EmailSignUpActivity.this, MainActivity.class));
                    }
                    else {
                        System.out.println(response.toString());
                        try {
                            System.out.println(response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        progress.dismiss();
                        Snackbar.make(findViewById(android.R.id.content), getString(R.string.generic_error), Snackbar.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<JsonElement> call, Throwable t) {
                    Snackbar.make(findViewById(android.R.id.content), getString(R.string.connection_error), Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }
}
