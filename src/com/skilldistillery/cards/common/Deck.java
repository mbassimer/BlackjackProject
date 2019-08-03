package com.skilldistillery.cards.common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
//	Create a class Deck. It will hold a List of Cards.
	private List<Card> cards;

//	In the constructor, initialize the List with all 52 cards.
	public Deck() {
		this.cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));

			}
		}
	}

	public int checkDeckSize() {
		return cards.size();

	}

	public Card dealCards() {
		return cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}


}
