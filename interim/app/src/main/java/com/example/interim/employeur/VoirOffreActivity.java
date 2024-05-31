package com.example.interim.employeur;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.interim.R;

public class VoirOffreActivity extends AppCompatActivity {

    private Button btnAccepter1, btnRefuser1, btnAccepter2, btnRefuser2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_offre);

        btnAccepter1 = findViewById(R.id.btnAccepter1);
        btnRefuser1 = findViewById(R.id.btnRefuser1);
        btnAccepter2 = findViewById(R.id.btnAccepter2);
        btnRefuser2 = findViewById(R.id.btnRefuser2);

        btnAccepter1.setOnClickListener(v -> Toast.makeText(VoirOffreActivity.this, "Candidature 1 Acceptée", Toast.LENGTH_SHORT).show());
        btnRefuser1.setOnClickListener(v -> Toast.makeText(VoirOffreActivity.this, "Candidature 1 Refusée", Toast.LENGTH_SHORT).show());

        btnAccepter2.setOnClickListener(v -> Toast.makeText(VoirOffreActivity.this, "Candidature 2 Acceptée", Toast.LENGTH_SHORT).show());
        btnRefuser2.setOnClickListener(v -> Toast.makeText(VoirOffreActivity.this, "Candidature 2 Refusée", Toast.LENGTH_SHORT).show());
    }
}
