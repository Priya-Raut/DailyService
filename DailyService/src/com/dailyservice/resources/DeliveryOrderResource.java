package com.dailyservice.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;

/**
 *
 * @author Priya Raut
 * @version 1.0
 */
@Path("/delivery-order")
public class DeliveryOrderResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create-order")
    public Response createOrder(@QueryParam("customerId")BigInteger customerId, @QueryParam("items") ) {
        //Call Database connection
        Response.status(Response.Status.OK).entity().build();
    }
}
