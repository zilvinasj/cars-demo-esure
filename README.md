# cars-demo-esure

ESURE Junior Developer Coding Challenge

** Scenario **
We have a new requirement to produce a service that allows us to filter the cars in our database by colour.

** Task **
Produce a Spring Boot REST API that reads in data from a JSON file and allows the user to filter by colour.

The json file is located with all of the project files and is accessed by the application to get the data and store it in a List. It is then possible to access it by making an http request to localhost:8080/cars?colour=<b>blue<b>
  
The project itself is runnable in any IDE that supports Spring Boot. Some Tests can also be found which check if the http response is correct along with trying out a colour and checking if the JSON returned is what was expected

