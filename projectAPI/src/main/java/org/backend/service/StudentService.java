package org.backend.service;

import org.backend.models.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAll();

    boolean insert(StudentDTO StudentDTO);

    boolean delete(String id);

    boolean update(String id, StudentDTO studentDTO);

    List<StudentDTO> getById(String id);

    List<StudentDTO> getByUsername(String username);
}
