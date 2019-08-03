package com.skilldistillery.cards.blackjack;

public abstract class AbstractBlackjackPlayer {
	
	private BlackjackHand hand = new BlackjackHand();
	
	public int getValue() {
		return hand.getHandValue();
	}
	
	public void shuffle(){
		
	}
	
	public void deal(){ 
		
	}
	
	
	
	public String winner(){
		
		
		return null;
		
	}

	public BlackjackHand getHand() {
		return hand;
	}

	public void setHand(BlackjackHand hand) {
		this.hand = hand;
	}

	public int abstractHand() {
		return 0;
	}
	
	

}
