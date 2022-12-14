package vn.ansv.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.ansv.management.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    /*
     * ----------------------------------
     * Truy vấn project (select option)
     * ----------------------------------
     */
    @Query(value = "SELECT p.id, NULL AS p.uid, NULL AS customer_id, p.project_name, NULL AS p.description, "
            + "NULL AS p.enabled, NULL AS p.note, NULL AS created_by, NULL AS created_at "
            + "FROM tbl_project AS p "
            + "WHERE p.enabled = 1", nativeQuery = true)
    List<Project> findAllSelectOption();
}
