package com.paul.Mappers;

import java.util.ArrayList;
import java.util.List;
import com.paul.Models.Movie;
import com.paul.Models.MovieByIdResponse;

public class MovieByIdToMovie {

    public static Movie mapMovieByIdToMovie(MovieByIdResponse movie) {
        Movie returnMovie = new Movie();
        returnMovie.setId(movie.getId());
        returnMovie.setOriginal_title(movie.getOriginal_title());
        returnMovie.setHomepage(movie.getHomepage());
        returnMovie.setOverview(movie.getOverview());
        returnMovie.setBackdrop_path(movie.getBackdrop_path());
        returnMovie.setPoster_path(movie.getPoster_path());
        
        List<Integer> genreIds = new ArrayList<>();
        for (int i = 0; i < movie.getGenres().size(); i++) {
            genreIds.add(movie.getGenres().get(i).getId());
        }
        returnMovie.setGenres(genreIds);
        
        returnMovie.setOriginal_language(movie.getOriginal_language());
        returnMovie.setRelease_date(movie.getRelease_date());
        returnMovie.setVote_average(String.valueOf(movie.getVote_average()));

        return returnMovie;
    }
}

