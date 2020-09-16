package com.example.moviesdrama.Model;

public class Movies {
    private String poster_path;
    private int id;
    private String original_language;
    private String title;
    private String overview;

    public Movies(String poster_path, int id, String original_language, String title,String overview) {
        this.poster_path = poster_path;
        this.id = id;
        this.original_language = original_language;
        this.title = title;
        this.overview=overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
