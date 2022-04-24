package gov.iti.jets.presentation;

import gov.iti.jets.services.dto.category.CategoryPostRequest;
import gov.iti.jets.services.dto.category.CategoryPutRequest;
import gov.iti.jets.services.service.category.CategoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path( "categories" )
public class CategoryApi {

     CategoryService categoryService = new CategoryService();
    @GET
    @Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public Response getAllCategory (){
        return Response.ok().entity( categoryService.getAllCategory() ).build();
    }

    @GET
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public Response getCategoryById ( @PathParam ( "id" ) int id){
        return Response.ok().entity( categoryService.getCategoryById(id) ).build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteAllCategory(){
        return Response.ok().entity( categoryService.deleteAllCategory() ).build();
    }

    @DELETE
    @Path( "{id}" )
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteCategoryById(@PathParam( "id" ) int id){
        return Response.ok().entity( categoryService.deleteCategoryById(id) ).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response addCategory( CategoryPostRequest categoryPostRequest , @Context UriInfo uriInfo ){
        return Response.created( uriInfo.getBaseUri() ).entity( categoryService.addCategory(categoryPostRequest) ).build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path( "{id}" )
    public Response editCategory( CategoryPutRequest categoryPutRequest , @PathParam( "id" ) int id ){
        return Response.ok().entity( categoryService.editCategory(categoryPutRequest , id) ).build();
    }
}
