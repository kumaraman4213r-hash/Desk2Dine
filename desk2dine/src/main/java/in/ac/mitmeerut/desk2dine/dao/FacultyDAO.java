package in.ac.mitmeerut.desk2dine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.ac.mitmeerut.desk2dine.model.Faculty;
import in.ac.mitmeerut.desk2dine.util.DBConnection;

public class FacultyDAO {

    // Add Faculty
    public boolean addFaculty(Faculty faculty) {

        String sql = "INSERT INTO faculty(name,department,mobile,email,password) VALUES(?,?,?,?,?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, faculty.getName());
            ps.setString(2, faculty.getDepartment());
            ps.setString(3, faculty.getMobile());
            ps.setString(4, faculty.getEmail());
            ps.setString(5, faculty.getPassword());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    // Faculty Login
    public Faculty loginFaculty(String email, String password) {

        String sql = "SELECT * FROM faculty WHERE email=? AND password=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Faculty faculty = new Faculty();

                faculty.setFacultyId(rs.getInt("faculty_id"));
                faculty.setName(rs.getString("name"));
                faculty.setDepartment(rs.getString("department"));
                faculty.setMobile(rs.getString("mobile"));
                faculty.setEmail(rs.getString("email"));
                faculty.setPassword(rs.getString("password"));

                return faculty;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    // Get Faculty By Email
    public Faculty getFacultyByEmail(String email) {

        String sql = "SELECT * FROM faculty WHERE email=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Faculty faculty = new Faculty();

                faculty.setFacultyId(rs.getInt("faculty_id"));
                faculty.setName(rs.getString("name"));
                faculty.setDepartment(rs.getString("department"));
                faculty.setMobile(rs.getString("mobile"));
                faculty.setEmail(rs.getString("email"));
                faculty.setPassword(rs.getString("password"));

                return faculty;
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    // Get All Faculty
    public ArrayList<Faculty> getAllFaculty() {

        ArrayList<Faculty> facultyList = new ArrayList<>();

        String sql = "SELECT * FROM faculty";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            while (rs.next()) {

                Faculty faculty = new Faculty();

                faculty.setFacultyId(rs.getInt("faculty_id"));
                faculty.setName(rs.getString("name"));
                faculty.setDepartment(rs.getString("department"));
                faculty.setMobile(rs.getString("mobile"));
                faculty.setEmail(rs.getString("email"));
                faculty.setPassword(rs.getString("password"));

                facultyList.add(faculty);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return facultyList;
    }

    // Update Faculty
    public boolean updateFaculty(Faculty faculty) {

        String sql = "UPDATE faculty SET name=?, department=?, mobile=?, email=?, password=? WHERE faculty_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, faculty.getName());
            ps.setString(2, faculty.getDepartment());
            ps.setString(3, faculty.getMobile());
            ps.setString(4, faculty.getEmail());
            ps.setString(5, faculty.getPassword());
            ps.setInt(6, faculty.getFacultyId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    // Delete Faculty
    public boolean deleteFaculty(int facultyId) {

        String sql = "DELETE FROM faculty WHERE faculty_id=?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setInt(1, facultyId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

}