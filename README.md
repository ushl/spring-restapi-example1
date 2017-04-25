# Purpose

An example RESTful API using Spring Boot.

# Configuration

Place the following into `application.properties`:

	spring.datasource.url=jdbc:mysql://DB_HOSTNAME_HERE/DB_NAME_HERE
	spring.datasource.username=USERNAME_HERE
	spring.datasource.password=PASSWORD_HERE

This file should be in the current working directory when starting
the application.

# Build

Maven is required to build the JAR file.

	$ mvn -e clean package

# Usage

	$ java -jar target/spring1.jar

Or:

	$ ./start.sh

The service will be available at [http://localhost:8080/](http://localhost:8080/).

The main endpoint of interest will be [http://localhost:8080/articles/](http://localhost:8080/articles/)

# Test reports

	$ mvn -e cobertura:cobertura

Reports will be available at `target/site/cobertura/index.html`.

