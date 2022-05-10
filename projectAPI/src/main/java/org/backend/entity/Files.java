package org.backend.entity;

public class Files {
    private int id;
    private String filename;
    private int baiTapId;
    private int nopBaiTapId;

    public Files() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getBaiTapId() {
        return baiTapId;
    }

    public void setBaiTapId(int baiTapId) {
        this.baiTapId = baiTapId;
    }

    public int getNopBaiTapId() {
        return nopBaiTapId;
    }

    public void setNopBaiTapId(int nopBaiTapId) {
        this.nopBaiTapId = nopBaiTapId;
    }
}
