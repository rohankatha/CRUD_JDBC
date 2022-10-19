package com.example.sqljdbc.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.sqljdbc.model.Data;

@Repository
public class JdbcDataRepository implements DataRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Data temp) {
        return jdbcTemplate.update("INSERT INTO testdb (title, description, published) VALUES(?,?,?)",
                new Object[] { temp.getTitle(), temp.getDescription(), temp.isPublished() });
    }

    @Override
    public int update(Data temp) {
        return jdbcTemplate.update("UPDATE testdb SET title=?, description=?, published=? WHERE id=?",
                new Object[] { temp.getTitle(), temp.getDescription(), temp.isPublished(), temp.getId() });
    }

    @Override
    public Data findById(Long id) {
        try {
            Data temp = jdbcTemplate.queryForObject("SELECT * FROM testdb WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Data.class), id);

            return temp;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM testdb WHERE id=?", id);
    }

    @Override
    public List<Data> findAll() {
        return jdbcTemplate.query("SELECT * from testdb", BeanPropertyRowMapper.newInstance(Data.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE from temps");
    }
}
