package org.backend.DAO.impl;

import org.backend.DAO.TeacherDAO;
import org.backend.entity.Account;
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
public class TeacherIMPL implements TeacherDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Teacher> getAll() {
        String sql = "SELECT * FROM giaovien";
        return jdbcTemplate.query(sql, (ResultSetExtractor<? extends List<Teacher>>) new ResultSetExtractor<List<Teacher>>() {
            @Override
            public List<Teacher> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Teacher> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setId(resultSet.getString("id"));
                    teacher.setName(resultSet.getString("name"));
                    teacher.setAge(resultSet.getInt("age"));
                    teacher.setAddress(resultSet.getString("address"));
                    teacher.setPicture(resultSet.getString("picture"));
                    teacher.setSdt(resultSet.getString("sdt"));
                    ls.add(teacher);
                }
                return ls;
            }
        });
    }

    @Override
    public boolean insert(Teacher teacher) {
        String sql = "INSERT INTO giaovien(`id`,`name`,`age`,`address`,`sdt`) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql, teacher.getId(), teacher.getName(), teacher.getAge(), teacher.getAddress(), teacher.getSdt()) > 0;
    }

    @Override
    public boolean update(String id, Teacher teacher) {
        String sql = "UPDATE giaovien SET name = ?, age = ?, address = ?, sdt = ? WHERE id = ?";
        return jdbcTemplate.update(sql, teacher.getName(), teacher.getAge(), teacher.getAddress(), teacher.getSdt(), id) > 0;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM giaovien where id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public List<Teacher> getById(String id) {
        String sql = "SELECT * FROM giaovien where id = ?";
        return jdbcTemplate.query(sql, (ResultSetExtractor<? extends List<Teacher>>) new ResultSetExtractor<List<Teacher>>() {
            @Override
            public List<Teacher> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Teacher> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setId(resultSet.getString("id"));
                    teacher.setName(resultSet.getString("name"));
                    teacher.setAge(resultSet.getInt("age"));
                    teacher.setAddress(resultSet.getString("address"));
                    teacher.setPicture(resultSet.getString("picture"));
                    teacher.setSdt(resultSet.getString("sdt"));
                    ls.add(teacher);
                }
                return ls;
            }
        }, id);
    }

    @Override
    public Teacher getByUser(String userName) {
        String sql = "SELECT * FROM `giaovien` WHERE giaovien.id = (SELECT account.teacherId FROM account WHERE account.username =  ?  )";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Teacher>() {
            @Override
            public Teacher extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Teacher teacher = new Teacher();
                while (resultSet.next()) {
                    teacher.setId(resultSet.getString("id"));
                    teacher.setName(resultSet.getString("name"));
                    teacher.setAge(resultSet.getInt("age"));
                    teacher.setAddress(resultSet.getString("address"));
                    teacher.setPicture(resultSet.getString("picture"));
                    teacher.setSdt(resultSet.getString("sdt"));
                }
                return teacher;
            }
        }, userName);
    }
}
