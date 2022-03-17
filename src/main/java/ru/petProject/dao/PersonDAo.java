package ru.petProject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.petProject.models.person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAo {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<person> index()
    {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(person.class)); //new personMapper());
    }
    public person show(int id)
    {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(person.class))
                .stream().findAny().orElse(null);
    }
    public void save(person person){
        jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?)", person.getName(), person.getEmail());

    }
    public void update(int id, person updatePerson)
    {
        jdbcTemplate.update("UPDATE Person SET name=?, email=? WHERE id=?",
                updatePerson.getName(), updatePerson.getEmail(), id);
    }
    public void delete(int id)
    {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);

    }
}
