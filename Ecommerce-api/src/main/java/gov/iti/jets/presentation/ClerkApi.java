package gov.iti.jets.presentation;

import gov.iti.jets.persistence.entity.Clerk;
import gov.iti.jets.services.dto.admin.AdminGetResponse;
import gov.iti.jets.services.dto.clerk.ClerkGetResponse;
import gov.iti.jets.services.dto.clerk.ClerkPostRequest;
import gov.iti.jets.services.dto.clerk.ClerkPutRequest;
import gov.iti.jets.services.service.clerk.ClerkService;
import gov.iti.jets.services.service.error.NotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path( "clerks" )
public class ClerkApi {

    @Context
    UriInfo uriInfo;
    ClerkService clerkService;
    public ClerkApi() {
        clerkService = new ClerkService();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})

    public Response getAllClerks() {
        List<ClerkGetResponse> allClerks = clerkService.getAllClerks();
        if( allClerks.isEmpty()){
            throw new NotFoundException("There is no clerks");
        }
        GenericEntity<List<ClerkGetResponse>> entity = new GenericEntity<List<ClerkGetResponse>>(allClerks) {};
        return Response.ok().entity(entity).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response getClerkById(@PathParam("id") int id) {
        if(clerkService.getClerk(id) == null){
            throw new NotFoundException( "There is no clerk with id = "+id );
        }
        return Response.ok().entity(clerkService.getClerk(id)).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response postClerk( ClerkPostRequest clerkPostRequest) {
        return Response.created( uriInfo.getBaseUri() ).entity(clerkService.addClerk(clerkPostRequest)).build();
    }

    @PUT
    @Path( "{id}" )
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response putClerkById( @PathParam( "id" ) int id, ClerkPutRequest clerkPutRequest) {
        if(clerkService.editClerk( id,clerkPutRequest) == null){
            throw new NotFoundException( "Cannot edit clerk with id = "+id );
        }
        return Response.ok().entity(clerkService.editClerk( id,clerkPutRequest)).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML , MediaType.TEXT_PLAIN})
    public Response deleteAllClerks() {
        String s = clerkService.deleteAllClerks();
        if(s == null){
            throw new NotFoundException( "There is no clerk to be deleted");
        }
        return Response.ok().entity(s).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML , MediaType.TEXT_PLAIN})
    public Response deleteClerkById(@PathParam("id") int id) {
        clerkService.deleteClerk( id );
        if( clerkService.deleteClerk(id ) == null){
            throw new NotFoundException( "Clerk with id = "+id+" not found to be deleted");
        }
        return Response.ok().entity( clerkService.deleteClerk(id ) ).build();
    }

}
