package in.ac.mitmeerut.desk2dine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import in.ac.mitmeerut.desk2dine.model.Canteen;
import in.ac.mitmeerut.desk2dine.util.DBConnection;

@Repository
public class CanteenDAO {

    // ==========================================
    // SAVE CANTEEN
    // ==========================================

    public boolean saveCanteen(Canteen canteen) {

        try {

            Connection connection = DBConnection.getConnection();

            String query = """
                    INSERT INTO canteen
                    (
                        name,
                        mobile,
                        email,
                        password
                    )
                    VALUES
                    (
                        ?, ?, ?, ?
                    )
                    """;

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(1, canteen.getName());
            preparedStatement.setString(2, canteen.getMobile());
            preparedStatement.setString(3, canteen.getEmail());
            preparedStatement.setString(4, canteen.getPassword());

            int rows = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rows > 0;

        } catch (Exception exception) {

            exception.printStackTrace();

            return false;
        }

    }

    // ==========================================
    // LOGIN
    // ==========================================

    public Canteen login(String email, String password) {

        try {

            Connection connection = DBConnection.getConnection();

            String query = """
                    SELECT *
                    FROM canteen
                    WHERE email = ?
                    AND password = ?
                    """;

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Canteen canteen = new Canteen();

                canteen.setCanteenId(resultSet.getInt("canteen_id"));
                canteen.setName(resultSet.getString("name"));
                canteen.setMobile(resultSet.getString("mobile"));
                canteen.setEmail(resultSet.getString("email"));
                canteen.setPassword(resultSet.getString("password"));

                resultSet.close();
                preparedStatement.close();
                connection.close();

                return canteen;

            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception exception) {

            exception.printStackTrace();

        }

        return null;

    }

    // ==========================================
    // FIND BY EMAIL
    // ==========================================

    public Canteen getByEmail(String email) {

        try {

            Connection connection = DBConnection.getConnection();

            String query =
                    "SELECT * FROM canteen WHERE email = ?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Canteen canteen = new Canteen();

                canteen.setCanteenId(resultSet.getInt("canteen_id"));
                canteen.setName(resultSet.getString("name"));
                canteen.setMobile(resultSet.getString("mobile"));
                canteen.setEmail(resultSet.getString("email"));
                canteen.setPassword(resultSet.getString("password"));

                resultSet.close();
                preparedStatement.close();
                connection.close();

                return canteen;

            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception exception) {

            exception.printStackTrace();

        }

        return null;

    }

    // ==========================================
    // UPDATE
    // ==========================================

    public boolean updateCanteen(Canteen canteen) {

        try {

            Connection connection = DBConnection.getConnection();

            String query = """
                    UPDATE canteen
                    SET
                        name=?,
                        mobile=?,
                        email=?,
                        password=?
                    WHERE
                        canteen_id=?
                    """;

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setString(1, canteen.getName());
            preparedStatement.setString(2, canteen.getMobile());
            preparedStatement.setString(3, canteen.getEmail());
            preparedStatement.setString(4, canteen.getPassword());
            preparedStatement.setInt(5, canteen.getCanteenId());

            int rows = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rows > 0;

        } catch (Exception exception) {

            exception.printStackTrace();

            return false;

        }

    }

    // ==========================================
    // DELETE
    // ==========================================

    public boolean deleteCanteen(int canteenId) {

        try {

            Connection connection = DBConnection.getConnection();

            String query =
                    "DELETE FROM canteen WHERE canteen_id=?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(query);

            preparedStatement.setInt(1, canteenId);

            int rows = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return rows > 0;

        } catch (Exception exception) {

            exception.printStackTrace();

            return false;

        }

    }

}