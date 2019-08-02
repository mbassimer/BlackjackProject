package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHand {

	protected List<Card> cards;
	
	public AbstractHand() {
		cards = new ArrayList<>();
	}
	
	public void addCArd(Card card) {
		cards.add(card);
	}
	public void clear() {
		cards.clear();
	}
	
	public abstract int getHandValue();
	
	public String toString() {
		//fancy display of cards in hand?
		return cards.toString();
	}
	
}
