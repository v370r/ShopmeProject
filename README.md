# ShopmeProject

#### ShopMe project from Udemy ####



-------------------------------------------------------------------------------------------------------------------------------------------------------------------

# How to run:

  #### mvn spring-boot:run ####


## From jar to run

	mvn package   
	         will be saved in target folder
	java -jar demo-0.0.1-SNAPSHOT.jar



-------------------------------------------------------------------------------------------------------------------------------------------------------------------
Multi-module maven project:


## ShopmeProject                                                     root project
    ---- shopmeCommon                                           module 1 
                                                                     shared library between backend and front end
    ---- shopmeWebParent                                       module 2
                                                           common dependencies between backend & front end
           ------ shopmeBackend                                   module 2a
           ------ shopmeFrontEnd                                 module 2b


----------------------------------------------------------------------------------------
User information: 
    Field Name    | Data Type     | Min length | Max length
    ------------- | -------------   ----------   ----------
    Email         | Text          |      8     |  128
    First Name    | Text          |      2     |   45
    Last Name     | Text          |      2     |   45
    Password      | Text          |      8     |   20
    Photos        | Image         |
    Enabled       | True/False    |
    Roles         | One or More Roles

------------------------------------------------------------------------------------------
Role Information:
   Field Name    | Data Type     | Min length | Max length
   ------------- | -------------   ----------   ----------
    Name         | Text          |      3     |  40
    Description  | Text          |      10    |  150
------------------------------------------------------------------------------------------
Roles
  Role Name     | Description
  ------------- | -------------
  Admin         | Manages Everything
  Sales Person  | manage product price, customers, shipping, orders and sales report
  Editor        | manages categories ,brands , products, articles and menus
  Shipper       | view products, view orders and update order status
  Assitant      | manage questions and reviews

   