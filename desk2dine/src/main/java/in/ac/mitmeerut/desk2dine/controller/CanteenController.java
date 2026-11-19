package in.ac.mitmeerut.desk2dine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ac.mitmeerut.desk2dine.model.Canteen;
import in.ac.mitmeerut.desk2dine.service.CanteenService;
import in.ac.mitmeerut.desk2dine.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CanteenController {

    // =====================================================
    // SERVICES
    // =====================================================

    @Autowired
    private CanteenService canteenService;

    @Autowired
    private OrderService orderService;


    // =====================================================
    // LOGIN PAGE
    // =====================================================

    @GetMapping("/canteen/login")
    public String loginPage() {

        return "canteen/canteen-login";
    }


    // =====================================================
    // LOGIN
    // =====================================================

    @PostMapping("/canteen/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            Model model,
            HttpSession session) {

        Canteen canteen =
                canteenService.login(email, password);

        if (canteen != null) {

            session.setAttribute(
                    "canteen",
                    canteen
            );

            return "redirect:/canteen/dashboard";
        }

        model.addAttribute(
                "error",
                "Invalid Email or Password"
        );

        return "canteen/canteen-login";
    }


    // =====================================================
    // DASHBOARD
    // =====================================================

    @GetMapping("/canteen/dashboard")
    public String dashboard(
            HttpSession session,
            Model model) {

        Canteen canteen =
                (Canteen) session.getAttribute("canteen");

        // Check Login
        if (canteen == null) {

            return "redirect:/canteen/login";
        }


        // =================================================
        // CANTEEN INFORMATION
        // =================================================

        model.addAttribute(
                "canteen",
                canteen
        );


        // =================================================
        // ORDER STATISTICS
        // =================================================

        model.addAttribute(
                "totalOrders",
                orderService.getTotalOrders()
        );

        model.addAttribute(
                "pendingOrders",
                orderService.getPendingOrders()
        );

        model.addAttribute(
                "preparingOrders",
                orderService.getPreparingOrders()
        );

        model.addAttribute(
                "readyOrders",
                orderService.getReadyOrders()
        );

        model.addAttribute(
                "deliveredOrders",
                orderService.getDeliveredOrders()
        );


        // =================================================
        // RECENT ORDERS
        // =================================================

        model.addAttribute(
                "orderList",
                orderService.getAllOrders()
        );


        return "canteen/canteen-dashboard";
    }


    // =====================================================
    // INCOMING ORDERS
    // =====================================================

    @GetMapping("/canteen/incoming-orders")
    public String incomingOrders(
            HttpSession session,
            Model model) {

        Canteen canteen =
                (Canteen) session.getAttribute("canteen");

        // Check Login
        if (canteen == null) {

            return "redirect:/canteen/login";
        }


        // Canteen Information
        model.addAttribute(
                "canteen",
                canteen
        );


        // =================================================
        // ONLY PENDING ORDERS
        // =================================================

        model.addAttribute(
                "orderList",
                orderService.getPendingOrderList()
        );


        return "canteen/canteen-incoming-orders";
    }


    // =====================================================
    // PREPARING ORDERS
    // =====================================================

    @GetMapping("/canteen/preparing")
    public String preparingOrders(
            HttpSession session,
            Model model) {

        Canteen canteen =
                (Canteen) session.getAttribute("canteen");

        // Check Login
        if (canteen == null) {

            return "redirect:/canteen/login";
        }


        // Canteen Information
        model.addAttribute(
                "canteen",
                canteen
        );


        // =================================================
        // ONLY PREPARING ORDERS
        // =================================================

        model.addAttribute(
                "orderList",
                orderService.getPreparingOrderList()
        );


        return "canteen/canteen-preparing";
    }


    // =====================================================
    // READY ORDERS
    // =====================================================

    @GetMapping("/canteen/ready")
    public String readyOrders(
            HttpSession session,
            Model model) {

        Canteen canteen =
                (Canteen) session.getAttribute("canteen");

        // Check Login
        if (canteen == null) {

            return "redirect:/canteen/login";
        }


        // Canteen Information
        model.addAttribute(
                "canteen",
                canteen
        );


        // =================================================
        // ONLY READY ORDERS
        // =================================================

        model.addAttribute(
                "orderList",
                orderService.getReadyOrderList()
        );


        return "canteen/canteen-ready";
    }


    // =====================================================
    // DELIVERED ORDERS
    // =====================================================

    @GetMapping("/canteen/delivered")
    public String deliveredOrders(
            HttpSession session,
            Model model) {

        Canteen canteen =
                (Canteen) session.getAttribute("canteen");

        // Check Login
        if (canteen == null) {

            return "redirect:/canteen/login";
        }


        // Canteen Information
        model.addAttribute(
                "canteen",
                canteen
        );


        // =================================================
        // ONLY DELIVERED ORDERS
        // =================================================

        model.addAttribute(
                "orderList",
                orderService.getDeliveredOrderList()
        );


        return "canteen/canteen-delivered";
    }


    // =====================================================
    // UPDATE ORDER STATUS
    // =====================================================

    @PostMapping("/canteen/update-status")
    public String updateOrderStatus(
            @RequestParam int orderId,
            @RequestParam String status,
            HttpSession session) {

        // =================================================
        // CHECK LOGIN
        // =================================================

        Canteen canteen =
                (Canteen) session.getAttribute("canteen");

        if (canteen == null) {

            return "redirect:/canteen/login";
        }


        // =================================================
        // UPDATE STATUS IN DATABASE
        // =================================================

        boolean updated =
                orderService.updateOrderStatus(
                        orderId,
                        status
                );


        // =================================================
        // IF UPDATE FAILED
        // =================================================

        if (!updated) {

            return "redirect:/canteen/dashboard";
        }


        // =================================================
        // REDIRECT ACCORDING TO STATUS
        // =================================================

        switch (status) {

            case "Pending":

                return "redirect:/canteen/incoming-orders";


            case "Preparing":

                return "redirect:/canteen/preparing";


            case "Ready":

                return "redirect:/canteen/ready";


            case "Delivered":

                return "redirect:/canteen/delivered";


            case "Completed":

                return "redirect:/canteen/dashboard";


            default:

                return "redirect:/canteen/dashboard";
        }
    }


    // =====================================================
    // LOGOUT
    // =====================================================

    @GetMapping("/canteen/logout")
    public String logout(
            HttpSession session) {

        // Destroy Session
        session.invalidate();

        return "redirect:/";
    }

}