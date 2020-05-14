package com.dailyservice.storage;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * This class tests database connection.
 *
 * @author Priya Raut
 * @version 1.0
 */
public class DatabaseConnectionTest {

    /**
     * Test to confirm if database connection is established or not.
     */
    @Test
    public void shouldConnectToDatabase(){
        Connection connection = DatabaseConnectionManager.getConnection();
        Assert.assertTrue("Connection to the database could not be established.", connection != null);
    }
}
