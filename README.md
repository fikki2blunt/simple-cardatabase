
# Car Management API
This project is a learning-based Spring Boot API designed to explore the basics of Spring Boot development, including user authentication, authorization, and data management. The API handles user authentication using JWT and manages data for cars and their respective owners. Additionally, a CommandLineRunner is used to preload sample data for testing purposes.

## Getting Started
These instructions will help you set up the project in your environment for local testing or further development.

**Prerequisites**

Ensure you have the following installed:
- JDK 21: Required to run the application.
- IDE (Integrated Development Environment): Recommended options include IntelliJ IDEA, Eclipse, or VS Code, for easier project setup and management.
- Maven Build Tool: For managing project dependencies and building the application.
- MySQL Database: For storing and managing data.
- Postman: For testing the API locally.


**Technologies Used**
- Spring Boot: Backend framework.
- Spring Security & JWT: Authentication and authorization.
- Spring Data REST: For exposing RESTful endpoints.
- MySQL: Relational database management system.
- Postman: Used for API testing during development.




## Features
**1. JWT Authentication:**
- Provides secure user authentication and authorization.
- Only the /login endpoint is accessible to all users without authentication
- All other endpoints require valid JWT tokens
**2. Car and Owner Data Management:**
- API allows the storage and retrieval of car and owner data.
- CRUD operations can be performed via RESTful endpoints(tested locally using postman.)
**3. Preloaded Data:**
- A CommandLineRunner is included in the Application class called HandsOnApplication.java (The class with the Main method) to automatically preload sample data (cars, owners, and users) into the database when the application starts.
**4. RESTful Endpoints:**
- Exposes endpoints for managing resources.
## Installation
1. Clone the repository
2. Open the Project in your IDE:
- Import the project as a Maven Project(If required by your IDE)
- Ensure all dependencies are resolved successfully.
3. Set up the database:
- Create database/schema and use the database in the MySQL relational database management system (e.g car_management)
- update the database configuration in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/car_management
spring.datasource.username="your-database-username"
spring.datasource.password="your-database-password"
spring.jpa.hibernate.ddl-auto=update

4. Run the application
5. Preloaded data: 
- After startup, sample data(cars, owners and users) will be automatically inserted into the database using the CommandLineRunner.

## API Endpoints
| **Method** | **Endpoint**        | **Description**                 | **Authentication** |
|------------|---------------------|---------------------------------|--------------------|
| `POST`     | `/login`            | Authenticates a user and returns a JWT token. | Not required       |
| `GET`      | `/cars`             | Retrieves all cars.             | Required           |
| `POST`     | `/cars`             | Adds a new car.                 | Required           |
| `GET`      | `/owners`           | Retrieves all car owners.       | Required           |
| `POST`     | `/owners`           | Adds a new owner.               | Required           |

## Testing The API
1. Install Postman.
2. Send a **POST** request to localhost:8080/login
3. Navigate to the "Body" tab within the HTTP request configuration.
4. Within the "Body" tab, there are several options for how to format the request body. Selected the "raw" option.
5. After selecting "raw", enter the user credentials in JSON format. The JSON object consists of two key-value pairs:
- "username": The key representing the username, with the value "admin".
 - "password": The key representing the password, with the value "password".
 {"username": "admin", "password": "password"}

6. A successful login typically results in the server returning a response containing an authentication token. 
7.  identified and copied only the token part, excluding the "Bearer " prefix.
8. Navigating to the "Headers" Tab. This tab is used to configure the HTTP headers that will be sent with a request to another endpoint such as localhost:8080/data/cars
9. Within the "Headers" section, a row with the "Key" as "Authorization" is Selected and checked. The extracted token (without the "Bearer" prefix) from the successful /login response is pasted into the "Value" field for the "Authorization" header.

## Additional Notes
**1. Default Port:**
- The application runs on http://localhost:8080 by default.
**2. Troubleshooting:**
- Ensure the  database is running and credentials in application.properties are correct.
- If you encounter Hibernate errors, verify the ddl-auto value and database schema.
**3. Preloaded Data Example:**
- The database will be preloaded with sample cars, owners and users automatically. Review the CommandLineRunner implementation in the Application class for details. 
## License
This project is for educational purposes and does not include a specific license. Feel free to use or extend it as you see fit.