package org.backend.service;

import org.backend.entity.StudentBaiTap;

import java.util.List;

public interface StudentBaiTapService {
    List<StudentBaiTap> getAll();
    List<StudentBaiTap> getByUserName(String username);
    StudentBaiTap getByUserNameAndClassId(String username);
    List<StudentBaiTap> getByClassId(String classId);
    boolean insertWithFile(StudentBaiTap sbt);
    boolean insertWithLink(StudentBaiTap sbt);
    boolean insertWithBoth(StudentBaiTap sbt);
    boolean update(StudentBaiTap sbt);
    boolean delete(int id);
}
