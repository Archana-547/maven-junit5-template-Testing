package org.example;

import Helper.SetupFunctions;
import com.google.gson.Gson;
import dto.LoginDto;
import dto.TestOrderDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class LoginFeatureTest {

    @BeforeAll
    public static void setup(){
        SetupFunctions setupFunctions = new SetupFunctions();
        setupFunctions.getUsername();
        setupFunctions.getPassword();
        System.out.println("Username:"+ setupFunctions.getUsername());
        System.out.println("Password:"+ setupFunctions.getPassword());

    }

    @Test
    public void sucessfullLoginTest(){
        //creating instance of loginDto class
        SetupFunctions setupFunctions = new SetupFunctions();
        LoginDto login = new LoginDto(setupFunctions.getUsername(),setupFunctions.getPassword());

        //seralization
        String loginDtoAsJson = new Gson().toJson(login);

       Response response = given().
                log().
                all().
                header("Content-Type", "application/json").
               //header("Bearer Token", "Token_VALUE").
                body(loginDtoAsJson).
                post("http://51.250.6.164:8080/login/student").
                then().
                log().
                all().
               extract().
              response();
              //statusCode(HttpStatus.SC_OK);
            Assertions.assertEquals("", response.asString());
            Assertions.assertEquals(401, response.getStatusCode());

    }
@Test
    public  void  unsucessfullLoginTest(){

        //creating instance of loginDto class
    LoginDto login = new dto.LoginDto("archanatuku", "p5Twdy7");

    //serialization
    String loginDtoAsJson = new Gson().toJson(login);
    given().
            log().
            all().
            header("Content-Type", "application/json").
            body(loginDtoAsJson).
            post("http://51.250.6.164:8080/login/student").
            then().
            log().
            all().
            statusCode(HttpStatus.SC_UNAUTHORIZED);

}

}


