# Uno-Game
Console program for a Self-playing Uno game where four computers played Uno against each other until one computer wins.

Link to Video: https://www.loom.com/share/8f3975d90a3140c2ab201ec8044fb541

Action Plan:
Create four main classes to keep our game properties and game logic organized. UnoHands, UnoCards, UnoDecks, and driver program UnoGame. Keep the properties within the classes private and then make a setter and getter for each property. Use the UnoGame class as the class for the game logic and flow. 

Project Overview:
-Start with a main deck (Int ArrayList) that is initialized with integers from 1 to 108
-From there shuffle the main deck 
-Deal 7 cards to each players Int ArrayList hand 
-Set one card (top card) from the deck to the play pile deck that is an ArrayList

Main matching mechanism by looping through the player hand ArrayList and determine if it contains any of the same color or type 

Classes: 

UnoCard - 
Class to keep track of the properties of each individual Uno Card
Determines color and type of cards
Determines if there is a match between card on play pile and player hand
Finds the match 

UnoDecks - 
Class to keep the properties of the two main decks of the game, overall deck and play pile
Keeps track of the turns 
Keeps track if we are in reverse or not 
Methods to draw & play cards
Methods for actions for specials cards, ex draw 2, WILD 

UnoHand - 
Class to keep the properties for the player hands
Methods to set and get hand 
Method to deal hands in game preparation
Testing purposes methods such as printing hands and getting size of hands


UnoGame - 
Driver class for the game 
Contains the game logic 
Contains the flow for the player turns 
Creates new instances of the unoHand class for each player
Creates new instance for the game decks 

