package com.cybereyestudios.payitforward;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonEmailSignIn, buttonEmailSignUp, buttonFacebookSignIn, buttonGoogleSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        buttonEmailSignIn = (Button) findViewById(R.id.buttonEmailSignIn);
        buttonEmailSignUp = (Button) findViewById(R.id.buttonEmailSignUp);
        buttonFacebookSignIn = (Button) findViewById(R.id.buttonFacebookSignIn);
        buttonGoogleSignIn = (Button) findViewById(R.id.buttonGoogleSignIn);

        buttonEmailSignIn.setOnClickListener(this);
        buttonEmailSignUp.setOnClickListener(this);
        buttonFacebookSignIn.setOnClickListener(this);
        buttonGoogleSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonEmailSignIn) {
            startActivity(new Intent(this, EmailSignInActivity.class));
        }
        else if (v.getId() == R.id.buttonEmailSignUp) {
            startActivity(new Intent(this, EmailSignUpActivity.class));
        }
        else if (v.getId() == R.id.buttonFacebookSignIn) {
            Snackbar.make(findViewById(android.R.id.content), getString(R.string.not_implemented_yet), Snackbar.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.buttonGoogleSignIn) {
            Snackbar.make(findViewById(android.R.id.content), getString(R.string.not_implemented_yet), Snackbar.LENGTH_SHORT).show();
        }
    }
}
