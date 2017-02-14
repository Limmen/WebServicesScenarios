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

Deploy war file to any application server and specify port+base uri. 

If you dont want to inspect resources manually, use ServiceClientTest which is a test-suite that tests every resource and edge-cases.

#### Resources

You can access the server through the following  URI's.

Format of response depends on the request HTTP-accept header. Both JSON and XML supported for all resources

#### Login

Login with POST request to get super secret token

`curl -H "Content-Type: application/json" -X POST -d '{"username":"kim","password":"id2208"}' http://localhost:8080/rest/login`

#### Itineraries

GET list of all itineraries

`http://localhost:8080/rest/itineraries?token=ID2208_AUTH_TOKEN` 

GET itinerary with index

`http://localhost:8080/rest/itineraries/index?token=ID2208_AUTH_TOKEN` 

GET list of itineraries from Stockholm to Mumbai

`http://localhost:8080/rest/itineraries?departmentCity=Stockholm&destinationCity=Mumbai&token=ID2208_AUTH_TOKEN`

#### Pricelist

GET pricelist

`http://localhost:8080/rest/pricelist?token=ID2208_AUTH_TOKEN`

#### Flights

GET list of all flights

`http://localhost:8080/rest/flights?token=ID2208_AUTH_TOKEN`

GET flight with index
`http://localhost:8080/rest/flights/index?token=ID2208_AUTH_TOKEN`

PUT list of flights

`curl -H 'Content-Type: application/json' -X PUT -d '{"flights":[{"DepartmentCity":"Stockholm","DestinationCity":"Paris"}]}' 'http://localhost:8080/rest/flights?token=ID2208_AUTH_TOKEN'` 

PUT flight with index

`curl -H 'Content-Type: application/json' -X PUT -d '{"flight":{"DepartmentCity":"Stockholm","DestinationCity":"Paris"}}' 'http://localhost:8080/rest/flights/1?token=ID2208_AUTH_TOKEN`

DELETE /flights resource

`curl -H 'Content-Type: application/json' -X DELETE 'http://localhost:8080/rest/flights?token=ID2208_AUTH_TOKEN'` 

DELETE /flights/1 resource

`curl -H 'Content-Type: application/json' -X DELETE 'http://localhost:8080/rest/flights/1?token=ID2208_AUTH_TOKEN'`

#### Tickets

GET list of all tickets

`http://localhost:8080/rest/tickets?token=ID2208_AUTH_TOKEN`

GET ticket with index

`http://localhost:8080/rest/tickets/1?token=ID2208_AUTH_TOKEN`

PUT list of tickets

`curl -H 'Content-Type: application/json' -X PUT -d '{"tickets":[{"Flight":{"DepartmentCity":"Stockholm","DestinationCity":"Paris"}, "Price":"10", "Date":"2013-03-11T01:38:18.309+0000" }]}' 'http://localhost:8080/rest/tickets?token=ID2208_AUTH_TOKEN'`

PUT ticket with index

`curl -H 'Content-Type: application/json' -X PUT -d '{"ticket":{"Flight":{"DepartmentCity":"Stockholm","DestinationCity":"Paris"}, "Price":"10", "Date":"2013-03-11T01:38:18.309+0000" }}' 'http://localhost:8080/rest/tickets/0?token=ID2208_AUTH_TOKEN'`

DELETE /tickets resource

`curl -H 'Content-Type: application/json' -X DELETE 'http://localhost:8080/rest/tickets?token=ID2208_AUTH_TOKEN'`

DELETE /tickets/1 resource
`curl -H 'Content-Type: application/json' -X DELETE 'http://localhost:8080/rest/tickets/1?token=ID2208_AUTH_TOKEN'`

#### Book Tickets

Book list of tickets with given creditcardnumber, receipt is returned.

`curl -H "Content-Type: application/json" -X POST -d '{"creditCardNumber": "1337", "tickets":[{"Flight":{"DepartmentCity":"Stockholm","DestinationCity":"Paris"},"Price":100.0,"Date":1486906930985}]}' 'http://localhost:8080/rest/bookticket?token=ID2208_AUTH_TOKEN'`

#### Purchased tickets

GET list of purchased tickets with receiptId 1

`http://localhost:8080/rest/purchasedtickets?receiptId=1&token=ID2208_AUTH_TOKEN` 
  
## Author
 
Kim Hammar  <kimham@kth.se>

Mallu Goswami
