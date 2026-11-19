package in.ac.mitmeerut.desk2dine.model;

public class Faculty {

    private int facultyId;
    private String name;
    private String department;
    private String mobile;
    private String email;
    private String password;

    // Default Constructor
    public Faculty() {

    }

    // Parameterized Constructor
    public Faculty(int facultyId, String name, String department,
                   String mobile, String email, String password) {

        this.facultyId = facultyId;
        this.name = name;
        this.department = department;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Faculty [facultyId=" + facultyId +
                ", name=" + name +
                ", department=" + department +
                ", mobile=" + mobile +
                ", email=" + email + "]";
    }

}