package co.gorest.studentinfo;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class DeleteUserTest {


    @Test
    public void deleteId(){
        Response response = given()
                .pathParams("id", 16)
                .when()
                .delete("/{users}");
        response.then().statusCode(200);
        response.prettyPrint();



    }

}
