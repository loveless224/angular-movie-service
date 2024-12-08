package com.paul.Services;

import com.paul.Clients.MovieClientImpl;
import com.paul.Mappers.MovieByIdToMovie;
import com.paul.Models.*;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public MovieResponse getMoviesByPopularity() { return movieClient.getMoviesByPopularity(); }

    public MovieResponse getMoviesByGenre(int genreId) {
        return movieClient.getMoviesByGenre(genreId);
    }

    public Movie getMovieById(int id) {
        MovieByIdResponse movie = movieClient.getMovieById(id);
        return MovieByIdToMovie.mapMovieByIdToMovie(movie);
    }

}
