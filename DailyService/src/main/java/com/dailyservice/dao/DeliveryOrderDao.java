package com.dailyservice.dao;

import com.dailyservice.dto.DeliveryOrderDto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class contains all the queries on DeliveryOrder table.
 *
 * @author Priya Raut
 * @version 1.0
 */
public class DeliveryOrderDao {

    private static final String INSERT_QUERY = "INSERT INTO DeliveryOrder (CustomerID, Items, BillAmount, OrderDate) VALUES (?, ?, ?, ?)";

    /**
     * Insert delivery order into DeliveryOrder table.
     *
     * @param connection instance for database connection.
     * @param deliveryOrderDto an instance of DeliveryOrderDto.
     */
    public void insertIntoDeliveryOrder(Connection connection, DeliveryOrderDto deliveryOrderDto){
        System.out.println("insertIntoDeliveryOrder started..");
        try(PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setBigDecimal(1, new BigDecimal(deliveryOrderDto.getCustomerId()));
            statement.setString(2, deliveryOrderDto.getItems().toString());
            statement.setDouble(3, deliveryOrderDto.getBillAmount());
            statement.setTimestamp(4, deliveryOrderDto.getOrderDateTime());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("insertIntoDeliveryOrder completed!");
    }
}
