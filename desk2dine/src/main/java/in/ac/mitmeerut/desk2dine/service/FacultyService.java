package in.ac.mitmeerut.desk2dine.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import in.ac.mitmeerut.desk2dine.dao.FacultyDAO;
import in.ac.mitmeerut.desk2dine.model.Faculty;

@Service
public class FacultyService {

    private FacultyDAO facultyDAO = new FacultyDAO();

    // Add Faculty
    public boolean addFaculty(Faculty faculty) {

        return facultyDAO.addFaculty(faculty);

    }

    // Faculty Login
    public Faculty loginFaculty(String email, String password) {

        return facultyDAO.loginFaculty(email, password);

    }

    // Get Faculty By Email
    public Faculty getFacultyByEmail(String email) {

        return facultyDAO.getFacultyByEmail(email);

    }

    // Get All Faculty
    public ArrayList<Faculty> getAllFaculty() {

        return facultyDAO.getAllFaculty();

    }

    // Update Faculty
    public boolean updateFaculty(Faculty faculty) {

        return facultyDAO.updateFaculty(faculty);

    }

    // Delete Faculty
    public boolean deleteFaculty(int facultyId) {

        return facultyDAO.deleteFaculty(facultyId);

    }

}