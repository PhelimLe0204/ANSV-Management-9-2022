package vn.ansv.management.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO - Plain Object Java Object
@Entity
@Table(name = "tbl_project")
public class Project {
    @Id
    private int id;
    private String uid;
    private Integer customer_id;
    private String project_name;
    private String description;
    private Integer enabled;
    private String note;
    private String created_by;
    private Date created_at;

    public Project() {
    }

    public Project(int id, String uid, Integer customer_id, String project_name, String description, Integer enabled,
            String note, String created_by, Date created_at) {
        this.id = id;
        this.uid = uid;
        this.customer_id = customer_id;
        this.project_name = project_name;
        this.description = description;
        this.enabled = enabled;
        this.note = note;
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

    public Integer getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getProject_name() {
        return this.project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
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
