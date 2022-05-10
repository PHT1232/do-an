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
                while (resultSet.next()) {
                    bt.setUsername(resultSet.getString("username"));
                    bt.setDeadline(resultSet.getString("deadline"));
                    bt.setTenBaiTap(resultSet.getString("tenBaiTap"));
                    bt.setNoiDungBaiTap(resultSet.getString("noiDungBaiTap"));
                    bt.setClassID(resultSet.getString("classID"));
                    bt.setMonhocID(resultSet.getString("monhocID"));
                }
                return bt;
            }
        }, id);
    }

    @Override
    public int getLastId() {
        String sql = "SELECT max(id) as 'id' FROM baitap";
        return jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                int id = 0;
                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                }
                return id;
            }
        });
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
                    bt.setTenBaiTap(resultSet.getString("tenBaiTap"));
                    bt.setNoiDungBaiTap(resultSet.getString("noiDungBaiTap"));
                    bt.setClassID(resultSet.getString("classID"));
                    bt.setMonhocID(resultSet.getString("monhocID"));
                    ls.add(bt);
                }
                return ls;
            }
        });
    }

    @Override
    public boolean insert(baiTap bt) {
        String sql = "insert into baitap(name, username, deadline, tenBaiTap, noiDungBaiTap, classID, monhocID) values (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, bt.getName(), bt.getUsername(), bt.getDeadline(), bt.getTenBaiTap(), bt.getNoiDungBaiTap(), bt.getClassID(), bt.getMonhocID()) > 0;
    }

    @Override
    public boolean update(baiTap bt) {
        String sql = "update baitap set name = ?, username = ?, deadline = ?, tenBaiTap = ?, noiDungBaiTap = ? where id = ?";
        return jdbcTemplate.update(sql, bt.getName(), bt.getUsername(), bt.getDeadline(), bt.getTenBaiTap(), bt.getNoiDungBaiTap(), bt.getId()) > 0;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from baitap where id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
