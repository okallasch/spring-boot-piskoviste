package org.gopas.springbootdemo.data.mappers;

import org.gopas.springbootdemo.data.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getLong("id"));
        person.setAge(rs.getInt("age"));
        person.setEmail(rs.getString("email"));
        person.setPwd(rs.getString("pwd"));
        person.setNickname(rs.getString("nickname"));
        person.setBirthday(rs.getDate("birthday").toLocalDate());
        return person;
    }
}
