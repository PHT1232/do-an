package org.backend.DAO.impl;

import org.backend.DAO.FileDAO;
import org.backend.entity.Files;
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
public class FileIMPL implements FileDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Files> getAll() {
        return null;
    }

    @Override
    public Files getById(int id) {
        return null;
    }

    @Override
    public List<Files> getListById(int id) {
        String sql = "SELECT * FROM files WHERE nopBaiTapId = ? or baiTapId = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<Files>>() {
            @Override
            public List<Files> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Files> ls = new ArrayList();
                while (resultSet.next()) {
                    Files bt = new Files();
                    bt.setId(resultSet.getInt("id"));
                    bt.setFilename(resultSet.getString("filename"));
                    bt.setBaiTapId(resultSet.getInt("baiTapId"));
                    bt.setNopBaiTapId(resultSet.getInt("nopBaiTapId"));
                    ls.add(bt);
                }
                return ls;
            }
        }, id, id);
    }

    @Override
    public boolean insert(Files f) {
        String sql = "INSERT INTO files (`filename`,`baiTapId`,`nopBaiTapId`) VALUES (?,?,?)";
        return jdbcTemplate.update(sql, f.getFilename(), f.getBaiTapId(), f.getNopBaiTapId()) > 0;
    }

    @Override
    public boolean update(Files f) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
