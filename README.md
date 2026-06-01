# Intellij-TODO-V1-01Jun

Here i am implementing TO-DO app using microservices:


Today i implemented User microservice :
In this user Add, user Delete ,User Update, Show all user operatipons are there.

# User Service

## Overview

User Service is a Spring Boot REST API application that provides CRUD operations for managing users.

Features:

* Create User
* Get User by ID
* Get User by Username
* Get All Users
* Update User
* Delete User
* Exception Handling

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Lombok
* Maven

---

## Project Structure

src/main/java

├── Controller

├── Service

├── Repository

├── Entity

├── ExceptionHandling

└── Application

---

## Database Configuration

Configure the database in `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Running the Application

Clone the repository:

```bash
git clone <repository-url>
```

Navigate to the project directory:

```bash
cd userservice
```

Build the project:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

Application runs on:

```text
http://localhost:8080
```

---

## User Entity

```java
@Entity
@Table(name = "User")
public class User {

    @Id
    private Integer userid;

    private String username;

    private String password;
}
```

---

## API Endpoints

### Create User

POST /users

Request Body:

```json
{
  "userid": 1,
  "username": "john",
  "password": "password123"
}
```

### Get All Users

GET /users

### Get User By ID

GET /users/{userid}

Example:

```http
GET /users/1
```

### Get User By Username

GET /users/username/{username}

Example:

```http
GET /users/username/john
```

### Update User

PUT /users/{userid}

Request Body:

```json
{
  "username": "john_updated",
  "password": "newpassword"
}
```

### Delete User

DELETE /users/{userid}

Example:

```http
DELETE /users/1
```

---

## Exception Handling

Custom exceptions are used to handle business errors such as:

* UserAlreadyExist
* UserNotFoundException

Global exception handling is implemented using `@RestControllerAdvice`.

---

## Author

Mitali Yadav
Java Backend Developer



