package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameField, passwordField, confirmPasswordField;
    private Button signUpButton, signInButton;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        usernameField = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);
        confirmPasswordField = findViewById(R.id.repassword);
        signUpButton = findViewById(R.id.btnsignup);
        signInButton = findViewById(R.id.btnsignin);


        dbHelper = new DBHelper(this);

        signUpButton.setOnClickListener(v -> handleSignUp());
        signInButton.setOnClickListener(v -> startActivity(new Intent(this, LoginActivity.class)));
    }

    private void handleSignUp() {
        String username = usernameField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();
        String confirmPassword = confirmPasswordField.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showToast("Please enter all the fields");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showToast("Passwords do not match");
            return;
        }

        if (dbHelper.checkusername(username)) {
            showToast("User already exists! Please sign in");
            return;
        }

        boolean isInserted = dbHelper.insertData(username, password);
        if (isInserted) {
            showToast("Registered successfully");
            startActivity(new Intent(this, HomeActivity.class));
        } else {
            showToast("Registration failed");
        }
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
