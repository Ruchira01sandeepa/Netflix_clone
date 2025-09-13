package com.example.Crud_application.repository;

import com.example.Crud_application.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
      Movie findByName(String name);

      List<Movie> findByCategory(String category);

}
