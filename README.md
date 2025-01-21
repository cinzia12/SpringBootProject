### Running the Spring Boot Service with Docker
##  Prerequisites

Ensure you have the following installed on your system:
- **Docker** (Check by running: `docker --version`)
- **Maven** (Check by running: `mvn -version`)

### Build the Application

Before building the Docker image, package the application into a `.jar` file by running:

* mvn clean package

After a successful build, verify that the target/ directory contains:

target/SpringBootProject-0.0.1-SNAPSHOT.jar

Now, create a Docker image using the Dockerfile,by running :

* docker build -t springbootproject .

Start the service inside a Docker container by running:

* docker run -p 8080:8080 springbootproject

Once running, the service will be accessible at http://localhost:8080/products

### Running the Spring Boot Service locally without Docker
run mvn spring-boot:run
Once running, the service will be accessible at http://localhost:8080/products
