package org.backend.service;

import org.backend.models.TeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getAll();
    boolean insert(TeacherDTO teacherDTO);
    boolean delete(String id);
    boolean update(String id, TeacherDTO teacherDTO);
    List<TeacherDTO> getById(String id);
}
