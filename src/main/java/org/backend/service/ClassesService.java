package org.backend.service;

import org.backend.models.ClassesDTO;

import java.util.List;

public interface ClassesService {
    List<ClassesDTO> getAll();

    boolean insert(ClassesDTO classes);

    boolean update(String id, ClassesDTO classes);

    boolean delete(String id);

    List<ClassesDTO> getById(String id);

    ClassesDTO getBySingleId(String id);

    ClassesDTO getByUser(String id);
}
