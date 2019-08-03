package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;

public class BlackjackHand extends AbstractHand {
	

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		return false;

	}

	public boolean isBust() {
		if (getHandValue() > 21) {

			return true;
		}
		return false;
	}

	public void addCard(Card additional) {

		super.addCard(additional);

	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : super.cards) {
			handValue += card.getValue();

		}

		return handValue;
	}

}
