package in.ac.mitmeerut.desk2dine.util;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {

        try {

            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();

            // ==========================================
            // FACULTY TABLE
            // ==========================================

            String facultyTable = """
                    CREATE TABLE IF NOT EXISTS faculty(

                        faculty_id INTEGER PRIMARY KEY AUTOINCREMENT,

                        name TEXT NOT NULL,

                        department TEXT NOT NULL,

                        mobile TEXT NOT NULL,

                        email TEXT UNIQUE NOT NULL,

                        password TEXT NOT NULL

                    );
                    """;

            statement.execute(facultyTable);

            // ==========================================
            // CANTEEN TABLE
            // ==========================================

            String canteenTable = """
                    CREATE TABLE IF NOT EXISTS canteen(

                        canteen_id INTEGER PRIMARY KEY AUTOINCREMENT,

                        name TEXT NOT NULL,

                        mobile TEXT NOT NULL,

                        email TEXT UNIQUE NOT NULL,

                        password TEXT NOT NULL

                    );
                    """;

            statement.execute(canteenTable);

            // ==========================================
            // MENU TABLE
            // ==========================================

            String menuTable = """
                    CREATE TABLE IF NOT EXISTS menu(

                        menu_id INTEGER PRIMARY KEY AUTOINCREMENT,

                        food_name TEXT NOT NULL,

                        category TEXT NOT NULL,

                        price REAL NOT NULL,

                        description TEXT,

                        available INTEGER DEFAULT 1

                    );
                    """;

            statement.execute(menuTable);

            // ==========================================
            // ORDERS TABLE
            // ==========================================

            String ordersTable = """
                    CREATE TABLE IF NOT EXISTS orders(

                        order_id INTEGER PRIMARY KEY AUTOINCREMENT,

                        faculty_email TEXT NOT NULL,

                        food_name TEXT NOT NULL,

                        quantity INTEGER NOT NULL,

                        price REAL NOT NULL,

                        total REAL NOT NULL,

                        status TEXT DEFAULT 'Pending'

                    );
                    """;

            statement.execute(ordersTable);

            // ==========================================
            // SUCCESS MESSAGE
            // ==========================================

            System.out.println("======================================");
            System.out.println(" Database Created Successfully");
            System.out.println(" Faculty Table Created Successfully");
            System.out.println(" Canteen Table Created Successfully");
            System.out.println(" Menu Table Created Successfully");
            System.out.println(" Orders Table Created Successfully");
            System.out.println("======================================");

            statement.close();
            connection.close();

        } catch (Exception exception) {

            exception.printStackTrace();

        }

    }

}