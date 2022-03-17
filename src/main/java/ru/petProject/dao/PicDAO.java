package ru.petProject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.petProject.models.pic;
import java.util.List;

@Component
public class PicDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PicDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<pic> index()
    {
        return jdbcTemplate.query("SELECT * FROM staff", new BeanPropertyRowMapper<>(pic.class)); //new personMapper());
    }
    public pic show(int id)
    {
        return jdbcTemplate.query("SELECT * FROM staff WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(pic.class))
                .stream().findAny().orElse(null);
    }
    public void save(pic pic){
        jdbcTemplate.update("INSERT INTO staff VALUES(?, ?, ?, ?, ?)", pic.getId(),pic.getTitle(),
                pic.getCost(), pic.getDescription(), pic.getPicture());

    }
    public void update(int id, pic updatePerson)
    {
        jdbcTemplate.update("UPDATE staff SET title=?, cost=?,description=?,picture=?  WHERE id=?",updatePerson.getTitle(),
                updatePerson.getCost(), updatePerson.getDescription(), updatePerson.getPicture(), id);
    }
    public void delete(int id)
    {
        jdbcTemplate.update("DELETE FROM staff WHERE id=?", id);

    }

}
