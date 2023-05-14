<h1 align="center">📱 Spring Boot Project Basic Instagram Application. 🗨️</h1>

- Frameworks and Language used :
  - Spring Boot `SNAPSHOT 3.0.6`
  - Java 17

- Data Flow :
  1. Controller
      <br/>
      > User
      - addUser : This method is used to call the addUser method of the service class to save the user data into the database.
      - getUserById :  This method is used to call the getUserById method of the service class to get the user data from the database based on selected user id.
        
      <br/>
      
      > Address
      - addAddress : This method is used to call the addAddress method of the service class to save the address data into the database.
       
      <br/>
       
      > Product
      - addProduct : This method is used to call the addProduct method of the service class to save the product data into the database.
      - deleteProductById : This method is used to call the deleteProductById method of the service class to delete product from the database based on selected product id.
      - getAllProductsByCategory : This method is used to call the getAllProductsByCategory method of the service class to get the list of products data available in the database based on selected product category.
          
      <br/>
      
      > Order
      - addOrder : This method is used to call the addOrder method of the service class to save the order data into the database.
      - getOrderById :  This method is used to call the getOrderById method of the service class to get the order data from the database based on selected order id.
            
  2. Services
      <br/>
      > User
      - addUser : This method is used to call the save method of the repository class to save the user data into the database.
      - getUserById :  This method is used to call the findById method of the repository class to get the user data from the database based on selected user id.
      
      <br/>
      
      > Address
      - addAddress : This method is used to call the save method of the repository class to save the address data into the database.
      
      <br/>
       
      > Product
      - addProduct : This method is used to call the save method of the repository class to save the product data into the database.
      - deleteProductById : This method is used to call the deleteById method of the repository class to delete the product data from the database based on selected product id.
      - getAllProductsByCategory : This method is used to call the findAllByCategory method of the repository class to get the list of products data available in the database based on selected product category.
      
      <br/>
      
      > Order
      - addOrder : This method is used to call the save method of the repository class to save the order data into the database.
      - getOrderById :  This method is used to call the findById method of the repository class to get the order data from the database based on selected order id.
      
  3. Repository
      - Used `Predefined` JpaRepository methods such as findById , save , deleteById , findAll for basic CRUD operations.
      
      <br/>
      
      > Product
      - findAllByCategory `Userdefined` : This method is used to get the list of products data available in the database based on selected product category. 
        
      
  4. Database Design
      - Used MySQL Database
      ```
       table user (
       	id integer not null auto_increment,
        	email varchar(255) not null,
        	name varchar(255) not null,
        	password varchar(255) not null,
        	phone_number bigint not null,
        	primary key (id)
    	)
    	
    	table address (
       	id integer not null auto_increment,
        	landmark varchar(255) not null,
        	name varchar(255) not null,
        	phone_number bigint not null,
        	state varchar(255) not null,
        	zipcode varchar(255) not null,
       	 	user_id integer not null,
        	primary key (id)
    	)
    	
    	table product (
       	id integer not null auto_increment,
        	brand varchar(255) not null,
        	category varchar(255) not null,
        	description varchar(255) not null,
        	name varchar(255) not null,
        	price integer not null,
        	primary key (id)
    	)
    	
    	table order (
      	id integer not null auto_increment,
        	product_quantity integer not null,
        	address_id integer not null,
        	product_id integer not null,
        	user_id integer not null,
        	primary key (id)
    	)
      ```
   
- Data Structure used in project :
  - List

- Project Summary :
```
  This is a Spring Boot project of Ecommerce API. User`(Buyer or Seller)` can register themselves by filling the required information.
  Upon registration basic validation applied to the filled data if all the validation passes then and only then a data is registered into the system.
  User`(Seller)` can able to register their product , fetch their saved product information and able to unregister their product if they want to. Whereas,
  User`(Buyer)` can able to order their required quantity of the product from the registered products using the Ecommerce API.
```
