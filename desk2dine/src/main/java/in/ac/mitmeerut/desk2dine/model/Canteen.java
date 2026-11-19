package in.ac.mitmeerut.desk2dine.model;

public class Canteen {

    // ==========================================
    // ATTRIBUTES
    // ==========================================

    private int canteenId;

    private String name;

    private String mobile;

    private String email;

    private String password;

    // ==========================================
    // DEFAULT CONSTRUCTOR
    // ==========================================

    public Canteen() {

    }

    // ==========================================
    // PARAMETERIZED CONSTRUCTOR
    // ==========================================

    public Canteen(int canteenId,
                   String name,
                   String mobile,
                   String email,
                   String password) {

        this.canteenId = canteenId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    // ==========================================
    // GETTERS
    // ==========================================

    public int getCanteenId() {
        return canteenId;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // ==========================================
    // SETTERS
    // ==========================================

    public void setCanteenId(int canteenId) {
        this.canteenId = canteenId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ==========================================
    // toString()
    // ==========================================

    @Override
    public String toString() {

        return "Canteen{" +
                "canteenId=" + canteenId +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}