package in.ac.mitmeerut.desk2dine.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:sqlite:desk2dine.db";

    public static Connection getConnection() {

        try {

            Class.forName("org.sqlite.JDBC");

            return DriverManager.getConnection(URL);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

            return null;

        }

    }

}