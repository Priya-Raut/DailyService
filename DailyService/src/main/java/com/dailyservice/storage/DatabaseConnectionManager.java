package com.dailyservice.storage;

import java.sql.*;

/**
 * DatabaseConnectionManager class to connect with database and test the connection.
 *
 * @author Priya Raut
 * @version 1.0
 */
public class DatabaseConnectionManager {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/dailyservice";
    private static final String USER = "root";
    private static final String PASSWORD = "MySQL215";
    private static final String TEST_QUERY = "Select * from Item";

    /**
     * Establish connection with database.
     *
     * @return Connection object if database connection is established, null otherwise.
     */
    public static Connection getConnection(){
        System.out.println("Connecting to database..");
        Connection connection = null;
        try{
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        }catch (SQLException | ClassNotFoundException throwable){
            throwable.printStackTrace();
        }
        System.out.println("Database connection is successful!");
        return connection;
    }

    /**
     * Test database connection by running a select query.
     */
    public static void testConnection(Connection connection){
        System.out.println("Executing a test query on database..");
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(TEST_QUERY);
            while(resultSet.next()){
                System.out.print("Item Name: " + resultSet.getString(2) + " Item Price: " + resultSet.getDouble(3));
                System.out.println();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Test query execution is successful!");
    }
}
