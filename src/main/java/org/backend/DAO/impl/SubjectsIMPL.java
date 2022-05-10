package org.backend.DAO.impl;

import org.backend.DAO.SubjectsDAO;
import org.backend.entity.Subjects;
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
public class SubjectsIMPL implements SubjectsDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Subjects> getAll() {
        String sql = "SELECT * FROM monhoc";
        return jdbcTemplate.query(sql, (ResultSetExtractor<? extends List<Subjects>>) new ResultSetExtractor<List<Subjects>>() {
            @Override
            public List<Subjects> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Subjects> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Subjects st = new Subjects();
                    st.setId(resultSet.getString("id"));
                    st.setName(resultSet.getString("monName"));
                    st.setClassId(resultSet.getString("classId"));
                    ls.add(st);
                }
                return ls;
            }
        });
    }

    @Override
    public boolean insert(Subjects Subjects) {
        String sql = "INSERT INTO monhoc(`id`,`monName`) Values (?,?)";
        return jdbcTemplate.update(sql, Subjects.getId(), Subjects.getName()) > 0;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM monhoc where id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public boolean update(String id, Subjects Subjects) {
        String sql = "UPDATE monhoc SET name = ?, age = ?, address = ?, sdt = ? where id = ?";
        return jdbcTemplate.update(sql, Subjects.getId(), Subjects.getName(), Subjects.getClassId(), id) > 0;
    }

    @Override
    public List<Subjects> getById(String id) {
        String sql = "SELECT * FROM monhoc where id = ?";
        return jdbcTemplate.query(sql, (ResultSetExtractor<? extends List<Subjects>>) new ResultSetExtractor<List<Subjects>>() {
            @Override
            public List<Subjects> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Subjects> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Subjects st = new Subjects();
                    st.setId(resultSet.getString("id"));
                    st.setName(resultSet.getString("monName"));
                    st.setClassId(resultSet.getString("classId"));
                    ls.add(st);
                }
                return ls;
            }
        }, id);
    }

    @Override
    public Subjects getBySingleId(String id) {
        String sql = "SELECT * FROM monhoc where id = ?";
        return jdbcTemplate.query(sql, (ResultSetExtractor<? extends Subjects>) new ResultSetExtractor<Subjects>() {
            @Override
            public Subjects extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Subjects st = new Subjects();
                while (resultSet.next()) {
                    st.setId(resultSet.getString("id"));
                    st.setName(resultSet.getString("monName"));
                    st.setClassId(resultSet.getString("classId"));
                }
                return st;
            }
        }, id);
    }

}