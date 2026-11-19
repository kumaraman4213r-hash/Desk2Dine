package in.ac.mitmeerut.desk2dine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ac.mitmeerut.desk2dine.dao.CanteenDAO;
import in.ac.mitmeerut.desk2dine.model.Canteen;

@Service
public class CanteenService {

    // ==========================================
    // DEPENDENCY INJECTION
    // ==========================================

    @Autowired
    private CanteenDAO canteenDAO;

    // ==========================================
    // SAVE CANTEEN
    // ==========================================

    public boolean saveCanteen(Canteen canteen) {

        return canteenDAO.saveCanteen(canteen);

    }

    // ==========================================
    // LOGIN
    // ==========================================

    public Canteen login(String email, String password) {

        return canteenDAO.login(email, password);

    }

    // ==========================================
    // GET BY EMAIL
    // ==========================================

    public Canteen getByEmail(String email) {

        return canteenDAO.getByEmail(email);

    }

    // ==========================================
    // UPDATE
    // ==========================================

    public boolean updateCanteen(Canteen canteen) {

        return canteenDAO.updateCanteen(canteen);

    }

    // ==========================================
    // DELETE
    // ==========================================

    public boolean deleteCanteen(int canteenId) {

        return canteenDAO.deleteCanteen(canteenId);

    }

}