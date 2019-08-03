package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Deck;

public class GameDriver {
	Scanner kb = new Scanner(System.in);

	private Dealer dealz = new Dealer();
	private Player playerz = new Player();

	public void Launch() {
		System.out.println("Welcome to the Blackjack table mate");
		System.out.println("Let's shuffle this deck before we get started.");
		dealz.shuffle();
		System.out.println("Let's begin");

		playerz.getHand().addCard(dealz.dealCards());
		playerz.getHand().addCard(dealz.dealCards());
		System.out.println("You've got  " + playerz.hand());
		dealz.getHand().addCard(dealz.dealCards());
		dealz.getHand().addCard(dealz.dealCards());
		System.out.println("The dealer has  " + dealz.getHand());
		playerTurn();

	}

	public int playerTurn() {

		System.out.println("What would you like to do?");
		System.out.println("1. Hit ");
		System.out.println("2. Stay ");

		int userInput = kb.nextInt();
		try {
			if (userInput == 1) {
				hit();
			}

			else if (userInput == 2) {
				stay();
			}
		} catch (InputMismatchException exception) {
			System.out.println("This is not the correct type of input");
		}

		return 0;
	}

	public void hit() {
		while (playerz.getValue() <= 21)
		playerz.getHand().addCard(dealz.dealCards());
		System.out.println("your hand is now  " + playerz.getHand());
		dealerPlay();

		 if(playerz.getHand().isBust()){
			 System.out.println("Sorry your turn is over");
			 
		 }else if(playerz.getHand().isBlackjack()) {
			 System.out.println("Player has blackjack");
		 }

	}

	public void stay() {
		System.out.println("Your current hand is " + playerz.getHand());
		dealerPlay();

	}

	public void dealerPlay() {
		while (dealz.getValue() < 17) {
			dealz.getHand().addCard(dealz.dealCards());

		}
		if (dealz.getHand().isBust()) {
			System.out.println("The game is over for the dealer");
		}
	}

}
