package gov.iti.jets.presentation;

import gov.iti.jets.services.dto.customer.CustomerOrderPostRequest;
import gov.iti.jets.services.dto.customer.CustomerPostRequest;
import gov.iti.jets.services.service.customer.CustomerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path( "customers" )
public class CustomerApi {
    @Context UriInfo uriInfo;
    CustomerService customerService = new CustomerService();

    @GET
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getAllCustomers(){
        return Response.ok().entity( customerService.getAllCustomers() ).build();
    }

    @GET
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getCustomerById( @PathParam ( "id" )int id){
        return Response.ok().entity( customerService.getCustomerById(id) ).build();
    }

    @GET
    @Path( "{id}/orders" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getOrdersOfCustomer( @PathParam ( "id" )int id){
        return Response.ok().entity( customerService.getOrdersOfCustomer(id) ).build();
    }

    @GET
    @Path( "{id}/orders/{oid}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getOrderByIdOfCustomer( @PathParam ( "id" )int id , @PathParam( "oid" )int oid){
        return Response.ok().entity( customerService.getOrderByIdOfCustomer(id , oid) ).build();
    }

    @DELETE
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response deleteAllCustomers(){
        return Response.ok().entity( customerService.deleteAllCustomers() ).build();
    }

    @DELETE
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response deleteCustomerById( @PathParam ( "id" )int id){
        return Response.ok().entity( customerService.deleteCustomerById(id) ).build();
    }

    @POST
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    @Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response addCustomer( CustomerPostRequest customerPostRequest ){
        return Response.created( uriInfo.getBaseUri() ).entity( customerService.addCustomer(customerPostRequest) ).build();
    }

    @POST
    @Path( "{id}/orders" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    @Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response addOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest,@PathParam( "id" )int id ){
        return Response.created( uriInfo.getBaseUri() ).entity( customerService.addOrderToCustomer(customerOrderPostRequest , id) ).build();
    }

    @PUT
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    @Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response editCustomer( CustomerPostRequest customerPostRequest,@PathParam( "id" )int id ){
        return Response.ok().entity( customerService.editCustomer(customerPostRequest , id) ).build();
    }

    @PUT
    @Path( "{id}/orders/{oid}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    @Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response editOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest,@PathParam( "id" )int id ,@PathParam("oid")int oid ){
        return Response.ok().entity( customerService.editOrderToCustomer(customerOrderPostRequest , id , oid) ).build();
    }
}
