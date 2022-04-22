package gov.iti.jets.services.admin;

import gov.iti.jets.services.admin.dto.AdminGetResponse;
import gov.iti.jets.services.admin.dto.AdminPostRequest;
import gov.iti.jets.services.admin.dto.AdminPutRequest;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface AdminService {
    @WebMethod
    public List<AdminGetResponse> getAllAdmin();
    @WebMethod
    public AdminGetResponse getAdminById(int id);
    @WebMethod
    public String addAdmin( AdminPostRequest adminPostRequest );
    @WebMethod
    public String deleteAllAdmin();
    @WebMethod
    public String deleteAdminById(int id);
    @WebMethod
    public AdminGetResponse editAdmin ( int id , AdminPutRequest adminPutRequest );
}
