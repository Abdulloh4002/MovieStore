package com.example.movieproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Movie {

    private Integer id;
    private String name;
    private Integer releaseYear;
    private Author author;
    private Genre genre;

    public Movie(String name, Integer releaseYear, Author author, Genre genre) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.author = author;
        this.genre = genre;
    }

    public Movie() {
    }
}
