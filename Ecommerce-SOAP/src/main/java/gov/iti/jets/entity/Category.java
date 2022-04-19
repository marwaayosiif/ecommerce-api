package gov.iti.jets.entity;
// default package
// Generated Apr 19, 2022, 11:05:40 PM by Hibernate Tools 6.0.0.Beta2


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name="category"
    ,catalog="rest_soap_api"
)
public class Category  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<Product> products = new HashSet<Product>(0);

    public Category() {
    }

    public Category(String name, Set<Product> products) {
       this.name = name;
       this.products = products;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="product_category", catalog="rest_soap_api", joinColumns = { 
        @JoinColumn(name="categ_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="produc_id", nullable=false, updatable=false) })
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


