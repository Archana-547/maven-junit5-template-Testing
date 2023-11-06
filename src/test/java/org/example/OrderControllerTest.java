package org.example;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

//postive test
public class OrderControllerTest {

    @Test
    public void successGettingOrder() {
        given()
                .log()
                .all()
                .when()
                .get("http://51.250.6.164:8080/test-orders/5")
                .then()
                .log()
                .all()
                .statusCode(200);


    }
    //Negetive test

    @Test
    public void NegetiveGettingOrder() {
        given()
                .when()
                .get("http://51.250.6.164:8080/test-orders/11")
                .then()
                //.statusCode(400);
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }


    // parametrized test
    @ParameterizedTest
    @ValueSource(ints ={1,2,5,9,10,11})
    public void successGettingOrderAndCheckResonseCode(int orderId) {

        //String URL = "http://51.250.6.164:8080/test-orders/" + orderId;
        given()
                .log()
                .all()
                .when()
                //.get(URL)
                .get("http://51.250.6.164:8080/test-orders/{ orderId}", orderId)
                .then()
                .log()
                .all()
                //.statusCode(200);
                .statusCode(HttpStatus.SC_OK);



    }
}