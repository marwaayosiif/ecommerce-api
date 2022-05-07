package gov.iti.jets.presentation;

import gov.iti.jets.services.dto.clerk.ClerkGetResponse;
import gov.iti.jets.services.dto.customer.CustomerGetResponse;
import gov.iti.jets.services.dto.customer.CustomerOrderGetResponse;
import gov.iti.jets.services.dto.customer.CustomerOrderPostRequest;
import gov.iti.jets.services.dto.customer.CustomerPostRequest;
import gov.iti.jets.services.service.customer.CustomerService;
import gov.iti.jets.services.service.error.NotFoundException;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Arrays;
import java.util.List;

@Path( "customers" )
public class CustomerApi {
    @Context UriInfo uriInfo;
    CustomerService customerService = new CustomerService();

    @GET
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getAllCustomers(@DefaultValue( "-1" ) @QueryParam( "s" )int start ,@DefaultValue( "-1" ) @QueryParam( "l" )int limit ){
        List<CustomerGetResponse> allCustomers;
        if(start == -1 && limit == -1) {
            allCustomers = customerService.getAllCustomers();
        }else {
            if(start == -1 || limit == -1){
                throw new NotFoundException("Query not correct");
            }
            allCustomers = customerService.getAllCustomers( start, limit );
        }
        if(allCustomers.isEmpty()){
            throw new NotFoundException("There is no customers");
        }
        Link self = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder() ).rel( "self" ).build();
        Link next = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder().path( "id" ) ).rel( "next" ).build();

        for ( CustomerGetResponse c :
                allCustomers   ) {
            c.setLinks( List.of( self.toString(),next.toString() ) );
        }
        GenericEntity<List<CustomerGetResponse>> entity = new GenericEntity<List<CustomerGetResponse>>(allCustomers) {};
        return Response.ok(entity).build();
    }

    @GET
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getCustomerById( @PathParam ( "id" )int id){
        CustomerGetResponse customerById = customerService.getCustomerById( id );
        if(customerById == null){
            throw new NotFoundException( "There is no customer with id = "+id );
        }
        Link self = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder() ).rel( "self" ).build();
        Link next = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder().path( "orders" ) ).rel( "next" ).build();
        customerById.setLinks( List.of(self.toString(),next.toString()) );
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
        Link self = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder() ).rel( "self" ).build();
        Link next = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder().path( "id" ) ).rel( "next" ).build();
        ordersOfCustomer.forEach( order ->{
            order.setLink( List.of(self.toString(),next.toString()) );
        } );
        GenericEntity<List<CustomerOrderGetResponse>> entity = new GenericEntity<List<CustomerOrderGetResponse>>(ordersOfCustomer) {};
        return Response.ok().entity( entity ).build();
    }

    @GET
    @Path( "{id}/orders/{oid}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
    public Response getOrderByIdOfCustomer( @PathParam ( "id" )int id , @PathParam( "oid" )int oid){
        CustomerOrderGetResponse orderByIdOfCustomer = customerService.getOrderByIdOfCustomer( id, oid );
        if(orderByIdOfCustomer == null){

            throw new NotFoundException( "There is no order with id = "+oid+" for customer with id = "+id );
        }
        Link self = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder() ).rel( "self" ).build();
        orderByIdOfCustomer.setLink( List.of(self.toString()) );
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
        Link self = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder() ).rel( "self" ).build();
        Link next = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder().path( "orders" ) ).rel( "next" ).build();
        customerGetResponse.setLinks( List.of(self.toString(),next.toString()) );
        return Response.ok().entity( customerGetResponse ).build();
    }


    @PATCH
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    @Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response editCustomerWithPatch(  String field,
                                           @PathParam( "id" )int id ){
        CustomerGetResponse customerGetResponse = customerService.editCustomerWithPatch( field, id );
        if(customerGetResponse == null){
            throw new NotFoundException( "Cannot edit customer with id = "+id );
        }
        Link self = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder() ).rel( "self" ).build();
        Link next = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder().path( "orders" ) ).rel( "next" ).build();
        customerGetResponse.setLinks( List.of(self.toString(),next.toString()) );
        return Response.ok().entity( customerGetResponse ).build();
    }


    @PUT
    @Path( "{id}/orders/{oid}" )
    @Produces( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    @Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN} )
    public Response editOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest,@PathParam( "id" )int id ,@PathParam("oid")int oid ){
        CustomerOrderGetResponse customerOrderGetResponse = customerService.editOrderToCustomer( customerOrderPostRequest, id, oid );
        System.out.println(customerOrderGetResponse == null);
        if(customerOrderGetResponse == null){
            System.out.println("IN IF");
            throw new NotFoundException( "Cannot edit order with id = "+oid+" for customer with id = "+id );
        }
        Link self = Link.fromUriBuilder( uriInfo.getAbsolutePathBuilder() ).rel( "self" ).build();
        System.out.println(self);
        System.out.println(customerOrderGetResponse);
        customerOrderGetResponse.setLink( List.of(self.toString()) );
        return Response.ok().entity( customerOrderGetResponse ).build();
    }
}
