package com.dimipet.blackjack;

public class Card {
	
	//FIXME turn to enum with values
	
    private String face;
    private int value;
    

    public Card() {
    	
    }
    
    public Card(String face, int value) {
        this.face = face;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String getFace() {
        return this.face;
    }

}