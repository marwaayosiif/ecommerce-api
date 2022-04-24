package gov.iti.jets.presentation;

import gov.iti.jets.services.service.order.OrderService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path( "orders" )
public class OrderApi {
    OrderService orderService = new OrderService();

    @GET
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    public Response getAllOrders(){
        return Response.ok().entity( orderService.getAllOrders() ).build();
    }

    @GET
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    public Response getOrderById( @PathParam ( "id" ) int id){
        return Response.ok().entity( orderService.getOrderById(id) ).build();
    }

    @DELETE
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN} )
    public Response deleteAllOrders(){
        return Response.ok().entity( orderService.deleteAllOrders() ).build();
    }

    @DELETE
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN} )
    public Response deleteOrderById( @PathParam ( "id" ) int id){
        return Response.ok().entity( orderService.deleteOrderById(id) ).build();
    }
}
