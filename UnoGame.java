/*Name:		Ana Sanchez
 * Date:	11/24/2019
 * File:	UnoGame.java
 * Purpose: Acts as my driver for my uno game. 
 * 			Links with other classes
 * 			UnoDecks, UnoHands, UnoCards
 * 
 * Statement of Own Work: 
 * This is my own code as
 * influenced by the textbook
 * and class discussions. 
 * 		
 */

package CST_105.GameOfUno;

import java.util.ArrayList;

public class UnoGame {

	public static void main(String[] args) {

		System.out.println("Game started");

		// Make a new instance of the deck object for the deck
		UnoDecks gameDeck = new UnoDecks();

		// Start game preparation

		// Set up deck for game
		gameDeck.createDeck();
		gameDeck.printDeck();
		gameDeck.shuffleDeck();
		gameDeck.printDeck();
		System.out.println();

		// Pass our deck into a var so we can manipulate
		ArrayList<Integer> deck = gameDeck.getDeck();

		// Player One Hand
		UnoHands handOne = new UnoHands();
		handOne.dealHand(deck);
		gameDeck.setDeck(deck);
		System.out.println();
		System.out.println("Player One Hand");
		handOne.printHand();
		gameDeck.printDeck();

		// Player Two Hand
		UnoHands handTwo = new UnoHands();
		handTwo.dealHand(deck);
		gameDeck.setDeck(deck);
		System.out.println();
		System.out.println("Player Two Hand");
		handTwo.printHand();
		gameDeck.printDeck();

		// Player Three Hand
		UnoHands handThree = new UnoHands();
		handThree.dealHand(deck);
		gameDeck.setDeck(deck);
		System.out.println("Player Three Hand");
		handThree.printHand();
		gameDeck.printDeck();

		// Player Four Hand
		UnoHands handFour = new UnoHands();
		handFour.dealHand(deck);
		gameDeck.setDeck(deck);
		System.out.println("Player Four Hand");
		handFour.printHand();
		gameDeck.printDeck();

		// Set play Pile, first card from deck to be first card on play pile
		gameDeck.startCard(deck);
		ArrayList<Integer> playPile = gameDeck.getPlayPile();
		gameDeck.printPlayPile();
		System.out.println();
		gameDeck.printDeck();

		// Testing deck size and hands size
		System.out.println("TESTING TESTING TESTING");
		System.out.println("Size of Deck");
		System.out.println(gameDeck.getDeckSize(deck));

		System.out.println("Size Of Player One Hand");
		ArrayList<Integer> hand1 = handOne.getHand();
		System.out.println(hand1.size());

		System.out.println("Size Of Player Two Hand");
		ArrayList<Integer> hand2 = handTwo.getHand();
		System.out.println(hand2.size());

		System.out.println("Size Of Player Three Hand");
		ArrayList<Integer> hand3 = handThree.getHand();
		System.out.println(hand3.size());

		System.out.println("Size Of Player Four Hand");
		ArrayList<Integer> hand4 = handFour.getHand();
		System.out.println(hand4.size());

		System.out.println("Size Of Play Pile");
		System.out.println(gameDeck.getPlayPileSize(playPile));

		// Making a new object of the unoCards class to invoke the methods
		UnoCards unoCards = new UnoCards();

		// Getting Card Color and Types for card top of play pile
		System.out.println();
		System.out.println("CHECKING COLOR AND TYPES");
		System.out.println("Color of card on play pile");
		System.out.println(unoCards.getColor(playPile, gameDeck.getActiveCardIndex()));
		String color = unoCards.getColor(playPile, gameDeck.getActiveCardIndex());

		System.out.println("Type of card on play pile");
		System.out.println(unoCards.getType(playPile, gameDeck.getActiveCardIndex()));
		String type = unoCards.getType(playPile, gameDeck.getActiveCardIndex());

		// Getting Card Color and Types for player one
		System.out.println();
		System.out.println("Hand One Colors");
		System.out.println(unoCards.getColorHand(hand1));
		ArrayList<String> colorHand = unoCards.getColorHand(hand1);

		System.out.println("Hand One Types");
		System.out.println(unoCards.getTypeHand(hand1));
		ArrayList<String> typeHand = unoCards.getTypeHand(hand1);

		// Getting Card Color and Types for player two
		System.out.println();
		System.out.println("Hand Two Colors");
		System.out.println(unoCards.getColorHand(hand2));
		ArrayList<String> colorHand2 = unoCards.getColorHand(hand2);

		System.out.println("Hand Two Types");
		System.out.println(unoCards.getTypeHand(hand2));
		ArrayList<String> typeHand2 = unoCards.getTypeHand(hand2);

		// Getting Card Color and Types for player three
		System.out.println();
		System.out.println("Hand Three Colors");
		System.out.println(unoCards.getColorHand(hand3));
		ArrayList<String> colorHand3 = unoCards.getColorHand(hand3);

		System.out.println("Hand Three Types");
		System.out.println(unoCards.getTypeHand(hand3));
		ArrayList<String> typeHand3 = unoCards.getTypeHand(hand3);

		// Getting Card Color and Types for player four
		System.out.println();
		System.out.println("Hand Four Colors");
		System.out.println(unoCards.getColorHand(hand4));
		ArrayList<String> colorHand4 = unoCards.getColorHand(hand4);

		System.out.println("Hand Three Types");
		System.out.println(unoCards.getTypeHand(hand4));
		ArrayList<String> typeHand4 = unoCards.getTypeHand(hand4);

		// Game and turns starts
		System.out.println("TURNS START");

		while (hand1.size() != 0 && hand2.size() != 0 && hand3.size() != 0 && hand4.size() != 0) {
			// Turn mechanism
			String turn = gameDeck.getPlayerTurn();
			String lastAction = gameDeck.getLastAction();
			System.out.println();
			System.out.println("Turn is: " + turn);
			boolean match = false;
			// Method to fill deck if there are no cards in the deck, takes from play pile
			// until reaches card on top, stops there
			if (gameDeck.getDeckSize(deck) == 0) {
				gameDeck.fillDeck(playPile);
			}
			
			//If is player ones turn 
			if (turn.equals("Player 1")) {
				System.out.println();

				System.out.println("Color of card on play pile");
				System.out.println(unoCards.getColor(playPile, gameDeck.getActiveCardIndex()));
				//Gets the color of the card on play pile
				color = unoCards.getColor(playPile, gameDeck.getActiveCardIndex());

				System.out.println("Type of card on play pile");
				System.out.println(unoCards.getType(playPile, gameDeck.getActiveCardIndex()));
				//Gets the type of the card on the play pile
				type = unoCards.getType(playPile, gameDeck.getActiveCardIndex());

				// Check for specials cards
				if (type.equals("WILD")) {
					gameDeck.playAnyCard(hand1);
					gameDeck.updateTurnIndex();

				} else if (type.equals("SKIP") && (!lastAction.equals("SKIP"))) {
					gameDeck.updateLastAction(type);
					gameDeck.skipTurn();

				} else if (type.equals("REVERSE") && (!lastAction.equals("REVERSE"))) {
					System.out.println("PLAYER DOES NOT GET TURN BECAUSE OF REVERSE");
					gameDeck.updateLastAction(type);
					gameDeck.reverse();
					gameDeck.updateTurnIndex();

				} else if (type.equals("Draw 2") && (!lastAction.equals("Draw 2"))) {
					System.out.println(turn + " drew 2 cards");
					gameDeck.updateLastAction(type);
					gameDeck.drawTwo(hand1);
					gameDeck.updateTurnIndex();
					
				} else if (type.contentEquals("Draw 4") && (!lastAction.equals("Draw 4"))) {
					System.out.println(turn + " drew 4 cards");
					gameDeck.updateLastAction(type);
					gameDeck.drawFour(hand1);
					gameDeck.updateTurnIndex();
				}
				
				// Any other kind of card, not special card
				else {

					// Check if we have a match
					match = unoCards.isMatch(color, type, colorHand, typeHand);
					System.out.println("Do we have a match: " + match);

					// If there is a match play card, add card to play pile, remove card from hand
					if (match) {
						int indexOfMatch = unoCards.findMatch(color, type, colorHand, typeHand);
						gameDeck.playCard(indexOfMatch, hand1);
						System.out.println(unoCards.getCard(indexOfMatch, colorHand, typeHand));
						handOne.printHand();
						gameDeck.setPlayPile(playPile);
						gameDeck.printPlayPile();
						colorHand = unoCards.getColorHand(hand1);
						typeHand = unoCards.getTypeHand(hand1);
						type = unoCards.getType(playPile, gameDeck.getActiveCardIndex());
						color = unoCards.getColor(playPile, gameDeck.getActiveCardIndex());
						gameDeck.updateTurnIndex();

					}

					// If there was no match, draw a card from deck and add to hand
					else {
						gameDeck.drawCard(hand1);
						handOne.setHand(hand1);
						handOne.printHand();
						gameDeck.setDeck(deck);
						gameDeck.printDeck();
						colorHand = unoCards.getColorHand(hand1);
						typeHand = unoCards.getTypeHand(hand1);
						gameDeck.updateTurnIndex();

					}
				}

				if (hand1.size() == 1) {
					System.out.println("\n\n\t\t\t___PLAYER ONE SCREAMS UNO!___\t\t\t\n\n");
				}

			} else if (turn.equals("Player 2")) {
				System.out.println();

				System.out.println("Color of card on play pile");
				System.out.println(unoCards.getColor(playPile, gameDeck.getActiveCardIndex()));
				color = unoCards.getColor(playPile, gameDeck.getActiveCardIndex());

				System.out.println("Type of card on play pile");
				System.out.println(unoCards.getType(playPile, gameDeck.getActiveCardIndex()));
				type = unoCards.getType(playPile, gameDeck.getActiveCardIndex());

				// Check for specials cards
				if (type.equals("WILD")) {
					gameDeck.playAnyCard(hand2);
					gameDeck.updateTurnIndex();

				} else if (type.equals("SKIP") && (!lastAction.equals("SKIP"))) {
					gameDeck.updateLastAction(type);
					gameDeck.skipTurn();

				} else if (type.equals("REVERSE") && (!lastAction.equals("REVERSE"))) {
					System.out.println("PLAYER DOES NOT GET TURN BECAUSE OF REVERSE");
					gameDeck.updateLastAction(type);
					gameDeck.reverse();
					gameDeck.updateTurnIndex();

				} else if (type.equals("Draw 2") && (!lastAction.equals("Draw 2"))) {
					System.out.println(turn + " drew 2 cards");
					gameDeck.updateLastAction(type);
					gameDeck.drawTwo(hand2);
					gameDeck.updateTurnIndex();
				} else if (type.contentEquals("Draw 4") && (!lastAction.equals("Draw 4"))) {
					System.out.println(turn + " drew 4 cards");
					gameDeck.updateLastAction(type);
					gameDeck.drawFour(hand2);
					gameDeck.updateTurnIndex();
				}
				// Any other kind of card, not special card
				else {

					// Check if we have a match
					match = unoCards.isMatch(color, type, colorHand2, typeHand2);
					System.out.println("Do we have a match: " + match);

					// If there is a match play card, add card to play pile, remove card from hand
					if (match) {
						int indexOfMatch = unoCards.findMatch(color, type, colorHand2, typeHand2);
						gameDeck.playCard(indexOfMatch, hand2);
						System.out.println(unoCards.getCard(indexOfMatch, colorHand2, typeHand2));
						handTwo.printHand();
						gameDeck.setPlayPile(playPile);
						gameDeck.printPlayPile();
						colorHand2 = unoCards.getColorHand(hand2);
						typeHand2 = unoCards.getTypeHand(hand2);
						type = unoCards.getType(playPile, gameDeck.getActiveCardIndex());
						color = unoCards.getColor(playPile, gameDeck.getActiveCardIndex());
						gameDeck.updateTurnIndex();

					}

					// If there was no match, draw a card from deck and add to hand
					else {
						gameDeck.drawCard(hand2);
						handTwo.setHand(hand2);
						handTwo.printHand();
						gameDeck.setDeck(deck);
						gameDeck.printDeck();
						colorHand2 = unoCards.getColorHand(hand2);
						typeHand2 = unoCards.getTypeHand(hand2);
						gameDeck.updateTurnIndex();

					}
				}

				if (hand2.size() == 1) {
					System.out.println("\n\n\t\t\t___PLAYER TWO SCREAMS UNO!___\t\t\t\n\n");
				}

			} else if (turn.equals("Player 3")) {
				System.out.println();

				System.out.println("Color of card on play pile");
				System.out.println(unoCards.getColor(playPile, gameDeck.getActiveCardIndex()));
				color = unoCards.getColor(playPile, gameDeck.getActiveCardIndex());

				System.out.println("Type of card on play pile");
				System.out.println(unoCards.getType(playPile, gameDeck.getActiveCardIndex()));
				type = unoCards.getType(playPile, gameDeck.getActiveCardIndex());

				// Check for specials cards
				if (type.equals("WILD")) {
					gameDeck.playAnyCard(hand3);
					gameDeck.updateTurnIndex();

				} else if (type.equals("SKIP") && (!lastAction.equals("SKIP"))) {
					gameDeck.updateLastAction(type);
					gameDeck.skipTurn();

				} else if (type.equals("REVERSE") && (!lastAction.equals("REVERSE"))) {
					System.out.println("PLAYER DOES NOT GET TURN BECAUSE OF REVERSE");
					gameDeck.updateLastAction(type);
					gameDeck.reverse();
					gameDeck.updateTurnIndex();

				} else if (type.equals("Draw 2") && (!lastAction.equals("Draw 2"))) {
					System.out.println(turn + " drew 2 cards");
					gameDeck.updateLastAction(type);
					gameDeck.drawTwo(hand3);
					gameDeck.updateTurnIndex();
				} else if (type.contentEquals("Draw 4") && (!lastAction.equals("Draw 4"))) {
					System.out.println(turn + " drew 4 cards");
					gameDeck.updateLastAction(type);
					gameDeck.drawFour(hand3);
					gameDeck.updateTurnIndex();
				}
				// Any other kind of card, not special card
				else {

					// Check if we have a match
					match = unoCards.isMatch(color, type, colorHand3, typeHand3);
					System.out.println("Do we have a match: " + match);

					// If there is a match play card, add card to play pile, remove card from hand
					if (match) {
						int indexOfMatch = unoCards.findMatch(color, type, colorHand3, typeHand3);
						gameDeck.playCard(indexOfMatch, hand3);
						System.out.println(unoCards.getCard(indexOfMatch, colorHand3, typeHand3));
						handThree.printHand();
						gameDeck.setPlayPile(playPile);
						gameDeck.printPlayPile();
						colorHand3 = unoCards.getColorHand(hand3);
						typeHand3 = unoCards.getTypeHand(hand3);
						type = unoCards.getType(playPile, gameDeck.getActiveCardIndex());
						color = unoCards.getColor(playPile, gameDeck.getActiveCardIndex());
						gameDeck.updateTurnIndex();

					}

					// If there was no match, draw a card from deck and add to hand
					else {
						gameDeck.drawCard(hand3);
						handThree.setHand(hand3);
						handThree.printHand();
						gameDeck.setDeck(deck);
						gameDeck.printDeck();
						colorHand3 = unoCards.getColorHand(hand3);
						typeHand3 = unoCards.getTypeHand(hand3);
						gameDeck.updateTurnIndex();

					}
				}

				if (hand3.size() == 1) {
					System.out.println("\n\n\t\t\t___PLAYER THREE SCREAMS UNO!___\t\t\t\n\n");
				}

			} else {

				System.out.println();

				System.out.println("Color of card on play pile");
				System.out.println(unoCards.getColor(playPile, gameDeck.getActiveCardIndex()));
				color = unoCards.getColor(playPile, gameDeck.getActiveCardIndex());

				System.out.println("Type of card on play pile");
				System.out.println(unoCards.getType(playPile, gameDeck.getActiveCardIndex()));
				type = unoCards.getType(playPile, gameDeck.getActiveCardIndex());

				// Check for specials cards
				if (type.equals("WILD")) {
					gameDeck.playAnyCard(hand4);
					gameDeck.updateTurnIndex();

				} else if (type.equals("SKIP") && (!lastAction.equals("SKIP"))) {
					gameDeck.updateLastAction(type);
					gameDeck.skipTurn();

				} else if (type.equals("REVERSE") && (!lastAction.equals("REVERSE"))) {
					System.out.println("PLAYER DOES NOT GET TURN BECAUSE OF REVERSE");
					gameDeck.updateLastAction(type);
					gameDeck.reverse();
					gameDeck.updateTurnIndex();

				} else if (type.equals("Draw 2") && (!lastAction.equals("Draw 2"))) {
					System.out.println(turn + " drew 2 cards");
					gameDeck.updateLastAction(type);
					gameDeck.drawTwo(hand4);
					gameDeck.updateTurnIndex();
				} else if (type.contentEquals("Draw 4") && (!lastAction.equals("Draw 4"))) {
					System.out.println(turn + " drew 4 cards");
					gameDeck.updateLastAction(type);
					gameDeck.drawFour(hand4);
					gameDeck.updateTurnIndex();
				}
				// Any other kind of card, not special card
				else {

					// Check if we have a match
					match = unoCards.isMatch(color, type, colorHand4, typeHand4);
					System.out.println("Do we have a match: " + match);

					// If there is a match play card, add card to play pile, remove card from hand
					if (match) {
						int indexOfMatch = unoCards.findMatch(color, type, colorHand4, typeHand4);
						gameDeck.playCard(indexOfMatch, hand4);
						System.out.println(unoCards.getCard(indexOfMatch, colorHand4, typeHand4));
						handFour.printHand();
						gameDeck.setPlayPile(playPile);
						gameDeck.printPlayPile();
						colorHand4 = unoCards.getColorHand(hand4);
						typeHand4 = unoCards.getTypeHand(hand4);
						type = unoCards.getType(playPile, gameDeck.getActiveCardIndex());
						color = unoCards.getColor(playPile, gameDeck.getActiveCardIndex());
						gameDeck.updateTurnIndex();

					}

					// If there was no match, draw a card from deck and add to hand
					else {
						gameDeck.drawCard(hand4);
						handFour.setHand(hand4);
						handFour.printHand();
						gameDeck.setDeck(deck);
						gameDeck.printDeck();
						colorHand4 = unoCards.getColorHand(hand4);
						typeHand4 = unoCards.getTypeHand(hand4);
						gameDeck.updateTurnIndex();

					}
				}

				if (hand4.size() == 1) {
					System.out.println("\n\n\t\t\t___PLAYER FOUR SCREAMS UNO!___\t\t\t\n\n");
				}

			}

		}

		if (hand1.size() == 0) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("PLAYER ONE WON");
		} else if (hand2.size() == 0) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("PLAYER TWO WON");
		} else if (hand3.size() == 0) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("PLAYER THREE WON");
		} else {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("PLAYER FOUR WON");
		}

	}

}
