package org.acme;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

import org.acme.resources.UserResource;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
// @TestHTTPEndpoint(UserResource.class)
public class UserResourceTest {

    @Test
    public void testUsersEndpoint() {

        // Response r = given().headers("Content-Type", ContentType.JSON, "Accept",
        // ContentType.JSON).when().get("/users")
        // .then()
        // .contentType(ContentType.JSON).extract().response();

        // List<String> jsonResponse = r.jsonPath().getList("$");
        // // Want to test that the first element in the array has a value of "Jack"

        // System.out.println(jsonResponse);

        given()
                .when().get("/users")
                .then()
                .statusCode(200);
        // .body("[0]", is("jack"));
    }

    @Test
    public void testPostFunction() {
        given().when().body("{\name\":\"Julie\"}").contentType("application/json").post("/users").then()
                .statusCode(201);
    }

}
