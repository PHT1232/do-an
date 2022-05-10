package org.backend.DAO.impl;

import org.backend.DAO.ClassesDAO;
import org.backend.DAO.ClassesDAO;
import org.backend.entity.Classes;
import org.backend.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassesIMPL implements ClassesDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Classes> getAll() {
        String sql = "SELECT id, name FROM lophoc";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<Classes>>() {
            @Override
            public List<Classes> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Classes> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Classes ac = new Classes();
                    ac.setName(resultSet.getString("name"));
                    ac.setId(resultSet.getString("id"));
                    ls.add(ac);
                }
                return ls;
            }
        });
    }

    @Override
    public boolean insert(Classes classes) {
        String sql = "INSERT INTO lophoc(id,name) VALUES (?,?)";
        return jdbcTemplate.update(sql, classes.getId(), classes.getName()) > 0;
    }


    @Override
    public boolean update(String id, Classes classes) {
        String sql = "UPDATE lophoc SET id = ?, name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, classes.getId(), classes.getName()) > 0;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM lophoc WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public List<Classes> getById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Classes getByUser(String id) {
        // TODO Auto-generated method stub
        return null;
    }

}
