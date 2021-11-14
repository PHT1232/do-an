package org.backend.DAO.impl;

import org.backend.DAO.baiTapDAO;
import org.backend.entity.baiTap;
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
public class baiTapIMPL implements baiTapDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<baiTap> getAll() {
        return null;
    }

    @Override
    public baiTap getById(int id) {
        String sql = "SELECT * FROM baitap WHERE id = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<baiTap>() {
            @Override
            public baiTap extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                baiTap bt = new baiTap();
                bt.setName(resultSet.getString("name"));
                bt.setUsername(resultSet.getString("username"));
                bt.setDeadline(resultSet.getString("deadline"));
                bt.setDeadline(resultSet.getString("file"));
                bt.setTenBaiTap(resultSet.getString("tenBaiTap"));
                bt.setNoiDungBaiTap(resultSet.getString("noiDungBaiTap"));
                return bt;
            }
        }, id);
    }

    @Override
    public List<baiTap> getListById(int id) {
        String sql = "SELECT * FROM baitap WHERE classId = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<baiTap>>() {
            @Override
            public List<baiTap> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<baiTap> ls = new ArrayList();
                while (resultSet.next()) {
                    baiTap bt = new baiTap();
                    bt.setName(resultSet.getString("name"));
                    bt.setUsername(resultSet.getString("username"));
                    bt.setDeadline(resultSet.getString("deadline"));
                    bt.setDeadline(resultSet.getString("file"));
                    bt.setTenBaiTap(resultSet.getString("tenBaiTap"));
                    bt.setNoiDungBaiTap(resultSet.getString("noiDungBaiTap"));
                    ls.add(bt);
                }
                return ls;
            }
        });
    }

    @Override
    public boolean insert(baiTap bt) {
        String sql = "insert into baitap(name, username, deadline, file, tenBaiTap, noiDungBaiTap) values (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, bt.getName(), bt.getUsername(), bt.getDeadline(), bt.getFile(), bt.getTenBaiTap(), bt.getNoiDungBaiTap()) > 0;
    }

    @Override
    public boolean update(baiTap bt) {
        String sql = "update baitap set name = ?, username = ?, deadline = ?, file = ?, tenBaiTap = ?, noiDungBaiTap = ? where id = ?";
        return jdbcTemplate.update(sql, bt.getName(), bt.getUsername(), bt.getDeadline(), bt.getFile(), bt.getTenBaiTap(), bt.getNoiDungBaiTap(), bt.getId()) > 0;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from baitap where id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
