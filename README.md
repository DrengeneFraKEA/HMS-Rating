## Setup Instructions
1. **Install my Images**
     - Ensure you have Docker installed on your system.
     - Run the following command in your terminal to pull the images:
      ```
      docker pull abdimo101/mysql:v1.0
      docker pull abdimo101/rating_microservice
      ```

2. **First run MySQL Container**
    - Start a MySQL container using the following command:
      ```
      docker run --name=rating-mysql -e MYSQL_ROOT_PASSWORD=password123 -e MYSQL_DATABASE=rating_microservice -d abdimo101/mysql:v1.0
      ```

3. **Create Docker Network**
    - Create a Docker network and connect it to the MySQL container to allow communication between containers:
      ```
      docker network create my-network
      docker network connect my-network rating-mysql
      ```
9. **Run the Rating Container**
    - Run the Rating container using the following command:
      ```
      docker run --name=rating-container -p 8090:8080 --network=my-network -e MYSQL_HOST=mysql-container -e MYSQL_PORT=3306 -e MYSQL_DB_NAME=rating_microservice -e MYSQL_USER=root -e MYSQL_PASSWORD=password123 docker pull abdimo101/rating_microservice
      ```



