# Scrimish

##Project 
We will implement a simplified game of Scrimish, a strategy card game, with 2 players: a human (i.e., the user) and the computer. Scrimish is a card game that was funded using kickstarter.com with the objective that luck is not a component of the game.
Both players have a set of cards composed of the following cards and numbers:

'1' Dagger Cards (x5 per player)<br>
'2' Sword Cards (x5 per player)<br>
'3' Morning Star Cards (x3 per player)<br>
'4' War Axe Cards (x3 per player)<br>
'5' Halberd Cards (x2 per player)<br>
'6' Longsword Cards (x2 per player)<br>
'A' Archer Cards (x2 per player)<br>
'S' Shield Cards (x2 per player)<br>
Crown Card (x1 per player)

##Setup
The user player places 5 Piles of 5 Cards each face down in front of him. The Crown Card should be hidden on the bottom of one of the 5 Piles. The rest of the Cards may be arranged however you like. The computer does the same thing: the crown card is placed on the bottom of a random pile, while the rest of the card are distributed into 5 piles (such that we have 5 cards in each pile).


##Game Play
The players take turns attacking (starting with the user first) by selecting the top card from one of their piles and laying that card face up in front of one of their opponent's piles. The defending player must then reveal the top card of the pile that was attacked. The card with the lowest number value loses and is discarded. The winning card must be returned face down to the top of the original pile it was drawn from. If the two cards have the same number value, both cards are discarded. The play continues until one of the players attacks their opponent's Crown Card, winning the game.
- Archer Card: If you attack with an Archer Card, it always wins. If your Archer Card is attacked, it always loses.
- Shield Card: Shield Cards cannot be used to attack. If your Shield Card is attacked, both your Shield Card and your opponent's attacking Card are discarded (except for Archer Cards: If a Shield Card is attacked by an Archer Card, neither Card is discarded, and both are returned face down to their original Piles).
- Crown Card: You can attack with your Crown Card. If you attack your opponent's Crown Card, you win. Otherwise, you lose the game.
- Instead of attacking, you may intentionally discard one Card on your turn. You do not have to reveal that Card to your opponent. You cannot intentionally discard your Crown Card.
