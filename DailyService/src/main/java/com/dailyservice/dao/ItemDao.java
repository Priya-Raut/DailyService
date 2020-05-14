package com.dailyservice.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDao {

    private static final String SELECT_ITEMID_FROM_ITEMNAME = "select ItemID from Item where ItemName=?";
    //TODO handle the case when item with given item name does not exist
    /**
     * Get itemId of an item using its name from the Item table
     *
     * @param connection instance for database connection.
     * @param itemName item name to be purchased by a customer
     * @return itemId of the item from database.
     */
    public BigInteger getItemIdFromItemName(Connection connection, String itemName){
        System.out.println("getItemIdFromItemName started..");
        PreparedStatement statement = null;
        BigInteger retrievedItemId = BigInteger.valueOf(0);
        try {
            statement = connection.prepareStatement(SELECT_ITEMID_FROM_ITEMNAME);
            statement.setString(1, itemName);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                retrievedItemId = resultSet.getBigDecimal("itemId").toBigInteger();
            }
            System.out.println("getItemIdFromItemName retrievedItemId: " + retrievedItemId);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        System.out.println("getItemIdFromItemName completed!");
        return retrievedItemId;
    }
}
