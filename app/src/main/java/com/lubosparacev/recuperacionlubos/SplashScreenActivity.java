package com.lubosparacev.recuperacionlubos;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.core.Amplify;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Check if a user is signed in
        Amplify.Auth.fetchAuthSession(
                result -> {
                    if (result.isSignedIn()) {
                        // Redirect to MainActivity
                        Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Redirect to LoginActivity
                        Intent intent = new Intent(SplashScreenActivity.this, SignInActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },
                error -> {
                    Log.e("Amplify", "Failed to fetch auth session", error);
                    // Redirect to LoginActivity
                    Intent intent = new Intent(SplashScreenActivity.this, SignInActivity.class);
                    startActivity(intent);
                    finish();
                }
        );
    }
}