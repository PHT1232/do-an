package org.backend.service;


import java.util.List;

import org.backend.models.LearningDTO;

public interface LearningService {
    List<LearningDTO> getAll();

    boolean insert(LearningDTO learning);

    boolean delete(String id);

    boolean update(String id, LearningDTO learning);

    List<LearningDTO> getById(String id);

    List<LearningDTO> getByTeacherId(String id);

    List<LearningDTO> getByTeacherIdAndMon(String id, String mon);
}
