package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Deck;

import com.skilldistillery.cards.common.Deck;

public class GameDriver {
	Scanner kb = new Scanner(System.in);

	private Dealer dealz = new Dealer();
	private Player playerz = new Player();
	int playerTotal, dealerTotal;

	public void launch() {
		System.out.println("Good'ay Welcome to the Wallabee Casino");
		System.out.println("This is the Blackjack Table");
		System.out.println("Let's shuffle this deck before we get started.");
		dealz.shuffle();
		dealz.checkDeckSize();
		System.out.println("Let's begin");
		gamePlay();
	}

	public void gamePlay() {

		playerz.getHand().addCard(dealz.dealCards());
		playerz.getHand().addCard(dealz.dealCards());
		System.out.println("You've got  " + playerz.hand() + "or a collective score of : " + playerz.getValue());

		dealz.getHand().addCard(dealz.dealCards());
		dealz.getHand().addCard(dealz.dealCards());
		System.out.println("The dealer has  " + dealz.getHand() + " a collective score of: " + dealz.getValue());

		if (playerz.getValue() == 21) {
			playerz.getHand().isBlackjack();
			System.out.println("Player wins");

		} else if (dealz.getValue() == 21) {
			dealz.getHand().isBlackjack();
			System.out.println("Dealer wins");

		} else if (dealz.getValue() > 21) {
			dealz.getHand().isBust();
			dealerzBust();
			System.out.println("Dealer loses");

		} else if (playerz.getValue() > 21) {
			playerz.getHand().isBust();
			System.out.println("Player Loses");

		}

		else
			playerOption();

	}

	public void playerOption() {
		boolean playerChoice = true;

		System.out.println("What would you like to do?");
		System.out.println("1. Hit ");
		System.out.println("2. Stay ");
		if (dealz.checkDeckSize() < 15) {
			dealz.shuffle();
		}

		try {
			int userInput = kb.nextInt();

			if (userInput == 1) {
				playerz.getHand().addCard(dealz.dealCards());
				System.out.println(
						"You now have a " + playerz.getHand() + "or a collective score of " + playerz.getValue());
				if (playerz.getHand().getHandValue() < 21) {
					playerOption();
				}

				else if (playerz.getValue() == 21) {
					System.out.println("Player's got Blackjack.");
					dealerPlay();
				} else if (playerz.getHand().getHandValue() > 21) {
					playerz.getHand().isBust();
					playerzBust();
				}

			}

			if (userInput == 2) {
				System.out.println("The amount you stayed with is" + playerz.getHand() + "or a collective of "
						+ playerz.getValue());
				playerChoice = false;
				dealerPlay();

			}
		} catch (InputMismatchException exception) {
			System.out.println("This is not the correct type of input");
			playerOption();
		}

	}

	public void dealerPlay() {
		while (dealz.getValue() <= 17) {
			dealz.getHand().addCard(dealz.dealCards());
			System.out.println("The house has" + dealz.getHand() + "or  " + dealz.getValue());
		}

		if (dealz.getValue() <= 21) {
			dealz.getHand().addCard(dealz.dealCards());
			winner();

		} else if (dealz.getValue() == 21) {
			System.out.println("Dealer has Black Jack.");
			winner();
		} else if (dealz.getValue() > 21) {
			dealz.getHand().isBust();
			dealerzBust();
		}

	}

	public void playerzBust() {
		System.out.println("This hand has bust, house wins.");

	}

	public void dealerzBust() {
		System.out.println("The house has busted, player wins");
	}

	public void winner() {
		if (dealz.getValue() < playerz.getValue()) {
			System.out.println("Player wins ");
		} else if (playerz.getValue() < dealz.getValue()) {
			System.out.println("House wins");
		} else if (dealz.getValue() == playerz.getValue()) {
			System.out.println("This game is a push");

		}

	}
}
