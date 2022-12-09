package vn.ansv.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.ansv.management.models.ProjectPriority;

public interface ProjectPriorityRepository extends JpaRepository<ProjectPriority, Integer> {
    @Query(value = "SELECT * FROM tbl_project_priority", nativeQuery = true)
    List<ProjectPriority> findAll_detailProject();
}
