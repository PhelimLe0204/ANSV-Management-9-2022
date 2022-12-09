package vn.ansv.management.services;

import java.util.List;

import vn.ansv.management.models.Menu;

public interface Interface_Menu {
    List<Menu> findAllLayoutByCategory(int category);
}
