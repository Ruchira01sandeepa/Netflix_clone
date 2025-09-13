package com.example.Crud_application.controller.com.example.Crud_application;

import com.example.Crud_application.dto.MovieDTO;
import com.example.Crud_application.model.Movie;
import com.example.Crud_application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/movies/")

public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/savemovie")
    public MovieDTO saveMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.saveMovie(movieDTO);
    }

    @PutMapping("/updatemovie")
    public MovieDTO updateUser(@RequestBody MovieDTO movieDTO) {
        MovieDTO updatedMovie = movieService.updateMovie(movieDTO);
        if (updatedMovie != null) {
            return updatedMovie;
        } else {
            return null;
        }
    }

    @GetMapping("/getdetails/{category}")
    public List<Movie> getMovie(@PathVariable String category) {
        List<Movie> movieDTO = movieService.getMovieByCategory(category);
        if (movieDTO != null) {
            return movieDTO;
        } else {
            return null;
        }
    }

    @GetMapping("/getAllFilms")
    public List<Movie> getAllEntities() {
        return movieService.getAllFilms();
    }

    @GetMapping("/searchFilm/{name}")
    public Movie searchFilm(@PathVariable String name) {
        return movieService.getFilm(name);
    }

}
