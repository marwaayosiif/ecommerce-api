package gov.iti.jets.persistence.repository.clerk;

import gov.iti.jets.persistence.entity.Clerk;
import gov.iti.jets.services.clerk.dto.ClerkPostRequest;
import gov.iti.jets.services.clerk.dto.ClerkPutRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class ClerkRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("api");
    EntityManager em;

    public List<Clerk> getAllClerks() {
        List<Clerk> clerks = new ArrayList<>();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Clerk> aQuery = em.createQuery( "select c from Clerk c", Clerk.class );
        clerks = aQuery.getResultList();
        em.getTransaction().commit();
        em.close();
        return clerks;
    }

    public Clerk getClerk( int id ) {
        Clerk clerk = new Clerk();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        clerk = em.find(Clerk.class, id);
        em.getTransaction().commit();
        em.close();
        return clerk;
    }

    public String addClerk( ClerkPostRequest clerkPostRequest ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist( new Clerk(clerkPostRequest.getName()) );
        em.getTransaction().commit();
        em.close();

        return "Clerk Added Successfully";
    }

    public Clerk editClerk( int id, ClerkPutRequest clerkPutRequest ) {
        Clerk merge = new Clerk();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Clerk clerk = em.find( Clerk.class, id );
        clerk.setName( clerkPutRequest.getName() );
        merge = em.merge( clerk );
        em.getTransaction().commit();
        em.close();
        return merge;
    }

    public String deleteAllClerks() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Clerk> aQuery = em.createQuery("select c from Clerk c", Clerk.class);
        List<Clerk> clerks = aQuery.getResultList();
        for (Clerk clerk : clerks) {
            em.remove( clerk );
        }
        em.getTransaction().commit();
        em.close();
        return "All Clerks are delete";
    }

    public String deleteClerk( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Clerk clerk = em.find(Clerk.class, id);
        em.remove( clerk );
        em.getTransaction().commit();
        em.close();
        return "Clerk with id : "+id+" deleted successfully";
    }
}
