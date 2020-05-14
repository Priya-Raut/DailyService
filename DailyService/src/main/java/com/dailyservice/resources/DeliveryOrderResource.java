package com.dailyservice.resources;

import com.dailyservice.dao.DeliveryOrderDao;
import com.dailyservice.dao.ItemDao;
import com.dailyservice.dto.DeliveryOrderDto;
import com.dailyservice.dto.ItemDto;
import com.dailyservice.storage.DatabaseConnectionManager;
import com.dailyservice.wrappers.ItemWrapper;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.sql.*;

/**
 * A resource for delivery order of items placed by a customer.
 *
 * @author Priya Raut
 * @version 1.0
 */
@Stateless
@Path("/delivery-order")
public class DeliveryOrderResource {

    /**
     * Create a delivery order based on given request parameters.
     *
     * @param customerId id of the customer who placed the order for delivery.
     * @param itemWrapper wrapper for the items to be purchased by the customer.
     * @return billAmount and status code.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create-order")
    public Response createOrder(@QueryParam("customerId") BigInteger customerId, ItemWrapper itemWrapper) {
        System.out.println("createOrder end point is called..");
        Connection connection = DatabaseConnectionManager.getConnection();
        DeliveryOrderDto deliveryOrderDto = createDeliveryOrderDto(connection, customerId, itemWrapper);
        System.out.println("deliveryOrderDto successful creation: " + deliveryOrderDto);

        DeliveryOrderDao deliveryOrderDao = new DeliveryOrderDao();
        deliveryOrderDao.insertIntoDeliveryOrder(connection, deliveryOrderDto);

        double billAmount = deliveryOrderDto.getBillAmount();
        System.out.println("Bill amount for the order is retrieved successfully!");
        if(billAmount != 0.0 ) return Response.status(Response.Status.OK).entity(billAmount).build();
        else return Response.noContent().build();
    }

    /**
     * Create instance of DeliveryOrderDto.
     *
     * @param connection Database connection object
     * @param customerId id of the customer placing an order
     * @param itemWrapper wrapper for items
     * @return instance of DeliveryOrderDto
     */
    public DeliveryOrderDto createDeliveryOrderDto(Connection connection, BigInteger customerId, ItemWrapper itemWrapper){
        System.out.println("Start creating delivery order..");
        ItemDao itemDao = new ItemDao();
        DeliveryOrderDto deliveryOrderDto = new DeliveryOrderDto();
        deliveryOrderDto.setCustomerId(customerId); //customerId
        BigInteger retrievedItemId = BigInteger.valueOf(0);
        for(ItemDto item : itemWrapper.getItems()) {
            System.out.println("item from the request: " + item);
            if(connection != null) {
                //set item id of each item from Item table
                retrievedItemId = itemDao.getItemIdFromItemName(connection, item.getItemName());
                System.out.println("retrievedItemId: " + retrievedItemId);
            }
            item.setItemId(retrievedItemId);
        }
        deliveryOrderDto.setItems(itemWrapper.getItems()); //items
        deliveryOrderDto.setBillAmount(deliveryOrderDto.getItems()); //billAmount
        deliveryOrderDto.setOrderDateTime(deliveryOrderDto.getOrderDateTime()); //orderDate
        System.out.println("Delivery order created successfully!");
        return deliveryOrderDto;
    }

}
