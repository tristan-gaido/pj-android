package com.example.interim;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CandidateSignupActivity extends AppCompatActivity {

    private EditText etLastName, etFirstName, etPassword, etEmail;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_signup);

        etLastName = findViewById(R.id.etLastName);
        etFirstName = findViewById(R.id.etFirstName);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    showCompletionDialog();
                } else {
                    Toast.makeText(CandidateSignupActivity.this, "Veuillez remplir tous les champs requis.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateFields() {
        return !etLastName.getText().toString().isEmpty() &&
                !etFirstName.getText().toString().isEmpty() &&
                !etPassword.getText().toString().isEmpty() &&
                !etEmail.getText().toString().isEmpty();
    }

    private void showCompletionDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Inscription complète")
                .setMessage("Votre inscription est maintenant complète.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(CandidateSignupActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }
}
