package lesson6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class Lesson6Application {

    /**
     * <strong>Homework 7</strong>
     * <p>Make sure your application starts with h2 database with console and set application to generate tables based on entities.✔
     * <p>Remove implementations of repositories.✔
     * <p>Adjust existing repositories to become JPA repositories.✔
     * <p>Adjust {@link Car} and {@link User} so they become entities and their id is autogenerated.✔
     * <p>Create new entity {@link com.devcors.javaacademy.lesson6.data.entity.BorrowedCar}, that will contain id of user and car.✔
     * <p>Create new repository for this entity.✔
     * <p>Create endpoints:</p>
     * <ul>
     *     <li><strong>POST /users</strong>, that creates new user</li>✔
     *     <li><strong>PUT /users/{id}</strong>, that updates existing user. Endpoint retrieves http status 400 in case user does not exist</li>✔
     *     <li><strong>DELETE /users/{id}</strong>, that deletes existing user</li>✔
     *
     *     <li><strong>PUT /users/{userId}/car/borrow/{carId}</strong>, that causes user to borrow car</li>
     *     <li><strong>PUT /users/{userId}/car/return/{carId}</strong>, that causes user to return car (Borrowed car will be deleted from database)</li>
     *     <li><strong>GET /users/{userId}/car</strong>, that retrieves all borrowed cars of user</li>
     *
     *     <li><strong>POST /cars</strong>, that creates new car</li>✔
     *     <li><strong>PUT /cars/{id}</strong>, that updates existing car. Endpoint retrieves http status 400 in case car does not exist</li>✔
     *     <li><strong>DELETE /cars/{id}</strong>, that deletes existing car</li>✔
     *     <li><strong>GET /cars/filter?brandName=Audi</strong>, with brandName query parameter, which is required and used to retrieve cars with this brand</li>✔
     * </ul>
     * <p>Extend junit tests to also test your implementation of endpoints working with borrowed cars (/users/{userId}/car/* endpoints).
     * <p>Optional: for PUT and POST endpoints creating/updating cars and users, create new DTO (data transfer object - new class only containing variables)
     * and use this DTO as a request to these endpoints. This DTO should not contain "id".
     * <p>Warning: "user" and "year" are reserved words for H2 database, therefore you need to name table/column differently - for example adding underscore as suffix.✔
     * <p>To test your implementation, you can use CarControllerIntegrationTest and UserControllerIntegrationTest,✔
     * which starts application as a spring boot application and try to reach your REST endpoints.✔
     * <p>This application should also be startable as a Spring boot application.✔
     * <p>And remember - google is your friend :)
     */
    public static void main(String[] args) {
        SpringApplication.run(Lesson6Application.class, args);
    }

}
