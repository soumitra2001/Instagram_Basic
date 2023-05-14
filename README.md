<h1 align="center">📱 Spring Boot Project Basic Instagram Application. 🗨️</h1>

- Frameworks and Language used :
  - Spring Boot `SNAPSHOT 3.0.6`
  - Java 17

- Data Flow :
  1. Controller
      <br/>
      > User
      - signUp : This method is used to call the userSignUp method of the service class for sign up a user and a authentication token will be created corresponding the            user. User information and Authentication info will be saved respective User and Authentication Table in MySql DB.
      - signIn :  This method is used to call the userSignIn method of the service class for user logIn. After login successful method will return a message and a                  Authentication token in string form. Using this token user can do any other operation like update, delete etc.
      - updateUserDetails : This method is used to call the updateUserInfo method of the service class for update the user information in DB. This method takes                    authentication token to check if user is valid or not then will update the details.
      - getAllUser : This method is used to call the findAllUser method of the service class for get the all user from DataBase.
        
      <br/>
      
      > Post
      - addPost : This method is used to call the addPost method of the service class to add a post corresponding the user into the Post table in database. This method takes token for user authentication.
      - getAllPostById : This method is used to call the findAllPostByUserId method of the service class to get all post that a user posted earlier. This method takes a userId as a pathvariable and find all the post related the user.
            
  2. Services
      <br/>
      > User
      - userSignUp : This method is used to call the save method of the repository class to save the user data into the database.
      - userSignIn :  This method is used to call the getByUserEmail method of the repository class to find the user which have this email which passes by the method. If the email match then only user can login otherwise not.
      - updateUserInfo : This method is used to call the getByToken method of the AuthenticationService class to check the authentication of the user then it will call the updateUser method to update user info in DB.
      
      <br/>
      
      > Post
      - addPost : This method is used to call the save method of the repository class to save the post of a user into the database.
      - findAllPostByUserId :  This method is used to call the findByUser method of the repository class to get the post of a particular user by using userid.
      
  3. Repository
        <br/>
        >User
        - Used `Predefined` JpaRepository methods such as findById , save , findAll for basic CRUD operations.
        - Also used `Custom Finder` method like findByUserEmail, getByUserEmail for find user data from DataBase.
        - updateUser :It's a `Userdefined` method to update a user's particular column.
      
      <br/>
      
      > Post
      - Used `Custom Finder` method like findByUser for find all post for a single user from DataBase.
        
      
  4. Database Design
      - Used MySQL Database
      ```
       create table authentication_token (
       token_id bigint not null auto_increment,
        token varchar(255),
        token_creation_date date,
        fk_user_id bigint,
        primary key (token_id)
        )
    	
    	create table post (
       post_id bigint not null auto_increment,
        created_date datetime(6),
        post_data varchar(255),
        updated_date datetime(6),
        fk_user_id bigint not null,
        primary key (post_id)
        )
    	
    	create table user (
       user_id bigint not null auto_increment,
        user_age integer,
        user_email varchar(255),
        user_first_name varchar(255),
        user_last_name varchar(255),
        user_password varchar(255),
        user_ph_number varchar(255),
        primary key (user_id)
        )
    	
    	alter table user 
       drop index UK_j09k2v8lxofv2vecxu2hde9so
       
       alter table authentication_token 
       add constraint FKh1d4j9xvy9w1g1kfttfnedeh5 
       foreign key (fk_user_id) 
       references user (user_id)
       
       alter table post 
       add constraint FKk4xxrj4jt46qk8qntudi0rbp 
       foreign key (fk_user_id) 
       references user (user_id)
      ```
   
- Data Structure used in project :
  - List

- Project Summary :
```
  This is a Spring Boot project of Basic Instagram API. User can register themselves by filling the required information.
  Upon registration basic validation applied to the filled data if all the validation passes then and only then a data is registered into the system.
  User can able to post their Image, Meme etc, fetch their posted image and able to delete their post if they want to. Whereas,
  User can able to update their required information from the registered data using the Basic Instagram API.
  AtLast User also can delete their account forever.
```
