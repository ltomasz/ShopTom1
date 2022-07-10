package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnector {
   // private static Logger LOGGER = Logger.getLogger(DatabaseConnector.class.getName());
    private DatabaseConnector() {
    }
    public static Connection getDBConnection() {
        Connection dbConnection =null;
        try {
            Class.forName(PostgresqlProperties.DB_DRIVER.getValue());
        } catch (ClassNotFoundException e) {
         //   LOGGER.log(Level.WARNING, "Driver not found. " + e.getMessage(), e);
            System.out.println( "Driver not found. " + e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(PostgresqlProperties.DB_CONNECTION.getValue(), PostgresqlProperties.DB_USER.getValue(),
                    PostgresqlProperties.DB_PASSWORD.getValue());
        } catch (SQLException e) {
         //   LOGGER.log(Level.WARNING, "Can't make connection with database. " + e.getMessage(), e);
            System.out.println(/*Level.WARNING,*/ "Can't make connection with database. " + e.getMessage()/*, e*/);
        }
        return dbConnection;
    }
}