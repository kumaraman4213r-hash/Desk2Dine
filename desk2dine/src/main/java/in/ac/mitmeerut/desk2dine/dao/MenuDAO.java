package in.ac.mitmeerut.desk2dine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.ac.mitmeerut.desk2dine.model.Menu;
import in.ac.mitmeerut.desk2dine.util.DBConnection;

public class MenuDAO {

    // ==========================
    // Add Menu Item
    // ==========================
    public boolean addMenu(Menu menu) {

        String sql = "INSERT INTO menu(food_name,category,price,description,available) VALUES(?,?,?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, menu.getFoodName());
            ps.setString(2, menu.getCategory());
            ps.setDouble(3, menu.getPrice());
            ps.setString(4, menu.getDescription());
            ps.setInt(5, menu.getAvailable());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    // ==========================
    // Get All Menu Items
    // ==========================
    public ArrayList<Menu> getAllMenu() {

        ArrayList<Menu> menuList = new ArrayList<>();

        String sql = "SELECT * FROM menu";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                Menu menu = new Menu();

                menu.setMenuId(rs.getInt("menu_id"));
                menu.setFoodName(rs.getString("food_name"));
                menu.setCategory(rs.getString("category"));
                menu.setPrice(rs.getDouble("price"));
                menu.setDescription(rs.getString("description"));
                menu.setAvailable(rs.getInt("available"));

                menuList.add(menu);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return menuList;
    }

    // ==========================
    // Get Menu By ID
    // ==========================
    public Menu getMenuById(int menuId) {

        String sql = "SELECT * FROM menu WHERE menu_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, menuId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Menu menu = new Menu();

                menu.setMenuId(rs.getInt("menu_id"));
                menu.setFoodName(rs.getString("food_name"));
                menu.setCategory(rs.getString("category"));
                menu.setPrice(rs.getDouble("price"));
                menu.setDescription(rs.getString("description"));
                menu.setAvailable(rs.getInt("available"));

                return menu;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    // ==========================
    // Update Menu Item
    // ==========================
    public boolean updateMenu(Menu menu) {

        String sql = "UPDATE menu SET food_name=?, category=?, price=?, description=?, available=? WHERE menu_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, menu.getFoodName());
            ps.setString(2, menu.getCategory());
            ps.setDouble(3, menu.getPrice());
            ps.setString(4, menu.getDescription());
            ps.setInt(5, menu.getAvailable());
            ps.setInt(6, menu.getMenuId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    // ==========================
    // Delete Menu Item
    // ==========================
    public boolean deleteMenu(int menuId) {

        String sql = "DELETE FROM menu WHERE menu_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, menuId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

}