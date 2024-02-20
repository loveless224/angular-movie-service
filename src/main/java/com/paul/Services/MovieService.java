package com.paul.Services;

import com.paul.Models.GenreResponse;
import com.paul.Models.MovieResponse;

public interface MovieService {
    public MovieResponse getMovieByTitle(String title);
    public GenreResponse getGenres();
    public MovieResponse getMoviesByPopularity();
}
