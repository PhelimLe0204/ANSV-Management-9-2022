package vn.ansv.management.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO - Plain Object Java Object
@Entity
@Table(name = "tbl_project_type")
public class ProjectType {
    @Id
    private int id;
    private String uid;
    private int step;
    private String type_name;
    private String display;
    private String description;
    private String created_by;
    private Date created_at;

    public ProjectType() {
    }

    public ProjectType(int id, String uid, int step, String type_name, String display, String description,
            String created_by, Date created_at) {
        this.id = id;
        this.uid = uid;
        this.step = step;
        this.type_name = type_name;
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

    public int getStep() {
        return this.step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getType_name() {
        return this.type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
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
