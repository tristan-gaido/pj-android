package com.example.interim;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
public class CandidatureActivity extends AppCompatActivity {

    private TextView tvAnnonceDate, tvAnnonceDescription;
    private EditText etNom, etPrenom, etDateNaissance, etTelephone;
    private Button btnCandidater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidature);

        tvAnnonceDate = findViewById(R.id.tvAnnonceDate);
        tvAnnonceDescription = findViewById(R.id.tvAnnonceDescription);
        etNom = findViewById(R.id.etNom);
        etPrenom = findViewById(R.id.etPrenom);
        etDateNaissance = findViewById(R.id.etDateNaissance);
        etTelephone = findViewById(R.id.etTelephone);
        btnCandidater = findViewById(R.id.btnCandidater);

        String date = getIntent().getStringExtra("date");
        String description = getIntent().getStringExtra("description");

        tvAnnonceDate.setText(date);
        tvAnnonceDescription.setText(description);

        btnCandidater.setOnClickListener(v -> {
            submitCandidature();
        });
    }

    private void submitCandidature() {
        Toast.makeText(this, "Candidature soumise avec succès!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(CandidatureActivity.this, CandidatureStatusActivity.class);
        startActivity(intent);

        finish();
    }
}
