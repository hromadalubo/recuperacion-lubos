package com.lubosparacev.recuperacionlubos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class VerifyAccountActivity extends AppCompatActivity {

    AmplifyCognito amplifyCognito;

    EditText codeEditText;
    Button verifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_account);

        amplifyCognito = new AmplifyCognito(getApplicationContext());
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        codeEditText = findViewById(R.id.codeEditText);
        verifyBtn = findViewById(R.id.verifyBtn);
        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = codeEditText.getText().toString();
                amplifyCognito.verifySignUp(username, code);
            }
        });
    }
}