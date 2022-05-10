package org.backend.DAO;

import org.backend.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAll();

    boolean insert(Student student);

    boolean delete(String id);

    boolean update(String id, Student student);

    List<Student> getById(String id);
    Student getByStudentId(String id);

    Student getByUser(String username);
    List<Student> getByUsername(String username);
    List<Student> getByClassId(String id);
}
