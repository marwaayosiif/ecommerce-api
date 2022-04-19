package gov.iti.jets.shoppingcart.entity;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.HashSet;
import java.util.Set;

import gov.iti.jets.customer.entity.Customer;
import gov.iti.jets.product.entity.Product;

/**
 * Shoppingcart generated by hbm2java
 */
@Entity
@Table(name="shoppingcart"
    ,catalog="rest_soap_api"
    , uniqueConstraints = @UniqueConstraint(columnNames="cust_id") 
)
public class Shoppingcart  implements java.io.Serializable {


     private Integer id;
     private Customer customer;
     private Double totalPrice;
     private Set<Product> products = new HashSet<Product>(0);

    public Shoppingcart() {
    }

    public Shoppingcart(Customer customer, Double totalPrice, Set<Product> products) {
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

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cust_id", unique=true)
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    @Column(name="total_price", precision=22, scale=0)
    public Double getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="shoppingcart_product", catalog="rest_soap_api", joinColumns = { 
        @JoinColumn(name="shopping_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="produ_id", nullable=false, updatable=false) })
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


