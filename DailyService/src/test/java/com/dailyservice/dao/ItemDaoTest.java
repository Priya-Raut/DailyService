package com.dailyservice.dao;

import com.dailyservice.dto.ItemDto;
import com.dailyservice.storage.DatabaseConnectionManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.sql.Connection;

import static org.junit.Assert.*;

public class ItemDaoTest {
    Connection connection;

    @Before
    public void setUp() throws Exception {
        connection = DatabaseConnectionManager.getConnection();
    }

    @Test
    public void shouldGetItemIdFromItemName() {
        ItemDao dao = new ItemDao();
        String itemName = "Salt";
        BigInteger itemId = dao.getItemIdFromItemName(connection, itemName);
        Assert.assertTrue("An itemId does not exist in Item table for given item name.", itemId != BigInteger.valueOf(0));
    }

    @Test
    public void shouldNotGetItemIdFromItemName() {
        ItemDao dao = new ItemDao();
        String itemName = "Sugar";
        BigInteger itemId = dao.getItemIdFromItemName(connection, itemName);
        Assert.assertTrue(itemId == BigInteger.valueOf(0));
    }


    @After
    public void tearDown() throws Exception {
        connection.close();
    }
}