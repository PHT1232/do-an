package org.backend.service;


import java.util.List;

import org.backend.entity.Subjects;
import org.backend.models.SubjectsDTO;

public interface SubjectsService {
    List<SubjectsDTO> getAll();

    boolean insert(SubjectsDTO subjects);

    boolean delete(String id);

    boolean update(String id, SubjectsDTO subjects);

    List<SubjectsDTO> getById(String id);

    SubjectsDTO getBySingleId(String id);
}
