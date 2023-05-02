package com.lubosparacev.recuperacionlubos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    AmplifyCognito amplifyCognito;

    EditText usernameSignInEditText;
    EditText passwordSignInEditText;
    Button signInBtn;
    TextView goToSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        amplifyCognito = new AmplifyCognito(getApplicationContext());

        usernameSignInEditText = findViewById(R.id.usernameSignInEditText);
        passwordSignInEditText = findViewById(R.id.passwordSignInEditText);
        signInBtn = findViewById(R.id.signInBtn);
        goToSignUp = findViewById(R.id.goToSignUp);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameSignInEditText.getText().toString();
                String password = passwordSignInEditText.getText().toString();
                amplifyCognito.signIn(username, password);
            }
        });

        goToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amplifyCognito.loadSignUp();
            }
        });
    }
}