package com.example.moviesdrama.Api;

import com.example.moviesdrama.Model.Results;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApi {
    @GET("movie?")
    public Call<Results> getMovies(@Query("api_key")String key
     ,@Query("page") int page );


}
