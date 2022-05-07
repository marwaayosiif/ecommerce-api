# Ecommerce API

>An Ecommerce web application built using Jsp, Jakarta Servlets and JPA as our second project at the Information Technology Institute. 
> It takes full advantage of Tailwind component to build our view in a simple way .
# 🏛 Architecture
This software project was built using a layered architecture. The following diagram demonstrates an example use case that goes through all the layers.


# 🏛 Database Schema


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
**Maven**

* Change the configuration of tomcat in `pom.xml`.
* Deploy the application using the following maven command:
```
mvn clean compile tomcat7:redeploy
```

**MySQL**
* Create a database user using MySQL Commandline 8.0 using the following commands:
```sql
CREATE USER 'manager'@'localhost' IDENTIFIED BY 'manager';
GRANT ALL PRIVILEGES ON ecommerce . * TO 'manager'@'localhost';
FLUSH PRIVILEGES;
```
* Go to `resources/META-INF/persistence.xml` and make the value of `hibernate.hbm2ddl.auto` property equal `create`. 
* Run DatabasePopulator.java file
```
mvn clean compile exec:java -Dexec.mainClass=gov.iti.jets.repository.util.DatabasePopulator
```
* Go back to `resources/META-INF/persistence.xml` and make the value of `hibernate.hbm2ddl.auto` property equal `update`.
