package org.backend.service.impl;

import org.backend.DAO.StudentBaiTapDAO;
import org.backend.entity.StudentBaiTap;
import org.backend.models.StudentBaiTapDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentBaiTapService implements org.backend.service.StudentBaiTapService {

    @Autowired
    StudentBaiTapDAO studentBaiTapDAO;

    @Override
    public List<StudentBaiTapDTO> getAll() {
        return null;
    }

    @Override
    public List<StudentBaiTapDTO> getByUserName(String username) {
        return null;
    }

    @Override
    public List<StudentBaiTapDTO> getByBaiTapId(int id) {
        List<StudentBaiTapDTO> lsbtdo = new ArrayList<>();
        for (StudentBaiTap stb : studentBaiTapDAO.getByBaiTapId(id)) {
            StudentBaiTapDTO sbtdo = new StudentBaiTapDTO();
            sbtdo.setId(stb.getId());
            sbtdo.setUsername(stb.getUsername());
            sbtdo.setBaiTapId(stb.getBaiTapId());
            sbtdo.setLienKetName(stb.getLienKetName());
            lsbtdo.add(sbtdo);
        }
        return lsbtdo;
    }

    @Override
    public int getLastId() {
        return studentBaiTapDAO.getLastId();
    }

    @Override
    public StudentBaiTapDTO getByUserNameAndBaiTapId(String username) {
        return null;
    }

    @Override
    public List<StudentBaiTapDTO> getByClassId(String classId) {
        return null;
    }

    @Override
    public boolean insertWithFile(StudentBaiTapDTO sbtdto) {
        StudentBaiTap stb = new StudentBaiTap();
        stb.setUsername(sbtdto.getUsername());
        stb.setBaiTapId(sbtdto.getBaiTapId());
        stb.setLienKetName(sbtdto.getLienKetName());
        return studentBaiTapDAO.insertWithFile(stb);
    }

    @Override
    public boolean insertWithLink(StudentBaiTapDTO sbt) {
        return false;
    }

    @Override
    public boolean insertWithBoth(StudentBaiTapDTO sbt) {
        return false;
    }

    @Override
    public boolean update(StudentBaiTapDTO sbt) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
