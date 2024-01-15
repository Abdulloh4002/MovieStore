package com.example.movieproject.controller;

import com.example.movieproject.model.Author;
import com.example.movieproject.repository.AuthorRepository;
import com.fasterxml.jackson.annotation.JacksonInject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping
    public List<Author> getAuthors(){
        return authorRepository.getAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable("id") Integer id){
        return authorRepository.getAuthorById(id);
    }

    @PostMapping
    public String addAuthor(@RequestBody Author author){
        authorRepository.addAuthor(author);
        return "New author was successfully added!";
    }

    @PutMapping("/{id}")
    public String updateAuthor(@PathVariable("id") Integer id, @RequestBody Author author){
        authorRepository.updateAuthor(id, author);
        return "Existing author was successfully updated";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable("id") Integer id){
        authorRepository.deleteAuthor(id);
        return "Author was successfully deleted";
    }
}
