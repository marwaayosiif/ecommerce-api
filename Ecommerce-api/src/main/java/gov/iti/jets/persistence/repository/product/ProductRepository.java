package gov.iti.jets.persistence.repository.product;

import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.persistence.entity.Product;
import gov.iti.jets.services.dto.product.ProductPostRequest;
import gov.iti.jets.services.dto.product.ProductPutRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductRepository {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("api");
    EntityManager em;
    public List<Product> getAllProducts() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Product> cQuery = em.createQuery( "select p from Product p", Product.class );
        List<Product> products = cQuery.getResultList();
        em.getTransaction().commit();
        em.close();
        return products;
    }

    public Product getProductById( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find( Product.class, id );
        em.getTransaction().commit();
        em.close();
        return product;
    }

    public String deleteAllProducts() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Product> cQuery = em.createQuery( "select p from Product p", Product.class );
        List<Product> products = cQuery.getResultList();
        for ( Product product : products ) {
            em.remove( product );
        }
        em.getTransaction().commit();
        em.close();
        return "All product were deleted successfully";
    }

    public String deleteProductById( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find( Product.class, id );
        em.remove( product );
        em.getTransaction().commit();
        em.close();
        return "Product with "+id+" was delete successfully";
    }

    public String addProduct( ProductPostRequest productPostRequest ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist( new Product(productPostRequest.getName(),productPostRequest.getDescription() , null , null,null) );
        em.getTransaction().commit();
        em.close();
        return "Product added successfully";
    }

    public Product editProduct( int id, ProductPutRequest productPutRequest ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Product product = em.find( Product.class, id );
        product.setName( productPutRequest.getName() );
        product.setDescription( productPutRequest.getDescription() );
        product.setPrice( productPutRequest.getPrice() );
        product.setCategories( editCategory( productPutRequest.getCategories() ) );
        product = em.merge( product );
        em.getTransaction().commit();
        em.close();
        return product;
    }

    private Set<Category> editCategory( List<Integer> integerList ){
//        em = emf.createEntityManager();
        Set<Category> categories = new HashSet<>();
        for ( Integer id :
                integerList ) {
            categories.add( em.find( Category.class , id ) );
        }
        return categories;
    }
}
