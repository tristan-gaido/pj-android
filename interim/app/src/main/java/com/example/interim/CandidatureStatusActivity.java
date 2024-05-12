package com.example.interim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CandidatureStatusActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnnonceAdapter adapter;

    private Button btnGerer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidature_status);

        btnGerer = findViewById(R.id.btnGerer);

        btnGerer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CandidatureStatusActivity.this, GestionCandidatureActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }



}
