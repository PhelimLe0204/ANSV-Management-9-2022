package vn.ansv.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.ansv.management.dto.ProjectOptionDto;

public interface ProjectOptionRepository extends JpaRepository<ProjectOptionDto, Integer> {
    /*
     * ----------------------------------
     * Truy vấn project (select option)
     * ----------------------------------
     */
    @Query(value = "SELECT p.id, c.customer_name, c.avatar AS customer_avatar, p.project_name, "
            + "(SELECT u1.fullname FROM tbl_user AS u1 WHERE u1.id = (SELECT u2.id FROM tbl_project_report AS pr INNER JOIN tbl_user AS u2 ON pr.am_id = u2.id WHERE pr.project_id = p.id ORDER BY pr.created_at DESC LIMIT 1) LIMIT 1) AS current_am, "
            + "(SELECT u1.fullname FROM tbl_user AS u1 WHERE u1.id = (SELECT u2.id FROM tbl_project_report AS pr INNER JOIN tbl_user AS u2 ON pr.pm_id = u2.id WHERE pr.project_id = p.id ORDER BY pr.created_at DESC LIMIT 1) LIMIT 1) AS current_pm "
            + "FROM tbl_project AS p "
            + "INNER JOIN tbl_customer AS c ON p.customer_id = c.id "
            + "WHERE p.enabled = 1", nativeQuery = true)
    List<ProjectOptionDto> findAllSelectOption();
}
