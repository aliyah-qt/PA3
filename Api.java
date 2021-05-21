package com.example.Project3;

import com.example.Project3.PurchaseOrderFormInfo;
import com.example.Project3.OrderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.util.List;

@Path("/order")
public class Api {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderByLatestId(@PathParam("id") int id) {

        PurchaseOrderFormInfo order = OrderService.getOrderByLatestId(id);

        boolean idFound = true;

        if(idFound) {
            return Response.ok(order, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getAllOrders() {
        List<PurchaseOrderFormInfo> orderList = OrderService.getAllOrders();

        if(orderList == null || orderList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build(); // i added this in, was originally blank
        }

        return Response.ok(orderList).build();
    }


    //This method represents a DELETE request where the id is provided as a path parameter and the request body is provided in JSON
    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
    public Response deleteOrder(@PathParam("id") int id) {

        //Retrieve the todo_object that you want to delete.
        PurchaseOrderFormInfo retrievedOrder = OrderService.getOrderByLatestId(id);

        if(retrievedOrder == null) {
            //If not found throw a 404
            return Response.status(Response.Status.NOT_FOUND).
                    entity("We could not find the requested resource").build();
        }

        // This calls the JDBC method which in turn calls the DELETE SQL command.
        if(OrderService.deleteOrder(retrievedOrder)) {
            return Response.ok().entity("Order Deleted Successfully").build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();


    }

}
