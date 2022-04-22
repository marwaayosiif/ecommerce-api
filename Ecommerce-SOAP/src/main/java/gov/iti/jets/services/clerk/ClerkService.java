package gov.iti.jets.services.clerk;

import gov.iti.jets.services.admin.dto.AdminGetResponse;
import gov.iti.jets.services.admin.dto.AdminPostRequest;
import gov.iti.jets.services.admin.dto.AdminPutRequest;
import gov.iti.jets.services.clerk.dto.ClerkGetResponse;
import gov.iti.jets.services.clerk.dto.ClerkPostRequest;
import gov.iti.jets.services.clerk.dto.ClerkPutRequest;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface ClerkService {
    @WebMethod
    public List<ClerkGetResponse> getAllClerk();
    @WebMethod
    public ClerkGetResponse getClerkById(int id);
    @WebMethod
    public String addClerk( ClerkPostRequest clerkPostRequest );
    @WebMethod
    public String deleteAllClerk();
    @WebMethod
    public String deleteClerkById(int id);
    @WebMethod
    public ClerkGetResponse editClerk ( int id , ClerkPutRequest clerkPutRequest );

}
