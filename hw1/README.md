# Homework 1 ID2208 - XML Processing

## Deliverables

- **Report**: `./report/report.pdf`
- **XML Schemas**: `./xml/schemas/`
- **XML Documents**: `./xml/documents`
- **XSLT Stylesheets**: `./xml/stylesheets/`
- **Java project for parsing with SAX/JAXB/DOM/XSLT**: `./src/`

## Description 

### Task one: Create schemas and sample documents

See deliverables.

### Task two: Use DOM, SAX, JAXB, XSLT

 - **JAXB**: `./src/limmen/kth/se/hw1/parsing/jaxb/JAXBParser.java` contains API for parser using JAXB to parse, validate and map into java object for: `short_cv.xml` and `transcript.xml`.
 It also contains API for building an application profile out of parsed java objects and marshalling it into `application_profile_generated_task2.xml`.
 - **DOM**: `./src/limmen/kth/se/hw1/parsing/DOMParser.java` contains API for parser using DOM to parse, validate and map into java object for: `company_info.xml`.
 - **SAX**: `./src/limmen/kth/se/hw1/parsing/SAXParser.java` contains API for parser using SAX to parse, validate and map into java object for: `employment_record.xml.xml`.
 - **XSLT**: `./src/limmen/kth/se/hw1/parsing/XSLTParser.java` contains API for parser using XSLT to parse and transform : 
 `company_info.xml, transcript.xml, short_cv.xml, employment_record.xml`. It also contains API for combining extracted data into `application_profile_generated_task3.xml`

### Task three: Use XSLT to calculate GPA and produce final application_profile

Main API of the parser:

- `parseWithDOM_SAX_JAXB()`: Parses the xml files into java structures using DOM,SAX,JAXB, then it extracts the relevant data and finally marshalls it into `application_profile_generated_task2.xml`
- `buildWithXSLT()`: Extracts the relevant data from the XML files with XSLT and then transforms it into into `application_profile_generated_task3`

## How to run

### Build

Execute the following in the root directory to build.

`mvn install`

### Compile

Execute the following in the root directory to only recompile the program

`mvn compile`

### Run

Execute the following in the root directory to run the program

`java -jar ./target/hw1-1.0-SNAPSHOT-jar-with-dependencies.jar`
 
 
## Author
 
Kim Hammar  <kimham@kth.se>
