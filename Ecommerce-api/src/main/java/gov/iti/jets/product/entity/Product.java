package gov.iti.jets.product.entity;
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
import java.util.HashSet;
import java.util.Set;

import gov.iti.jets.category.entity.Category;
import gov.iti.jets.clerk.entity.Clerk;
import gov.iti.jets.order.entity.Order;
import gov.iti.jets.shoppingcart.entity.Shoppingcart;

/**
 * Product generated by hbm2java
 */
@Entity
@Table(name="product"
    ,catalog="rest_soap_api"
)
public class Product  implements java.io.Serializable {


     private Integer id;
     private Clerk clerk;
     private String name;
     private Double price;
     private Set<Order> orders = new HashSet<Order>(0);
     private Set<Shoppingcart> shoppingcarts = new HashSet<Shoppingcart>(0);
     private Set<Category> categories = new HashSet<Category>(0);

    public Product() {
    }

    public Product(Clerk clerk, String name, Double price, Set<Order> orders, Set<Shoppingcart> shoppingcarts, Set<Category> categories) {
       this.clerk = clerk;
       this.name = name;
       this.price = price;
       this.orders = orders;
       this.shoppingcarts = shoppingcarts;
       this.categories = categories;
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
    @JoinColumn(name="clerk_id")
    public Clerk getClerk() {
        return this.clerk;
    }
    
    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    
    @Column(name="name", length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="price", precision=22, scale=0)
    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="order_product", catalog="rest_soap_api", joinColumns = { 
        @JoinColumn(name="pro_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="ord_id", nullable=false, updatable=false) })
    public Set<Order> getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="shoppingcart_product", catalog="rest_soap_api", joinColumns = { 
        @JoinColumn(name="produ_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="shopping_id", nullable=false, updatable=false) })
    public Set<Shoppingcart> getShoppingcarts() {
        return this.shoppingcarts;
    }
    
    public void setShoppingcarts(Set<Shoppingcart> shoppingcarts) {
        this.shoppingcarts = shoppingcarts;
    }

@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="product_category", catalog="rest_soap_api", joinColumns = { 
        @JoinColumn(name="produc_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="categ_id", nullable=false, updatable=false) })
    public Set<Category> getCategories() {
        return this.categories;
    }
    
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }




}


