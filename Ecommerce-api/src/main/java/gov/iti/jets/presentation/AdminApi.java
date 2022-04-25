package gov.iti.jets.presentation;

import gov.iti.jets.services.dto.admin.AdminGetResponse;
import gov.iti.jets.services.dto.admin.AdminPostRequest;
import gov.iti.jets.services.dto.admin.AdminPutRequest;
import gov.iti.jets.services.service.admin.AdminService;
import gov.iti.jets.services.service.error.NotFoundException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("admins")
public class AdminApi {
    AdminService adminService;
    public AdminApi() {
        adminService = new AdminService();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response getAllAdmins() {
        List<AdminGetResponse> allAdmins = adminService.getAllAdmins();
        if(allAdmins.isEmpty()){
            throw new NotFoundException("There is no Admins");
        }
        return Response.ok().entity(allAdmins).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response getAdminById(@PathParam("id") int id) {
        AdminGetResponse admin = adminService.getAdmin( id );
        if(admin == null){
            throw new NotFoundException( "There is no admin with id = "+id );
        }
        return Response.ok().entity(admin).build();
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
        AdminGetResponse adminGetResponse = adminService.editAdmin( id, adminPutRequest );
        if(adminGetResponse == null){
            throw new NotFoundException( "Cannot edit admin with id = "+id );
        }
        return Response.ok().entity(adminGetResponse).build();
    }

    @DELETE
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response deleteAllAdmins() {
        String s = adminService.deleteAllAdmins();
        if(s == null){
            throw new NotFoundException( "There is no admin to be deleted");
        }
        return Response.ok().entity(s).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Response deleteAdminById(@PathParam("id") int id) {
        String s = adminService.deleteAdmin( id );
        if(s == null){
            throw new NotFoundException( "Admin with id = "+id+" not found to be deleted");
        }
        return Response.ok().entity(s).build();
    }

}
