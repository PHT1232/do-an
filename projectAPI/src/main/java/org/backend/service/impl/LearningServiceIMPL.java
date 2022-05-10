package org.backend.service.impl;

import org.backend.DAO.LearningDAO;
import org.backend.entity.Learning;
import org.backend.models.LearningDTO;
import org.backend.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LearningServiceIMPL implements LearningService {

    @Autowired
    LearningDAO learningDAO;

    @Override
    public List<LearningDTO> getAll() {
        List<LearningDTO> lsDTO = new ArrayList<>();
        List<Learning> ls = learningDAO.getAll();
        for (Learning learning : ls) {
            LearningDTO learningDTO = new LearningDTO();
            learningDTO.setId(learning.getId());
            learningDTO.setIdStudent(learning.getIdStudent());
            learningDTO.setIdMon(learning.getIdMon());
            learningDTO.setIdTeacher(learning.getIdTeacher());
            lsDTO.add(learningDTO);
        }
        return lsDTO;
    }

    @Override
    public boolean insert(LearningDTO learningDTO) {
        Learning st = new Learning();
        st.setId(learningDTO.getId());
        st.setIdStudent(learningDTO.getIdStudent());
        st.setIdMon(learningDTO.getIdMon());
        st.setIdTeacher(learningDTO.getIdTeacher());
        return learningDAO.insert(st);
    }

    @Override
    public boolean delete(String id) {
        return learningDAO.delete(id);
    }

    @Override
    public boolean update(String id, LearningDTO learningDTO) {
        Learning st = new Learning();
        st.setIdStudent(learningDTO.getIdStudent());
        st.setIdMon(learningDTO.getIdMon());
        st.setIdTeacher(learningDTO.getIdTeacher());
        return learningDAO.update(id, st);
    }

    @Override
    public List<LearningDTO> getById(String id) {
        List<LearningDTO> lsDTO = new ArrayList<>();
        List<Learning> ls = learningDAO.getById(id);
        for (Learning learning : ls) {
            LearningDTO learningDTO = new LearningDTO();
            learningDTO.setId(learning.getId());
            learningDTO.setIdStudent(learning.getIdStudent());
            learningDTO.setIdMon(learning.getIdMon());
            learningDTO.setIdTeacher(learning.getIdTeacher());
            lsDTO.add(learningDTO);
        }
        return lsDTO;
    }

}
