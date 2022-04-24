package gov.iti.jets.presentation;

import gov.iti.jets.services.dto.product.ProductPostRequest;
import gov.iti.jets.services.dto.product.ProductPutRequest;
import gov.iti.jets.services.service.product.ProductService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path( "products" )
public class ProductApi {
    ProductService productService = new ProductService();

    @GET
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    public Response getAllProducts(){
        return Response.ok().entity( productService.getAllProducts() ).build();
    }

    @GET
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    public Response getProductById( @PathParam ( "id" ) int id){
        return Response.ok().entity( productService.getProductById(id) ).build();
    }

    @DELETE
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN} )
    public Response deleteAllProducts(){
        return Response.ok().entity( productService.deleteAllProducts() ).build();
    }

    @DELETE
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    public Response deleteProductById( @PathParam ( "id" ) int id){
        return Response.ok().entity( productService.deleteProductById(id) ).build();
    }

    @POST
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response addProduct( ProductPostRequest productPosyRequest , @Context UriInfo uriInfo ){
        return Response.created( uriInfo.getBaseUri() ).entity( productService.addProduct(productPosyRequest) ).build();
    }

    @PUT
    @Path( "{id}" )
    public Response editProduct( @PathParam( "id" )int id, ProductPutRequest productPutRequest){
        return Response.ok().entity( productService.editProduct(id ,productPutRequest) ).build();
    }

}
