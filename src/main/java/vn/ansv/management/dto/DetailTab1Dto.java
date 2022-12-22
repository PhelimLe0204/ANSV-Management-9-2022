package vn.ansv.management.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetailTab1Dto {
    @Id
    private int id;
    private int project_id;
    private int project_type_id;
    private int project_priority_id;
    private int project_status_id;
    private int week;
    private int year;
    private String ma_hop_dong;
    private String ma_ke_toan;
    private int currency_unit_id;

    public DetailTab1Dto() {
    }

    public DetailTab1Dto(int id, int project_id, int project_type_id, int project_priority_id, int project_status_id,
            int week, int year, String ma_hop_dong, String ma_ke_toan, int currency_unit_id) {
        this.id = id;
        this.project_id = project_id;
        this.project_type_id = project_type_id;
        this.project_priority_id = project_priority_id;
        this.project_status_id = project_status_id;
        this.week = week;
        this.year = year;
        this.ma_hop_dong = ma_hop_dong;
        this.ma_ke_toan = ma_ke_toan;
        this.currency_unit_id = currency_unit_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject_id() {
        return this.project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getProject_type_id() {
        return this.project_type_id;
    }

    public void setProject_type_id(int project_type_id) {
        this.project_type_id = project_type_id;
    }

    public int getProject_priority_id() {
        return this.project_priority_id;
    }

    public void setProject_priority_id(int project_priority_id) {
        this.project_priority_id = project_priority_id;
    }

    public int getProject_status_id() {
        return this.project_status_id;
    }

    public void setProject_status_id(int project_status_id) {
        this.project_status_id = project_status_id;
    }

    public int getWeek() {
        return this.week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMa_hop_dong() {
        return this.ma_hop_dong;
    }

    public void setMa_hop_dong(String ma_hop_dong) {
        this.ma_hop_dong = ma_hop_dong;
    }

    public String getMa_ke_toan() {
        return this.ma_ke_toan;
    }

    public void setMa_ke_toan(String ma_ke_toan) {
        this.ma_ke_toan = ma_ke_toan;
    }

    public int getCurrency_unit_id() {
        return this.currency_unit_id;
    }

    public void setCurrency_unit_id(int currency_unit_id) {
        this.currency_unit_id = currency_unit_id;
    }

}
