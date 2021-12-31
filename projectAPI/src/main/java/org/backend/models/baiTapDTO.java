package org.backend.models;

public class baiTapDTO {
    private int id;
    private String name;
    private String username;
    private String deadline;
    private String file;
    private String tenBaiTap;
    private String noiDungBaiTap;

    public baiTapDTO() {

    }

    public baiTapDTO(int id, String name, String username, String deadline, String file, String tenBaiTap, String noiDungBaiTap) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.deadline = deadline;
        this.file = file;
        this.tenBaiTap = tenBaiTap;
        this.noiDungBaiTap = noiDungBaiTap;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
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
