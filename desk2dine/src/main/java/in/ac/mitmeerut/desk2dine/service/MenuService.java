package in.ac.mitmeerut.desk2dine.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import in.ac.mitmeerut.desk2dine.dao.MenuDAO;
import in.ac.mitmeerut.desk2dine.model.Menu;

@Service
public class MenuService {

    private MenuDAO menuDAO = new MenuDAO();

    // ==========================
    // Add Menu Item
    // ==========================
    public boolean addMenu(Menu menu) {

        return menuDAO.addMenu(menu);

    }

    // ==========================
    // Get All Menu Items
    // ==========================
    public ArrayList<Menu> getAllMenu() {

        return menuDAO.getAllMenu();

    }

    // ==========================
    // Get Menu By ID
    // ==========================
    public Menu getMenuById(int menuId) {

        return menuDAO.getMenuById(menuId);

    }

    // ==========================
    // Update Menu Item
    // ==========================
    public boolean updateMenu(Menu menu) {

        return menuDAO.updateMenu(menu);

    }

    // ==========================
    // Delete Menu Item
    // ==========================
    public boolean deleteMenu(int menuId) {

        return menuDAO.deleteMenu(menuId);

    }

}