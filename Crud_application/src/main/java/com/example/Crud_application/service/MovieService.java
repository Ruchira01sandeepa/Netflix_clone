package com.example.Crud_application.service;

import com.example.Crud_application.dto.MovieDTO;
import com.example.Crud_application.model.Movie;
import com.example.Crud_application.repository.MovieRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private ModelMapper modelMapper;

    public MovieDTO saveMovie(MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        movieRepo.save(movie);
        return movieDTO;
    }

    public MovieDTO updateMovie(MovieDTO movieDTO) {
        Movie movie = movieRepo.findByName(movieDTO.getName());
        if (movie != null) {
            movie.setCategory(movieDTO.getCategory());
            movieRepo.save(movie);
            return modelMapper.map(movie, MovieDTO.class);
        } else {
            return null;
        }
    }

    public List<Movie> getMovieByCategory(String category) {
        List<Movie> movie = movieRepo.findByCategory(category);
        return movie;
    }

    public List<Movie> getAllFilms() {
        return movieRepo.findAll();
    }

    public Movie getFilm(String name) {
        Movie movie = movieRepo.findByName(name);
        return movie;
    }

}
