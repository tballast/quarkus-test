package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UserResourceTest {

    @Test
    public void testUsersEndpoint() {

        Response r = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().get("/users")
                .then()
                .contentType(ContentType.JSON).extract().response();

        List<String> jsonResponse = r.jsonPath().getList("$");
        // Want to test that the first element in the array has a value of "Jack"

        System.out.println(jsonResponse);

        // given()
        // .when().get("/users")
        // .then()
        // .statusCode(200)
        // .body("[0].name", equals("Jack"));
    }

    // @Test
    // public void testGreetingEndpoint() {
    // String uuid = UUID.randomUUID().toString();
    // given()
    // .pathParam("name", uuid)
    // .when().get("/hello/greeting/{name}")
    // .then()
    // .statusCode(200)
    // .body(is("hello " + uuid));
    // }
}
