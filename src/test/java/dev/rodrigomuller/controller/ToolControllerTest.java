package dev.rodrigomuller.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ToolControllerTest {
    @Test
    public void testOffersEndpointShouldReturn200() {
        given()
                .when().get("/tools")
                .then()
                .statusCode(200);
    }

    @Test
    public void testMeOffersEndpointWithoutTokenShouldReturn401() {
        given()
                .when().get("/tools/me")
                .then()
                .statusCode(401);
    }


}
