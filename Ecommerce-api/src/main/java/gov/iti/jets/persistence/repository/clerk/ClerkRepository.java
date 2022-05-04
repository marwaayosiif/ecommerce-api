package gov.iti.jets.persistence.repository.clerk;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.persistence.entity.Admin;
import gov.iti.jets.persistence.entity.Clerk;
import gov.iti.jets.services.dto.clerk.ClerkPostRequest;
import gov.iti.jets.services.dto.clerk.ClerkPutRequest;
import jakarta.persistence.*;

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
        if(clerk == null){
            return null;
        }
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
        if(clerks.isEmpty()){
            return null;
        }else {
            for ( Clerk clerk : clerks ) {
                em.remove( clerk );
            }
        }
        em.getTransaction().commit();
        em.close();
        return "All Clerks are delete";
    }

    public String deleteClerk( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Clerk clerk = em.find(Clerk.class, id);
        System.out.println("before if");
        if(clerk == null){
            System.out.println("in if");
            return null;
        }
        System.out.println("After if");
        em.remove( clerk );
        em.getTransaction().commit();
        em.close();
        return "Clerk with id : "+id+" deleted successfully";
    }
}
