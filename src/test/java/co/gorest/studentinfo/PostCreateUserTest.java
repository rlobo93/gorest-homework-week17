package co.gorest.studentinfo;


import co.gorest.model.StudentPojo;
import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBase;

import static io.restassured.RestAssured.given;


public class PostCreateUserTest extends TestBase {

    @Test
    public void createUser() {


        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setName("ron");
        studentPojo.setGender("Jira");
        studentPojo.setEmail("r1225@gmail.com");
        studentPojo.setStatus("active");


        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 5a08acd60a4f9f76dd28e583fa505a76eeaa98e3da1658ee53c924cac7b1d8d1")
                .body(studentPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();


    }
}
