package org.backend.service.impl;

import org.backend.DAO.ClassesDAO;
import org.backend.entity.Classes;
import org.backend.models.ClassesDTO;
import org.backend.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassesServiceIMPL implements ClassesService {

    @Autowired
    ClassesDAO ClassesDAO;

    @Override
    public List<ClassesDTO> getAll() {
        List<ClassesDTO> lsDTO = new ArrayList<>();
        List<Classes> ls = ClassesDAO.getAll();
        for (Classes classes : ls) {
            ClassesDTO classesDTO = new ClassesDTO();
            classesDTO.setId(classes.getId());
            classesDTO.setName(classes.getName());
            lsDTO.add(classesDTO);
        }
        return lsDTO;
    }

    @Override
    public boolean insert(ClassesDTO classesDTO) {
        Classes st = new Classes();
        st.setId(classesDTO.getId());
        st.setName(classesDTO.getName());
        return ClassesDAO.insert(st);
    }

    @Override
    public boolean delete(String id) {
        return ClassesDAO.delete(id);
    }

    @Override
    public boolean update(String id, ClassesDTO classesDTO) {
        Classes st = new Classes();
        st.setName(classesDTO.getName());
        return ClassesDAO.update(id, st);
    }

    @Override
    public List<ClassesDTO> getById(String id) {
        List<ClassesDTO> lsDTO = new ArrayList<>();
        List<Classes> ls = ClassesDAO.getById(id);
        for (Classes classes : ls) {
            ClassesDTO ClassesDTO = new ClassesDTO();
            ClassesDTO.setId(classes.getId());
            ClassesDTO.setName(classes.getName());
            lsDTO.add(ClassesDTO);
        }
        return lsDTO;
    }

    @Override
    public ClassesDTO getBySingleId(String id) {
        ClassesDTO cdt = new ClassesDTO();
        Classes cl = ClassesDAO.getBySingleId(id);
        cdt.setId(cl.getId());
        cdt.setName(cl.getName());
        return cdt;
    }

    @Override
    public ClassesDTO getByUser(String id) {
        // TODO Auto-generated method stub
        return null;
    }
}
