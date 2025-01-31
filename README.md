# demoDBMS

## Project Description

demoDBMS is a simple demo of SpringBoot and MySQL connection and implemented CRUD operations

## Prerequisites

Ensure you have the following installed on your system:
- Java 17 or later
- Maven 3.8+
- MySQL 

## Installation and Setup

1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd demoDBMS
   ```
2. Configure the database settings in `application.properties` or `application.yml` (located in `src/main/resources/`). Example:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=root
   spring.datasource.password=password
   ```
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints

### Database Operations
- **Create User**: `POST /api/users`
- **Update User**: `POST /api/users/{id}`
- **Get User**: `GET /api/users`
- **Delete User**: `DELETE /api/users/{id}`

## Expected API Responses

Each API response follows a structured format:
```json
{
  "status": "success",
  "message": "Operation completed successfully",
  "data": { ... }
}
```
For errors:
```json
{
  "status": "error",
  "message": "Error description"
}
```
