package com.paul.Services;

import com.paul.Clients.MovieClientImpl;
import com.paul.Models.GenreResponse;
import com.paul.Models.Movie;
import com.paul.Models.MovieResponse;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

    public MovieClientImpl movieClient;
    public MovieServiceImpl(
            MovieClientImpl movieClient){this.movieClient = movieClient;}
    public MovieResponse getMovieByTitle(String title){
        return movieClient.getMovieByTitle(title);
    }

    public GenreResponse getGenres(){
        return movieClient.getGenres();
    }
}
