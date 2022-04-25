package gov.iti.jets.presentation;

import gov.iti.jets.services.dto.admin.AdminGetResponse;
import gov.iti.jets.services.dto.customer.CustomerGetResponse;
import gov.iti.jets.services.dto.customer.CustomerOrderGetResponse;
import gov.iti.jets.services.dto.customer.CustomerOrderPostRequest;
import gov.iti.jets.services.dto.customer.CustomerPostRequest;
import gov.iti.jets.services.service.customer.CustomerService;
import gov.iti.jets.services.service.error.NotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;

@Path( "customers" )
public class CustomerApi {
    @Context UriInfo uriInfo;
    CustomerService customerService = new CustomerService();

    @GET
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getAllCustomers(){
        List<CustomerGetResponse> allCustomers = customerService.getAllCustomers();
        if(allCustomers.isEmpty()){
            throw new NotFoundException("There is no customers");
        }
        return Response.ok().entity( allCustomers ).build();
    }

    @GET
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getCustomerById( @PathParam ( "id" )int id){
        CustomerGetResponse customerById = customerService.getCustomerById( id );
        if(customerById == null){
            throw new NotFoundException( "There is no customer with id = "+id );
        }
        return Response.ok().entity( customerById ).build();
    }

    @GET
    @Path( "{id}/orders" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getOrdersOfCustomer( @PathParam ( "id" )int id){
        List<CustomerOrderGetResponse> ordersOfCustomer = customerService.getOrdersOfCustomer( id );
        if(ordersOfCustomer.isEmpty()){
            throw new NotFoundException("There is no orders for customer with id  = "+id);
        }
        return Response.ok().entity( ordersOfCustomer ).build();
    }

    @GET
    @Path( "{id}/orders/{oid}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getOrderByIdOfCustomer( @PathParam ( "id" )int id , @PathParam( "oid" )int oid){
        Object orderByIdOfCustomer = customerService.getOrderByIdOfCustomer( id, oid );
        if(orderByIdOfCustomer == null){

            throw new NotFoundException( "There is no order with id = "+oid+" for customer with id = "+id );
        }
        return Response.ok().entity( orderByIdOfCustomer ).build();
    }

    @DELETE
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response deleteAllCustomers(){
        String s = customerService.deleteAllCustomers();
        if(s == null){
            throw new NotFoundException( "There is no customer to be deleted");
        }
        return Response.ok().entity( s ).build();
    }

    @DELETE
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response deleteCustomerById( @PathParam ( "id" )int id){
        String s = customerService.deleteCustomerById(id);
        if(s == null){
            throw new NotFoundException( "Customer with id = "+id+" not found to be deleted");
        }
        return Response.ok().entity( s ).build();
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
        CustomerGetResponse customerGetResponse = customerService.editCustomer( customerPostRequest, id );
        if(customerGetResponse == null){
            throw new NotFoundException( "Cannot edit customer with id = "+id );
        }
        return Response.ok().entity( customerGetResponse ).build();
    }

    //TODO doest print
    @PUT
    @Path( "{id}/orders/{oid}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    @Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response editOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest,@PathParam( "id" )int id ,@PathParam("oid")int oid ){
        CustomerOrderGetResponse customerOrderGetResponse = customerService.editOrderToCustomer( customerOrderPostRequest, id, oid );
        if(customerOrderPostRequest == null){
            throw new NotFoundException( "Cannot edit order with id = "+oid+" for customer with id = "+id );
        }
        return Response.ok().entity( customerOrderGetResponse ).build();
    }
}
