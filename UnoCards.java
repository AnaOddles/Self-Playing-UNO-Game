/*Name:		Ana Sanchez
 * Date:	11/24/2019
 * File:	UnoCards.java
 * Purpose: Acts as class that contains the 
 * 			methods and data fields for 
 * 			the card object.
 * 
 * Statement of Own Work: 
 * This is my own code as
 * influenced by the textbook
 * and class discussions. 
 */ 		

package CST_105.GameOfUno;

import java.util.ArrayList;

public class UnoCards {
	//Attributes 
		private String[] colors = { "R" ,"Y", "G", "B"};
		private String[] types = { "0", "1", "1", "2", "2", "3", "3", "4", "4", "5", "5", "6", "6", "7", "7", "8", "8", "9", "9",
				"SKIP", "SKIP", "REVERSE", "REVERSE", "Draw 2", "Draw 2", "Draw 4", "WILD"};
		
		//Default Constructor
		public UnoCards(){
			
		}
		
		//Methods 
		
		//Method to get the color of the card on the top of the play pile
		public String getColor(ArrayList<Integer> playPile, int activeCardIndex) {
			//System.out.println("Got color of card on top of play pile");
			String color = "";
			int cardNum = playPile.get(activeCardIndex);
			color = colors[cardNum /28];
			return color;
			
		}
		
		//Method to get the type of the card on the top of play pile
		public String getType(ArrayList<Integer> playPile, int activeCardIndex) {
			//System.out.println("Got type of card on top of play pile");
			String type = "";
			int cardNum = playPile.get(activeCardIndex);
			type = types[cardNum %27];
			return type;
			
		}
		
		//Method to get the color of the cards in the hand
		public ArrayList<String> getColorHand(ArrayList<Integer> hand) {
			//System.out.println("Got color of cards in hand");
			ArrayList<String> color = new ArrayList<String>();
			String color2 = "";
			for(int i = 0; i < hand.size(); i++) {
				int cardNum = hand.get(i);
				color2 = colors[cardNum /28];
				color.add(color2);
				
				
			}
			return color;
			
		}

		
		//Method to get the type of the cards in the hand 
		public ArrayList<String> getTypeHand(ArrayList<Integer> hand) {
			//System.out.println("Got type of cards in hand");
			ArrayList<String> type = new ArrayList<String>();
			String type2 = "";
			for(int i = 0; i < hand.size(); i++) {
				int cardNum = hand.get(i);
				type2 = types[cardNum %27];
				type.add(type2);
				
				
			}
			return type;
			
		}
		
		//Method to get the card that was matched so we can display it 
		public String getCard (int indexOfMatch, ArrayList<String> colorHand, ArrayList<String> typeHand) {
			String card = "";
			String type = typeHand.get(indexOfMatch);
			String color = colorHand.get(indexOfMatch);
			card = color + " " + type;
			return card;
			
		}
		
		//Method to determining if the card on play pile is a match with any cards in the hand
		public boolean isMatch(String color, String type, ArrayList<String> colorHand, ArrayList<String> typeHand) {
			System.out.println("Checking for match");
			boolean isMatch = false;
			boolean colorMatch = colorHand.contains(color);
			boolean typeMatch = typeHand.contains(type);
			
			if(colorMatch || typeMatch){
				isMatch = true;
				
			}
			
			
			return isMatch;
			
		}
		
		//Method to find the match  
		public int findMatch(String color, String type, ArrayList<String> colorHand, ArrayList<String> typeHand) {
			int indexOfMatch = 0;
			for(int i = 0; i < colorHand.size(); i++) {
				if(colorHand.get(i) == color || typeHand.get(i) == type) {
					indexOfMatch = i;
					break;
				}
				
				
			}
			return indexOfMatch;
			
		}

}
