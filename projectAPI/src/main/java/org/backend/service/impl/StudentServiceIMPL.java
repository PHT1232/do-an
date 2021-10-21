package org.backend.service.impl;

import org.backend.DAO.StudentDAO;
import org.backend.entity.Student;
import org.backend.models.StudentDTO;
import org.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Override
    public List<StudentDTO> getAll() {
        List<StudentDTO> lsDTO = new ArrayList<>();
        List<Student> ls = studentDAO.getAll();
        for (Student student : ls) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            studentDTO.setAge(student.getAge());
            studentDTO.setAddress(student.getAddress());
            studentDTO.setPicture(student.getPicture());
            studentDTO.setSdt(student.getSdt());
            lsDTO.add(studentDTO);
        }
        return lsDTO;
    }

    @Override
    public boolean insert(StudentDTO studentDTO) {
        Student st = new Student();
        st.setId(studentDTO.getId());
        st.setName(studentDTO.getName());
        st.setAge(studentDTO.getAge());
        st.setAddress(studentDTO.getAddress());
        st.setSdt(studentDTO.getSdt());
        return studentDAO.insert(st);
    }

    @Override
    public boolean delete(String id) {
        return studentDAO.delete(id);
    }

    @Override
    public boolean update(String id, StudentDTO studentDTO) {
        Student st = new Student();
        st.setName(studentDTO.getName());
        st.setAddress(studentDTO.getAddress());
        st.setAge(studentDTO.getAge());
        st.setSdt(studentDTO.getSdt());
        return studentDAO.update(id, st);
    }

    @Override
    public List<StudentDTO> getById(String id) {
        List<StudentDTO> lsDTO = new ArrayList<>();
        List<Student> ls = studentDAO.getById(id);
        for (Student student : ls) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            studentDTO.setAge(student.getAge());
            studentDTO.setAddress(student.getAddress());
            studentDTO.setPicture(student.getPicture());
            studentDTO.setSdt(student.getSdt());
            lsDTO.add(studentDTO);
        }
        return lsDTO;
    }
}
