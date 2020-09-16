package com.example.moviesdrama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;

import com.example.moviesdrama.Adapter.MoviesAdapter;
import com.example.moviesdrama.Api.MoviesApi;
import com.example.moviesdrama.Model.Movies;
import com.example.moviesdrama.Model.MoviesClient;
import com.example.moviesdrama.Model.Results;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MoviesAdapter adapter ;
    private static String BASE_URL="https://api.themoviedb.org/3/discover/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_content);
        swipeRefreshLayout = findViewById(R.id.main_containt);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new MoviesAdapter();
        recyclerView.setAdapter(adapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MoviesApi con=retrofit.create(MoviesApi.class);
        con.getMovies("fd1cf271e5715af6f51f845f52da8f30",1).enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response)
            {
                if(response.isSuccessful()) {
                    Results results=response.body();
                    ArrayList<Movies> arr=new ArrayList<>();
                    Movies[] movies=results.getResults();
                    for(int i=0;i<movies.length;i++){
                        arr.add(new Movies(movies[i].getPoster_path(),
                                movies[i].getId()
                        ,movies[i].getOriginal_language()
                        ,movies[i].getTitle()
                        ,movies[i].getOverview()));
                        Log.d(TAG, "onResponse: success mohamed "+movies[i].getTitle());
                    }

                    //todo
                    adapter.setMoviesList(arr);

                    Log.e(TAG, "onResponse: success mohamed "+response.body().toString());
                }else{
                    Log.e(TAG, "onResponse: mohamed "+response.message() );
                }
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Log.e(TAG, "onResponse: mohamed "+t.getMessage() );
            }
        });

    }

}