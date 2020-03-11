package com.logiccache.hotel.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AvailabilityControllerIT {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    @Ignore
    public void canGetASingleCharacter() throws Exception {
        given().log().all()
                .get("/hotel/bookings?customerId=100")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .log().all()
                .body("name", equalTo("Mickey Mouse"));
    }

    @Test
    @Ignore
    public void canFetchAll() throws Exception {
        Response response = given()
                .log().all()
                .get("/test-app/characters")
                .then()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .log().all()
                .body("list.size()", is(3))
                .extract().response();

        List<Character> characters = Arrays.asList(response.getBody().prettyPeek().as(Character[].class));
        assertThat(characters).extracting("name")
                .contains("Mickey Mouse", "Mr. Bean", "Oliver Twist")
                .doesNotContain("Paddington Bear", "Superman");
    }

}
