package vn.ansv.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ansv.management.models.Menu;
import vn.ansv.management.models.MenuCategory;
import vn.ansv.management.repositories.MenuCategoryRepository;
import vn.ansv.management.repositories.MenuRepository;

@Service
public class MenuCategoryService implements Interface_MenuCategory {
    @Autowired
    private MenuCategoryRepository menuCategoryRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuCategory> findAllLayout() {
        List<MenuCategory> category = menuCategoryRepository.findAllLayout();

        category.forEach((categoryItem) -> {
            try {
                // Menu cấp 1
                List<Menu> menuLayoutByCategory1 = menuRepository.findAllLayoutLevel1(
                        categoryItem.getId(), 1);
                menuLayoutByCategory1.forEach((menuItem1) -> {
                    if (menuItem1.getLevel() == 1) {
                        try {
                            // Menu cấp 2 với menu cấp 1 tương ứng
                            List<Menu> menuLayoutByCategory2 = menuRepository.findAllLayoutLevel2(
                                    menuItem1.getId(), 2);
                            menuItem1.setMenu_con(menuLayoutByCategory2);
                        } catch (NullPointerException e) {
                            System.out.println("");
                            System.out.println(
                                    "NullPointerException (MenuCategoryService - line 40) ===== Menu (level 1) with id "
                                            + menuItem1.getId() + " has no include.");
                            System.out.println("");
                        }
                    }
                });
                categoryItem.setMenu_item(menuLayoutByCategory1);
            } catch (NullPointerException e) {
                System.out.println("");
                System.out.println("NullPointerException (MenuCategoryService - line 47) ===== Category with id "
                        + categoryItem.getId()
                        + " has no include menu.");
                System.out.println("");
            }
        });

        return category;
    }
}
