package gov.iti.jets.repository.admin;

import java.util.List;

import gov.iti.jets.dto.admin.AdminGetResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class adminRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful");
    EntityManager em;
    public adminRepository() {
    }

    public List<AdminGetResponse> getAdmin(){
        em = emf.createEntityManager();
        em.getTransaction().begin();

        em.getTransaction().commit();
        em.close();
        return null;
    }
    
}
