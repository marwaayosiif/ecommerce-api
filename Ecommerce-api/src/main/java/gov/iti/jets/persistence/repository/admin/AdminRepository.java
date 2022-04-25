package gov.iti.jets.persistence.repository.admin;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.persistence.entity.Admin;
import gov.iti.jets.services.dto.admin.AdminPostRequest;
import gov.iti.jets.services.dto.admin.AdminPutRequest;
import jakarta.persistence.*;

public class AdminRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("api");
    EntityManager em;

    public List<Admin> getAllAdmins(){
        List<Admin> admins = new ArrayList<>();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Admin> aQuery = em.createQuery("select a from Admin a", Admin.class);
        admins = aQuery.getResultList();
        em.getTransaction().commit();
        em.close();
        return admins;
    }

    public String deleteAllAdmins(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Admin> aQuery = em.createQuery("select a from Admin a", Admin.class);
        List<Admin> admins = aQuery.getResultList();
        if(admins.isEmpty()){
            return null;
        }else {
            for ( Admin admin : admins ) {
                em.remove( admin );
            }
        }
        em.getTransaction().commit();
        em.close();
        return "All admin are delete";
    }


    public Admin getAdmin(int id){
        Admin admin = new Admin();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        admin = em.find(Admin.class, id);
        em.getTransaction().commit();
        em.close();
        return admin;
    }

    public String deleteAdmin(int id){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Admin admin = em.find(Admin.class, id);
        if(admin == null){
            return null;
        }
        em.remove( admin );
        em.getTransaction().commit();
        em.close();
        return "Admin with id : "+id+" deleted successfully";
    }

    public String addAdmin( AdminPostRequest adminPostRequest ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist( new Admin(adminPostRequest.getName()) );
        em.getTransaction().commit();
        em.close();

        return "Admin Added Successfully";
    }

    public Admin editAdmin( int id, AdminPutRequest adminPutRequest ) {
        Admin merge = new Admin();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Admin admin = em.find( Admin.class, id );
        if(admin == null){
            return null;
        }
        admin.setName( adminPutRequest.getName() );
        merge = em.merge( admin );
        em.getTransaction().commit();
        em.close();
        return merge;
    }



}
