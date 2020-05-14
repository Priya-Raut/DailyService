package com.dailyservice.dao;

import com.dailyservice.storage.DatabaseConnectionManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * This test class tests ItemDao class.
 *
 * @author Priya Raut
 * @version 1.0
 */
public class ItemDaoTest {
    Connection connection;

    /**
     * Setup the database connection.
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        connection = DatabaseConnectionManager.getConnection();
    }

    /**
     * Test when item id can be retrieved successfully from item name.
     */
    @Test
    public void shouldGetItemIdFromItemName() {
        ItemDao dao = new ItemDao();
        String itemName = "Salt";
        BigInteger itemId = dao.getItemIdFromItemName(connection, itemName);
        Assert.assertTrue("An itemId does not exist in Item table for given item name.", itemId != BigInteger.valueOf(0));
    }

    /**
     * Test when item id CANNOT be retrieved successfully from item name.
     */
    @Test
    public void shouldNotGetItemIdFromItemName() {
        ItemDao dao = new ItemDao();
        String itemName = "Sugar";
        BigInteger itemId = dao.getItemIdFromItemName(connection, itemName);
        Assert.assertFalse("An itemId exists in Item table for given item name. It should not!",itemId != BigInteger.valueOf(0));
    }

    /**
     * Close the database connection.
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        connection.close();
    }
}