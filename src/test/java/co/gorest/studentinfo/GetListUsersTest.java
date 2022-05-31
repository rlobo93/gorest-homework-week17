package co.gorest.studentinfo;

import io.restassured.response.Response;
import org.junit.Test;
import testbase.TestBase;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class GetListUsersTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStudentInfo() {
        Response response = given()
                .pathParams("id", 3230)
                .when()
                .get("/{/users}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

//    @Test
//    public void searchStudentWithParameter() {
//        HashMap <String, Object> qParams = new HashMap<>();
//        qParams.put("Program", "Computer Science");
//        qParams.put("limit",2);
//
//        Response response = given()
//                .queryParams(qParams)
//                .when()
//                .get("list");
//        response.then().statusCode(200);
//        response.prettyPrint();
//
//    }

}
