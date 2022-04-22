package gov.iti.jets.persistence.entity;
// default package
// Generated Apr 22, 2022, 8:44:06 AM by Hibernate Tools 6.0.0.Beta2


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name="admin"
    ,catalog="api"
)
public class Admin  implements java.io.Serializable {


     private Integer id;
     private String name;

    public Admin() {
    }

    public Admin(String name) {
       this.name = name;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }




}


