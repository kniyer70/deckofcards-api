package com.homepoint.models;

public final class DeckOfCardsResponse {
    private String deck_id;
    private String remaining;
    private String shuffled;
    private String statuscode;
    private String success;

    public String getDeck_id() {
        return deck_id;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public String getShuffled() {
        return shuffled;
    }

    public void setShuffled(String shuffled) {
        this.shuffled = shuffled;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
