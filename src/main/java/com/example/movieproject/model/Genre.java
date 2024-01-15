package com.example.movieproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Genre {

    private Integer id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }
}
