﻿# Project

## Technologies Used

- Java 17
- Spring Boot
- Maven
- Thymeleaf
- PostgreSQL

## Setup Instructions

1. Clone the repository:

   ```bash
git clone https://github.com/gracielastoimenova/XGateInternTask.git

2. Navigate to the project directory:

cd XGateInternTask

3. Set up the PostgreSQL database:

Create a new PostgreSQL database named project_database:

CREATE DATABASE project_database;

4. Restore the database from the backup:

Use the provided SQL dump file to restore the database. Make sure you have the backup file (project_database_backup.sql) in an accessible location, and then run:

psql -U your_username -d project_database -f path/to/project_database_backup.sql
Replace your_username with your PostgreSQL username and adjust the path to the location of your backup file.

Alternatively, you can create a new database in pgAdmin 4, right-click on it, select Restore, then choose the project_database_backup.sql file and click Restore.

5. Configure the application properties:

Update the src/main/resources/application.properties file with your database credentials:

spring.datasource.url=jdbc:postgresql://localhost:5432/project_database
spring.datasource.username=your_username
spring.datasource.password=your_password

6. Import the project into your IDE (e.g., IntelliJ IDEA, Eclipse).

7. Install dependencies:

Ensure you have Maven installed, and then run:
mvn clean install

8. Run the application

9. Access the application: 

Use the correct URL format to access the application:
http://localhost:8080/login



