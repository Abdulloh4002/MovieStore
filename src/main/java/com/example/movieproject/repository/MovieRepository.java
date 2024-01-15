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
        return jdbcTemplate.query("select * from movie",new MovieMapper());
    }

    public Movie getMovieById(Integer id){
        return (Movie) jdbcTemplate.query("select * from movie where id=?",new Object[]{id},new MovieMapper());
    }

    public void addMovie(Movie movie){
        jdbcTemplate.query("insert into movie(name, release_year,author_id, genre_id) values(?, ?, ?, ?)",
                new Object[]{
                        movie.getName(),
                        movie.getReleaseYear(),
                        movie.getAuthor().getId(),
                        movie.getGenre().getId()
                },
                new MovieMapper()
        );
    }

    public void updateMovie(Integer id, Movie movie ){

        jdbcTemplate.query("update movie set name = ?, release_year =  ?, author_id = ?, genre_id = ? where id = ?)",
                new Object[]{
                        movie.getName(),
                        movie.getReleaseYear(),
                        movie.getAuthor().getId(),
                        movie.getGenre().getId(),
                        id
                },
                new MovieMapper()
        );
    }

    public void deleteMovie(Integer id){
        jdbcTemplate.query("delete from table movie where id = ?", new Object[]{id}, new MovieMapper());
    }
}
