package com.homepoint.deckofcards.helper;
import com.homepoint.models.DeckOfCardsResponse;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public final class DeckOfCards {
    final static String url="http://deckofcardsapi.com/api/deck/";

    //This will fetch the response body as is and log it. given and when are optional here
    public final static DeckOfCardsResponse getNewDeckID() {
        DeckOfCardsResponse newDeckVals = new DeckOfCardsResponse();
        Response response = given().baseUri(url).basePath("new").get().then().extract().response();
        newDeckVals.setStatuscode(Integer.toString(response.statusCode()));
        newDeckVals.setDeck_id(response.jsonPath().getString("deck_id"));
        newDeckVals.setRemaining(response.jsonPath().getString("remaining"));
        return newDeckVals;
    }

    public final static DeckOfCardsResponse getNewDeckID(String jokersEnabled) {
        //Tried implementing POST but it does not work as we are getting a 301 Error: The only way to make it a POST is follows:
        // http://biercoff.com/why-rest-assured-doesnt-redirect-post-requests/
        //        Ask developers to return 303 code as a redirect for POST code
        //        Change POST call to Get and then redirect will work properly
        //        Or you could manually redirect yourself by:
        //          taking Location from response of the first call
        //          Merging cookies from one request to another
        //          Make new request with needed headers\cookies to a extracted location and then verifying that redirect intention was correct.
        DeckOfCardsResponse newDeckVals = new DeckOfCardsResponse();
        String body = "{\"jokers_enabled\": " + jokersEnabled + "}";
        Response response = given()
                .config(RestAssuredConfig.config().redirect(RedirectConfig.redirectConfig().followRedirects(true)))
                              .baseUri(url)
                              .basePath("new")
                              .queryParam("jokers_enabled", jokersEnabled)
                            .when()
                              .get()
                            .then()
                              .extract()
                              .response();
        newDeckVals.setStatuscode(Integer.toString(response.statusCode()));
        newDeckVals.setDeck_id(response.jsonPath().getString("deck_id"));
        newDeckVals.setRemaining(response.jsonPath().getString("remaining"));
        return newDeckVals;
    }

    public final static DeckOfCardsResponse getDrawCardDeckIDParm(String deckID){
        //String drawURL = url + deckID + "/draw/";
        DeckOfCardsResponse drawCardResponseVals = new DeckOfCardsResponse();
        Response response = given()
                .baseUri(url)
                .when()
                .get("{deckID}/draw/", deckID)
                .then()
                .extract()
                .response();
        //Response response = when().get(drawURL).then().extract().response();
        drawCardResponseVals.setStatuscode(Integer.toString(response.statusCode()));
        drawCardResponseVals.setDeck_id(response.jsonPath().getString("deck_id"));
        drawCardResponseVals.setRemaining(response.jsonPath().getString("remaining"));
        return drawCardResponseVals;
    }

    public static void main(String args[]) {

    }
}
