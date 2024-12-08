package com.paul.Mappers;

import java.util.ArrayList;
import java.util.List;
import com.paul.Models.Movie;
import com.paul.Models.MovieByIdResponse;
import com.paul.Models.Results;

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
        movie.getGenres().forEach(genre -> genreIds.add(genre.getId()));
        returnMovie.setGenres(genreIds);
        returnMovie.setVideos(movie.getVideos());
        returnMovie.setOriginal_language(movie.getOriginal_language());
        returnMovie.setRelease_date(movie.getRelease_date());
        returnMovie.setVote_average(String.valueOf(movie.getVote_average()));

        if(movie.getVideos() != null && movie.getVideos().getResults() != null){
            returnMovie.setYoutubeUrl(constructVideoUrl(movie.getVideos().getResults()));
        }
        else { returnMovie.setYoutubeUrl(null); }

        return returnMovie;
    }

    public static String constructVideoUrl(List<Results> results) {
        if (results == null || results.isEmpty()) {
            return null;
        }
        Results firstResult = results.get(0);

        if (firstResult != null && "youtube".equalsIgnoreCase(firstResult.getSite())) {
            String videoKey = firstResult.getKey();
            return "https://www.youtube.com/embed/" + videoKey;
        }
        return null;
    }
}

