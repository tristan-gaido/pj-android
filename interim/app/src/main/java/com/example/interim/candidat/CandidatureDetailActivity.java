package com.example.interim.candidat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.interim.R;

public class CandidatureDetailActivity extends AppCompatActivity {

    private TextView tvCandidatureTitle;
    private TextView tvCandidatureDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidature_detail);

        tvCandidatureTitle = findViewById(R.id.tvCandidatureTitle);
        tvCandidatureDescription = findViewById(R.id.tvCandidatureDescription);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");

        tvCandidatureTitle.setText(title);
        tvCandidatureDescription.setText(description);
    }
}
