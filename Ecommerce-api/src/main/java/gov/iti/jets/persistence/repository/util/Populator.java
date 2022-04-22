 package gov.iti.jets.persistence.repository.util;

 import gov.iti.jets.persistence.entity.*;
 import jakarta.persistence.EntityManager;
 import jakarta.persistence.EntityManagerFactory;
 import jakarta.persistence.Persistence;

 public class Populator {
     public static void main(String[] args) {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory( "api" );
         EntityManager em = emf.createEntityManager();

         Admin admin1 = new Admin( "Marwa");
         Admin admin2 = new Admin( "Menna");
         Admin admin3 = new Admin( "Basma");
         Admin admin4 = new Admin( "Omnia");

//         Clerk clerk1 = new Clerk( admin, "hend", "hend@gmail.com", null );
//         Clerk clerk2 = new Clerk( admin, "hafsa", "hafsa@gmail.com", null );
//         Product product1 = new Product( clerk1, "milka", 10.0, null, null, null );
//         Product product2 = new Product( clerk1, "pepsi", 5.5, null, null, null );
//         Product product3 = new Product( clerk2, "cake", 2.5, null, null, null );
//         Categories Categories1 = new Categories( "sugary", null );
//         Categories Categories2 = new Categories( "drink", null );
//         Categories Categories3 = new Categories( "eatable", null );

//         product1.setCategorieses( new HashSet<Categories>( Arrays.asList( Categories1, Categories3 ) ) );
//         product2.setCategorieses( new HashSet<Categories>( Arrays.asList( Categories1, Categories2 ) ) );
//         product3.setCategorieses( new HashSet<Categories>( Arrays.asList( Categories3 ) ) );
//
//
//         Customer customer1 = new Customer("khatab","khatab@gmail.com","01126241347",null,null);
//         Customer customer2 = new Customer("hashem","hashem@gmail.com","01126241346",null,null);
//         Customer customer3 = new Customer("osama","osama@gmail.com","01126241345",null,null);
//         Customer customer4 = new Customer("ashraf","khatab@gmail.com","01126241344",null,null);
//
//         Shoppingcart shoppingcart1 = new Shoppingcart(customer1 , 90.6 , new HashSet<>(Arrays.asList( product1,product2,product3 )));
//         Shoppingcart shoppingcart2 = new Shoppingcart(customer2 , 70.4 , new HashSet<>(Arrays.asList( product1,product3 )));
//         Shoppingcart shoppingcart3 = new Shoppingcart(customer3 , 65.9 , new HashSet<>(Arrays.asList( product1,product2 )));
//
//         Order order1 = new Order(customer1 , 90.6 , new HashSet<>(Arrays.asList( product1,product2,product3 )));
//         Order order2 = new Order(customer2 , 30.0, new HashSet<>(Arrays.asList( product1)));

         em.getTransaction().begin();
         em.persist(admin1);
         em.persist(admin2);
         em.persist(admin3);
         em.persist(admin4);
//         em.persist( clerk1 );
//         em.persist( clerk2 );
//         em.persist( Categories1 );
//         em.persist( Categories2 );
//         em.persist( Categories3 );
//         em.persist( product1 );
//         em.persist( product2 );
//         em.persist( product3 );
//         em.persist( customer1 );
//         em.persist( customer2 );
//         em.persist( customer3 );
//         em.persist( customer4 );
//         em.persist( shoppingcart1 );
//         em.persist( shoppingcart2 );
//         em.persist( shoppingcart3 );
//         em.persist( order1 );
//         em.persist( order2 );
         em.getTransaction().commit();
         em.close();
         emf.close();
     }
 }
