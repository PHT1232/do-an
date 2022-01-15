package org.backend.models;

public class TeacherDTO {
    private String id;
    private String name;
    private int age;
    private String address;
    private String picture;
    private String sdt;

    public TeacherDTO() {
    }

    public TeacherDTO(String id, String name, int age, String address, String picture, String sdt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.picture = picture;
        this.sdt = sdt;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
