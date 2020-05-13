package com.dailyservice.resources;

import com.dailyservice.dto.DeliveryOrderDto;
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
import java.time.LocalDateTime;

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
        Connection connection = DatabaseConnectionManager.getConnection();
        DeliveryOrderDto deliveryOrderDto = createDeliveryOrderDto(connection, customerId, itemWrapper);
        System.out.println("deliveryOrderDto successful creation: " + deliveryOrderDto);
        insertIntoDeliveryOrder(connection, deliveryOrderDto);
        double billAmount = 123; //getTotalPaybleAmount(deliveryOrderDto);
        return Response.status(Response.Status.OK).entity(billAmount).build();
    }

    public DeliveryOrderDto createDeliveryOrderDto(Connection connection, BigInteger customerId, ItemWrapper itemWrapper){
        System.out.println("Start creating delivery order..");

        DeliveryOrderDto deliveryOrderDto = new DeliveryOrderDto();
        deliveryOrderDto.setCustomerId(customerId); //customerId
        BigInteger retrievedItemId = BigInteger.valueOf(0);
        for(ItemDto item : itemWrapper.getItems()) {
            System.out.println("item from the request: " + item);
            if(connection != null) {
                retrievedItemId = getItemIdFromItemName(connection, item.getItemName());
                System.out.println("retrievedItemId: " + retrievedItemId);
            }
            item.setItemId(retrievedItemId);
        }
        deliveryOrderDto.setItems(itemWrapper.getItems()); //items
        Timestamp orderDateTime = deliveryOrderDto.getOrderDateTime(); //orderDate
        deliveryOrderDto.setOrderDateTime(orderDateTime);
        System.out.println("Delivery order created successfully..");
        return deliveryOrderDto;
    }

    // TODO its a summation of billAmounts of all entries with same customerId and same datetime
    public double getTotalPaybleAmount(DeliveryOrderDto deliveryOrderDto){
        return 123;
    }

    //TODO handle the case when item with given item name does not exist
    public BigInteger getItemIdFromItemName(Connection connection, String itemName){
        System.out.println("getItemIdFromItemName started..");
        final String SELECT_ITEMID_FROM_ITEMNAME = "select ItemID from Item where ItemName=?";
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
        System.out.println("getItemIdFromItemName completed..");
        return retrievedItemId;
    }

    public void insertIntoDeliveryOrder(Connection connection, DeliveryOrderDto deliveryOrderDto){
        System.out.println("insertIntoDeliveryOrder started..");
        final String INSERT_INTO_DELIVERY_ORDER = "INSERT INTO DeliveryOrder (ItemID, CustomerID, BillAmount, OrderDate) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            for(ItemDto item : deliveryOrderDto.getItems()){
                statement = connection.prepareStatement(INSERT_INTO_DELIVERY_ORDER);
                statement.setBigDecimal(1, new BigDecimal(item.getItemId()));
                statement.setBigDecimal(2, new BigDecimal(deliveryOrderDto.getCustomerId()));
                statement.setDouble(3, deliveryOrderDto.getBillAmount(item));
                statement.setTimestamp(4, deliveryOrderDto.getOrderDateTime());
                statement.executeUpdate();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        System.out.println("insertIntoDeliveryOrder completed..");
    }
}
