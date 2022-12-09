package vn.ansv.management.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO - Plain Object Java Object
@Entity
@Table(name = "tbl_project_priority")
public class ProjectPriority {
    @Id
    private int id;
    private String uid;
    private String priority_name;
    private int level;
    private String display;
    private String description;
    private String created_by;
    private Date created_at;

    public ProjectPriority() {
    }

    public ProjectPriority(int id, String uid, String priority_name, int level, String display, String description,
            String created_by, Date created_at) {
        this.id = id;
        this.uid = uid;
        this.priority_name = priority_name;
        this.level = level;
        this.display = display;
        this.description = description;
        this.created_by = created_by;
        this.created_at = created_at;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPriority_name() {
        return this.priority_name;
    }

    public void setPriority_name(String priority_name) {
        this.priority_name = priority_name;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_by() {
        return this.created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

}
