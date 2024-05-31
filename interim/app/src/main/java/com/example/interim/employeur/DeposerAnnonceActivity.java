package com.example.interim.employeur;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.interim.R;

public class DeposerAnnonceActivity extends AppCompatActivity {

    private EditText etTitre, etDescription, etDateDebut, etDateFin, etCompetences, etRemuneration;
    private Button btnPublier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposer_annonce);

        etTitre = findViewById(R.id.etTitre);
        etDescription = findViewById(R.id.etDescription);
        etDateDebut = findViewById(R.id.etDateDebut);
        etDateFin = findViewById(R.id.etDateFin);
        etCompetences = findViewById(R.id.etCompetences);
        etRemuneration = findViewById(R.id.etRemuneration);
        btnPublier = findViewById(R.id.btnPublier);

        btnPublier.setOnClickListener(v -> publierAnnonce());
    }

    private void publierAnnonce() {
        // Logique pour publier l'annonce
        // Vous pouvez ajouter la logique pour enregistrer les données dans une base de données ou envoyer à un serveur

        // Pour l'instant, affichons simplement un message de confirmation
        Toast.makeText(this, "Annonce publiée avec succès", Toast.LENGTH_SHORT).show();
    }
}
