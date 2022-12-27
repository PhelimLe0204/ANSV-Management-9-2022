package vn.ansv.management.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserOptionDto {
    @Id
    private int id;
    private String employee_code;
    private String fullname;
    private String avatar;

    public UserOptionDto() {
    }

    public UserOptionDto(int id, String employee_code, String fullname, String avatar) {
        this.id = id;
        this.employee_code = employee_code;
        this.fullname = fullname;
        this.avatar = avatar;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_code() {
        return this.employee_code;
    }

    public void setEmployee_code(String employee_code) {
        this.employee_code = employee_code;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
