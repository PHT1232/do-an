package org.backend.models;

import java.util.List;

import org.backend.entity.Subjects;

public class LearningDTO {
    private String id;
    private String idStudent;
    private String idMon;
    private String idTeacher;


    public LearningDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdMon() {
        return idMon;
    }

    public void setIdMon(String idMon) {
        this.idMon = idMon;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public LearningDTO(String id, String idStudent, String idMon, String idTeacher) {
        this.id = id;
        this.idStudent = idStudent;
        this.idMon = idMon;
        this.idTeacher = idTeacher;
    }
}