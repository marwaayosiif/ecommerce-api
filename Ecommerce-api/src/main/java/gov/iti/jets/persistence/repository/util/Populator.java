 package gov.iti.jets.persistence.repository.util;

 import gov.iti.jets.persistence.entity.*;
 import jakarta.persistence.EntityManager;
 import jakarta.persistence.EntityManagerFactory;
 import jakarta.persistence.Persistence;

 import java.util.Arrays;
 import java.util.HashSet;

 public class Populator {
     public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory( "api" );
         EntityManager em = emf.createEntityManager();
         

         Admin admin1 = new Admin( "Marwa");
         Admin admin2 = new Admin( "Menna");
         Admin admin3 = new Admin( "Basma");
         Admin admin4 = new Admin( "Omnia");

         Clerk clerk1 = new Clerk( "Khatab");
         Clerk clerk2 = new Clerk( "Hashem");
         Clerk clerk3 = new Clerk( "Ashraf");
         Clerk clerk4 = new Clerk( "Osama");

        //  gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product product1 = new gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product( "milka", 10, "chocolate",  null );
        //  gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product product2 = new gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product( "pepsi", 5, "drinks", null );
        //  gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product product3 = new gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product.gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product( "cake", 3 , "sweeets", null );
        //  gov.iti.jets.persistence.entity.Category category1 = new gov.iti.jets.persistence.entity.Category( "sugary", null );
        //  gov.iti.jets.persistence.entity.Category category2 = new gov.iti.jets.persistence.entity.Category( "drink", null );
        //  gov.iti.jets.persistence.entity.Category category3 = new gov.iti.jets.persistence.entity.Category( "eatable", null );

        //  gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product product = new gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product("hey", 4 ,"vcds");
        // gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product product = new gov.iti.jets.persistence.entity.gov.iti.jets.persistence.entity.Clerk.gov.iti.jets.persistence.entity.Product("hey", 4, "hey");
        Category category1 = new Category( "sugary", null );
        Category category2 = new Category( "drink", null);
        Category category3 = new Category( "eatable", null);
        
        Product product1 = new Product("milka", "chocolate", 10, null , null);
        Product product2 = new Product("pepsi", "drinks", 5, null , null);
        Product product3 = new Product(  "cake", "sweeets" , 3, null, null);
         product1.setCategories( new HashSet<Category>( Arrays.asList( category1, category3 ) ) );
         product2.setCategories( new HashSet<Category>( Arrays.asList( category1, category2 ) ) );
         product3.setCategories( new HashSet<Category>( Arrays.asList( category3 ) ) );

         em.getTransaction().begin();
        em.persist(admin1);
        em.persist(admin2);
        em.persist(admin3);
        em.persist(admin4);
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

         em.getTransaction().commit();

         em.close();
         emf.close();
     }
 }
