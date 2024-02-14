package com.paul.Controllers;

import com.paul.Models.Movie;
import com.paul.Models.MovieResponse;
import com.paul.Services.MovieService;
import com.paul.Services.MovieServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    @GetMapping("/movie-by-title/{title}")
    public MovieResponse getMovie(@PathVariable("title") String title){
        return movieService.getMovieByTitle(title);
    }
}
