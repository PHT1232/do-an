package org.backend.entity;

public class chamDiem {
    private int id;
    private int diem;
    private int baiTapId;
    private String studentId;

    public chamDiem() {
    }

    public chamDiem(int id, int diem, int baiTapId, String studentId) {
        this.id = id;
        this.diem = diem;
        this.baiTapId = baiTapId;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getBaiTapId() {
        return baiTapId;
    }

    public void setBaiTapId(int baiTapId) {
        this.baiTapId = baiTapId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
