package org.backend.models;

public class AccountDTO {
    private int id;
    private String userName;
    private String password;
    private String teacherId;
    private String studentId;
    private String authority;
    private boolean enabled;

    public AccountDTO() {
    }

    public AccountDTO(int id, String userName, String password, String teacherId, String studentId, String authority) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.authority = authority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
