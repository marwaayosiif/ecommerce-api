# Ecommerce API

>An ecommerce api using restful web services in project and soap web services in another project, providing some method for another developer who can use them to facilitate his job in creating an ecommerce app using this methods.

# 📗 Documentation

[Postman-documentation](https://documenter.getpostman.com/view/14515926/UyxdL95S)

# 🏛 Database Schema
![apii](https://user-images.githubusercontent.com/43884139/167253726-282cedbe-6ec3-4506-8771-34393a471eea.jpg)



# ⚙ Features
* Get all admins. `Restfull and Soap`
* Get admin by id. `Restfull and Soap`
* Delete all admins. `Restfull and Soap`
* Delete admin by id. `Restfull and Soap`
* Add new admin. `Restfull and Soap`
* Edit admin by id. `Restfull and Soap`
* Get all categories. `Restfull and Soap`
* Get category by id. `Restfull and Soap`
* Delete all categories. `Restfull and Soap`
* Delete category by id. `Restfull and Soap`
* Add new category. `Restfull and Soap`
* Edit category by id. `Restfull and Soap`
* Get all clerks. `Restfull and Soap`
* Get clerk by id. `Restfull and Soap`
* Delete all clekrs. `Restfull and Soap`
* Delete clerk by id. `Restfull and Soap`
* Add new clerk. `Restfull and Soap`
* Edit clerk by id. `Restfull and Soap`
* Get all products. `Restfull and Soap`
* Get product by id. `Restfull and Soap`
* Delete all products. `Restfull and Soap`
* Delete product by id. `Restfull and Soap`
* Add new product. `Restfull and Soap`
* Edit product by id. `Restfull and Soap`
* Get all orders. `Restfull and Soap`
* Get order by id. `Restfull and Soap`
* Delete all orders. `Restfull and Soap`
* Delete order by id. `Restfull and Soap`
* Get all customers. `Restfull and Soap`
* Get all customers with pagination. `Restfull only`
* Get customer by id. `Restfull and Soap`
* Get all orders for specific customer. `Restfull and Soap`
* Get order by id for specific customer. `Restfull and Soap`
* Delete all products. `Restfull and Soap`
* Delete product by id. `Restfull and Soap`
* Add new customer. `Restfull and Soap`
* Add new order to customer. `Restfull and Soap`
* Edit customer by id. `Restfull and Soap`
* Edit order of customer by id. `Restfull and Soap`
* Edit customer by id using patching. `Restfull only`
* HATEAOS in customer resource only. `Restfull only`
* Customized error when there is no object found only. `Restfull and Soap`
* Using XML and JSON form in all resource. `Restfull only`


# ⚙ Technologies used
* Maven
* JPA
* MySQL
* Restful web service (using JAX-RS)
* Soap web service (using JAX-WS)
 

# 🛠 How to run


**MySQL**
* Create a database user using MySQL Commandline 8.0 using the following commands:
```sql
CREATE USER 'apiuser'@'localhost' IDENTIFIED BY 'apiuser';
GRANT ALL PRIVILEGES ON api . * TO 'apiuser'@'localhost';
FLUSH PRIVILEGES;
```
* Go to `resources/META-INF/persistence.xml` in any project and make the value of `hibernate.hbm2ddl.auto` property equal `create`. 
* Run DatabasePopulator.java file
```
mvn clean compile exec:java -Dexec.mainClass=gov.iti.jets.persistence.repository.util.Populator
```
* Go back to `resources/META-INF/persistence.xml` and make the value of `hibernate.hbm2ddl.auto` property equal `update`.

**Maven**

* Change the configuration of tomcat in `pom.xml` in both project.
* Deploy the application using the following maven command:
```
mvn clean compile tomcat7:redeploy
```