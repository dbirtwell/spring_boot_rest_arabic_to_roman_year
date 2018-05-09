# Arabic Year to Roman Numeral Year Conversion

This is a sample java-based RESTful API project written in Spring Boot using Gradle 4.0 (or later) and Java 8. The application is a REST Service to convert an year passed in as an Arabic numeral passed in to the equivalent Roman Numeral Roman.

This is very simple and has limitations. Basically, it only supports year 1 through 3999, due to the limitations of simple ASCII Roman numerals only being able to be represented
up to 3999 without using Unicode.

The main purpose of this program was to show how one can wrap a simple legacy project in a RESTFul API using Spring Boot.
I actually wrote the business logic portion of this project (the Arabic year to Roman year business package) a while ago. I wanted to create an example of how one could expose a very simple Spring Boot RESTful API which did a little more than just the usual "Hello World" and do this using TDD.

This project includes some Exception Handling for Spring Boot using a Custom Exception Handler and the ControllerAdvice annotation.

## Getting Started

Not much here, but I have included a file named todo.txt where I document some things I still need to do.

### Prerequisites

You will need Java 8 installed and running on your system.

You will need Gradle 4.0 (or later).

Since this was initially built with the Spring Intitialzr, Gradle Wrapper files are also contained in this project.

### Installing

This Gradle Project includes the default Gradle tasks and runs on port 8080 (the default Spring Boot Application port).

gradle clean build
gradle bootRun

then go to:

http://localhost:8080/trackmystuff

or

http://localhost:8080/trackmystuff/message


## Running the tests

There Unit Tests for the business logic, MockMvc Tests for Spring Boot-styled Web Mock Tests and some Spring Boot-styled Integration Tests.

You can run the tests either inside an IDE, of via the command line using

gradle test

## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Gradle](https://gradle.org/) - Dependency Management

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
