package com.example.interim.employeur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.interim.R;

public class MesOffresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_offres);

        setupOfferButtons(R.id.btnVoir, R.id.btnModifier, R.id.btnSupprimer);
    }

    private void setupOfferButtons(int btnVoirId, int btnModifierId, int btnSupprimerId) {
        Button btnVoir = findViewById(btnVoirId);

        btnVoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MesOffresActivity.this, VoirOffreActivity.class);
                startActivity(intent);
            }
        });

    }
}
