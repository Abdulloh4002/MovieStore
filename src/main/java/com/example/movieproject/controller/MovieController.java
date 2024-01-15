package com.example.movieproject.controller;

import com.example.movieproject.model.Movie;
import com.example.movieproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository MovieRepository;

    @GetMapping
    public List<Movie> getMovies(){
        return MovieRepository.getMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable("id") Integer id){
        return MovieRepository.getMovieById(id);
    }

    @PostMapping
    public String addMovie(@RequestBody Movie Movie){
        MovieRepository.addMovie(Movie);
        return "New Movie was successfully added!";
    }

    @PutMapping("/{id}")
    public String updateMovie(@PathVariable("id") Integer id, @RequestBody Movie Movie){
        MovieRepository.updateMovie(id, Movie);
        return "Existing Movie was successfully updated";
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable("id") Integer id){
        MovieRepository.deleteMovie(id);
        return "Movie was successfully deleted";
    }

}
