package org.backend.DAO.impl;

import org.backend.DAO.LearningDAO;
import org.backend.entity.Learning;
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
public class LearningIMPL implements LearningDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Learning> getAll() {
        String sql = "SELECT * FROM danghoc";
        return jdbcTemplate.query(sql, (ResultSetExtractor<? extends List<Learning>>) new ResultSetExtractor<List<Learning>>() {
            @Override
            public List<Learning> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Learning> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Learning st = new Learning();
                    st.setId(resultSet.getString("id"));
                    st.setIdMon(resultSet.getString("idMon"));
                    st.setIdStudent(resultSet.getString("idStudent"));
                    st.setIdTeacher(resultSet.getString("idTeacher"));
                    ls.add(st);
                }
                return ls;
            }
        });
    }

    @Override
    public boolean insert(Learning learning) {
        String sql = "INSERT INTO danghoc(`id`,`idMon`,`idStudent`,`idTeacher`) Values (?,?,?,?)";
        return jdbcTemplate.update(sql, learning.getId(), learning.getIdMon(), learning.getIdStudent(), learning.getIdTeacher()) > 0;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM danghoc where id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public boolean update(String id, Learning learning) {
        String sql = "UPDATE danghoc SET name = ?, age = ?, address = ?, sdt = ? where id = ?";
        return jdbcTemplate.update(sql, learning.getId(), learning.getIdMon(), learning.getIdStudent(), learning.getIdTeacher(), id) > 0;
    }

    @Override
    public List<Learning> getById(String id) {
        String sql = "SELECT * FROM danghoc where id = ?";
        return jdbcTemplate.query(sql, (ResultSetExtractor<? extends List<Learning>>) new ResultSetExtractor<List<Learning>>() {
            @Override
            public List<Learning> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Learning> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Learning st = new Learning();
                    st.setId(resultSet.getString("id"));
                    st.setIdMon(resultSet.getString("idMon"));
                    st.setIdStudent(resultSet.getString("idStudent"));
                    st.setIdTeacher(resultSet.getString("idTeacher"));
                    ls.add(st);
                }
                return ls;
            }
        });
    }
}