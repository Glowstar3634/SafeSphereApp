package com.example.safesphereapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;

    TextView signUpButton;
    TextView forgotYourPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.usernameID);
        password = findViewById(R.id.passwordID);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);
        forgotYourPassword = findViewById(R.id.forgotYourPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                    Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpSwitch = new Intent(MainActivity.this, SignUpActivity.class);
                MainActivity.this.startActivity(signUpSwitch);
            }
        });

        forgotYourPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotYourPasswordSwitch = new Intent(MainActivity.this, forgotYourPassword.class);
                MainActivity.this.startActivity(forgotYourPasswordSwitch);
            }
        });
    }
}
