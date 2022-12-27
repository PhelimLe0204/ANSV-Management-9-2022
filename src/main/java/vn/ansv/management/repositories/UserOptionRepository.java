package vn.ansv.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.ansv.management.dto.UserOptionDto;

public interface UserOptionRepository extends JpaRepository<UserOptionDto, Integer> {
    /*
     * ----------------------------------
     * Truy vấn user (select option)
     * ----------------------------------
     */
    @Query(value = "SELECT u.id, u.employee_code, u.fullname, u.avatar "
            + "FROM tbl_user AS u "
            + "INNER JOIN tbl_user_role AS ur ON u.id = ur.user_id "
            + "INNER JOIN tbl_role AS r ON ur.role_id = r.id "
            + "WHERE u.enabled = 1 and r.id = 6", nativeQuery = true)
    List<UserOptionDto> findAllSelectOption();
}
