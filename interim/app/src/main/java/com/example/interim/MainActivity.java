package com.example.interim;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;

import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.interim.logique.LoginActivity;

public class MainActivity extends AppCompatActivity {

    Button btnEmployeur, btnCandidat, btnAnonyme;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestLocationPermission();


        btnEmployeur = findViewById(R.id.btnEmployeur);
        btnCandidat = findViewById(R.id.btnCandidat);
        btnAnonyme = findViewById(R.id.btnAnonyme);

        btnEmployeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("userType", "employeur");
                startActivity(intent);
            }
        });

        btnCandidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("userType", "candidat");
                startActivity(intent);
            }
        });

        btnAnonyme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Exemple: Afficher un Toast ou démarrer une autre activité
                Toast.makeText(MainActivity.this, "Mode Anonyme Activé", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, "La permission de localisation est nécessaire pour afficher des annonces autour de votre position.", Toast.LENGTH_LONG).show();
            }
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            initializeLocationBasedFeatures();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initializeLocationBasedFeatures();
            } else {
                Toast.makeText(this, "Permission refusée. Certaines fonctionnalités ne seront pas disponibles.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void initializeLocationBasedFeatures() {
        Toast.makeText(this, "Localisation activée, vous pouvez voir les annonces locales.", Toast.LENGTH_LONG).show();
    }


}
