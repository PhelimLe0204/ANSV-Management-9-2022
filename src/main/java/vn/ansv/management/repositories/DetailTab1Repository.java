package vn.ansv.management.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.ansv.management.dto.DetailTab1Dto;

@Repository
public interface DetailTab1Repository extends CrudRepository<DetailTab1Dto, Integer> {
    /*
     * --------------------------------------------------------------
     * Cập nhật thông tin chi tiết báo cáo (tab 1 - Phần phân loại)
     * --------------------------------------------------------------
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE tbl_project_report pr SET pr.project_id = :project_id, "
            + "pr.project_type_id = :project_type_id, pr.project_priority_id = :project_priority_id, "
            + "pr.project_status_id = :project_status_id, pr.week = :week, pr.year = :year, "
            + "pr.ma_hop_dong = :ma_hop_dong, pr.ma_ke_toan = :ma_ke_toan, pr.currency_unit_id = :currency_unit_id "
            + "WHERE pr.id = :id", nativeQuery = true)
    void update(
            @Param("id") int id, @Param("project_id") int project_id,
            @Param("project_type_id") int project_type_id,
            @Param("project_priority_id") int project_priority_id,
            @Param("project_status_id") int project_status_id, @Param("week") int week,
            @Param("year") int year,
            @Param("ma_hop_dong") String ma_hop_dong, @Param("ma_ke_toan") String ma_ke_toan,
            @Param("currency_unit_id") int currency_unit_id);
}
