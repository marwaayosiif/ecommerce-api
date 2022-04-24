package gov.iti.jets.persistence.repository.category;

import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.persistence.entity.Product;
import gov.iti.jets.services.category.dto.CategoryPutRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("api");
    EntityManager em;
    public List<Category> getAllCategory() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Category> cQuery = em.createQuery( "select c from Category c", Category.class );
        List<Category> categories = cQuery.getResultList();
        em.getTransaction().commit();
        em.close();
        return categories;
    }

    public String deleteAllCategory() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Category> cQuery = em.createQuery( "select c from Category c", Category.class );
        List<Category> categories = cQuery.getResultList();
        for ( Category category : categories ) {
            em.remove( category );
        }
        em.getTransaction().commit();
        em.close();
        return "All categories were deleted successfully";
    }

    public Category getCategoryById( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Category category = em.find( Category.class, id );
        em.getTransaction().commit();
        em.close();
        return category;
    }

    public String deleteCategoryById( int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Category category = em.find( Category.class, id );
        em.remove( category );
        em.getTransaction().commit();
        em.close();
        return "Category with "+id+" was deleted successfully";

    }

    public String addCategory( String name ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist( new Category(name , null) );
        em.getTransaction().commit();
        em.close();
        return "Category added successfully";
    }

    public Category editCategory( CategoryPutRequest categoryPutRequest, int id ) {
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Category category = em.find( Category.class, id );
        List<Integer> productIds = categoryPutRequest.getProductId();
        Set<Product> products = new HashSet<>();
        for ( Integer productId: productIds ) {
            products.add( em.find( Product.class  , productId) );
        }
        category.setProducts( products );
        category = em.merge( category );
        em.getTransaction().commit();
        em.close();
        return category;
    }
}
