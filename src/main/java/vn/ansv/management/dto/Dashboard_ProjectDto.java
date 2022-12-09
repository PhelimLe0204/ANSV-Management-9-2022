package vn.ansv.management.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dashboard_ProjectDto {
    @Id
    private int id;
    private String job_name;
    private String customer_name;
    private String pic_name;
    private String status_display;
    private String status_color;
    private String tinh_trang_du_an;

    public Dashboard_ProjectDto() {
    }

    public Dashboard_ProjectDto(int id, String job_name, String customer_name, String pic_name,
            String status_display, String status_color, String tinh_trang_du_an) {
        this.id = id;
        this.job_name = job_name;
        this.customer_name = customer_name;
        this.pic_name = pic_name;
        this.status_display = status_display;
        this.status_color = status_color;
        this.tinh_trang_du_an = tinh_trang_du_an;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob_name() {
        return this.job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getCustomer_name() {
        return this.customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPic_name() {
        return this.pic_name;
    }

    public void setPic_name(String pic_name) {
        this.pic_name = pic_name;
    }

    public String getStatus_display() {
        return this.status_display;
    }

    public void setStatus_display(String status_display) {
        this.status_display = status_display;
    }

    public String getStatus_color() {
        return this.status_color;
    }

    public void setStatus_color(String status_color) {
        this.status_color = status_color;
    }

    public String getTinh_trang_du_an() {
        return this.tinh_trang_du_an;
    }

    public void setTinh_trang_du_an(String tinh_trang_du_an) {
        this.tinh_trang_du_an = tinh_trang_du_an;
    }

    @Override
    public String toString() {
        return "Dashboard_DeploymentDto [id=" + id + ", job_name=" + job_name + ", customer_name=" + customer_name
                + ", pic_name=" + pic_name + ", status_display=" + status_display + ", tinh_trang_du_an="
                + tinh_trang_du_an + "]";
    }
}
