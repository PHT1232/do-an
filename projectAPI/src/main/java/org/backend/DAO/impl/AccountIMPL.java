package org.backend.DAO.impl;

import org.backend.DAO.AccountDAO;
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
public class AccountIMPL implements AccountDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> getAll() {
        String sql = "SELECT account.username, password, teacherId, studentId, enabled, authority FROM account inner join authorities on authorities.username = account.username";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<Account>>() {
            @Override
            public List<Account> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Account> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Account ac = new Account();
                    ac.setPassword(resultSet.getString("password"));
                    ac.setUserName(resultSet.getString("userName"));
                    ac.setStudentId(resultSet.getString("studentId"));
                    ac.setTeacherId(resultSet.getString("teacherId"));
                    ac.setAuthority(resultSet.getString("authority"));
                    ac.setEnabled(resultSet.getBoolean("enabled"));
                    ls.add(ac);
                }
                return ls;
            }
        });
    }

    @Override
    public boolean insert(Account account) {
        String sql = "INSERT INTO account VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql, account.getUserName(), account.getPassword(), account.getTeacherId(), account.getStudentId(), account.isEnabled()) > 0;
    }

    @Override
    public boolean insertAuthorities(String username, String authorities) {
        String sql = "INSERT INTO authorities VALUES (?,?)";
        return jdbcTemplate.update(sql, username, authorities) > 0;
    }

    @Override
    public boolean update(String id, Account account) {
        String sql = "UPDATE account SET username = ?, password = ?, teacherId = ?, studentId = ?, authority = ?, enabled = true WHERE id = ?";
        return jdbcTemplate.update(sql, account.getUserName(), account.getPassword(), account.getTeacherId(), account.getStudentId(), account.getAuthority(), id) > 0;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM account WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public List<Teacher> getById(String name) {
        String sql = "SELECT id, name, age, address, picture, sdt FROM account inner join giaovien on giaovien.id = account.teacherId WHERE account.username = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<Teacher>>() {
            @Override
            public List<Teacher> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Teacher> ls = new ArrayList<>();
                while (resultSet.next()) {
                    Teacher tc = new Teacher();
                    tc.setId(resultSet.getString("id"));
                    tc.setName(resultSet.getString("name"));
                    tc.setAddress(resultSet.getString("address"));
                    tc.setAge(resultSet.getInt("age"));
                    tc.setPicture(resultSet.getString("picture"));
                    tc.setSdt(resultSet.getString("sdt"));
                    ls.add(tc);
                }
                return ls;
            }
        }, name);
    }

    @Override
    public Account getByUserName(String userName) {
        String sql = "SELECT * FROM account where username = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Account>() {
            @Override
            public Account extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                Account ac = new Account();
                while (resultSet.next()) {
                    ac.setPassword(resultSet.getString("password"));
                    ac.setUserName(resultSet.getString("userName"));
                    ac.setStudentId(resultSet.getString("studentId"));
                    ac.setTeacherId(resultSet.getString("teacherId"));
                }
                return ac;
            }
        }, userName);
    }

    @Override
    public List<String> getUserRoles(String username) {
        String sql = "SELECT authority FROM authorities WHERE username = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<String>>() {
            @Override
            public List<String> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<String> roles = new ArrayList<>();
                while (resultSet.next()) {
                    roles.add(resultSet.getString("authority"));
                }
                return roles;
            }
        }, username);
    }
}
