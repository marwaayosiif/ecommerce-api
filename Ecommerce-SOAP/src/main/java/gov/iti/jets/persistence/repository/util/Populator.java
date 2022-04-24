package gov.iti.jets.persistence.repository.util;

import gov.iti.jets.persistence.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Arrays;
import java.util.HashSet;

public class Populator {
    public static void main( String[] args ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "api" );
        EntityManager em = emf.createEntityManager();


        Admin admin1 = new Admin( "Marwa" );
        Admin admin2 = new Admin( "Menna" );
        Admin admin3 = new Admin( "Basma" );
        Admin admin4 = new Admin( "Omnia" );

        Clerk clerk1 = new Clerk( "Khatab" );
        Clerk clerk2 = new Clerk( "Hashem" );
        Clerk clerk3 = new Clerk( "Ashraf" );
        Clerk clerk4 = new Clerk( "Osama" );

        Category category1 = new Category( "sugary", null );
        Category category2 = new Category( "drink", null );
        Category category3 = new Category( "eatable", null );

        Product product1 = new Product( "milka", "chocolate", 10, null, null );
        Product product2 = new Product( "pepsi", "drinks", 5, null, null );
        Product product3 = new Product( "cake", "sweeets", 3, null, null );

        product1.setCategories( new HashSet<Category>( Arrays.asList( category1, category3 ) ) );
        product2.setCategories( new HashSet<Category>( Arrays.asList( category1, category2 ) ) );
        product3.setCategories( new HashSet<Category>( Arrays.asList( category3 ) ) );


        Customer customer1 = new Customer( "Amira", "amira@gamil.com", "01146931276", null );
        Customer customer2 = new Customer( "Abdelaziz", "zizo@gamil.com", "01146931277", null );
        Customer customer3 = new Customer( "hesham", "hesham@gamil.com", "01146931278", null );
        Customer customer4 = new Customer( "samy", "samy@gamil.com", "01146931279", null );

        Order order1 = new Order( customer1, 500, new HashSet<Product>( Arrays.asList( product1, product2 ) ) );
        Order order2 = new Order( customer1, 900, new HashSet<Product>( Arrays.asList( product1, product2, product3 ) ) );
        Order order3 = new Order( customer2, 500, new HashSet<Product>( Arrays.asList( product1, product2, product3 ) ) );
        Order order4 = new Order( customer2, 300, new HashSet<Product>( Arrays.asList( product3, product2 ) ) );
        Order order5 = new Order( customer3, 100, new HashSet<Product>( Arrays.asList( product1 ) ) );


        em.getTransaction().begin();
        em.persist( admin1 );
        em.persist( admin2 );
        em.persist( admin3 );
        em.persist( admin4 );
        em.persist( clerk1 );
        em.persist( clerk2 );
        em.persist( clerk3 );
        em.persist( clerk4 );
        em.persist( category1 );
        em.persist( category2 );
        em.persist( category3 );
        em.persist( product1 );
        em.persist( product2 );
        em.persist( product3 );
        em.persist( customer1 );
        em.persist( customer2 );
        em.persist( customer3 );
        em.persist( customer4 );
        em.persist( order1 );
        em.persist( order2 );
        em.persist( order3 );
        em.persist( order4 );
        em.persist( order5 );

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
