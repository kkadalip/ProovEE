#  Improved REST API for Estonian Weather data

###### To run tests separately:
	$ gradle test
	
## 1) Building the application
	Open command prompt, navigate to project root, for example:
	$ cd C:\Users\your.name\Desktop\ProovEE
	
	Run in command prompt:
    $ gradle build
    
## 2) Starting the application
	Run in command prompt:
	$ gradle bootRun
	Open http://localhost:8090/

####  Building and starting with custom variables instead:	
	$ gradlew bootRun -Pargs=--port=8093
	OR
	$ gradlew build && java -jar build/libs/proov-ee-1.0.jar --mode=dev --port=8091
######	NB! Port 8090 will be used if "--port=" variable is not provided

## Building and launching an executable JAR (to \build\libs folder)
	$ cd C:\Users\your.name\Desktop\ProovEE
	$ gradle bootJar
	$ cd build\libs
	$ java -jar proov-ee-1.0.jar
    
### Configuration files    
    All environments:
    config/application.properties
    config/application.yml

	Logging:
	config/log/log4j2.xml
    
### Application API docs (Swagger 2)
	http://localhost:8090/swagger-ui.html
	http://localhost:8090/v2/api-docs
	http://localhost:8090/swagger-resources

#### Java trust store certificates
    Currently not needed.
    
#### Frameworks in use:
* Spring Boot - https://spring.io/projects/spring-boot
* JAXB API for XML parsing - https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/

#### Helpful guides:
* Setting up Spring Boot - https://spring.io/guides/gs/spring-boot/
* Serving web content - https://spring.io/guides/gs/serving-web-content/
* Server side testing - https://docs.spring.io/spring/docs/current/spring-framework-reference/testing.html

###### REST API:
* Swagger - https://swagger.io/
* Swagger UI - https://swagger.io/tools/swagger-ui/

##### Source data and logic
* http://www.ilmateenistus.ee/teenused/ilmainfo/eesti-vaatlusandmed-xml/
* http://www.ilmateenistus.ee/ilma_andmed/xml/observations.php
* https://www.freemathhelp.com/wind-chill.html