package gov.iti.jets.presentation;

import gov.iti.jets.services.dto.clerk.ClerkPostRequest;
import gov.iti.jets.services.dto.clerk.ClerkPutRequest;
import gov.iti.jets.services.service.clerk.ClerkService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path( "clerks" )
public class ClerkApi {

    ClerkService clerkService;
    public ClerkApi() {
        clerkService = new ClerkService();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response getAllClerks() {
        return Response.ok().entity(clerkService.getAllClerks()).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response getClerkById(@PathParam("id") int id) {
        return Response.ok().entity(clerkService.getClerk(id)).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response postClerk( ClerkPostRequest clerkPostRequest) {
        return Response.ok().entity(clerkService.addClerk(clerkPostRequest)).build();
    }

    @PUT
    @Path( "{id}" )
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response putClerkById( @PathParam( "id" ) int id, ClerkPutRequest clerkPutRequest) {
        return Response.ok().entity(clerkService.editClerk( id,clerkPutRequest)).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response deleteAllClerks() {
        return Response.ok().entity(clerkService.deleteAllClerks()).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response deleteClerkById(@PathParam("id") int id) {
        return Response.ok().entity(clerkService.deleteClerk(id )).build();
    }

}
