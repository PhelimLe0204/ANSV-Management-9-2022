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
    @Query(value = "SELECT p.id, null AS uid, null AS customer_id, p.project_name, null AS description, "
            + "null AS enabled, null AS note, null AS created_by, null AS created_at "
            + "FROM tbl_project AS p "
            + "WHERE p.enabled = 1", nativeQuery = true)
    List<Project> findAllSelectOption();
}
