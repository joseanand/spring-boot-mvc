# Simple Spring Boot with MongoDB project
Spring boot MVC security project which has CRUD operation to MongoDB

# How to run the project:
1. Right click on the project in eclipse
2. Select Run As
3. Select Maven Build...
4. Under Goals enter "sprint-boot:run"

This will execute the project under eclipse itself.

# Application Usage:
Application is configured to run on 9080.  http://localhost:9080
* /login is the non authenticate page.
* /home is a non authenticated page which provides user the cabablity to redirect to greetings page with authentication and registration page for user to signup a new account.
* /register is a non authenticated page which provides user cabability to sign up.
* /greetings is an authenticated page which displays the user details on the page.
