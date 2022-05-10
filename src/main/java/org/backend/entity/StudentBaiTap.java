package org.backend.entity;

public class StudentBaiTap {
    private int id;
    private String username;
    private int file;
    private int lienKet;
    private int baiTapId;
    private String fileName;
    private String lienKetName;

    public StudentBaiTap() {
    }

    public StudentBaiTap(int id, String username, int file, int lienKet, String fileName, String lienKetName) {
        this.id = id;
        this.username = username;
        this.file = file;
        this.lienKet = lienKet;
        this.fileName = fileName;
        this.lienKetName = lienKetName;
    }

    public int getBaiTapId() {
        return baiTapId;
    }

    public void setBaiTapId(int baiTapId) {
        this.baiTapId = baiTapId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getLienKet() {
        return lienKet;
    }

    public void setLienKet(int lienKet) {
        this.lienKet = lienKet;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLienKetName() {
        return lienKetName;
    }

    public void setLienKetName(String lienKetName) {
        this.lienKetName = lienKetName;
    }
}
