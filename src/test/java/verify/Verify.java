package verify;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Verify {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }


    @Test
    public void test001() {

        List<Object> data = response.extract().path("");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total Record are 20 : " + data.size());
        System.out.println("------------------End of Test---------------------------");
    }


    @Test
    public void test002() {

        List<String> name = response.extract().path("findAll{it.id == 3830}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id 3830 name Bhargava Dutta : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test003() {

        List<String> email = response.extract().path("findAll{it.id == 3820}.email");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id 3830 has email bhargava_dutta@zemlak.io : " + email);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test004() {

        List<HashMap<String, ?>> status = response.extract().path("findAll{it.status == 'active'}.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(".All ID has status = active : " + status);
        System.out.println("------------------End of Test---------------------------");
    }


    @Test
    public void test005() {

        List<String> gender = response.extract().path("findAll{it.id ==3823}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id 3823 gender is female   : " + gender);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test006() {

        List<String> gender = response.extract().path("findAll{it.id ==3830}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id 3830 gender male : " + gender);
        System.out.println("------------------End of Test---------------------------");
    }

    

}
