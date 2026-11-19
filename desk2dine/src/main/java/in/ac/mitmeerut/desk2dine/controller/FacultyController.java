package in.ac.mitmeerut.desk2dine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

import in.ac.mitmeerut.desk2dine.model.Faculty;
import in.ac.mitmeerut.desk2dine.model.Order;
import in.ac.mitmeerut.desk2dine.service.FacultyService;
import in.ac.mitmeerut.desk2dine.service.MenuService;
import in.ac.mitmeerut.desk2dine.service.OrderService;

@Controller
public class FacultyController {

    // ==========================================
    // SERVICES
    // ==========================================

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private OrderService orderService;


    // ==========================================
    // FACULTY LOGIN PAGE
    // ==========================================

    @GetMapping("/faculty/login")
    public String facultyLogin() {

        return "faculty/faculty-login";
    }


    // ==========================================
    // FACULTY REGISTER PAGE
    // ==========================================

    @GetMapping("/faculty/register")
    public String facultyRegister() {

        return "faculty/faculty-register";
    }


    // ==========================================
    // SAVE FACULTY
    // ==========================================

    @PostMapping("/faculty/save")
    public String saveFaculty(
            @ModelAttribute Faculty faculty) {

        boolean status =
                facultyService.addFaculty(faculty);

        if (status) {

            return "redirect:/faculty/login";
        }

        return "faculty/faculty-register";
    }


    // ==========================================
    // FACULTY AUTHENTICATION
    // ==========================================

    @PostMapping("/faculty/authenticate")
    public String authenticateFaculty(

            @RequestParam String email,
            @RequestParam String password,

            HttpSession session,
            Model model) {

        Faculty faculty =
                facultyService.loginFaculty(
                        email,
                        password
                );

        if (faculty != null) {

            session.setAttribute(
                    "faculty",
                    faculty
            );

            return "redirect:/faculty/dashboard";
        }

        model.addAttribute(
                "error",
                "Invalid Email or Password"
        );

        return "faculty/faculty-login";
    }


    // ==========================================
    // FACULTY DASHBOARD
    // ==========================================

    @GetMapping("/faculty/dashboard")
    public String facultyDashboard(

            HttpSession session,
            Model model) {

        Faculty faculty =
                (Faculty) session.getAttribute("faculty");

        if (faculty == null) {

            return "redirect:/faculty/login";
        }

        model.addAttribute(
                "faculty",
                faculty
        );

        return "faculty/faculty-dashboard";
    }


    // ==========================================
    // FACULTY MENU
    // ==========================================

    @GetMapping("/faculty/menu")
    public String facultyMenu(

            HttpSession session,
            Model model) {

        Faculty faculty =
                (Faculty) session.getAttribute("faculty");

        if (faculty == null) {

            return "redirect:/faculty/login";
        }

        model.addAttribute(
                "faculty",
                faculty
        );

        model.addAttribute(
                "menuList",
                menuService.getAllMenu()
        );

        return "faculty/faculty-menu";
    }


    // ==========================================
    // FACULTY PLACE ORDER PAGE
    // ==========================================

    @GetMapping("/faculty/place-order")
    public String facultyPlaceOrder(

            @RequestParam(required = false)
            String foodName,

            @RequestParam(required = false)
            Double price,

            HttpSession session,
            Model model) {

        Faculty faculty =
                (Faculty) session.getAttribute("faculty");

        if (faculty == null) {

            return "redirect:/faculty/login";
        }

        Order order = new Order();

        if (foodName != null) {

            order.setFoodName(foodName);
        }

        if (price != null) {

            order.setPrice(price);
        }

        model.addAttribute(
                "faculty",
                faculty
        );

        model.addAttribute(
                "order",
                order
        );

        return "faculty/faculty-place-order";
    }


    // ==========================================
    // PLACE ORDER
    // ==========================================

    @PostMapping("/faculty/place-order")
    public String placeOrder(

            @ModelAttribute Order order,

            HttpSession session,
            Model model) {

        Faculty faculty =
                (Faculty) session.getAttribute("faculty");

        if (faculty == null) {

            return "redirect:/faculty/login";
        }

        // Faculty Email
        order.setFacultyEmail(
                faculty.getEmail()
        );

        // Calculate Total
        order.setTotal(
                order.getPrice()
                * order.getQuantity()
        );

        // Initial Status
        order.setStatus("Pending");

        // Save Order
        boolean status =
                orderService.placeOrder(order);

        model.addAttribute(
                "faculty",
                faculty
        );

        if (status) {

            model.addAttribute(
                    "success",
                    "Order Placed Successfully."
            );

        } else {

            model.addAttribute(
                    "error",
                    "Unable to Place Order."
            );
        }

        model.addAttribute(
                "order",
                new Order()
        );

        return "faculty/faculty-place-order";
    }


    // ==========================================
    // MY ORDERS
    // ==========================================

    @GetMapping("/faculty/my-orders")
    public String myOrders(

            HttpSession session,
            Model model) {

        Faculty faculty =
                (Faculty) session.getAttribute("faculty");

        if (faculty == null) {

            return "redirect:/faculty/login";
        }

        model.addAttribute(
                "faculty",
                faculty
        );

        model.addAttribute(
                "orderList",
                orderService.getOrdersByFaculty(
                        faculty.getEmail()
                )
        );

        return "faculty/faculty-my-orders";
    }


    // ==========================================
    // FACULTY BILLS
    // ==========================================

    @GetMapping("/faculty/bills")
    public String facultyBills(

            HttpSession session,
            Model model) {

        // Get logged-in faculty
        Faculty faculty =
                (Faculty) session.getAttribute("faculty");

        // Check login
        if (faculty == null) {

            return "redirect:/faculty/login";
        }

        // Send faculty information
        model.addAttribute(
                "faculty",
                faculty
        );

        // ==========================================
        // GET FACULTY ORDERS
        // ==========================================

        model.addAttribute(
                "orderList",
                orderService.getOrdersByFaculty(
                        faculty.getEmail()
                )
        );

        return "faculty/faculty-bills";
    }


    // ==========================================
    // LOGOUT
    // ==========================================

    @GetMapping("/faculty/logout")
    public String facultyLogout(
            HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }

}