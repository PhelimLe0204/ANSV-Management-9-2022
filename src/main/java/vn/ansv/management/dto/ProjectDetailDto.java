package vn.ansv.management.dto;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ProjectDetailDto {
    @Id
    private int id;
    private String uid;

    private String project_name; // Tên dự án
    private String customer_name; // Khách hàng

    private int project_type_id;
    private String type_name; // Giai đoạn của công việc

    private int project_priority_id;
    private String priority_name; // Mức độ ưu tiên

    private int project_status_id;
    private String status_color; // Màu của trạng thái
    private String status_name; // Trạng thái báo cáo

    private int currency_unit_id;
    private String currency_unit_display; // Đơn vị tiền tệ

    private int am_manager_id;
    private String am_manager_name;

    private int am_id;
    private String am_name;

    private int pm_manager_id;
    private String pm_manager_name;

    private int pm_id;
    private String pm_name;

    private int week;
    private int year;
    private String ma_hop_dong;
    private String ma_ke_toan;

    private String job_name;
    private String description;
    private String tong_muc_dau_tu_du_kien;
    private String hinh_thuc_dau_tu;
    private int muc_do_kha_thi;
    private String phan_tich_SWOOT;
    private String pham_vi_cung_cap;
    private String tong_gia_tri_thuc_te;

    private String so_tien_tam_ung;
    private String ke_hoach_tam_ung;

    private String so_tien_DAC;
    private String hop_dong_DAC;
    private String muc_tieu_DAC;
    private String thuc_te_DAC;

    private String so_tien_PAC;
    private String hop_dong_PAC;
    private String muc_tieu_PAC;
    private String thuc_te_PAC;

    private String so_tien_FAC;
    private String hop_dong_FAC;
    private String muc_tieu_FAC;
    private String thuc_te_FAC;

    private String general_issue;
    private String solution;

    private String ke_hoach_tuan_nay;
    private String ke_hoach_tuan_sau;

    private String ket_qua_tuan_truoc;
    private String ket_qua_tuan_nay;

    private int enabled;
    private String ghi_chu;
    private String created_by;
    private Date created_at;

    public ProjectDetailDto() {
    }

    // calculated field = transient, not exist in MySql
    @Transient
    private long chenh_lech_DAC; // chenh_lech_DAC is calculated from "hop_dong_DAC", "muc_tieu_DAC" và
                                 // "thuc_te_DAC"
    @Transient
    private long chenh_lech_PAC; // chenh_lech_PAC is calculated from "hop_dong_PAC", "muc_tieu_PAC" và
                                 // "thuc_te_PAC"
    @Transient
    private long chenh_lech_FAC; // chenh_lech_FAC is calculated from "hop_dong_FAC", "muc_tieu_FAC" và
                                 // "thuc_te_FAC"

    public String tinh_ngay_chenh_lech(String date_hop_dong, String date_muc_tieu, String date_thuc_te) {
        DateTimeFormatter dateFormatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("dd/MM/uuuu")
                .toFormatter(Locale.ENGLISH);
        String result = null;

        if (date_hop_dong == null && date_muc_tieu == null) {
            return result;
        }

        LocalDate muc_tieu = null;
        LocalDate thuc_te = null;

        if (date_muc_tieu != null) {
            muc_tieu = LocalDate.parse(date_muc_tieu, dateFormatter);

            if (date_thuc_te == null) {
                // Không có ngày thực tế (chưa hoàn thành công việc)
                thuc_te = LocalDate.now();
                long dif = Duration.between(thuc_te.atStartOfDay(), muc_tieu.atStartOfDay()).toDays();
                if (dif > 0) {
                    result = "Còn " + Math.abs(dif) + " ngày";
                }
                if (dif == 0) {
                    result = "Deadline";
                }
                if (dif < 0) {
                    result = "Đã chậm " + Math.abs(dif) + " ngày";
                }
            } else {
                thuc_te = LocalDate.parse(date_thuc_te, dateFormatter);
                long dif = Duration.between(thuc_te.atStartOfDay(), muc_tieu.atStartOfDay()).toDays();
                if (dif > 0) {
                    result = "Sớm " + Math.abs(dif) + " ngày";
                }
                if (dif == 0) {
                    result = "Đúng hạn";
                }
                if (dif < 0) {
                    result = "Bị chậm " + Math.abs(dif) + " ngày";
                }
            }
        }

        return result;
    }

    public String getChenh_lech_DAC() {
        return tinh_ngay_chenh_lech(hop_dong_DAC, muc_tieu_DAC, thuc_te_DAC);
    }

    public String getChenh_lech_PAC() {
        return tinh_ngay_chenh_lech(hop_dong_PAC, muc_tieu_PAC, thuc_te_PAC);
    }

    public String getChenh_lech_FAC() {
        return tinh_ngay_chenh_lech(hop_dong_FAC, muc_tieu_FAC, thuc_te_FAC);
    }

    public ProjectDetailDto(int id, String uid, String project_name, String customer_name, int project_type_id,
            String type_name, int project_priority_id, String priority_name, int project_status_id, String status_color,
            String status_name, int currency_unit_id, String currency_unit_display, int am_manager_id,
            String am_manager_name, int am_id, String am_name, int pm_manager_id, String pm_manager_name, int pm_id,
            String pm_name, int week, int year, String ma_hop_dong, String ma_ke_toan, String job_name,
            String description, String tong_muc_dau_tu_du_kien, String hinh_thuc_dau_tu, int muc_do_kha_thi,
            String phan_tich_SWOOT, String pham_vi_cung_cap, String tong_gia_tri_thuc_te, String so_tien_tam_ung,
            String ke_hoach_tam_ung, String so_tien_DAC, String hop_dong_DAC, String muc_tieu_DAC, String thuc_te_DAC,
            String so_tien_PAC, String hop_dong_PAC, String muc_tieu_PAC, String thuc_te_PAC, String so_tien_FAC,
            String hop_dong_FAC, String muc_tieu_FAC, String thuc_te_FAC, String general_issue, String solution,
            String ke_hoach_tuan_nay, String ke_hoach_tuan_sau, String ket_qua_tuan_truoc, String ket_qua_tuan_nay,
            int enabled, String ghi_chu, String created_by, Date created_at) {
        this.id = id;
        this.uid = uid;
        this.project_name = project_name;
        this.customer_name = customer_name;
        this.project_type_id = project_type_id;
        this.type_name = type_name;
        this.project_priority_id = project_priority_id;
        this.priority_name = priority_name;
        this.project_status_id = project_status_id;
        this.status_color = status_color;
        this.status_name = status_name;
        this.currency_unit_id = currency_unit_id;
        this.currency_unit_display = currency_unit_display;
        this.am_manager_id = am_manager_id;
        this.am_manager_name = am_manager_name;
        this.am_id = am_id;
        this.am_name = am_name;
        this.pm_manager_id = pm_manager_id;
        this.pm_manager_name = pm_manager_name;
        this.pm_id = pm_id;
        this.pm_name = pm_name;
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

    public String getProject_name() {
        return this.project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getCustomer_name() {
        return this.customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getProject_type_id() {
        return this.project_type_id;
    }

    public void setProject_type_id(int project_type_id) {
        this.project_type_id = project_type_id;
    }

    public String getType_name() {
        return this.type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public int getProject_priority_id() {
        return this.project_priority_id;
    }

    public void setProject_priority_id(int project_priority_id) {
        this.project_priority_id = project_priority_id;
    }

    public String getPriority_name() {
        return this.priority_name;
    }

    public void setPriority_name(String priority_name) {
        this.priority_name = priority_name;
    }

    public int getProject_status_id() {
        return this.project_status_id;
    }

    public void setProject_status_id(int project_status_id) {
        this.project_status_id = project_status_id;
    }

    public String getStatus_color() {
        return this.status_color;
    }

    public void setStatus_color(String status_color) {
        this.status_color = status_color;
    }

    public String getStatus_name() {
        return this.status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public int getCurrency_unit_id() {
        return this.currency_unit_id;
    }

    public void setCurrency_unit_id(int currency_unit_id) {
        this.currency_unit_id = currency_unit_id;
    }

    public String getCurrency_unit_display() {
        return this.currency_unit_display;
    }

    public void setCurrency_unit_display(String currency_unit_display) {
        this.currency_unit_display = currency_unit_display;
    }

    public int getAm_manager_id() {
        return this.am_manager_id;
    }

    public void setAm_manager_id(int am_manager_id) {
        this.am_manager_id = am_manager_id;
    }

    public String getAm_manager_name() {
        return this.am_manager_name;
    }

    public void setAm_manager_name(String am_manager_name) {
        this.am_manager_name = am_manager_name;
    }

    public int getAm_id() {
        return this.am_id;
    }

    public void setAm_id(int am_id) {
        this.am_id = am_id;
    }

    public String getAm_name() {
        return this.am_name;
    }

    public void setAm_name(String am_name) {
        this.am_name = am_name;
    }

    public int getPm_manager_id() {
        return this.pm_manager_id;
    }

    public void setPm_manager_id(int pm_manager_id) {
        this.pm_manager_id = pm_manager_id;
    }

    public String getPm_manager_name() {
        return this.pm_manager_name;
    }

    public void setPm_manager_name(String pm_manager_name) {
        this.pm_manager_name = pm_manager_name;
    }

    public int getPm_id() {
        return this.pm_id;
    }

    public void setPm_id(int pm_id) {
        this.pm_id = pm_id;
    }

    public String getPm_name() {
        return this.pm_name;
    }

    public void setPm_name(String pm_name) {
        this.pm_name = pm_name;
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

    public int getMuc_do_kha_thi() {
        return this.muc_do_kha_thi;
    }

    public void setMuc_do_kha_thi(int muc_do_kha_thi) {
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
