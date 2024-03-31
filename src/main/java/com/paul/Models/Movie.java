package com.paul.Models;

import java.util.List;

public class Movie {
    private int id;
    private String original_title;
    private String homepage;
    private String overview;
    private String backdrop_path;
    private String poster_path;
    private List<Integer> genre_ids;
    private String original_language;
    private String release_date;
    private String vote_average;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public List<Integer> getGenres() {
        return genre_ids;
    }

    public void setGenres(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }
    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Movie() {}

    public Movie(int id, String original_title, String homepage, String overview, String vote_average, List<Integer> genre_ids) {
        this.id = id;
        this.original_title = original_title;
        this.homepage = homepage;
        this.overview = overview;
        this.vote_average = vote_average;
        this.genre_ids = genre_ids;
    }
}
