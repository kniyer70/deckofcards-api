package com.compugain.deckofcards.helper;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class DeckOfCards {
    final static String url="http://deckofcardsapi.com/api/deck/";

    //This will fetch the response body as is and log it. given and when are optional here
    public static ArrayList<Object> getNewDeckID() {
        ArrayList<Object> newDeckVals = new ArrayList<>();
        Response response = when().get(url + "new").then().extract().response();
        newDeckVals.add(Integer.toString(response.statusCode()));
        newDeckVals.add(response.jsonPath().getString("deck_id"));
        newDeckVals.add(response.jsonPath().getString("remaining"));
        return newDeckVals;
    }

    public static ArrayList<Object> getNewDeckID(String jokersEnabled) {
        ArrayList<Object> newDeckVals = new ArrayList<>();
        Response response = given().queryParam("jokers_enabled", jokersEnabled).when().get(url + "new").
                then().extract().response();
        newDeckVals.add(Integer.toString(response.statusCode()));
        newDeckVals.add(response.jsonPath().getString("deck_id"));
        newDeckVals.add(response.jsonPath().getString("remaining"));
        return newDeckVals;
    }

    public static ArrayList<Object> getDrawCardDeckIDParm(String deckID){
        String drawURL = url + deckID + "/draw/";
        ArrayList<Object> drawCardResponseVals = new ArrayList<>();
        Response response = when().get(drawURL).then().extract().response();
        drawCardResponseVals.add(Integer.toString(response.statusCode()));
        drawCardResponseVals.add(response.jsonPath().getString("success"));
        drawCardResponseVals.add(response.jsonPath().getString("deck_id"));
        drawCardResponseVals.add(response.jsonPath().getString("shuffled"));
        drawCardResponseVals.add(response.jsonPath().getString("remaining"));
        ArrayList<Map<String, String>> actualCards = response.jsonPath().getJsonObject("cards");
        for (String key : actualCards.get(0).keySet()){
            if(key.equalsIgnoreCase("code") ||key.equalsIgnoreCase("value") ||key.equalsIgnoreCase("suit")){
                drawCardResponseVals.add(actualCards.get(0).get(key));
            }
        }
        return drawCardResponseVals;
    }

    public static void main(String args[]) {

    }
}
