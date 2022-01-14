package org.backend.DAO.impl;

import org.backend.DAO.StudentBaiTapDAO;
import org.backend.entity.Student;
import org.backend.entity.StudentBaiTap;
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
public class StudentBaiTapIMPL implements StudentBaiTapDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<StudentBaiTap> getAll() {
        return null;
    }

    @Override
    public List<StudentBaiTap> getByUserName(String username) {
        String sql = "Select * from studentBaiTap where username = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<StudentBaiTap>>() {
            @Override
            public List<StudentBaiTap> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<StudentBaiTap> ls = new ArrayList<>();
                while (resultSet.next()) {
                    
                }
                return null;
            }
        });
    }

    @Override
    public List<StudentBaiTap> getByBaiTapId(int id) {
        String sql = "SELECT * FROM studentBaiTap where baiTapid = ?";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<StudentBaiTap>>() {
            @Override
            public List<StudentBaiTap> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<StudentBaiTap> ls = new ArrayList<>();
                while (rs.next()) {
                    StudentBaiTap stbt = new StudentBaiTap();
                    stbt.setId(rs.getInt("id"));
                    stbt.setUsername(rs.getString("username"));
                    stbt.setBaiTapId(rs.getInt("baiTapId"));
                    stbt.setLienKetName(rs.getString("lienket"));
                    ls.add(stbt);
                }
                return ls;
            }
        }, id);
    }


    @Override
    public int getLastId() {
        String sql = "SELECT max(id) as 'id' FROM studentbaitap";
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
    public StudentBaiTap getByUserNameAndBaiTapId(String username) {
        return null;
    }

    @Override
    public List<StudentBaiTap> getByClassId(String classId) {
        return null;
    }

    @Override
    public boolean insertWithFile(StudentBaiTap sbt) {
        String sql = "INSERT INTO studentBaiTap(`username`, `baiTapId`, `lienket`) VALUES (?,?,?)";
        return jdbcTemplate.update(sql, sbt.getUsername(), sbt.getBaiTapId(), sbt.getLienKetName()) > 0;
    }

    @Override
    public boolean insertWithLink(StudentBaiTap sbt) {
        return false;
    }

    @Override
    public boolean insertWithBoth(StudentBaiTap sbt) {
        return false;
    }

    @Override
    public boolean update(StudentBaiTap sbt) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
