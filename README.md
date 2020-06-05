# Name

Monitering tool.

## Requirements
For building and running the application you need:
JDK 1.8
Maven 3

## Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.cubic.monitor.MonitorApplication class from your IDE.
Alternatively you can use below command [more information see](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins.html#build-tool-plugins-maven-plugin) .

```bash
mvn spring-boot:run
```

## Usage

```python

API document is written in swagger 
please go to http://localhost:8080/swagger-ui.html#/

How to Dockerize Spring Boot Application
Go to docker console inside project target directory run the following command 

Build Docker Image
$ docker build -t monitor.jar .

Check Docker Image
$ docker image ls

Run Docker Image
$ docker run -p 9090:8080 monitor.jar

In the run command, we have specified that the port 8080 on the container should be mapped to the port 9090 on the Host OS.
```

## Packaging & run  
```
mvn clean package

Default packaging is jar and save it in /target directory 
Copy the jar file. Put any directory go to that directory and run the command:  java -jar monitor-0.0.1-SNAPSHOT.jar
Open the browser http://localhost:8080/monitor/<DomainName>

To see application information
http://localhost:8080/actuator/prometheus

```

## Note *
Application can more customize i need to learn then i can implements .