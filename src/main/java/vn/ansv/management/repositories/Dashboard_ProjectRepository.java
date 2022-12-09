package vn.ansv.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.ansv.management.dto.Dashboard_ProjectDto;

public interface Dashboard_ProjectRepository extends JpaRepository<Dashboard_ProjectDto, Integer> {
        @Query(value = "SELECT pr.id, pr.job_name, c.customer_name, "
                        + "(SELECT u.fullname FROM tbl_user AS u WHERE u.id = pr.am_id) AS pic_name, "
                        + "ps.display AS status_display, ps.color AS status_color, pr.general_issue AS tinh_trang_du_an "
                        + "FROM tbl_project_report AS pr "
                        + "INNER JOIN tbl_project AS p ON pr.project_id = p.id "
                        + "INNER JOIN tbl_customer AS c ON p.customer_id = c.id "
                        + "INNER JOIN tbl_project_status AS ps ON pr.project_status_id = ps.id "
                        + "WHERE pr.enabled = ?1 AND pr.project_type_id = ?2 AND pr.week = ?3 AND pr.year = ?4 "
                        + "ORDER BY pr.job_name", nativeQuery = true)
        List<Dashboard_ProjectDto> findAllDashboardProjectStep1(int enabled, int type, int week, int year);

        @Query(value = "SELECT pr.id, pr.job_name, c.customer_name, "
                        + "(SELECT u.fullname FROM tbl_user AS u WHERE u.id = pr.pm_id) AS pic_name, ps.display AS status_display, "
                        + "ps.color AS status_color, pr.general_issue AS tinh_trang_du_an "
                        + "FROM tbl_project_report AS pr "
                        + "INNER JOIN tbl_project AS p ON pr.project_id = p.id "
                        + "INNER JOIN tbl_customer AS c ON p.customer_id = c.id "
                        + "INNER JOIN tbl_project_status AS ps ON pr.project_status_id = ps.id "
                        + "WHERE pr.enabled = ?1 AND pr.project_type_id = ?2 AND pr.week = ?3 AND pr.year = ?4 "
                        + "ORDER BY pr.job_name", nativeQuery = true)
        List<Dashboard_ProjectDto> findAllDashboardProjectStep2(int enabled, int type, int week, int year);
}
