package vn.ansv.management.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//POJO - Plain Object Java Object
@Entity
@Table(name = "tbl_menu_category")
public class MenuCategory {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "uid", nullable = false, unique = true, length = 300)
    private String uid;

    @Column(name = "menu_category", nullable = false, unique = true, length = 300)
    private String menu_category;

    @Column(name = "note")
    private String note;

    @Column(name = "created_by")
    private Integer created_by;

    @Column(name = "created_at")
    private Date created_at;

    // calculated field = transient, not exist in MySql
    @Transient
    private Object menu_item;

    public MenuCategory() {
    }

    public MenuCategory(String uid, String menu_category, String note, Integer created_by, Date created_at) {
        this.uid = uid;
        this.menu_category = menu_category;
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

    public String getMenu_category() {
        return this.menu_category;
    }

    public void setMenu_category(String menu_category) {
        this.menu_category = menu_category;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getCreated_by() {
        return this.created_by;
    }

    public void setCreated_by(Integer created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Object getMenu_item() {
        return menu_item;
    }

    public void setMenu_item(Object menu_item) {
        this.menu_item = menu_item;
    }
}
