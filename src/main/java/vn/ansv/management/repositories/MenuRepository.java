package vn.ansv.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.ansv.management.models.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
  /*
   * ---------------------------------------------------------
   * Truy vấn menu (level 1) trên layout theo phân loại menu
   * ---------------------------------------------------------
   */
  @Query(value = "SELECT m.id, null AS uid, null AS menu_category_id, level, null AS previous, " +
      "m.display, m.icon_data, m.link, include, null AS enabled, null AS created_by, " +
      "null AS created_at " +
      "FROM tbl_menu AS m " +
      "WHERE m.menu_category_id = ?1 AND m.level = ?2 AND m.enabled = 1", nativeQuery = true)
  List<Menu> findAllLayoutLevel1(int menu_category_id, int level);

  /*
   * -------------------------------------------------------
   * Truy vấn menu (level 2) trên layout theo menu level 1
   * -------------------------------------------------------
   */
  @Query(value = "SELECT m.id, null AS uid, null AS menu_category_id, level, null AS previous, " +
      "m.display, m.icon_data, m.link, include, null AS enabled, null AS created_by, " +
      "null AS created_at " +
      "FROM tbl_menu AS m " +
      "WHERE m.previous = ?1 AND m.level = ?2 AND m.enabled = 1", nativeQuery = true)
  List<Menu> findAllLayoutLevel2(int previous, int level);

  // Iterable<Menu> findByEnabled(int enabled);
  // @Query("SELECT m.id, m.uid, m.menu_category_id, m.level, m.previous,
  // m.display, m.icon_data, m.link, m.include " +
  // "FROM Menu m WHERE m.enabled = 1")
  // @Query("SELECT m " +
  // "FROM Menu m WHERE m.enabled = 1")
  // List<Menu> findAllEnabled();

  // @Query(value = "SELECT id, menu_category FROM tbl_menu_category", nativeQuery
  // = true)
  // public List<Object[]> findTest();

  // @Query("SELECT m.id, m.uid, m.menu_category_id, m.level, m.previous,
  // m.display, m.icon_data, m.link, m.include " +
  // "FROM tbl_menu m WHERE m.enabled = 1")
  // Iterable<Menu> findAllEnabled(@Param("enabled") Integer status);
}
