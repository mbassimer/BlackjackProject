package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
public class Dealer extends AbstractBlackjackPlayer {

	private Deck cards = new Deck();


	public Dealer() {

	}

	public BlackjackHand hand() {
		return super.getHand();

	}
	
	public int checkDeckSize() {
		System.out.println("The table has  "+ cards.checkDeckSize() + " cards") ;
		return 0;
		
	}

	public void shuffle() {

		cards.shuffle();

	}

	public Card dealCards() {

		return cards.dealCards();

	}



}
