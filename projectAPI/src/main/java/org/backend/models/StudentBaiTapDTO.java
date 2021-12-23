package org.backend.models;

public class StudentBaiTapDTO {
    private int id;
    private String username;
    private String file;
    private String lienKet;

    public StudentBaiTapDTO() {
    }

    public StudentBaiTapDTO(int id, String username, String file, String lienKet) {
        this.id = id;
        this.username = username;
        this.file = file;
        this.lienKet = lienKet;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLienKet() {
        return lienKet;
    }

    public void setLienKet(String lienKet) {
        this.lienKet = lienKet;
    }
}
