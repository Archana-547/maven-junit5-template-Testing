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

public class OrderCreation {
    static String token;

    @BeforeAll
    public static void setUp(){
        token = Authorization.getToken();
        System.out.println(token);
        System.out.println("This token is before all area" +token);
    }
@Test
    public void createOrder(){
        //creating instance of createDto class or dto creation with constructor
        TestOrderDto orderDto = new TestOrderDto("New order", "123445","comment");

        //serialization
        String orderDtoAsJson = new Gson().toJson(orderDto);

       given().
                log().
                all().
                header("Content-Type", "application/json").
               // header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcmNoYW5hIiwiZXhwIjoxNzAwMTAxNDg3LCJpYXQiOjE3MDAwODM0ODd9.FfyoIHV90SjJZO3wBLFb69FSJFytGQf1ek2U60HbpC7HJfpL556nWCAfEBNsa_w2BNbRor1Ssxj4lxfLlhY1Bw").
                       header("Authorization", "Bearer "+ token).
                body(orderDtoAsJson).
                post("http://51.250.6.164:8080/orders").
                then().
                log().
                all().
               //assertThat().
               statusCode(HttpStatus.SC_OK);


    }

    @Test
    public void  getOrderById(){

        given().
                log().
                all().
                header("Content-Type", "application/json").
               // header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhcmNoYW5hIiwiZXhwIjoxNzAwMTAxNDg3LCJpYXQiOjE3MDAwODM0ODd9.FfyoIHV90SjJZO3wBLFb69FSJFytGQf1ek2U60HbpC7HJfpL556nWCAfEBNsa_w2BNbRor1Ssxj4lxfLlhY1Bw").
                header("Authorization", "Bearer "+ token).
                //body(orderDtoAsJson).
                get("http://51.250.6.164:8080/orders/4859").
                then().
                log().
                all().
                assertThat().
                statusCode(HttpStatus.SC_OK);




    }
}


