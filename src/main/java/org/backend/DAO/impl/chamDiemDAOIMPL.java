package org.backend.DAO.impl;

import org.backend.DAO.chamDiemDAO;
import org.backend.entity.chamDiem;
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
public class chamDiemDAOIMPL implements chamDiemDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<chamDiem> getAll() {
        return null;
    }

    @Override
    public chamDiem getById(int id) {
        return null;
    }

    @Override
    public chamDiem getByBaiTapId(String baiTap) {
        return null;
    }

    @Override
    public chamDiem getByStudentId(String studentId) {
        String sql = "SELECT * FROM chamDiem where studentId = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<chamDiem>() {
            @Override
            public chamDiem extractData(ResultSet rs) throws SQLException, DataAccessException {
                chamDiem cd = new chamDiem();
                while (rs.next()) {
                    cd.setId(rs.getInt("id"));
                    cd.setDiem(rs.getInt("diem"));
                    cd.setBaiTapId(rs.getInt("baitapId"));
                    cd.setStudentId(rs.getString("studentId"));
                }
                return cd;
            }
        }, studentId);
    }

    @Override
    public int getLastId() {
        return 0;
    }

    @Override
    public List<chamDiem> getListById(String id, String monhoc) {
        return null;
    }

    @Override
    public List<chamDiem> getListByBaiTapId(int baiTap) {
        String sql = "SELECT * FROM chamDiem where baitapId = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<chamDiem>>() {
            @Override
            public List<chamDiem> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<chamDiem> ls = new ArrayList<>();
                while (rs.next()) {
                    chamDiem cd = new chamDiem();
                    cd.setId(rs.getInt("id"));
                    cd.setDiem(rs.getInt("diem"));
                    cd.setBaiTapId(rs.getInt("baitapId"));
                    cd.setStudentId(rs.getString("studentId"));
                    ls.add(cd);
                }
                return ls;
            }
        }, baiTap);
    }

    @Override
    public List<chamDiem> getListByStudentId(String studentId) {
        String sql = "SELECT * FROM chamDiem where studentId = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<chamDiem>>() {
            @Override
            public List<chamDiem> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<chamDiem> ls = new ArrayList<>();
                while (rs.next()) {
                    chamDiem cd = new chamDiem();
                    cd.setId(rs.getInt("id"));
                    cd.setDiem(rs.getInt("diem"));
                    cd.setBaiTapId(rs.getInt("baitapId"));
                    cd.setStudentId(rs.getString("studentId"));
                    ls.add(cd);
                }
                return ls;
            }
        }, studentId);
    }

    @Override
    public boolean insert(chamDiem bt) {
        String sql = "INSERT INTO chamDiem(`diem`,`baitapId`,`studentId`) VALUES(?,?,?)";
        return jdbcTemplate.update(sql, bt.getDiem(), bt.getBaiTapId(), bt.getStudentId()) > 0;
    }

    @Override
    public boolean update(chamDiem bt) {
        String sql = "UPDATE chamDiem SET diem = ?, baitapId = ?, studentId = ? where id = ?)";
        return jdbcTemplate.update(sql, bt.getDiem(), bt.getBaiTapId(), bt.getStudentId(), bt.getId()) > 0;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
