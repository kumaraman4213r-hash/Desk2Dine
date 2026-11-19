package in.ac.mitmeerut.desk2dine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import in.ac.mitmeerut.desk2dine.model.Order;
import in.ac.mitmeerut.desk2dine.util.DBConnection;

@Repository
public class OrderDAO {

    // =====================================================
    // PLACE ORDER
    // =====================================================

    public boolean placeOrder(Order order) {

        String sql = """
                INSERT INTO orders
                (faculty_email, food_name, quantity, price, total, status)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, order.getFacultyEmail());
            ps.setString(2, order.getFoodName());
            ps.setInt(3, order.getQuantity());
            ps.setDouble(4, order.getPrice());
            ps.setDouble(5, order.getTotal());
            ps.setString(6, order.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }


    // =====================================================
    // GET ALL ORDERS
    // =====================================================

    public ArrayList<Order> getAllOrders() {

        ArrayList<Order> orderList = new ArrayList<>();

        String sql = """
                SELECT *
                FROM orders
                ORDER BY order_id DESC
                """;

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Order order = createOrderFromResultSet(rs);

                orderList.add(order);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return orderList;
    }


    // =====================================================
    // GET PENDING ORDER LIST
    // =====================================================

    public ArrayList<Order> getPendingOrderList() {

        return getOrdersByStatusName("Pending");
    }


    // =====================================================
    // GET PREPARING ORDER LIST
    // =====================================================

    public ArrayList<Order> getPreparingOrderList() {

        return getOrdersByStatusName("Preparing");
    }


    // =====================================================
    // GET READY ORDER LIST
    // =====================================================

    public ArrayList<Order> getReadyOrderList() {

        return getOrdersByStatusName("Ready");
    }


    // =====================================================
    // GET DELIVERED ORDER LIST
    // =====================================================

    public ArrayList<Order> getDeliveredOrderList() {

        return getOrdersByStatusName("Delivered");
    }


    // =====================================================
    // GET ORDERS BY STATUS - LIST
    // =====================================================

    private ArrayList<Order> getOrdersByStatusName(String status) {

        ArrayList<Order> orderList = new ArrayList<>();

        String sql = """
                SELECT *
                FROM orders
                WHERE status = ?
                ORDER BY order_id DESC
                """;

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, status);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Order order = createOrderFromResultSet(rs);

                    orderList.add(order);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return orderList;
    }


    // =====================================================
    // GET ORDERS BY FACULTY
    // =====================================================

    public ArrayList<Order> getOrdersByFaculty(
            String facultyEmail) {

        ArrayList<Order> orderList = new ArrayList<>();

        String sql = """
                SELECT *
                FROM orders
                WHERE faculty_email = ?
                ORDER BY order_id DESC
                """;

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, facultyEmail);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Order order = createOrderFromResultSet(rs);

                    orderList.add(order);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return orderList;
    }


    // =====================================================
    // UPDATE ORDER STATUS
    // =====================================================

    public boolean updateOrderStatus(
            int orderId,
            String status) {

        String sql = """
                UPDATE orders
                SET status = ?
                WHERE order_id = ?
                """;

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, status);
            ps.setInt(2, orderId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }


    // =====================================================
    // DELETE ORDER
    // =====================================================

    public boolean deleteOrder(int orderId) {

        String sql = """
                DELETE FROM orders
                WHERE order_id = ?
                """;

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, orderId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }


    // =====================================================
    // GET TOTAL ORDERS
    // =====================================================

    public int getTotalOrders() {

        String sql = "SELECT COUNT(*) FROM orders";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            if (rs.next()) {

                return rs.getInt(1);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }


    // =====================================================
    // GET ORDERS COUNT BY STATUS
    // =====================================================

    public int getOrdersByStatus(String status) {

        String sql = """
                SELECT COUNT(*)
                FROM orders
                WHERE status = ?
                """;

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, status);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return rs.getInt(1);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }


    // =====================================================
    // GET PENDING ORDERS COUNT
    // =====================================================

    public int getPendingOrders() {

        return getOrdersByStatus("Pending");
    }


    // =====================================================
    // GET PREPARING ORDERS COUNT
    // =====================================================

    public int getPreparingOrders() {

        return getOrdersByStatus("Preparing");
    }


    // =====================================================
    // GET READY ORDERS COUNT
    // =====================================================

    public int getReadyOrders() {

        return getOrdersByStatus("Ready");
    }


    // =====================================================
    // GET DELIVERED ORDERS COUNT
    // =====================================================

    public int getDeliveredOrders() {

        return getOrdersByStatus("Delivered");
    }


    // =====================================================
    // CREATE ORDER OBJECT
    // =====================================================

    private Order createOrderFromResultSet(
            ResultSet rs) throws SQLException {

        Order order = new Order();

        order.setOrderId(
                rs.getInt("order_id")
        );

        order.setFacultyEmail(
                rs.getString("faculty_email")
        );

        order.setFoodName(
                rs.getString("food_name")
        );

        order.setQuantity(
                rs.getInt("quantity")
        );

        order.setPrice(
                rs.getDouble("price")
        );

        order.setTotal(
                rs.getDouble("total")
        );

        order.setStatus(
                rs.getString("status")
        );

        return order;
    }

}