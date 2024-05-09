## Setup Instructions
1. **Clone the Repository**
    - Clone this repository to your local machine using the following command:
      ```
      git clone git@github.com:DrengeneFraKEA/HMS-Rating.git
      ```

2. **Open the Project**
    - Navigate to the project directory in your terminal or file explorer:
      ```
      cd rating_microservice
      ```

3. **Install MySQL Docker Image**
     - Ensure you have Docker installed on your system.
     - Run the following command in your terminal to pull the MySQL Docker image:
      ```
      docker pull mysql
      ```

4. **Run MySQL Container**
    - Start a MySQL container using the following command:
      ```
      docker run --name=mysql-container -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=rating_microservice -d mysql
      ```
      Replace `password` with your root password.

5. **Ensure Configuration Consistency**
    - Ensure that the MySQL configuration in the `application.properties` file matches the settings used when starting the MySQL container:
      ```
      spring.datasource.url=jdbc:mysql://localhost:3306/rating_microservice
      spring.datasource.username=root
      spring.datasource.password=password
      ```

6. **Create Docker Network**
    - Create a Docker network and connect it to the MySQL container to allow communication between containers:
      ```
      docker network create my-network
      docker network connect my-network mysql-container
      ```

7. **Build the Application**
    - Click on "Maven" in your IDE to clean and install the project.

8. **Build Docker Image**
    - Build a Docker image of the Spring Boot application using the provided Dockerfile:
      ```
      docker build -t my-spring-app .
      ```

9. **Run Docker Container**
    - Run the Docker container using the following command:
      ```
      docker run --name=spring-container -p 8090:8080 --network=my-network -e MYSQL_HOST=mysql-container -e MYSQL_PORT=3306 -e MYSQL_DB_NAME=rating_microservice -e MYSQL_USER=root -e MYSQL_PASSWORD=password my-spring-app
      ```



