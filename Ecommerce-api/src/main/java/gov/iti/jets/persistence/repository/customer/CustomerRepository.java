package gov.iti.jets.persistence.repository.customer;

import gov.iti.jets.persistence.entity.Customer;
import gov.iti.jets.persistence.entity.Order;
import gov.iti.jets.persistence.entity.Product;
import gov.iti.jets.services.dto.customer.CustomerOrderGetResponse;
import gov.iti.jets.services.dto.customer.CustomerOrderPostRequest;
import gov.iti.jets.services.dto.customer.CustomerPostRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "api" );
    EntityManager em;

    public List<Customer> getAllCustomers() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Customer> customerQ = em.createQuery( "from Customer c", Customer.class );
        List<Customer> customers = customerQ.getResultList();
        em.getTransaction().commit();
        em.close();
        return customers;
    }

    public Customer getCustomerById( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer = em.find( Customer.class, id );
        em.getTransaction().commit();
        em.close();
        return customer;
    }

    public List<Order> getOrdersOfCustomer( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer = em.find( Customer.class, id );
        if(customer ==  null){
            return new ArrayList<>();
        }
        em.getTransaction().commit();
        em.close();
        return customer.getOrders().stream().collect( Collectors.toList() );
    }

    public Order getOrderByIdOfCustomer( int id, int oid ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer = em.find( Customer.class, id );
        if(customer == null){
            return null;
        }
        em.getTransaction().commit();
        em.close();
        return customer.getOrders().stream().filter( order -> {
            return order.getId() == oid;
        } ).findFirst().get();
    }

    public String deleteAllCustomers() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Customer> customerQ = em.createQuery( "from Customer c", Customer.class );
        if(customerQ.getResultList().isEmpty()){
            return null;
        }
        for ( Customer customer : customerQ.getResultList() ) {
            em.remove( customer );
        }

        em.getTransaction().commit();
        em.close();
        return "All customers were deleted successfully";
    }

    public String deleteCustomerById( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer = em.find( Customer.class, id );
        if(customer == null){
            return null;
        }
        em.remove( customer );
        em.getTransaction().commit();
        em.close();
        return "Customer with id " + id + " was deleted successfully";
    }

    public String addCustomer( CustomerPostRequest customerPostRequest ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist( new Customer( customerPostRequest.getName(), customerPostRequest.getEmail(), customerPostRequest.getPhone(), null ) );
        em.getTransaction().commit();
        em.close();
        return "Customer added successfully";
    }

    public String addOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest, int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Set<Product> products = new HashSet<>();
        Customer customer = em.find( Customer.class, id );
        if(customer == null){
            return null;
        }
        for ( Integer productId :
                customerOrderPostRequest.getProductsId() ) {
            products.add( em.find( Product.class, productId ) );
        }
        em.persist( new Order( customer, customerOrderPostRequest.getTotalPrice(), products ) );
        em.getTransaction().commit();
        em.close();
        return "Order was added to customer with id " + id + " successfully";
    }

    public Customer editCustomer( CustomerPostRequest customerPostRequest, int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer = em.find( Customer.class, id );
        if(customer == null){
            return null;
        }
        customer.setName( customerPostRequest.getName() );
        customer.setEmail( customerPostRequest.getEmail() );
        customer.setPhone( customerPostRequest.getPhone() );
        customer = em.merge( customer );
        em.getTransaction().commit();
        em.close();
        return customer;
    }

    public Order editOrderToCustomer( CustomerOrderPostRequest customerOrderPostRequest, int id, int oid ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer = em.find( Customer.class, id );
        if(customer == null){
            return null;
        }
        Optional<Order> first = customer.getOrders().stream().filter( o -> {
            return o.getId() == oid;
        } ).findFirst();
        if(!first.isPresent()){
            return null;
        }
        Order order = first.get();
        order.setTotalPrice( customerOrderPostRequest.getTotalPrice() );
        Set<Product> products = new HashSet<>();
        customerOrderPostRequest.getProductsId().forEach( productId -> {
            products.add( em.find( Product.class, productId ) );
        } );
        order.setProducts( products );
        order = em.merge( order );
        em.getTransaction().commit();
        em.close();
        return order;
    }
}
