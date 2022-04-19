package gov.iti.jets.services.admin;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("admins")
public class adminService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAdmins() {
        return Response.ok().entity("").build();
    }
}
