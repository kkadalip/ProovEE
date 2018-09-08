#  Improved REST API for Estonian Weather data

## Building the application
    $ gradle build

## Starting the application
	Open command prompt, navigate to project root, for example:
	$ cd C:\Users\your.name\Desktop\ProovEE
	And then run in command prompt:
	$ gradle bootRun
	Open http://localhost:8090/

## Building and running the application project with variables:	
	$ gradlew build && java -jar build/libs/proov-ee-1.0.jar --mode=dev --port=8091
######	NB! Port 8090 will be used if "--port=" variable is not provided
### Environment variables
	mode=dev (dev, test, live)
	server.port=    (port number to run the application on)
    security.oauth2.client.clientSecret=TODO
    
### Configuration files    
    All environments:
    config/application.properties
    config/application.yml

	Logging:
	config/log/log4j2.xml
	
	(TODO separate files for -local, -dev, -test, -live environments)
    
### Application API docs (Swagger 2)
	http://localhost:8090/swagger-ui.html
	http://localhost:8090/v2/api-docs
	http://localhost:8090/swagger-resources

#### Java trust store certificates
    Currently not needed.
    
#### Frameworks in use:
* Spring Boot - https://spring.io/projects/spring-boot
* JAXB API for XML parsing - https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/
###### REST API:
* Swagger - https://swagger.io/
* Swagger UI - https://swagger.io/tools/swagger-ui/
