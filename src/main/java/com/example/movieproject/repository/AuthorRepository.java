package com.example.movieproject.repository;

import com.example.movieproject.mapper.AuthorMapper;
import com.example.movieproject.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Author> getAuthors(){
        return jdbcTemplate.query("select * from author",new AuthorMapper());
    }

    public Author getAuthorById(Integer id){
        return (Author) jdbcTemplate.query("select * from author where id=?",new Object[]{id},new AuthorMapper());
    }

    public void addAuthor(Author author){
        jdbcTemplate.query("insert into author(name, surname) values(?, ?)",
                new Object[]{
                        author.getName(),
                        author.getSurname()
                },
                new AuthorMapper()
        );
    }

    public void updateAuthor(Integer id, Author author){

        jdbcTemplate.query("update author set name = ?, surname =? where id = ?)",
                new Object[]{
                        author.getName(),
                        author.getSurname(),
                        id
                },
                new AuthorMapper()
        );
    }

    public void deleteAuthor(Integer id){
        jdbcTemplate.query("delete from table author where id = ?", new Object[]{id}, new AuthorMapper());
    }
}
