package com.example.interim.candidat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interim.R;

import java.util.List;

public class AnnonceAdapter extends RecyclerView.Adapter<AnnonceAdapter.AnnonceViewHolder> {

    private Context context;
    private List<Annonce> annonces;

    public AnnonceAdapter(Context context, List<Annonce> annonces) {
        this.context = context;
        this.annonces = annonces;
    }

    @NonNull
    @Override
    public AnnonceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_annonce, parent, false);
        return new AnnonceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnonceViewHolder holder, int position) {
        Annonce annonce = annonces.get(position);
        holder.title.setText(annonce.getTitle());
        holder.date.setText(annonce.getDate());
        holder.description.setText(annonce.getDescription());
        holder.imageView.setImageResource(annonce.getImageResourceId()); // Assurez-vous que vous avez des images valides

        // Ajouter un écouteur pour chaque élément
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CandidatureActivity.class);
                intent.putExtra("date", annonce.getDate());
                intent.putExtra("description", annonce.getDescription());
                context.startActivity(intent);
            }
        });
    }

    public void updateData(List<Annonce> newAnnonces) {
        annonces.clear();
        annonces.addAll(newAnnonces);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return annonces.size();
    }

    public static class AnnonceViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date, description;
        public ImageView imageView;

        public AnnonceViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            date = itemView.findViewById(R.id.tvDate);
            description = itemView.findViewById(R.id.tvDescription);
            imageView = itemView.findViewById(R.id.imageViewLogo);
        }
    }
}
