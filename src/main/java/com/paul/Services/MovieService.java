package com.paul.Services;

import com.paul.Models.Movie;
import com.paul.Models.MovieResponse;

public interface MovieService {
    public MovieResponse getMovieByTitle(String title);
}
