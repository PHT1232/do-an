package org.backend.service.impl;

import org.backend.DAO.TeacherDAO;
import org.backend.entity.Teacher;
import org.backend.models.TeacherDTO;
import org.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceIMPL implements TeacherService {

    @Autowired
    TeacherDAO teacherDAO;

    @Override
    public List<TeacherDTO> getAll() {
        List<TeacherDTO> lsDTO = new ArrayList<>();
        List<Teacher> ls = teacherDAO.getAll();
        for (Teacher tc : ls) {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setId(tc.getId());
            teacherDTO.setName(tc.getName());
            teacherDTO.setAge(tc.getAge());
            teacherDTO.setAddress(tc.getAddress());
            teacherDTO.setPicture(tc.getPicture());
            teacherDTO.setSdt(tc.getSdt());
            lsDTO.add(teacherDTO);
        }
        return lsDTO;
    }

    @Override
    public boolean insert(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setName(teacherDTO.getName());
        teacher.setAge(teacherDTO.getAge());
        teacher.setAddress(teacherDTO.getAddress());
        teacher.setSdt(teacherDTO.getSdt());
        return teacherDAO.insert(teacher);
    }

    @Override
    public boolean delete(String id) {
        return teacherDAO.delete(id);
    }

    @Override
    public boolean update(String id, TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setAge(teacherDTO.getAge());
        teacher.setAddress(teacherDTO.getAddress());
        teacher.setSdt(teacherDTO.getSdt());
        return teacherDAO.update(id, teacher);
    }

    @Override
    public List<TeacherDTO> getById(String id) {
        List<TeacherDTO> lsDTO = new ArrayList<>();
        List<Teacher> ls = teacherDAO.getById(id);
        for (Teacher tc : ls) {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setId(tc.getId());
            teacherDTO.setName(tc.getName());
            teacherDTO.setAge(tc.getAge());
            teacherDTO.setAddress(tc.getAddress());
            teacherDTO.setPicture(tc.getPicture());
            teacherDTO.setSdt(tc.getSdt());
            lsDTO.add(teacherDTO);
        }
        return lsDTO;
    }
    @Override
    public TeacherDTO getByUser(String id){
        Teacher ls = teacherDAO.getByUser(id);
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(ls.getId());
        teacherDTO.setName(ls.getName());
        teacherDTO.setAge(ls.getAge());
        teacherDTO.setAddress(ls.getAddress());
        teacherDTO.setPicture(ls.getPicture());
        teacherDTO.setSdt(ls.getSdt());


        return teacherDTO;
    }
}
