package org.backend.service;

import org.backend.models.StudentBaiTapDTO;

import java.util.List;

public interface StudentBaiTapService {
    List<StudentBaiTapDTO> getAll();

    List<StudentBaiTapDTO> getByUserName(String username);

    List<StudentBaiTapDTO> getByBaiTapId(int id);

    int getLastId();

    StudentBaiTapDTO getByUserNameAndBaiTapId(String username);

    List<StudentBaiTapDTO> getByClassId(String classId);

    boolean insertWithFile(StudentBaiTapDTO sbt);

    boolean insertWithLink(StudentBaiTapDTO sbt);

    boolean insertWithBoth(StudentBaiTapDTO sbt);

    boolean update(StudentBaiTapDTO sbt);

    boolean delete(int id);
}
