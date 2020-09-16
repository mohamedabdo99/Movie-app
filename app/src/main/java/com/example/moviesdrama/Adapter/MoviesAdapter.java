package com.example.moviesdrama.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesdrama.Details_activity;
import com.example.moviesdrama.MainActivity;
import com.example.moviesdrama.Model.Movies;
import com.example.moviesdrama.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private List<Movies> moviesList = new ArrayList<>();




    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card,parent,false);

        return new MoviesViewHolder(view);
    }
    public void setMoviesList(List<Movies> moviesList){
        this.moviesList=moviesList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position)
    {

        Picasso.get()
                .load("http://image.tmdb.org/t/p/w500/"+moviesList.get(position).getPoster_path())
                .into(holder.image_poster);
        holder.txt_title.setText(moviesList.get(position).getTitle());
        holder.txt_lang.setText(moviesList.get(position).getOriginal_language());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent myintent = new Intent(view.getContext(),Details_activity.class);
                myintent.putExtra("image"
                        ,"http://image.tmdb.org/t/p/w500/"+moviesList
                        .get(position).getPoster_path());
                myintent.putExtra("over",moviesList.get(position).getOverview());

                view.getContext().startActivity(myintent);


            }
        });


    }
    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MoviesViewHolder extends RecyclerView.ViewHolder
    {
        ImageView image_poster;
        TextView txt_lang,txt_title;
        CardView cardView;

        public MoviesViewHolder(@NonNull View itemView) {
            super(itemView);

            image_poster = itemView.findViewById(R.id.image_card);
            txt_title = itemView.findViewById(R.id.text_title_card);
            txt_lang = itemView.findViewById(R.id.text_rating_card);

            cardView = itemView.findViewById(R.id.card_view);


        }
    }
}
