package vn.ansv.management.models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//POJO - Plain Object Java Object
@Entity
@Table(name = "tbl_menu")
public class Menu {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name = "uid", nullable = true, unique = true, length = 300)
  private String uid;

  @Column(name = "menu_category_id")
  private Integer menu_category_id;

  @Column(name = "level")
  private Integer level;

  @Column(name = "previous")
  private Integer previous;

  @Column(name = "display")
  private String display;

  @Column(name = "icon_data")
  private String icon_data;

  @Column(name = "link")
  private String link;

  @Column(name = "include")
  private Integer include;

  @Column(name = "enabled")
  private Integer enabled;

  @Column(name = "created_by")
  private Integer created_by;

  @Column(name = "created_at")
  private Date created_at;

  // calculated field = transient, not exist in MySql
  @Transient
  private Object menu_con;

  public Menu() {
  }

  public Menu(String uid, Integer menu_category_id, Integer level, Integer previous, String display, String icon_data,
      String link, Integer include, Integer enabled, Integer created_by, Date created_at) {
    this.uid = uid;
    this.menu_category_id = menu_category_id;
    this.level = level;
    this.previous = previous;
    this.display = display;
    this.icon_data = icon_data;
    this.link = link;
    this.include = include;
    this.enabled = enabled;
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

  public Integer getMenu_category_id() {
    return this.menu_category_id;
  }

  public void setMenu_category_id(Integer menu_category_id) {
    this.menu_category_id = menu_category_id;
  }

  public Integer getLevel() {
    return this.level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Integer getPrevious() {
    return this.previous;
  }

  public void setPrevious(Integer previous) {
    this.previous = previous;
  }

  public String getDisplay() {
    return this.display;
  }

  public void setDisplay(String display) {
    this.display = display;
  }

  public String getIcon_data() {
    return this.icon_data;
  }

  public void setIcon_data(String icon_data) {
    this.icon_data = icon_data;
  }

  public String getLink() {
    return this.link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public Integer getInclude() {
    return this.include;
  }

  public void setInclude(Integer include) {
    this.include = include;
  }

  public Integer getEnabled() {
    return this.enabled;
  }

  public void setEnabled(Integer enabled) {
    this.enabled = enabled;
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

  public Object getMenu_con() {
    return menu_con;
  }

  public void setMenu_con(Object menu_con) {
    this.menu_con = menu_con;
  }
}
