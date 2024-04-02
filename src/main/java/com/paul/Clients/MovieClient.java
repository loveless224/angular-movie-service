package com.paul.Clients;

import com.paul.Models.GenreResponse;
import com.paul.Models.MovieByIdResponse;
import com.paul.Models.MovieResponse;

public interface MovieClient {
    public MovieResponse getMovieByTitle(String title);
    public GenreResponse getGenres();
    public MovieResponse getMoviesByGenre(int genreId);
    public MovieResponse getMoviesByPopularity();
    public MovieByIdResponse getMovieById(int id);
}
