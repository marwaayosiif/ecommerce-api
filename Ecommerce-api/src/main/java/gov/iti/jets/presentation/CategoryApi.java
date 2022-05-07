package gov.iti.jets.presentation;

import gov.iti.jets.services.dto.admin.AdminGetResponse;
import gov.iti.jets.services.dto.category.CategoryGetResponse;
import gov.iti.jets.services.dto.category.CategoryPostRequest;
import gov.iti.jets.services.dto.category.CategoryPutRequest;
import gov.iti.jets.services.dto.clerk.ClerkGetResponse;
import gov.iti.jets.services.service.category.CategoryService;
import gov.iti.jets.services.service.error.NotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path( "categories" )
public class CategoryApi {

     CategoryService categoryService = new CategoryService();
    @GET
    @Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public Response getAllCategory (){
        List<CategoryGetResponse> allCategory = categoryService.getAllCategory();
        if(allCategory.isEmpty()){
            throw new NotFoundException("There is no categories");
        }
        GenericEntity<List<CategoryGetResponse>> entity = new GenericEntity<List<CategoryGetResponse>>(allCategory) {};

        return Response.ok().entity( entity ).build();
    }

    @GET
    @Path( "{id}" )
    @Produces( {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public Response getCategoryById ( @PathParam ( "id" ) int id){
        CategoryGetResponse categoryById = categoryService.getCategoryById( id );
        if(categoryById == null){
            throw new NotFoundException( "There is no category with id = "+id );
        }
        return Response.ok().entity( categoryById ).build();
    }

    @DELETE
    @Produces({MediaType.TEXT_PLAIN ,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response deleteAllCategory(){
        String s = categoryService.deleteAllCategory();
        if(s == null){
            throw new NotFoundException( "There is no category to be deleted");
        }
        return Response.ok().entity( s ).build();
    }

    @DELETE
    @Path( "{id}" )
    @Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response deleteCategoryById(@PathParam( "id" ) int id){
        String s =categoryService.deleteCategoryById(id);
        if(s == null){
            throw new NotFoundException( "Category with id = "+id+" not found to be deleted");
        }
        return Response.ok().entity( s ).build();
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
        System.out.println(categoryPutRequest);
        CategoryGetResponse categoryGetResponse = categoryService.editCategory( categoryPutRequest, id );
        if(categoryGetResponse == null){
            throw new NotFoundException( "Cannot edit category with id = "+id );
        }
        return Response.ok().entity( categoryGetResponse ).build();
    }
}
