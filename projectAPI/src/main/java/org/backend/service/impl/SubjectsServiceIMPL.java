package org.backend.service.impl;

import org.backend.DAO.SubjectsDAO;
import org.backend.entity.Subjects;
import org.backend.models.SubjectsDTO;
import org.backend.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectsServiceIMPL implements SubjectsService {

    @Autowired
    SubjectsDAO subjectsDAO;

    @Override
    public List<SubjectsDTO> getAll() {
        List<SubjectsDTO> lsDTO = new ArrayList<>();
        List<Subjects> ls = subjectsDAO.getAll();
        for (Subjects Subjects : ls) {
            SubjectsDTO SubjectsDTO = new SubjectsDTO();
            SubjectsDTO.setId(Subjects.getId());
            SubjectsDTO.setName(Subjects.getName());
            SubjectsDTO.setClassId(Subjects.getClassId());
            lsDTO.add(SubjectsDTO);
        }
        return lsDTO;
    }

    @Override
    public boolean insert(SubjectsDTO SubjectsDTO) {
        Subjects st = new Subjects();
        st.setId(SubjectsDTO.getId());
        st.setName(SubjectsDTO.getName());
        st.setClassId(SubjectsDTO.getClassId());
        return subjectsDAO.insert(st);
    }

    @Override
    public boolean delete(String id) {
        return subjectsDAO.delete(id);
    }

    @Override
    public boolean update(String id, SubjectsDTO SubjectsDTO) {
        Subjects st = new Subjects();
        st.setName(SubjectsDTO.getName());
        st.setClassId(SubjectsDTO.getClassId());
        return subjectsDAO.update(id, st);
    }

    @Override
    public List<SubjectsDTO> getById(String id) {
        List<SubjectsDTO> lsDTO = new ArrayList<>();
        List<Subjects> ls = subjectsDAO.getById(id);
        for (Subjects Subjects : ls) {
            SubjectsDTO SubjectsDTO = new SubjectsDTO();
            SubjectsDTO.setId(Subjects.getId());
            SubjectsDTO.setName(Subjects.getName());
            SubjectsDTO.setClassId(Subjects.getClassId());
            lsDTO.add(SubjectsDTO);
        }
        return lsDTO;
    }

}
