package vn.ansv.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.ansv.management.models.ProjectStatus;

public interface ProjectStatusReposiroty extends JpaRepository<ProjectStatus, Integer> {
    @Query(value = "SELECT * FROM tbl_project_status", nativeQuery = true)
    List<ProjectStatus> findAll_detailProject();
}
