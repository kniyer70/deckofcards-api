package com.homepoint.deckofcards.apitests;

import com.homepoint.deckofcards.helper.DeckOfCards;
import com.homepoint.models.DeckOfCardsResponse;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
//Combining test cases to take advantage of the newly created deck for testing the draw functionality
//Remove the order dependency
//Make Test Case names more meaning full
//Create DeckOFCards Object rather than using static class methods
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//Setting the order of Testcases so I can leverage the Decks created and demonstrate the Ordering feature in Junit5.
//   - Although in my opinion it is recommended not to introduce these dependencies amongst test cases, I just used it for my convenience so I do
//     not have to create another deck of cards and also show of the order feature in JUnit5.
public class TestCasesForDeckOfCardsAPI {
    static DeckOfCards deckOfCards = new DeckOfCards();
    static DeckOfCardsResponse deckOfCardsResponseWithJoker = new DeckOfCardsResponse();
    static DeckOfCardsResponse deckOfCardsResponseWithoutJoker = new DeckOfCardsResponse();

    @Test
    @Order(1)
    public void GivenCreateNewDeckOfCardsWhenJokersEnabledIsFalseThenSuccess() {
        DeckOfCardsResponse newDeckVals = deckOfCards.getNewDeckID();
        assertEquals(newDeckVals.getStatuscode(), "200");
        deckOfCardsResponseWithoutJoker.setDeck_id(newDeckVals.getDeck_id());
        assertEquals(newDeckVals.getRemaining(), "52");
    }

    @Test
    @Order(2)
    public void GivenCreateNewDeckOfCardsWhenJokersEnabledIsTrueThenSuccess() {
        DeckOfCardsResponse newDeckVals = deckOfCards.getNewDeckID("true");
        assertEquals(newDeckVals.getStatuscode(), "200");
        deckOfCardsResponseWithJoker.setDeck_id(newDeckVals.getDeck_id());
        assertEquals(newDeckVals.getRemaining(), "54");
    }

    @Test
    @Order(3)
    public void GivenDrawACardWhenJokersEnabledIsFalseThenSuccess() {
        DeckOfCardsResponse cardDrawVals = deckOfCards.getDrawCardDeckIDParm(deckOfCardsResponseWithoutJoker.getDeck_id());
        assertEquals(cardDrawVals.getStatuscode().toString(), "200");
        assertEquals(deckOfCardsResponseWithoutJoker.getDeck_id(), cardDrawVals.getDeck_id());
        assertTrue(Integer.parseInt(cardDrawVals.getRemaining()) < 52, "Deck Draw Function is not working..!!!");
    }

    @Test
    @Order(4)
    public void GivenDrawACardWhenJokersEnabledIsTrueThenSuccess() {
        DeckOfCardsResponse cardDrawVals = deckOfCards.getDrawCardDeckIDParm(deckOfCardsResponseWithJoker.getDeck_id());
        assertEquals(cardDrawVals.getStatuscode(), "200");
        assertEquals(deckOfCardsResponseWithJoker.getDeck_id(), cardDrawVals.getDeck_id().toString());
        assertTrue(Integer.parseInt(cardDrawVals.getRemaining()) < 54, "Deck Draw Function is not working..!!!");
    }
}

