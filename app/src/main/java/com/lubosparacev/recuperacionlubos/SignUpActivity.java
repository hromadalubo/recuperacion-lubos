package com.lubosparacev.recuperacionlubos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    AmplifyCognito amplifyCognito;

    EditText userNameEditText;
    EditText emailEditText;
    EditText passwordEditText;
    Button registerBtn;
    TextView goToSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        amplifyCognito = new AmplifyCognito(getApplicationContext());

        userNameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerBtn = findViewById(R.id.registerBtn);
        goToSignIn = findViewById(R.id.goToSignIn);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                amplifyCognito.signUp(email, username, password);
            }
        });

        goToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amplifyCognito.loadLogin();
            }
        });
    }
}