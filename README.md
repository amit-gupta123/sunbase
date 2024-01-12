# CRUD APPLICATION
## General Description:
    This is a crud based mvp, developed for demonstration purpose.
    This is developed with keeping things in mind like, ( Readability, Extensibility, Modularity, Coding to interface principle, Seperation of concern, SOLID principle, etc.)
    So it can be fully developed to form a new customer relationship management application. I have implemented it using Thymeleaf as ui, Spring boot as framework and MySQL as a database.
    
    
### What this project does?
    This is a crud application.
    This operates on all the crud ( create , read , update, delete ) functionality of an entity (Customer here);
- #### Create Operation:
      This let you create a customer and persist in database.
- #### Read Operation:
      This let you customer from database.
  - ##### Single customer:
         Fetches data of single user.
  - ##### All customer:
         Fetches data of all customer.
- #### Update Operation:
      Uses create operation with given id to update the customer data.
      Create operation help becuase of id and preexistance of customer data.
- #### Delete Operation:
      Delete a customer with a given id from database.
## Extended functoinality:
- ### Pagination
    One screen shows only 5 customer's data.
    Data of next added customer is shown on next page.
    Navigation to back and forth is implemented.
    Total count is also shown.
- ### Sorting
    Sorting is implemented as clickable sorting.
    click on any parameter on basis of which you want to sort, in toggling order.
    Sorting is only implemented on parameter which i thought to be suitable.
  
## Get Up and Running
  ### Installation
    1. IDE of your choice.
    2. MySQL database.
    3. Maven as build tool ( In case you need to install, in some ide already configured ).
    4. Java (Java 17 or >).
    5. Git
  ### Configuration
    1. Provide port number you want to use.
    2. database url
    3. username
    4. password
    5. dialect of ORM
    6. jwt_secret (I have not configured jwt completely, I need to scratch my head a bit more.
                   So it is not needed for this project. I have simply used a spring security dependency and default login feature of it.)
    7. username to login: user
    8. password: copy it from log generated by spring.
    9. dependencies: JPA, Securty, Spring Web, Sql Driver, Dev tools, Lombok.
    10. After you login to application( please head up to ( http://localhost:8085/api/v1/customers )location, Becauseof what I mentioned Earlier point 6 above in this section.
                                      And from here you will be able to continue.)
    11. Thymeleaf templating.
    
## Improvements possible
   - ### Validation
         Things can be validated more regoriously to improve robustness.
         City and state can be made actual city and state of a country and provide a functionality to choose from.
   - ### Authentication and Authorization
         I have used simple spring-security login feature to demonstrate. I need to Hit my head, more on this.
         And I think, wiil be able to learn all about spring security very soon, (few days).
  - ### Can be containerized and deployed
  - ### Future Scope
        Since this is a mvp, It can be completed to make full fledged customer maanager application and can be scaled.
  And much more.
   ##### Author
    - Amit Gupta
# ScreenShot
shared in pdf file

