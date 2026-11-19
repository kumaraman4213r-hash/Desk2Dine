package in.ac.mitmeerut.desk2dine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ac.mitmeerut.desk2dine.util.DatabaseInitializer;

@SpringBootApplication
public class Desk2dineApplication {

    public static void main(String[] args) {

        // Create database and tables
        DatabaseInitializer.initializeDatabase();

        // Start Spring Boot
        SpringApplication.run(Desk2dineApplication.class, args);

        System.out.println("======================================");
        System.out.println(" Desk2Dine Started Successfully");
        
        System.out.println("======================================");

    }

}