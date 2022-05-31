package co.gorest.studentinfo;


import co.gorest.model.StudentPojo;
import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBase;

import static io.restassured.RestAssured.given;


public class PatchUpdateUserTest extends TestBase {

    @Test
    public void updateStudentWithPatch(){

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setName("ronny");
        studentPojo.setEmail("r111225@gmail.com");
        studentPojo.setStatus("active");
        studentPojo.setGender("male");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 5a08acd60a4f9f76dd28e583fa505a76eeaa98e3da1658ee53c924cac7b1d8d1")
                .body(studentPojo)
                .pathParams("id",3830)
                .when()
                .patch("/{/id}");
                response.then().statusCode(200);
                response.prettyPrint();

            }
}
