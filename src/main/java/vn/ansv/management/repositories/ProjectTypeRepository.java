package vn.ansv.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.ansv.management.models.ProjectType;

public interface ProjectTypeRepository extends JpaRepository<ProjectType, Integer> {
    @Query(value = "SELECT * FROM tbl_project_type", nativeQuery = true)
    List<ProjectType> findAll_detailProject();
}
