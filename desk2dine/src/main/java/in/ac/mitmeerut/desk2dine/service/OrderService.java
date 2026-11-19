package in.ac.mitmeerut.desk2dine.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.mitmeerut.desk2dine.dao.OrderDAO;
import in.ac.mitmeerut.desk2dine.model.Order;

@Service
public class OrderService {

    // =====================================================
    // ORDER DAO
    // =====================================================

    @Autowired
    private OrderDAO orderDAO;


    // =====================================================
    // PLACE ORDER
    // =====================================================

    public boolean placeOrder(Order order) {

        return orderDAO.placeOrder(order);
    }


    // =====================================================
    // GET ALL ORDERS
    // =====================================================

    public ArrayList<Order> getAllOrders() {

        return orderDAO.getAllOrders();
    }


    // =====================================================
    // GET PENDING ORDER LIST
    // =====================================================

    public ArrayList<Order> getPendingOrderList() {

        return orderDAO.getPendingOrderList();
    }


    // =====================================================
    // GET PREPARING ORDER LIST
    // =====================================================

    public ArrayList<Order> getPreparingOrderList() {

        return orderDAO.getPreparingOrderList();
    }


    // =====================================================
    // GET READY ORDER LIST
    // =====================================================

    public ArrayList<Order> getReadyOrderList() {

        return orderDAO.getReadyOrderList();
    }


    // =====================================================
    // GET DELIVERED ORDER LIST
    // =====================================================

    public ArrayList<Order> getDeliveredOrderList() {

        return orderDAO.getDeliveredOrderList();
    }


    // =====================================================
    // GET ORDERS BY FACULTY
    // =====================================================

    public ArrayList<Order> getOrdersByFaculty(
            String facultyEmail) {

        return orderDAO.getOrdersByFaculty(facultyEmail);
    }


    // =====================================================
    // UPDATE ORDER STATUS
    // =====================================================

    public boolean updateOrderStatus(
            int orderId,
            String status) {

        return orderDAO.updateOrderStatus(
                orderId,
                status
        );
    }


    // =====================================================
    // DELETE ORDER
    // =====================================================

    public boolean deleteOrder(int orderId) {

        return orderDAO.deleteOrder(orderId);
    }


    // =====================================================
    // TOTAL ORDERS COUNT
    // =====================================================

    public int getTotalOrders() {

        return orderDAO.getTotalOrders();
    }


    // =====================================================
    // PENDING ORDERS COUNT
    // =====================================================

    public int getPendingOrders() {

        return orderDAO.getPendingOrders();
    }


    // =====================================================
    // PREPARING ORDERS COUNT
    // =====================================================

    public int getPreparingOrders() {

        return orderDAO.getPreparingOrders();
    }


    // =====================================================
    // READY ORDERS COUNT
    // =====================================================

    public int getReadyOrders() {

        return orderDAO.getReadyOrders();
    }


    // =====================================================
    // DELIVERED ORDERS COUNT
    // =====================================================

    public int getDeliveredOrders() {

        return orderDAO.getDeliveredOrders();
    }


    // =====================================================
    // GET COUNT BY STATUS
    // =====================================================

    public int getOrdersByStatus(String status) {

        return orderDAO.getOrdersByStatus(status);
    }

}