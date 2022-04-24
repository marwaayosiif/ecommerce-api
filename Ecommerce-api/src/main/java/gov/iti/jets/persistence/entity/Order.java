package gov.iti.jets.persistence.entity;// default package
// Generated Apr 24, 2022, 2:56:59 PM by Hibernate Tools 6.0.0.Beta2


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * gov.iti.jets.persistence.entity.Order generated by hbm2java
 */
@Entity
@Table(name="order"
    ,catalog="api"
)
public class Order  implements java.io.Serializable {


     private Integer id;
     private Customer customer;
     private Integer totalPrice;
     private Set<Product> products = new HashSet<Product>(0);

    public Order() {
    }

    public Order( Customer customer, Integer totalPrice, Set<Product> products) {
       this.customer = customer;
       this.totalPrice = totalPrice;
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

@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cutomer_id")
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer( Customer customer) {
        this.customer = customer;
    }

    
    @Column(name="total_price")
    public Integer getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="product_order", catalog="api", joinColumns = { 
        @JoinColumn(name="order_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="prod_id", nullable=false, updatable=false) })
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


