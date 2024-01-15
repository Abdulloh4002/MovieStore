package com.example.movieproject.repository;

import com.example.movieproject.mapper.MovieMapper;
import com.example.movieproject.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> getMovies(){
        return jdbcTemplate.query(
                "select * from movie",
                new MovieMapper()
        );
    }

    public Movie getMovieById(Integer id){
        return jdbcTemplate.queryForObject(
                "select * from movie where id=?",
                    new Object[]{id},
                    new MovieMapper()
        );
    }

    public void addMovie(Movie movie){
        jdbcTemplate.update(
                "insert into movie(name, release_year,author_id, genre_id) values(?, ?, ?, ?)",
                    movie.getName(),
                    movie.getReleaseYear(),
                    movie.getAuthorId(),
                    movie.getGenreId()
            );
    }

    public void updateMovie(Integer id, Movie movie ){

        jdbcTemplate.update(
                "update movie set name = ?, release_year =  ?, author_id = ?, genre_id = ? where id = ?)",
                    movie.getName(),
                    movie.getReleaseYear(),
                    movie.getAuthorId(),
                    movie.getGenreId(),
                    id
        );
    }

    public void deleteMovie(Integer id){
        jdbcTemplate.update(
                "delete from table movie where id = ?",
                id
        );
    }
}
