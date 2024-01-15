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
    private Integer authorId;
    private Integer genreId;

    public Movie(String name, Integer releaseYear, Integer authorId, Integer genreId) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.authorId = authorId;
        this.genreId = genreId;
    }

    public Movie() {
    }
}
