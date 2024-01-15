package com.example.movieproject.repository;

import com.example.movieproject.mapper.GenreMapper;
import com.example.movieproject.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Genre> getGenres(){
        return jdbcTemplate.query(
                "select * from genre",
                    new GenreMapper()
        );
    }

    public Genre getGenreById(Integer id){
        return jdbcTemplate.queryForObject(
                "select * from genre where id=?",
                    new Object[]{id},
                    new GenreMapper()
        );
    }

    public void addGenre(Genre genre){
        jdbcTemplate.update(
                "insert into genre(name) values(?)",
                    genre.getName()
        );
    }

    public void updateGenre(Integer id, Genre genre){

        jdbcTemplate.update(
                "update genre set name = ? where id = ?",
                    genre.getName(),
                    id
        );
    }

    public void deleteGenre(Integer id){
        jdbcTemplate.update(
                "delete from table genre where id = ?",
                    id)
        ;
    }
}

