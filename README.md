# C-COP-Spring-Boot

This project aimed to create a dashboard using the Montgomery County crime and arrest data in order to show relationships between the two. The website is currently live [here](http://ec2-52-54-85-216.compute-1.amazonaws.com:8080/CCOP/) although it may get taken down in the near future. The website is currently not set to update the database consistently. Please navigate to the month of April 2017 to see meaningful data. It is possible that you will have to refresh the page once or twice before the data will display. 

This is an Angular2 frontend application written with a Spring Boot (Java) backend. In order to run the application, you must have installed or have the ability to run:

1. Node, NPM
2. Maven
3. MySQL DB
4. Angular CLI

Download / clone the repo and in the `frontend/src/main/frontend` directory run:  
`npm install`  
This will download all the necessary dependencies. 

From here you can either launch the application from command line using Maven, or load in the application through Eclipse or IntelliJ. Either way you must package up the project using maven before running.

To launch from command line run:  
From root directory `mvn clean install`  
From backend directory `mvn spring-boot:run`

