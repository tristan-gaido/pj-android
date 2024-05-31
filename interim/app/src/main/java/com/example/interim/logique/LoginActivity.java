package com.example.interim.logique;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.interim.R;
import com.example.interim.candidat.AnnonceActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Button showPasswordButton, loginButton;
    private TextView signUpCandidate, signUpEmployer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        showPasswordButton = findViewById(R.id.showPasswordButton);
        loginButton = findViewById(R.id.loginButton);
        signUpCandidate = findViewById(R.id.signUpCandidate);
        signUpEmployer = findViewById(R.id.signUpEmployer);

        signUpCandidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CandidateSignupActivity.class);
                startActivity(intent);
            }
        });

        signUpEmployer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, EmployerSignupActivity.class);
                startActivity(intent);
            }
        });



        showPasswordButton.setOnClickListener(new View.OnClickListener() {
            boolean isPasswordVisible = false;
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showPasswordButton.setText("Afficher");
                    isPasswordVisible = false;
                } else {
                    passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    showPasswordButton.setText("Masquer");
                    isPasswordVisible = true;
                }
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Connexion en cours...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, AnnonceActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
