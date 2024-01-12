package org.example;

import Helper.Authorization;
import com.google.gson.Gson;
import dto.LoginDto;
import dto.TestOrderDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCreation {
    static String token;

    @BeforeAll
    public static void setUp() {
        token = Authorization.getToken();
        System.out.println(token);
        System.out.println("This token is before all area" + token);
    }

    @Test
    public void createOrder() {

        String customerName = "Any Name";
        String customerPhone = "676688";
        String Comment = " quick delivery";
        //creating instance of createDto class or dto creation with constructor
        //TestOrderDto orderDto = new TestOrderDto("Archana", "123445","comment");
        //TestOrderDto orderDto = new TestOrderDto(customerName, "123445","comment");// for first assert
        //TestOrderDto orderDto = new TestOrderDto(customerName, customerPhone,"comment");// for second assert
        TestOrderDto orderDto = new TestOrderDto(customerName, customerPhone, Comment);// for third assert

        //serialization
        String orderDtoAsJson = new Gson().toJson(orderDto);

        Response response = given().
                log().
                all().
                header("Content-Type", "application/json").
                // header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcmNoYW5hIiwiZXhwIjoxNzAwMTAxNDg3LCJpYXQiOjE3MDAwODM0ODd9.FfyoIHV90SjJZO3wBLFb69FSJFytGQf1ek2U60HbpC7HJfpL556nWCAfEBNsa_w2BNbRor1Ssxj4lxfLlhY1Bw").
                        header("Authorization", "Bearer " + token).
                body(orderDtoAsJson).
                post("http://51.250.6.164:8080/orders").
                then().
                log().
                all().
                //assertThat().
                // statusCode(HttpStatus.SC_OK);
                        extract().
                response();
        //Deserialization
        TestOrderDto resultReceived = new Gson().fromJson(response.asString(), TestOrderDto.class);
        assertEquals("OPEN", resultReceived.getStatus());
        assertEquals(customerName, resultReceived.getCustomerName());
        assertEquals(customerPhone, resultReceived.getCustomerPhone());
        assertEquals(Comment, resultReceived.getComment());
        assertEquals(HttpStatus.SC_OK, response.getStatusCode());

// AssertAll
        assertAll("Grouped Assertions of Created Order",
                () -> assertEquals("676688", orderDto.getCustomerPhone(), "Customer ph number "),
                () -> assertEquals("Any Name", orderDto.getCustomerName(), "Customer Name")
        );

    }
        @Test
        public void getOrderById () {

            given().
                    log().
                    all().
                    header("Content-Type", "application/json").
                    // header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcmNoYW5hIiwiZXhwIjoxNzAwMTAxNDg3LCJpYXQiOjE3MDAwODM0ODd9.FfyoIHV90SjJZO3wBLFb69FSJFytGQf1ek2U60HbpC7HJfpL556nWCAfEBNsa_w2BNbRor1Ssxj4lxfLlhY1Bw").
                            header("Authorization", "Bearer " + token).
                    //body(orderDtoAsJson).
                            get("http://51.250.6.164:8080/orders/4859").
                    then().
                    log().
                    all().
                    assertThat().
                    statusCode(HttpStatus.SC_OK);


        }
    }


