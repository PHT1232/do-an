package org.backend.DAO;

import org.backend.entity.StudentBaiTap;

import java.util.List;

public interface StudentBaiTapDAO {
    List<StudentBaiTap> getAll();
    List<StudentBaiTap> getByUserName(String username);
    StudentBaiTap getByUserNameAndClassId(String username);
    List<StudentBaiTap> getByClassId(String classId);
    boolean insert(StudentBaiTap sbt);
    boolean update(StudentBaiTap sbt);
    boolean delete(int id);
}
