package gov.iti.jets.persistence.repository.order;

import gov.iti.jets.persistence.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class OrderRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "api" );
    EntityManager em;

    public List<Order> getAllOrders() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Order> orders = em.createQuery( "from Order o", Order.class );
        List<Order> orderList = orders.getResultList();
        em.getTransaction().commit();
        em.close();
        return orderList;
    }

    public Order getOrderById( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Order order = em.find( Order.class, id );
        em.getTransaction().commit();
        em.close();
        return order;
    }

    public String deleteAllOrders() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Order> orders = em.createQuery( "from Order o", Order.class );
        for ( Order order :
                orders.getResultList() ) {
            em.remove( order );
        }
        em.getTransaction().commit();
        em.close();
        return "All orders were delete successfully";
    }

    public String deleteOrderById( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Order order = em.find( Order.class, id );
        em.remove( order );
        em.getTransaction().commit();
        em.close();
        return "Order with "+ id+" was delete successfully";
    }
}
