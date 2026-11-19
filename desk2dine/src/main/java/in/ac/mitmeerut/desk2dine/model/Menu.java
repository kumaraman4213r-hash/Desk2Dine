package in.ac.mitmeerut.desk2dine.model;

public class Menu {

    private int menuId;
    private String foodName;
    private String category;
    private double price;
    private String description;
    private int available;

    // Default Constructor
    public Menu() {

    }

    // Parameterized Constructor
    public Menu(int menuId, String foodName, String category,
                double price, String description,
                int available) {

        this.menuId = menuId;
        this.foodName = foodName;
        this.category = category;
        this.price = price;
        this.description = description;
        this.available = available;
    }

    // Getter & Setter

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

}