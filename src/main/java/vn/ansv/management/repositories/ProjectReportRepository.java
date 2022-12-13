package vn.ansv.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.ansv.management.dto.ProjectDetailDto;

public interface ProjectReportRepository extends JpaRepository<ProjectDetailDto, Integer> {
    @Query(value = "SELECT pr.id, pr.uid, p.project_name, c.customer_name, pr.project_type_id, "
            + "pt.display AS type_name, pr.project_priority_id, pp.display AS priority_name, pr.project_status_id, "
            + "ps.color AS status_color, ps.status_name, pr.currency_unit_id, cu.currency_unit AS currency_unit_display, "
            + "pr.am_manager_id, (SELECT u.fullname from tbl_user AS u WHERE u.id = pr.am_manager_id) AS am_manager_name, "
            + "pr.am_id, (SELECT u.fullname from tbl_user AS u WHERE u.id = pr.am_id) AS am_name, "
            + "pr.pm_manager_id, (SELECT u.fullname from tbl_user AS u WHERE u.id = pr.pm_manager_id) AS pm_manager_name, "
            + "pr.pm_id, (SELECT u.fullname from tbl_user AS u WHERE u.id = pr.pm_id) AS pm_name, "
            + "pr.week, pr.year, pr.ma_hop_dong, pr.ma_ke_toan, pr.job_name, pr.description, pr.tong_muc_dau_tu_du_kien, "
            + "pr.hinh_thuc_dau_tu, pr.muc_do_kha_thi, pr.phan_tich_SWOOT, pr.pham_vi_cung_cap, pr.tong_gia_tri_thuc_te, "
            + "pr.so_tien_tam_ung, pr.ke_hoach_tam_ung, pr.so_tien_DAC, pr.hop_dong_DAC, pr.muc_tieu_DAC, pr.thuc_te_DAC, "
            + "pr.so_tien_PAC, pr.hop_dong_PAC, pr.muc_tieu_PAC, pr.thuc_te_PAC, pr.so_tien_FAC, pr.hop_dong_FAC, "
            + "pr.muc_tieu_FAC, pr.thuc_te_FAC, pr.general_issue, pr.solution, pr.ke_hoach_tuan_nay, pr.ke_hoach_tuan_sau, "
            + "pr.ket_qua_tuan_truoc, pr.ket_qua_tuan_nay, pr.enabled, pr.ghi_chu, pr.created_by, pr.created_at "
            + "FROM tbl_project_report AS pr "
            + "INNER JOIN tbl_project AS p ON pr.project_id = p.id "
            + "INNER JOIN tbl_customer AS c ON p.customer_id = c.id "
            + "INNER JOIN tbl_project_type AS pt ON pr.project_type_id = pt.id "
            + "INNER JOIN tbl_project_priority AS pp ON pr.project_priority_id = pp.id "
            + "INNER JOIN tbl_project_status AS ps ON pr.project_status_id = ps.id "
            + "INNER JOIN tbl_currency_unit AS cu ON pr.currency_unit_id = cu.id "
            + "WHERE pr.id = ?1 AND pr.enabled = ?2 LIMIT 1", nativeQuery = true)
    ProjectDetailDto findByIdEnabled(int id, int enabled);
}
