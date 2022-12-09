package vn.ansv.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ansv.management.models.Menu;
import vn.ansv.management.repositories.MenuRepository;

@Service
public class MenuService implements Interface_Menu {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> findAllLayoutByCategory(int category) {
        return menuRepository.findAll();
    }
}
