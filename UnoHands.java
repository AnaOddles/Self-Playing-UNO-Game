/*Name:		Ana Sanchez
 * Date:	11/24/2019
 * File:	UnoHands.java
 * Purpose: Acts as class that contains the 
 * 			methods and data fields for 
 * 			the player hand objext.
 * 
 * Statement of Own Work: 
 * This is my own code as
 * influenced by the textbook
 * and class discussions. 
 * 		
 */
package CST_105.GameOfUno;

import java.util.ArrayList;

public class UnoHands {
	// Attributes
		private ArrayList<Integer> hand = new ArrayList<Integer>(); 

		// Constructor
		public UnoHands() {

		}

		// Method to get the hand
		public ArrayList<Integer> getHand() {
			//System.out.println("got hand");
			return hand;

		}

		// Method to set the hand
		public void setHand(ArrayList<Integer> hand) {
			//System.out.println("updated hand");
			this.hand = hand;
		}

		// Method to create a hand, take seven cards from a deck array
		public ArrayList<Integer> dealHand(ArrayList<Integer> deck) {
			System.out.println("Dealing hand");
			for (int i = 0; i < 7; i++) {
				int card = deck.get(i);
				hand.add(card);
				deck.remove(i);
			}

			return deck;
		}
		
		//Method to print the hand 
		public void printHand() {
			System.out.println("HAND");
			for (int i = 0; i < hand.size(); i++) {
				System.out.print(" " + hand.get(i) + " ");
			}
			System.out.println("\n");
		}
		
		//Method to get the size of the hand 
		public int getSizeHand(ArrayList<Integer> hand) {
			int sizeOfHand = 0;
			sizeOfHand = hand.size();
			return sizeOfHand;
			
		}
		

}
