# Homework 3 ID2208 - RESTful Web Service

## Deliverables

- **Report**: `./report/report.pdf`
- **REST server**: `./src/main/java/kth/se/id2208/hw3/server`
- **REST client**: `./src/main/java/kth/se/id2208/hw3/client`

## Description 

RESTful web service based on the scenario from hw2. Contains both client and server.

## How to run

### Build

Execute the following in the root directory to build war file.

`mvn clean install -DskipTests`

`mvn clean package -DskipTests`
### Compile

Execute the following in the root directory to only recompile the program

`mvn compile -DskipTests`

### Run

Deploy war file to any application server and specify port+base uri. You can then access the server through the following sample URI's.
Format of response depends on the request HTTP-accept header. Both JSON and XML supported for all resources

- `curl -H "Content-Type: application/json" -X POST -d '{"username":"kim","password":"id2208"}' http://localhost:8080/rest/login` - Login with POST request

- `http://localhost:8080/rest/itineraries?token=ID2208_AUTH_TOKEN` : Returns list of all itineraries

- `http://localhost:8080/rest/itineraries/index?token=ID2208_AUTH_TOKEN` : Returns itinerary with index 

- `http://localhost:8080/rest/itineraries?departmentCity=Stockholm&destinationCity=Mumbai&token=ID2208_AUTH_TOKEN` - Returns list of itineraries from Stockholm to Mumbai

- `http://localhost:8080/rest/pricelist?token=ID2208_AUTH_TOKEN` - Returns pricelist

- `http://localhost:8080/rest/flights?token=ID2208_AUTH_TOKEN` - Returns list of all flights

- `http://localhost:8080/rest/flights/index?token=ID2208_AUTH_TOKEN` - Returns flight with index

- `curl -H 'Content-Type: application/json' -X PUT -d '{"flights":[{"DepartmentCity":"Stockholm","DestinationCity":"Paris"}]}' 'http://localhost:8080/rest/flights?token=ID2208_AUTH_TOKEN'` - Puts list of flights

- `curl -H 'Content-Type: application/json' -X PUT -d '{"flight":{"DepartmentCity":"Stockholm","DestinationCity":"Paris"}}' 'http://localhost:8080/rest/flights/1?token=ID2208_AUTH_TOKEN` - Put flight

- `curl -H 'Content-Type: application/json' -X DELETE 'http://localhost:8080/rest/flights?token=ID2208_AUTH_TOKEN'` - Delete /flights resource

- `curl -H 'Content-Type: application/json' -X DELETE 'http://localhost:8080/rest/flights/1?token=ID2208_AUTH_TOKEN'` - Delete /flights/1 resource

- `http://localhost:8080/rest/tickets?token=ID2208_AUTH_TOKEN` - Returns list of all tickets

- `http://localhost:8080/rest/tickets/1?token=ID2208_AUTH_TOKEN` - Returns ticket with index

- `curl -H 'Content-Type: application/json' -X PUT -d '{"tickets":[{"Flight":{"DepartmentCity":"Stockholm","DestinationCity":"Paris"}, "Price":"10", "Date":"2013-03-11T01:38:18.309+0000" }]}' 'http://localhost:8080/rest/tickets?token=ID2208_AUTH_TOKEN'` - Puts list of tickets

- `curl -H 'Content-Type: application/json' -X PUT -d '{"ticket":{"Flight":{"DepartmentCity":"Stockholm","DestinationCity":"Paris"}, "Price":"10", "Date":"2013-03-11T01:38:18.309+0000" }}' 'http://localhost:8080/rest/tickets/0?token=ID2208_AUTH_TOKEN'` - Put ticket

- `curl -H 'Content-Type: application/json' -X DELETE 'http://localhost:8080/rest/tickets?token=ID2208_AUTH_TOKEN'` - Delete /tickets resource

- `curl -H 'Content-Type: application/json' -X DELETE 'http://localhost:8080/rest/tickets/1?token=ID2208_AUTH_TOKEN'` - Delete /tickets/1 resource

- `curl -H "Content-Type: application/json" -X POST -d '{"creditCardNumber": "1337", "tickets":[{"Flight":{"DepartmentCity":"Stockholm","DestinationCity":"Paris"},"Price":100.0,"Date":1486906930985}]}' 'http://localhost:8080/rest/bookticket?token=ID2208_AUTH_TOKEN'` - Book ticket with POST request

- `http://localhost:8080/rest/purchasedtickets?receiptId=1&token=ID2208_AUTH_TOKEN` - List of purchased tickets with receiptId 1

or simply run the test-client which is a regular JUnit test.
  
## Author
 
Kim Hammar  <kimham@kth.se>

Mallu Goswami
