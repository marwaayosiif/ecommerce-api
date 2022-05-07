package gov.iti.jets.presentation;

import gov.iti.jets.services.dto.admin.AdminGetResponse;
import gov.iti.jets.services.dto.clerk.ClerkGetResponse;
import gov.iti.jets.services.dto.order.OrderGetResponse;
import gov.iti.jets.services.service.error.NotFoundException;
import gov.iti.jets.services.service.order.OrderService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path( "orders" )
public class OrderApi {
    OrderService orderService = new OrderService();

    @GET
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    public Response getAllOrders(){
        List<OrderGetResponse> allOrders = orderService.getAllOrders();
        if(allOrders.isEmpty()){
            throw new NotFoundException("There is no orders");
        }
        GenericEntity<List<OrderGetResponse>> entity = new GenericEntity<List<OrderGetResponse>>(allOrders) {};

        return Response.ok().entity( entity ).build();
    }

    @GET
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    public Response getOrderById( @PathParam ( "id" ) int id){
        OrderGetResponse orderById = orderService.getOrderById( id );
        if(orderById == null){
            throw new NotFoundException( "There is no order with id = "+id );
        }
        return Response.ok().entity( orderById ).build();
    }

    @DELETE
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN} )
    public Response deleteAllOrders(){
        String s = orderService.deleteAllOrders();
        if(s == null){
            throw new NotFoundException( "There is no order to be deleted");
        }
        return Response.ok().entity( s ).build();
    }

    @DELETE
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN} )
    public Response deleteOrderById( @PathParam ( "id" ) int id){
        String s = orderService.deleteOrderById(id);
        if(s == null){
            throw new NotFoundException( "Order with id = "+id+" not found to be deleted");
        }
        return Response.ok().entity( s ).build();
    }
}
