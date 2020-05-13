package com.dailyservice.resources;

import com.dailyservice.dto.ItemDto;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;

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
    public Response createOrder(@QueryParam("customerId")BigInteger customerId) {
        //Call database and
        //Response.status(Response.Status.OK).entity().build();
        return Response.status(Response.Status.OK).build();
    }
}
