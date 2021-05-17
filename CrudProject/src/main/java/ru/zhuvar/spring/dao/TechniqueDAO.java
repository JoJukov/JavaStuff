package ru.zhuvar.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.zhuvar.spring.models.Technique;

import java.util.List;

@Component
public class TechniqueDAO {
    private static final int AMOUNT = 4;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TechniqueDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Technique> index() {
        return jdbcTemplate.query("SELECT * FROM TECH", new BeanPropertyRowMapper<>(Technique.class));
    }

    public Technique show(int id) {
        return jdbcTemplate.query("SELECT * FROM TECH WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Technique.class))
                .stream().findAny().orElse(null);
    }

    public void save(Technique technique) {
        jdbcTemplate.update("INSERT INTO TECH VALUES(1, ?, ?, ?)",
                technique.getName(), technique.getWheels(), technique.getGuns());
    }

    public void update(int id, Technique techUpd) {
        jdbcTemplate.update("UPDATE TECH SET name=?, wheels=?, guns=? where id=?",
                techUpd.getName(), techUpd.getWheels(), techUpd.getGuns(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM TECH WHERE id=?", id);
    }
}
