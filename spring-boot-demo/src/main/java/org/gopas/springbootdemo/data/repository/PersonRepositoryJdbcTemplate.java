package org.gopas.springbootdemo.data.repository;

import org.gopas.springbootdemo.data.mappers.PersonMapper;
import org.gopas.springbootdemo.data.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryJdbcTemplate {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepositoryJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Person findById(Long id) {
        return jdbcTemplate
                .queryForObject("SELECT id_person AS id, age, birthday, email, nickname, pwd" +
                                " FROM person p" +
                                " WHERE p.id_person = ?",
                        new PersonMapper(),
                        id);
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT  id_person AS id, age, birthday, email, nickname, pwd" +
                        " FROM person p",
                new BeanPropertyRowMapper<>(Person.class));
    }
}
