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
