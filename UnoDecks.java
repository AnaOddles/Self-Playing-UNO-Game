/*Name:		Ana Sanchez
 * Date:	11/24/2019
 * File:	UnoDecks.java
 * Purpose: Acts as the class that contains the 
 * 			methods and data fields for 
 * 			the deck objects such as
 * 			the play pile and overall 
 * 			deck.
 * 
 * Statement of Own Work: 
 * This is my own code as
 * influenced by the textbook
 * and class discussions. 
 * 		
 */
package CST_105.GameOfUno;

import java.util.ArrayList;
import java.util.Collections;

public class UnoDecks {
	// Attributes
	
	// Array lists for the different hands
	private ArrayList<Integer> deck = new ArrayList<Integer>();
	private ArrayList<Integer> playPile = new ArrayList<Integer>();

	// Array to control turns
	private String[] playerTurn = { "Player 1", "Player 2", "Player 3", "Player 4" };

	// Index for the play pile
	private int activeCardIndex = 0;

	// Index for the active turn index
	private int turnIndex = 0;

	// int to determine if reverse is active
	private int reverseActive = 1;
	
	//String to determine if the special card was played already and next turn can play normally 
	private String lastAction = "";

	// Constructor
	public UnoDecks() {

	}

	// Method to get the deck
	public ArrayList<Integer> getDeck() {
		// System.out.println("got deck");
		return deck;

	}

	// Method to change/set the decks
	public void setDeck(ArrayList<Integer> deck) {
		System.out.println("updated deck");
		this.deck = deck;

	}
	
	//Method to initialize the deck with a number from 1 to 108
	public void createDeck() {
		for (int i = 1; i < 109; i++) {
			deck.add(i);
		}
		System.out.println("\ncreated deck\n");

	}
	
	//Method to shuffle the deck
	public void shuffleDeck() {
		System.out.println("\nShuffled deck\n ");
		Collections.shuffle(deck);

	}

	//Method to print tht deck
	public void printDeck() {
		System.out.println("DECK");
		// System.out.println("printed deck");
		for (int i = 0; i < deck.size(); i++) {
			System.out.print(" " + deck.get(i) + " ");
		}
		System.out.println("\n");
	}

	//Method to get the size of the deck, for testing purposes 
	public int getDeckSize(ArrayList<Integer> deck) {
		// System.out.println("Got size of deck");
		int sizeOfDeck = 0;
		sizeOfDeck = deck.size();
		return sizeOfDeck;

	}

	//Method to play the first card on deck to play pile, move the card to play pile
	//and delete it from the deck 
	public ArrayList<Integer> startCard(ArrayList<Integer> deck) {
		System.out.println("Placed the first card for play pile");
		int startCard = deck.get(0);
		deck.remove(0);
		playPile.add(startCard);
		return playPile;

	}

	// Method to get the playPile
	public ArrayList<Integer> getPlayPile() {
		// System.out.println("got Play Pile");
		return playPile;

	}

	// Method to change/set the playPile deck
	public void setPlayPile(ArrayList<Integer> playPile) {
		// System.out.println("updated playPile");
		this.playPile = playPile;

	}

	//Method to print the play pile
	public void printPlayPile() {
		System.out.println("\nPLAY PILE");
		// System.out.println("printed play pile");
		for (int i = 0; i < playPile.size(); i++) {
			System.out.print(" " + playPile.get(i) + " ");
		}
		System.out.println();
	}
	
	//Method to get te play pile size
	public int getPlayPileSize(ArrayList<Integer> playPile) {
		int playSize = 0;
		playSize = playPile.size();

		return playSize;

	}

	// method to get the active index of top of card in the playPile
	public int getActiveCardIndex() {
		return activeCardIndex;
	}

	// Method to change/set the active/top card in the playPile
	public void updateActiveCardIndex() {
		// System.out.println("updated index of card in play pile");
		++activeCardIndex;

	}

	//Method to play a card 
	public ArrayList<Integer> playCard(int indexOfMatch, ArrayList<Integer> hand) {
		System.out.println("Card was played");
		updateActiveCardIndex();
		int cardPlayed = hand.get(indexOfMatch);
		hand.remove(indexOfMatch);
		playPile.add(cardPlayed);
		return playPile;

	}

	//Method to draw a card 
	public ArrayList<Integer> drawCard(ArrayList<Integer> hand) {
		System.out.println("card was drawn from deck");
		int cardTopOfDeck = deck.get(0);
		hand.add(cardTopOfDeck);
		deck.remove(0);
		return deck;

	}

	//Method to fill deck if is it empty 
	public ArrayList<Integer> fillDeck(ArrayList<Integer> playPile) {
		int movedCard = 0;
		for (int i = 0; i < playPile.size() - 1; i++) {
			System.out.println("Filling Deck!");
			movedCard = playPile.get(i);
			deck.add(movedCard);
			playPile.remove(i);

		}
		return deck;

	}

	//Method to get the turn index
	public int getTurnIndex() {
		return turnIndex;
	}
	
	//Method to update the turn index, move to next turn 
	public void updateTurnIndex() {
		//if we are reversing, we are going to subtract 
		if (reverseActive % 2 ==0) {
			if(turnIndex==0) {
				turnIndex= 3;
			}
			else {
				turnIndex--;
			}
		}
		//we are not in reverse mode, do normal adding to turn 
		else {
			if(turnIndex == 3) {
				turnIndex = 0;
			}
			else {
				turnIndex++;
			}
		}
	}
	
	
	//Method to get the value to deterine if we are in reverse or not 
	public int getReverseActive() {
		return reverseActive;
	}
	
	//Method to get the player turn 
	public String getPlayerTurn() {
		String turn = playerTurn[turnIndex];
		return turn;
	}
	
	//Method to play any card, if there is a wild card 
	public ArrayList<Integer> playAnyCard(ArrayList<Integer> hand){
		System.out.println("WILD CARD, any card was played");
		updateActiveCardIndex();
		int cardPlayed = hand.get(0);
		hand.remove(0);
		playPile.add(cardPlayed);
		return playPile;
		
	}
	
	//Method for the draw two card, if there is a draw 2 card
	public ArrayList<Integer> drawTwo (ArrayList<Integer> hand){
		for(int i = 0; i < 2; i++) {
			int cardTopDeck = deck.get(0);
			hand.add(cardTopDeck);
			deck.remove(0);
		}
		return deck;
		
	}
	
	//Method for the draw four card, if there is a draw 4 card
	public ArrayList<Integer> drawFour (ArrayList<Integer> hand){
		for(int i = 0; i < 4; i++) {
			int cardTopDeck = deck.get(0);
			hand.add(cardTopDeck);
			deck.remove(0);
		}
		return deck;
		
	}
	
	//Method for the skip turn, if there is a skip card
	public void skipTurn() {
		System.out.println("Turn was skipped");
		if(turnIndex==0) {
			turnIndex = 2;
		}
		else if(turnIndex==1) {
			turnIndex = 3;
		}
		else if(turnIndex==2) {
			turnIndex = 0;
		}
		else {
			turnIndex = 1;
		}
	}
	
	//Method to switch the reverse value, every time the card is played 
	public void reverse() {
		reverseActive++;
	}
	
	//Mthod to get the last action, occuring on turn 
	public String getLastAction(){
		return lastAction;
	}
	
	//Method to uodate, set the last action
	public void updateLastAction(String type) {
		lastAction = type;
		
	}

}
