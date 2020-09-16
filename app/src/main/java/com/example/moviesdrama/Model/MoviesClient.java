package com.example.moviesdrama.Model;

import com.example.moviesdrama.Api.MoviesApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesClient {
    private static String BASE_URL="https://api.themoviedb.org/3/discover/";
    private static MoviesApi moviesApi;
    private static  MoviesClient INSTANCE;

    public MoviesClient()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        moviesApi= retrofit.create(MoviesApi.class);

    }

    public static MoviesApi getINSTANCE() {
        if (null==INSTANCE)
        {
            INSTANCE = new MoviesClient();
        }

        return moviesApi;
    }


}
