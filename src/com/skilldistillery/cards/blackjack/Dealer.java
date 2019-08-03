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

	public void shuffle() {

		cards.shuffle();

	}

	public Card dealCards() {

		return cards.dealCards();

	}


	@Override
	public String winner() {

		return super.winner();
	}

}
