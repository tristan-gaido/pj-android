package com.example.interim;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnnonceActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AnnonceAdapter adapter;
    private List<Annonce> annonces;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annonce);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        annonces = getDummyAnnonces();

        adapter = new AnnonceAdapter(this, annonces);
        recyclerView.setAdapter(adapter);

        setupSearchView();
    }

    private void setupSearchView() {
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterAnnonces(newText);
                return true;
            }
        });
    }

    private void filterAnnonces(String text) {
        if (adapter != null) {
            List<Annonce> filteredList = new ArrayList<>();
            for (Annonce annonce : annonces) {
                if (annonce.getTitle().toLowerCase().contains(text.toLowerCase())) {
                    filteredList.add(annonce);
                }
            }
            adapter.updateData(filteredList);
        } else {
            Log.e("AnnonceActivity", "Adapter is not initialized");
        }
    }



    private List<Annonce> getDummyAnnonces() {
        List<Annonce> dummyAnnonces = new ArrayList<>();
        dummyAnnonces.add(new Annonce("Ingénieur Logiciel", "Participez à des projets de développement logiciel de grande envergure.", "2024-06-01", R.drawable.joblogo));
        dummyAnnonces.add(new Annonce("Analyste de Données", "Analysez des données complexes pour guider les décisions stratégiques.", "2024-06-10", R.drawable.joblogo));
        dummyAnnonces.add(new Annonce("Designer UX/UI", "Créez des expériences utilisateur captivantes pour nos produits numériques.", "2024-07-20", R.drawable.joblogo));
        dummyAnnonces.add(new Annonce("Responsable Marketing", "Dirigez nos stratégies de marketing et augmentez notre présence sur le marché.", "2024-08-15", R.drawable.joblogo));
        dummyAnnonces.add(new Annonce("Développeur Front-End", "Développez des interfaces avant-gardistes pour nos applications web.", "2024-09-05", R.drawable.joblogo));
        dummyAnnonces.add(new Annonce("Expert en Sécurité", "Assurez la sécurité de nos systèmes et protégez nos données contre les cyberattaques.", "2024-10-10", R.drawable.joblogo));
        dummyAnnonces.add(new Annonce("Consultant en Gestion", "Fournissez des conseils experts pour améliorer nos processus organisationnels.", "2024-11-25", R.drawable.joblogo));
        dummyAnnonces.add(new Annonce("Architecte Logiciel", "Concevez l'architecture pour nos solutions logicielles complexes.", "2024-12-30", R.drawable.joblogo));
        dummyAnnonces.add(new Annonce("Spécialiste en IA", "Innovez avec l'intelligence artificielle pour résoudre des problèmes complexes.", "2025-01-15", R.drawable.joblogo));


        return dummyAnnonces;
    }
}

