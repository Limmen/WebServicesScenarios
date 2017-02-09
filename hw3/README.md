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

- `http://localhost:8080/rest/itineraries` : Returns list of all itineraries
- `http://localhost:8080/rest/itineraries/1` : Returns first itinerary in the list
- `http://localhost:8080/rest/itineraries?departmentCity=Stockholm&destinationCity=Mumbai` - Returns list of itineraries from Stockholm to Mumbai
- TODO....


or simply run the test-client which is a regular JUnit test.
  
## Author
 
Kim Hammar  <kimham@kth.se>

Mallu Goswami
