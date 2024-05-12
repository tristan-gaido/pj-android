package com.example.interim;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EmployerSignupActivity extends AppCompatActivity {

    private EditText etCompanyName, etEmail, etPassword, etCompanyAddress, etCompanyWebsite, etCompanyLinkedIn, etCompanySocialMedia;
    private Button btnShowPassword, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_signup);

        etCompanyName = findViewById(R.id.etCompanyName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etCompanyAddress = findViewById(R.id.etCompanyAddress);
        etCompanyWebsite = findViewById(R.id.etCompanyWebsite);
        etCompanyLinkedIn = findViewById(R.id.etCompanyLinkedIn);
        etCompanySocialMedia = findViewById(R.id.etCompanySocialMedia);
        btnShowPassword = findViewById(R.id.btnShowPassword);
        btnSignup = findViewById(R.id.btnSignup);

        btnShowPassword.setOnClickListener(new View.OnClickListener() {
            boolean isPasswordVisible = false;

            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    btnShowPassword.setText("Afficher");
                    isPasswordVisible = false;
                } else {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    btnShowPassword.setText("Masquer");
                    isPasswordVisible = true;
                }
                etPassword.setSelection(etPassword.getText().length());
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    showCompletionDialog();
                } else {
                    Toast.makeText(EmployerSignupActivity.this, "Veuillez remplir tous les champs requis.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




    private boolean validateFields() {
        return !etCompanyName.getText().toString().isEmpty() &&
                !etEmail.getText().toString().isEmpty() &&
                !etPassword.getText().toString().isEmpty();
    }

    private void showCompletionDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Inscription complète")
                .setMessage("Votre inscription est maintenant complète.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Redirige vers la page de connexion
                        Intent intent = new Intent(EmployerSignupActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Efface la pile d'activités
                        startActivity(intent);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }
}
