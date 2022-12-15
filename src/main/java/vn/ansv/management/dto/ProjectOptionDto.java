package vn.ansv.management.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProjectOptionDto {
    @Id
    private int id;
    private String customer_name;
    private String customer_avatar;
    private String project_name;
    private String current_am;
    private String current_pm;

    public ProjectOptionDto() {
    }

    public ProjectOptionDto(int id, String customer_name, String customer_avatar, String project_name,
            String current_am, String current_pm) {
        this.id = id;
        this.customer_name = customer_name;
        this.customer_avatar = customer_avatar;
        this.project_name = project_name;
        this.current_am = current_am;
        this.current_pm = current_pm;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return this.customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_avatar() {
        return this.customer_avatar;
    }

    public void setCustomer_avatar(String customer_avatar) {
        this.customer_avatar = customer_avatar;
    }

    public String getProject_name() {
        return this.project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getCurrent_am() {
        return this.current_am;
    }

    public void setCurrent_am(String current_am) {
        this.current_am = current_am;
    }

    public String getCurrent_pm() {
        return this.current_pm;
    }

    public void setCurrent_pm(String current_pm) {
        this.current_pm = current_pm;
    }

}
