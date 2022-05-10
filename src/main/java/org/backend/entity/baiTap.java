package org.backend.entity;

import java.util.List;

public class baiTap {
    private int id;
    private String name;
    private String username;
    private String deadline;
    private List<String> file;
    private String tenBaiTap;
    private String noiDungBaiTap;
    private String classID;
    private String monhocID;

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getMonhocID() {
        return monhocID;
    }

    public void setMonhocID(String monhocID) {
        this.monhocID = monhocID;
    }

    public baiTap() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public List<String> getFile() {
        return file;
    }

    public void setFile(List<String> file) {
        this.file = file;
    }

    public String getTenBaiTap() {
        return tenBaiTap;
    }

    public void setTenBaiTap(String tenBaiTap) {
        this.tenBaiTap = tenBaiTap;
    }

    public String getNoiDungBaiTap() {
        return noiDungBaiTap;
    }

    public void setNoiDungBaiTap(String noiDungBaiTap) {
        this.noiDungBaiTap = noiDungBaiTap;
    }
}
