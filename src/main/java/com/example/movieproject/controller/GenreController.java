package com.example.movieproject.controller;


import com.example.movieproject.model.Genre;
import com.example.movieproject.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreRepository GenreRepository;

    @GetMapping
    public List<Genre> getGenres(){
        return GenreRepository.getGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable("id") Integer id){
        return GenreRepository.getGenreById(id);
    }

    @PostMapping
    public String addGenre(@RequestBody Genre Genre){
        GenreRepository.addGenre(Genre);
        return "New Genre was successfully added!";
    }

    @PutMapping("/{id}")
    public String updateGenre(@PathVariable("id") Integer id, @RequestBody Genre Genre){
        GenreRepository.updateGenre(id, Genre);
        return "Existing Genre was successfully updated";
    }

    @DeleteMapping("/{id}")
    public String deleteGenre(@PathVariable("id") Integer id){
        GenreRepository.deleteGenre(id);
        return "Genre was successfully deleted";
    }
}
