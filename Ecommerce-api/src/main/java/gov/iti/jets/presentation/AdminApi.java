package gov.iti.jets.presentation;

import gov.iti.jets.persistence.repository.admin.AdminRepository;
import gov.iti.jets.services.dto.admin.AdminPostRequest;
import gov.iti.jets.services.dto.admin.AdminPutRequest;
import gov.iti.jets.services.service.admin.AdminService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("admins")
public class AdminApi {
    AdminService adminService;
    public AdminApi() {
        adminService = new AdminService();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response getAllAdmins() {
        return Response.ok().entity(adminService.getAllAdmins()).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response getAdminById(@PathParam("id") int id) {
        return Response.ok().entity(adminService.getAdmin(id)).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response postAdmin( AdminPostRequest adminPostRequest) {
        return Response.ok().entity(adminService.addAdmin(adminPostRequest)).build();
    }

    @PUT
    @Path( "{id}" )
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response putAdminById( @PathParam( "id" ) int id, AdminPutRequest adminPutRequest) {
        return Response.ok().entity(adminService.editAdmin( id,adminPutRequest)).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response deleteAllAdmins() {
        return Response.ok().entity(adminService.deleteAllAdmins()).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response deleteAdminById(@PathParam("id") int id) {
        return Response.ok().entity(adminService.deleteAdmin(id )).build();
    }

}
