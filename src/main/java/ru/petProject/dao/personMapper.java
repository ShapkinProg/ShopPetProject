package ru.petProject.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.petProject.models.person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class personMapper implements RowMapper<person> {
    @Override
    public person mapRow(ResultSet rs, int rowNum) throws SQLException {
        person person = new person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setEmail(rs.getString("email"));
        return person;
    }
}
