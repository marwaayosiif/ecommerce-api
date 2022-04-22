package gov.iti.jets.services.service.admin;

import gov.iti.jets.persistence.entity.Admin;
import gov.iti.jets.persistence.repository.admin.AdminRepository;
import gov.iti.jets.services.dto.admin.AdminGetResponse;
import gov.iti.jets.services.dto.admin.AdminPostRequest;
import gov.iti.jets.services.dto.admin.AdminPutRequest;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    AdminRepository adminRepository = new AdminRepository();
    public List<AdminGetResponse> getAllAdmins(){
        List<Admin> allAdmins = adminRepository.getAllAdmins();
        List<AdminGetResponse> admins = new ArrayList<>();
        for ( Admin admin: allAdmins ) {
            admins.add( mapperFromAdminToAdminGetResponse( admin ) );
        }
        return admins;
    }

    public AdminGetResponse getAdmin( int id ) {
        Admin admin = adminRepository.getAdmin( id );
        return mapperFromAdminToAdminGetResponse( admin );
    }

    public String addAdmin( AdminPostRequest adminPostRequest ) {
        return adminRepository.addAdmin( adminPostRequest );
    }

    public AdminGetResponse editAdmin( int id, AdminPutRequest adminPutRequest ) {
        Admin admin = adminRepository.editAdmin( id, adminPutRequest );
        return mapperFromAdminToAdminGetResponse( admin );
    }

    public String deleteAllAdmins() {
        return adminRepository.deleteAllAdmins();
    }

    public String deleteAdmin( int id ) {
        return adminRepository.deleteAdmin( id );
    }

    private AdminGetResponse mapperFromAdminToAdminGetResponse(Admin admin) {
        return new AdminGetResponse( admin.getId(), admin.getName());
    }

}

