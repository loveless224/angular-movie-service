package com.paul.Clients;

import com.paul.Models.GenreResponse;
import com.paul.Models.Movie;
import com.paul.Models.MovieResponse;

public interface MovieClient {
    public MovieResponse getMovieByTitle(String title);
    public GenreResponse getGenres();
}
