package org.example;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.example.CardValueMapper.getCardValue;

public class BlackJack {

    public static  void main(String[] args) {

        Response response =
        given().
                log().
                all().
                get("https://deckofcardsapi.com/api/deck/new/").
                then().
                log().
                all().
                extract().
                response();

        // Deserialization
        DeckDto result = new Gson().fromJson(response.asString(), DeckDto.class);

        String deckId = result.getDeck_id();

        String urlForCards = "https://deckofcardsapi.com/api/deck/new/" + deckId + "draw/?count=6";

        String urlForShuffling ="https://deckofcardsapi.com/api/deck/" + deckId + "/shuffle/";

//Drawing cards
        Response responseCards =

        given().
                log().
                all().
                get(urlForCards).
                then().
                log().
                all().
                assertThat().
                extract().
                response();

//Shuffling cards
        given().
                log().
                all().
                get(urlForShuffling).
                then().
                log().
                all();

        // Parse the JSON response using JsonPath
        JsonPath jsonPath = JsonPath.from(response.asString());

        // Extract the ArrayList of "value"
        ArrayList<String> valuesList = jsonPath.get("cards.value");
        System.out.println(valuesList);
        // Convert ArrayList to String[]
        String[] values = valuesList.toArray(new String[0]);


        System.out.println("JACK: " + getCardValue("JACK"));

    }

    }

