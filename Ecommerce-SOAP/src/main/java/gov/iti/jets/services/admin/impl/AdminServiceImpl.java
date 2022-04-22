package gov.iti.jets.services.admin.impl;

import gov.iti.jets.persistence.entity.Admin;
import gov.iti.jets.persistence.repository.admin.AdminRepository;
import gov.iti.jets.services.admin.AdminService;
import gov.iti.jets.services.admin.dto.AdminGetResponse;
import gov.iti.jets.services.admin.dto.AdminPostRequest;
import gov.iti.jets.services.admin.dto.AdminPutRequest;
import jakarta.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "gov.iti.jets.services.admin.AdminService")
public class AdminServiceImpl implements AdminService  {
    AdminRepository adminRepository = new AdminRepository();
    @Override
    public List<AdminGetResponse> getAllAdmin() {
        List<Admin> allAdmins = adminRepository.getAllAdmins();
        List<AdminGetResponse> admins = new ArrayList<>();
        for ( Admin admin: allAdmins ) {
            admins.add( mapperFromAdminToAdminGetResponse( admin ) );
        }
        return admins;
    }

    @Override
    public AdminGetResponse getAdminById( int id ) {
        Admin admin = adminRepository.getAdmin( id );
        return mapperFromAdminToAdminGetResponse( admin );
    }

    @Override
    public String addAdmin( AdminPostRequest adminPostRequest ) {
        return adminRepository.addAdmin( adminPostRequest );
    }

    @Override
    public String deleteAllAdmin() {
        return adminRepository.deleteAllAdmins();
    }

    @Override
    public String deleteAdminById( int id ) {
        return adminRepository.deleteAdmin( id );
    }

    @Override
    public AdminGetResponse editAdmin( int id , AdminPutRequest adminPutRequest ) {
        Admin admin = adminRepository.editAdmin( id, adminPutRequest );
        return mapperFromAdminToAdminGetResponse( admin );
    }

    private AdminGetResponse mapperFromAdminToAdminGetResponse(Admin admin) {
        return new AdminGetResponse( admin.getId(), admin.getName());
    }
}
