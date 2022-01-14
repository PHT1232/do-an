package org.backend.DAO.impl;

import org.backend.DAO.StudentDAO;
import org.backend.entity.Student;
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
public class StudentIMPL implements StudentDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getAll() {
        String sql = "SELECT * FROM sinhVien";
        return jdbcTemplate.query(sql, (ResultSetExtractor<? extends List<Student>>) new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Student> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Student st = new Student();
                    st.setId(resultSet.getString("id"));
                    st.setName(resultSet.getString("name"));
                    st.setAge(resultSet.getInt("age"));
                    st.setAddress(resultSet.getString("address"));
                    st.setPicture(resultSet.getString("picture"));
                    st.setSdt(resultSet.getString("sdt"));
                    ls.add(st);
                }
                return ls;
            }
        });
    }

    @Override
    public boolean insert(Student student) {
        String sql = "INSERT INTO sinhVien(`id`,`name`,`age`,`address`,`sdt`) Values (?,?,?,?,?)";
        return jdbcTemplate.update(sql, student.getId(), student.getName(), student.getAge(), student.getAddress(),student.getSdt()) > 0;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM sinhvien where id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public boolean update(String id, Student student) {
        String sql = "UPDATE sinhvien SET name = ?, age = ?, address = ?, sdt = ? where id = ?";
        return jdbcTemplate.update(sql, student.getName(), student.getAge(), student.getAddress(),student.getSdt(), id) > 0;
    }

    @Override
    public List<Student> getById(String id) {
        String sql = "SELECT * FROM sinhvien where id=?";
        return jdbcTemplate.query(sql, (ResultSetExtractor<? extends List<Student>>) new ResultSetExtractor<List<Student>>() {
            @Override
            public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Student> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Student st = new Student();
                    st.setId(resultSet.getString("id"));
                    st.setName(resultSet.getString("name"));
                    st.setAge(resultSet.getInt("age"));
                    st.setAddress(resultSet.getString("address"));
                    st.setPicture(resultSet.getString("picture"));
                    st.setSdt(resultSet.getString("sdt"));
                    ls.add(st);
                }
                return ls;
            }
        });
    }
}