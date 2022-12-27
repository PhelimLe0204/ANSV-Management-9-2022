package vn.ansv.management.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO - Plain Object Java Object
@Entity
@Table(name = "tbl_project_report")
public class ProjectReport {
    @Id
    @GeneratedValue
    @Column(name = "id") // 1
    private int id;
    @Column(name = "uid") // 2
    private String uid;
    @Column(name = "project_id") // 3
    private int project_id;
    @Column(name = "project_type_id") // 4
    private int project_type_id;
    @Column(name = "project_priority_id") // 5
    private int project_priority_id;
    @Column(name = "project_status_id") // 6
    private int project_status_id;
    @Column(name = "currency_unit_id") // 7
    private int currency_unit_id;
    @Column(name = "am_manager_id") // 8
    private int am_manager_id;
    @Column(name = "am_id") // 9
    private int am_id;
    @Column(name = "pm_manager_id") // 10
    private int pm_manager_id;
    @Column(name = "pm_id") // 11
    private int pm_id;

    @Column(name = "week") // 12
    private int week;
    @Column(name = "year") // 13
    private int year;
    @Column(name = "ma_hop_dong") // 14
    private String ma_hop_dong;
    @Column(name = "ma_ke_toan") // 15
    private String ma_ke_toan;

    @Column(name = "job_name") // 16
    private String job_name;
    @Column(name = "description") // 17
    private String description;
    @Column(name = "tong_muc_dau_tu_du_kien") // 18
    private String tong_muc_dau_tu_du_kien;
    @Column(name = "hinh_thuc_dau_tu") // 19
    private String hinh_thuc_dau_tu;
    @Column(name = "muc_do_kha_thi") // 20
    private Integer muc_do_kha_thi;
    @Column(name = "phan_tich_SWOOT") // 21
    private String phan_tich_SWOOT;
    @Column(name = "pham_vi_cung_cap") // 22
    private String pham_vi_cung_cap;
    @Column(name = "tong_gia_tri_thuc_te") // 23
    private String tong_gia_tri_thuc_te;

    @Column(name = "so_tien_tam_ung") // 24
    private String so_tien_tam_ung;
    @Column(name = "ke_hoach_tam_ung") // 25
    private String ke_hoach_tam_ung;

    @Column(name = "so_tien_DAC") // 26
    private String so_tien_DAC;
    @Column(name = "hop_dong_DAC") // 27
    private String hop_dong_DAC;
    @Column(name = "muc_tieu_DAC") // 28
    private String muc_tieu_DAC;
    @Column(name = "thuc_te_DAC") // 29
    private String thuc_te_DAC;

    @Column(name = "so_tien_PAC") // 30
    private String so_tien_PAC;
    @Column(name = "hop_dong_PAC") // 31
    private String hop_dong_PAC;
    @Column(name = "muc_tieu_PAC") // 32
    private String muc_tieu_PAC;
    @Column(name = "thuc_te_PAC") // 33
    private String thuc_te_PAC;

    @Column(name = "so_tien_FAC") // 34
    private String so_tien_FAC;
    @Column(name = "hop_dong_FAC") // 35
    private String hop_dong_FAC;
    @Column(name = "muc_tieu_FAC") // 36
    private String muc_tieu_FAC;
    @Column(name = "thuc_te_FAC") // 37
    private String thuc_te_FAC;

    @Column(name = "general_issue") // 38
    private String general_issue;
    @Column(name = "solution") // 39
    private String solution;

    @Column(name = "ke_hoach_tuan_nay") // 40
    private String ke_hoach_tuan_nay;
    @Column(name = "ke_hoach_tuan_sau") // 41
    private String ke_hoach_tuan_sau;
    @Column(name = "ket_qua_tuan_truoc") // 42
    private String ket_qua_tuan_truoc;
    @Column(name = "ket_qua_tuan_nay") // 43
    private String ket_qua_tuan_nay;

    @Column(name = "enabled") // 44
    private int enabled;
    @Column(name = "ghi_chu") // 45
    private String ghi_chu;

    @Column(name = "created_by") // 46
    private String created_by;
    @Column(name = "created_at") // 47
    private Date created_at;

    public ProjectReport() {
    }

    public ProjectReport(int id, String uid, int project_id, int project_type_id, int project_priority_id,
            int project_status_id, int currency_unit_id, int am_manager_id, int am_id, int pm_manager_id, int pm_id,
            int week, int year, String ma_hop_dong, String ma_ke_toan, String job_name, String description,
            String tong_muc_dau_tu_du_kien, String hinh_thuc_dau_tu, Integer muc_do_kha_thi, String phan_tich_SWOOT,
            String pham_vi_cung_cap, String tong_gia_tri_thuc_te, String so_tien_tam_ung, String ke_hoach_tam_ung,
            String so_tien_DAC, String hop_dong_DAC, String muc_tieu_DAC, String thuc_te_DAC, String so_tien_PAC,
            String hop_dong_PAC, String muc_tieu_PAC, String thuc_te_PAC, String so_tien_FAC, String hop_dong_FAC,
            String muc_tieu_FAC, String thuc_te_FAC, String general_issue, String solution, String ke_hoach_tuan_nay,
            String ke_hoach_tuan_sau, String ket_qua_tuan_truoc, String ket_qua_tuan_nay, int enabled, String ghi_chu,
            String created_by, Date created_at) {
        this.id = id;
        this.uid = uid;
        this.project_id = project_id;
        this.project_type_id = project_type_id;
        this.project_priority_id = project_priority_id;
        this.project_status_id = project_status_id;
        this.currency_unit_id = currency_unit_id;
        this.am_manager_id = am_manager_id;
        this.am_id = am_id;
        this.pm_manager_id = pm_manager_id;
        this.pm_id = pm_id;
        this.week = week;
        this.year = year;
        this.ma_hop_dong = ma_hop_dong;
        this.ma_ke_toan = ma_ke_toan;
        this.job_name = job_name;
        this.description = description;
        this.tong_muc_dau_tu_du_kien = tong_muc_dau_tu_du_kien;
        this.hinh_thuc_dau_tu = hinh_thuc_dau_tu;
        this.muc_do_kha_thi = muc_do_kha_thi;
        this.phan_tich_SWOOT = phan_tich_SWOOT;
        this.pham_vi_cung_cap = pham_vi_cung_cap;
        this.tong_gia_tri_thuc_te = tong_gia_tri_thuc_te;
        this.so_tien_tam_ung = so_tien_tam_ung;
        this.ke_hoach_tam_ung = ke_hoach_tam_ung;
        this.so_tien_DAC = so_tien_DAC;
        this.hop_dong_DAC = hop_dong_DAC;
        this.muc_tieu_DAC = muc_tieu_DAC;
        this.thuc_te_DAC = thuc_te_DAC;
        this.so_tien_PAC = so_tien_PAC;
        this.hop_dong_PAC = hop_dong_PAC;
        this.muc_tieu_PAC = muc_tieu_PAC;
        this.thuc_te_PAC = thuc_te_PAC;
        this.so_tien_FAC = so_tien_FAC;
        this.hop_dong_FAC = hop_dong_FAC;
        this.muc_tieu_FAC = muc_tieu_FAC;
        this.thuc_te_FAC = thuc_te_FAC;
        this.general_issue = general_issue;
        this.solution = solution;
        this.ke_hoach_tuan_nay = ke_hoach_tuan_nay;
        this.ke_hoach_tuan_sau = ke_hoach_tuan_sau;
        this.ket_qua_tuan_truoc = ket_qua_tuan_truoc;
        this.ket_qua_tuan_nay = ket_qua_tuan_nay;
        this.enabled = enabled;
        this.ghi_chu = ghi_chu;
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

    public int getCurrency_unit_id() {
        return this.currency_unit_id;
    }

    public void setCurrency_unit_id(int currency_unit_id) {
        this.currency_unit_id = currency_unit_id;
    }

    public int getAm_manager_id() {
        return this.am_manager_id;
    }

    public void setAm_manager_id(int am_manager_id) {
        this.am_manager_id = am_manager_id;
    }

    public int getAm_id() {
        return this.am_id;
    }

    public void setAm_id(int am_id) {
        this.am_id = am_id;
    }

    public int getPm_manager_id() {
        return this.pm_manager_id;
    }

    public void setPm_manager_id(int pm_manager_id) {
        this.pm_manager_id = pm_manager_id;
    }

    public int getPm_id() {
        return this.pm_id;
    }

    public void setPm_id(int pm_id) {
        this.pm_id = pm_id;
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

    public String getJob_name() {
        return this.job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTong_muc_dau_tu_du_kien() {
        return this.tong_muc_dau_tu_du_kien;
    }

    public void setTong_muc_dau_tu_du_kien(String tong_muc_dau_tu_du_kien) {
        this.tong_muc_dau_tu_du_kien = tong_muc_dau_tu_du_kien;
    }

    public String getHinh_thuc_dau_tu() {
        return this.hinh_thuc_dau_tu;
    }

    public void setHinh_thuc_dau_tu(String hinh_thuc_dau_tu) {
        this.hinh_thuc_dau_tu = hinh_thuc_dau_tu;
    }

    public Integer getMuc_do_kha_thi() {
        return this.muc_do_kha_thi;
    }

    public void setMuc_do_kha_thi(Integer muc_do_kha_thi) {
        this.muc_do_kha_thi = muc_do_kha_thi;
    }

    public String getPhan_tich_SWOOT() {
        return this.phan_tich_SWOOT;
    }

    public void setPhan_tich_SWOOT(String phan_tich_SWOOT) {
        this.phan_tich_SWOOT = phan_tich_SWOOT;
    }

    public String getPham_vi_cung_cap() {
        return this.pham_vi_cung_cap;
    }

    public void setPham_vi_cung_cap(String pham_vi_cung_cap) {
        this.pham_vi_cung_cap = pham_vi_cung_cap;
    }

    public String getTong_gia_tri_thuc_te() {
        return this.tong_gia_tri_thuc_te;
    }

    public void setTong_gia_tri_thuc_te(String tong_gia_tri_thuc_te) {
        this.tong_gia_tri_thuc_te = tong_gia_tri_thuc_te;
    }

    public String getSo_tien_tam_ung() {
        return this.so_tien_tam_ung;
    }

    public void setSo_tien_tam_ung(String so_tien_tam_ung) {
        this.so_tien_tam_ung = so_tien_tam_ung;
    }

    public String getKe_hoach_tam_ung() {
        return this.ke_hoach_tam_ung;
    }

    public void setKe_hoach_tam_ung(String ke_hoach_tam_ung) {
        this.ke_hoach_tam_ung = ke_hoach_tam_ung;
    }

    public String getSo_tien_DAC() {
        return this.so_tien_DAC;
    }

    public void setSo_tien_DAC(String so_tien_DAC) {
        this.so_tien_DAC = so_tien_DAC;
    }

    public String getHop_dong_DAC() {
        return this.hop_dong_DAC;
    }

    public void setHop_dong_DAC(String hop_dong_DAC) {
        this.hop_dong_DAC = hop_dong_DAC;
    }

    public String getMuc_tieu_DAC() {
        return this.muc_tieu_DAC;
    }

    public void setMuc_tieu_DAC(String muc_tieu_DAC) {
        this.muc_tieu_DAC = muc_tieu_DAC;
    }

    public String getThuc_te_DAC() {
        return this.thuc_te_DAC;
    }

    public void setThuc_te_DAC(String thuc_te_DAC) {
        this.thuc_te_DAC = thuc_te_DAC;
    }

    public String getSo_tien_PAC() {
        return this.so_tien_PAC;
    }

    public void setSo_tien_PAC(String so_tien_PAC) {
        this.so_tien_PAC = so_tien_PAC;
    }

    public String getHop_dong_PAC() {
        return this.hop_dong_PAC;
    }

    public void setHop_dong_PAC(String hop_dong_PAC) {
        this.hop_dong_PAC = hop_dong_PAC;
    }

    public String getMuc_tieu_PAC() {
        return this.muc_tieu_PAC;
    }

    public void setMuc_tieu_PAC(String muc_tieu_PAC) {
        this.muc_tieu_PAC = muc_tieu_PAC;
    }

    public String getThuc_te_PAC() {
        return this.thuc_te_PAC;
    }

    public void setThuc_te_PAC(String thuc_te_PAC) {
        this.thuc_te_PAC = thuc_te_PAC;
    }

    public String getSo_tien_FAC() {
        return this.so_tien_FAC;
    }

    public void setSo_tien_FAC(String so_tien_FAC) {
        this.so_tien_FAC = so_tien_FAC;
    }

    public String getHop_dong_FAC() {
        return this.hop_dong_FAC;
    }

    public void setHop_dong_FAC(String hop_dong_FAC) {
        this.hop_dong_FAC = hop_dong_FAC;
    }

    public String getMuc_tieu_FAC() {
        return this.muc_tieu_FAC;
    }

    public void setMuc_tieu_FAC(String muc_tieu_FAC) {
        this.muc_tieu_FAC = muc_tieu_FAC;
    }

    public String getThuc_te_FAC() {
        return this.thuc_te_FAC;
    }

    public void setThuc_te_FAC(String thuc_te_FAC) {
        this.thuc_te_FAC = thuc_te_FAC;
    }

    public String getGeneral_issue() {
        return this.general_issue;
    }

    public void setGeneral_issue(String general_issue) {
        this.general_issue = general_issue;
    }

    public String getSolution() {
        return this.solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getKe_hoach_tuan_nay() {
        return this.ke_hoach_tuan_nay;
    }

    public void setKe_hoach_tuan_nay(String ke_hoach_tuan_nay) {
        this.ke_hoach_tuan_nay = ke_hoach_tuan_nay;
    }

    public String getKe_hoach_tuan_sau() {
        return this.ke_hoach_tuan_sau;
    }

    public void setKe_hoach_tuan_sau(String ke_hoach_tuan_sau) {
        this.ke_hoach_tuan_sau = ke_hoach_tuan_sau;
    }

    public String getKet_qua_tuan_truoc() {
        return this.ket_qua_tuan_truoc;
    }

    public void setKet_qua_tuan_truoc(String ket_qua_tuan_truoc) {
        this.ket_qua_tuan_truoc = ket_qua_tuan_truoc;
    }

    public String getKet_qua_tuan_nay() {
        return this.ket_qua_tuan_nay;
    }

    public void setKet_qua_tuan_nay(String ket_qua_tuan_nay) {
        this.ket_qua_tuan_nay = ket_qua_tuan_nay;
    }

    public int getEnabled() {
        return this.enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getGhi_chu() {
        return this.ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
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
