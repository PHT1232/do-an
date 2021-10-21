package org.backend.DAO;

import org.backend.entity.Teacher;

import java.util.List;

public interface TeacherDAO {
    List<Teacher> getAll();
    boolean insert(Teacher teacher);
    boolean update(String id, Teacher teacher);
    boolean delete(String id);
    List<Teacher> getById(String id);
}
