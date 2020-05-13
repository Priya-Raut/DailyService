package com.dailyservice.resources;

import com.dailyservice.dto.ItemDto;
import com.dailyservice.storage.DatabaseConnectionManager;
import com.dailyservice.wrappers.ItemWrapper;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

/**
 *
 * @author Priya Raut
 * @version 1.0
 */
@Stateless
@Path("/delivery-order")
public class DeliveryOrderResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create-order")
    public Response createOrder(@QueryParam("customerId") BigInteger customerId, ItemWrapper itemWrapper) {
        System.out.println("createOrder end point is called..");
        System.out.println("custmerId: " + customerId);
        Connection connection = DatabaseConnectionManager.getConnection();
        for(ItemDto item : itemWrapper.getItems()) {
            System.out.println("item from the request: " + item);
//            if(connection != null) {
//               BigDecimal retrievedItemId = getItemIdFromItemName(connection, item.getItemName());
//            }
        }
        // TODO Send the list to getbillAmount() method, calculate billAmount

        //return billAmount
        // TODO its a summation of billAmounts of all entries with same customerId and same datetime
        //Response.status(Response.Status.OK).entity().build();

        return Response.status(Response.Status.OK).build();
    }

    public BigDecimal getItemIdFromItemName(Connection connection, String itemName){
        final String SELECT_ITEMID_FROM_ITEMNAME = "Select ItemID from Item where itemName=";
        Statement statement = null;
        BigDecimal retrievedItemId = new BigDecimal(BigInteger.ZERO);
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ITEMID_FROM_ITEMNAME + itemName);
            retrievedItemId = resultSet.getBigDecimal("itemId");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return retrievedItemId;
    }

    public void insertIntoDeliveryOrder(Connection connection, BigInteger customerId, BigInteger itemId, Double BillAmount){
        final String INSERT_INTO_DELIVERY_ORDER = "INSERT INTO DeliveryOrder (ItemID, CustomerID, BillAmount, OrderDate) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(INSERT_INTO_DELIVERY_ORDER);
            //TODO figure out difference between BigInteger and BigDecimal
//            statement.setBigDecimal(1, itemId);
//            statement.setBigDecimal(2, customerId);
            statement.setDouble(3, BillAmount);
            //TODO set current datetime in DATETIME field
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
