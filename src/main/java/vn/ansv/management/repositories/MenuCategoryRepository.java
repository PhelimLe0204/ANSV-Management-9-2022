package vn.ansv.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.ansv.management.models.MenuCategory;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Integer> {
    @Query(value = "SELECT id, null AS uid, menu_category, null AS note, null AS created_by, " +
            "null AS created_at FROM tbl_menu_category", nativeQuery = true)
    List<MenuCategory> findAllLayout(); // Phân loại menu trên layout
}
