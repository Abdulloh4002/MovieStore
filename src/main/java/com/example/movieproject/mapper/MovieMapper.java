package com.example.movieproject.mapper;

import com.example.movieproject.model.Author;
import com.example.movieproject.model.Genre;
import com.example.movieproject.model.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Movie(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("release_year"),
                rs.getInt("author_id"),
                rs.getInt("genre_id")
        );
    }
}
