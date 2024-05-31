package com.example.interim.candidat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;

import com.example.interim.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GestionCandidatureActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView tvEmail, tvContactEmployer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_candidature);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button btnContact = findViewById(R.id.btnContact);
        tvEmail = findViewById(R.id.tvEmail);
        tvContactEmployer = findViewById(R.id.tvContactEmployer);

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvEmail.getVisibility() == View.GONE) {
                    tvEmail.setVisibility(View.VISIBLE);
                    tvContactEmployer.setVisibility(View.GONE);
                } else {
                    tvEmail.setVisibility(View.GONE);
                }
            }
        });

        Button btnAccept = findViewById(R.id.btnAccept);
        Button btnRefuse = findViewById(R.id.btnRefuse);

        btnAccept.setOnClickListener(v -> {
        });

        btnRefuse.setOnClickListener(v -> {
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng location = new LatLng(43.610769, 3.876716);
        mMap.addMarker(new MarkerOptions().position(location).title("445 avenue du major Flandres, Montpellier"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12));
    }
}
