package in.ac.mitmeerut.desk2dine.model;

public class Order {

    private int orderId;
    private String facultyEmail;
    private String foodName;
    private int quantity;
    private double price;
    private double total;
    private String status;

    // ==========================
    // Default Constructor
    // ==========================

    public Order() {

    }

    // ==========================
    // Parameterized Constructor
    // ==========================

    public Order(int orderId, String facultyEmail,
                 String foodName, int quantity,
                 double price, double total,
                 String status) {

        this.orderId = orderId;
        this.facultyEmail = facultyEmail;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.status = status;

    }

    // ==========================
    // Getter & Setter
    // ==========================

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getFacultyEmail() {
        return facultyEmail;
    }

    public void setFacultyEmail(String facultyEmail) {
        this.facultyEmail = facultyEmail;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}