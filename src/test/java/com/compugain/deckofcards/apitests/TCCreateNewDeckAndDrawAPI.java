package com.compugain.deckofcards.apitests;

import com.compugain.deckofcards.helper.DeckOfCards;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.ArrayList;
//Combining test cases to take advantage of the newly created deck for testing the draw functionality
public class TCCreateNewDeckAndDrawAPI extends DeckOfCards {
    private String newDeckIDWithoutJoker = "";
    private String newDeckIDWithJoker = "";
    private int newDeckNumberOfCards = 0;

    @Test(priority = 1)
    private void CreateNewDeckOfCardsWithoutJokerSuccess() {
        ArrayList<Object> newDeckVals = getNewDeckID();
        Assert.assertEquals(newDeckVals.get(0).toString(), "200");
        newDeckIDWithoutJoker = newDeckVals.get(1).toString();
        Assert.assertEquals(newDeckVals.get(2).toString(), "52");
    }

    @Test(priority = 2)
    private void CreateNewDeckOfCardsWithJokerSuccess() {
        ArrayList<Object> newDeckVals = getNewDeckID("true");
        Assert.assertEquals(newDeckVals.get(0).toString(), "200");
        newDeckIDWithJoker = newDeckVals.get(1).toString();
        Assert.assertEquals(newDeckVals.get(2).toString(), "54");
    }

    @Test(priority = 3)
    private void DrawCardWithoutJokerSuccess() {
        ArrayList<Object> cardDrawVals = getDrawCardDeckIDParm(newDeckIDWithoutJoker);
        Assert.assertEquals(cardDrawVals.get(0).toString(), "200");
        Assert.assertEquals(newDeckIDWithoutJoker, cardDrawVals.get(2).toString());
        Assert.assertTrue(Integer.parseInt(cardDrawVals.get(4).toString()) < 52, "Deck Draw Function is not working..!!!");
    }

    @Test(priority = 4)
    private void DrawCardWithJokerSuccess() {
        ArrayList<Object> cardDrawVals = getDrawCardDeckIDParm(newDeckIDWithJoker);
        Assert.assertEquals(cardDrawVals.get(0).toString(), "200");
        Assert.assertEquals(newDeckIDWithJoker, cardDrawVals.get(2).toString());
        Assert.assertTrue(Integer.parseInt(cardDrawVals.get(4).toString()) < 54, "Deck Draw Function is not working..!!!");
    }
}

