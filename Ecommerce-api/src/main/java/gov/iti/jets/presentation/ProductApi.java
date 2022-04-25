package gov.iti.jets.presentation;

import gov.iti.jets.services.dto.admin.AdminGetResponse;
import gov.iti.jets.services.dto.product.ProductGetResponse;
import gov.iti.jets.services.dto.product.ProductPostRequest;
import gov.iti.jets.services.dto.product.ProductPutRequest;
import gov.iti.jets.services.service.error.NotFoundException;
import gov.iti.jets.services.service.product.ProductService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.util.List;

@Path( "products" )
public class ProductApi {
    ProductService productService = new ProductService();

    @GET
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    public Response getAllProducts(){
        List<ProductGetResponse> allProducts = productService.getAllProducts();
        if(allProducts.isEmpty()){
            throw new NotFoundException("There is no products");
        }
        return Response.ok().entity( allProducts ).build();
    }

    @GET
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    public Response getProductById( @PathParam ( "id" ) int id){
        ProductGetResponse productById = productService.getProductById( id );
        if(productById == null){
            throw new NotFoundException( "There is no product with id = "+id );
        }
        return Response.ok().entity( productById ).build();
    }

    @DELETE
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN} )
    public Response deleteAllProducts(){
        String s = productService.deleteAllProducts();
        if(s == null){
            throw new NotFoundException( "There is no product to be deleted");
        }
        return Response.ok().entity( s).build();
    }

    @DELETE
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON} )
    public Response deleteProductById( @PathParam ( "id" ) int id){
        String s = productService.deleteProductById(id);
        if(s == null){
            throw new NotFoundException( "Product with id = "+id+" not found to be deleted");
        }
        return Response.ok().entity( s ).build();
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
        ProductGetResponse productGetResponse = productService.editProduct( id, productPutRequest );
        if(productGetResponse == null){
            throw new NotFoundException( "Cannot edit product with id = "+id );
        }
        return Response.ok().entity( productGetResponse ).build();
    }

}
