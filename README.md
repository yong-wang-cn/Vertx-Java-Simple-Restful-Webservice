# Vertx-Java-Simple-Restful-Webservice
A simple web service by reactive Vertx Java
<p> Prerequisites:

1. Java SDK 1.8
2. Vert.x 3.7.0
3. AngularJS 1.6.9
4. Maven

<p> How to build: 
    
    Under the project root, run the following Maven command
    mvn clean insatll
    This will generate a fat jar under target with name of UniqueGmailAddress.jar
  
<p> How to deploy
  
    No need to deploy to any server
  
<p> How to run
  
    Just run the fat jar file as the following:
    java -jar UniqueGmailAddress.jar
    Once it is launched successfully
        Vertx has a built-in HTTP Web server
        Port: 8080
        It serves static content from webroot
        It configures one RESTful API: POST /uga which take a comma delimited email list and returns the total number of unique gmail addresses
  
<p> How to test
  
    Point your browser to http://localhost:8080
    Put in any number of email addrss and click on submit button
    The number of unique gmail address will be displayed

<p> Vertx does it all
  
    Vertx is a purely reactive flavor of Java, it has a built-in web/app server which can create RESTful web services and serves static content, it is one of the simplest ways to create web service.
