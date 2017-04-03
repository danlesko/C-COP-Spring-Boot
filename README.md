# C-COP-Spring-Boot

This is an Angular2 frontend application written with a Spring Boot (Java) backend. In order to run the application, you must have installed or have the ability to run:

1. Node, NPM
2. Maven

With NPM installed, you must then install:

1. Angular CLI
2. Typings
3. Angular2-Google-Chart
  * Although this is a node_module, it does not get added the angular-cli.json, and therefore must be downloaded separately

Follow these directions to start:

1. Install [NVM](https://github.com/creationix/nvm#install-script) or Node (This will include NPM)
2. Optionally install Maven, or run the project from inside Eclipse (You will need your own Tomcat Server) or IntelliJ
3. Install the Angular CLI
   1. `npm install -g @angular/cli@1.0.0-rc.1`
4. Install Typings
   1. `npm install -g typings`
5. Inside of the frontend/src/main/frontend directory you must Install Angular2-Google-Chart
   1. `npm install --save-dev angular2-google-chart`
   
   It will give some warnings about not all dependencies being met, ideally we will update the whole project to Angular4 before the end of April 2017.

Once this is done, you can run:  
`npm install`  
in the frontend/src/main/frontend directory which contains all of the Angular2 data to download all the missing node_modules.

From here you can either launch the application from command line using Maven, or load in the application through Eclipse or IntelliJ.

To launch from command line run:  
From root directory `mvn clean install`  
From backend directory `mvn spring-boot:run`

