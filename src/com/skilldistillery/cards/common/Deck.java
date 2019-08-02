package com.skilldistillery.cards.common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck<totalCards> {
//	Create a class Deck. It will hold a List of Cards.
	private List<Card> cards;
//	In the constructor, initialize the List with all 52 cards.
	public Deck() {
		this.cards = new ArrayList<>();
		for(Suit suit: Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
				
				
			}
		}
	}
//	Add a method dealCard that removes a Card from the deck.
	public int  checkDeckSize() {
		return cards.size();
		
	}
//	Add a method checkDeckSize which returns the number of cards still in the deck.
public Card dealCards() {
	return cards.remove(0);
}
	//	Add a method shuffle to shuffle the deck.
//	
public void shuffle() {
	Collections.shuffle(cards);
}
	
	
	
	
	
	
	
}

