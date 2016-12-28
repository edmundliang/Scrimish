//Edmund Liang
//109083401

import java.util.ArrayList;

public class Scrimish {

	private static java.util.Scanner input = new java.util.Scanner(System.in);
	private static ArrayList[] userPiles;
	private static ArrayList[] computerPiles = initializeComputerPile();
	private static boolean userTurn = true;
	private static int userIndex = 0;
	private static int computerIndex = 0;

	private static ArrayList<String> generateCards() {
		ArrayList<String> originalCards = new ArrayList();

		//#1 Dagger Cards (x5)
		//#2 Sword Cards (x5)
		for(int i = 0; i <5; i++) {
			originalCards.add("1");
			originalCards.add("2");
		}

		//#3 Morning Star Cards (x3)
		//#4 War Axe Cards (x3)
		for(int i = 0; i < 3;i++) {
			originalCards.add("3");
			originalCards.add("4");
		}

		//#5 Halberd Cards (x2 per player)
		//#6 Longsword Cards (x2 per player)
		//'A' Archer Cards (x2 per player)
		//'S' Shield Cards (x2 per player)
		for(int i = 0; i < 2; i++) {
			originalCards.add("5");
			originalCards.add("6");
			originalCards.add("A");
			originalCards.add("S");
		}

		//'C' Crown Card (x1 per player)
		originalCards.add("C");
		return originalCards;
	}

	private static ArrayList<String>[] initializeComputerPile() {
		ArrayList<String> originalCards = generateCards();
		ArrayList[] pile = new ArrayList[5];
		for(int i = 0; i < 5;i++) {
			pile[i] = new ArrayList<String>();

		}

		int crownpile = randBetween(0,4);
		pile[crownpile].add(originalCards.remove(originalCards.size()-1));
		for(int i = 0; i <5; i++) {
			for(int j = 0; j < 5; j++) {
				if(j!=4 || i != crownpile)
					pile[i].add(originalCards.remove(randBetween(0, originalCards.size()-1)));
			}
		}

		return pile;

	}

	private static ArrayList<String>[] initializeUserPile() {

	
		boolean format;
		ArrayList[] pile = new ArrayList[5];

		do {
			for(int i = 0; i < 5; i++) {
				pile[i] = new ArrayList<String>();
			}
			format = true;	
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			int count4 = 0;
			int count5 = 0;
			int count6 = 0;
			int countA = 0;
			int countS = 0;
			int countC = 0;
			System.out.print("Enter 5 cards for each pile: ");
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					String s = input.next();
					switch(s) {
					case "1": count1++;
					break;
					case "2": count2++;
					break;
					case "3": count3++;
					break;
					case "4": count4++;
					break;
					case "5": count5++;
					break;
					case "6": count6++;
					break;
					case "A": countA++;
					break;
					case "S": countS++;
					break;
					case "C": countC++;
					break;
					}
					pile[i].add(s);
				}
			}
			if(count1 > 5 || count2 > 5 || count3 > 3 || count4 > 3 || count5 > 2 || count6 > 2 || countA > 2 || countS > 2|| countC > 1)
				format = false;
			int i;
			for(i = 0; i < 5; i++) {
				if(pile[i].get(0).equals("C"))
					break;
			}
			if(i == 5)
				format = false;
		} while(!format);

		return pile;

	}

	private static int randBetween(int a, int b) {
		return a + (int) Math.round(Math.random() * (b-a));
	}

	private static String pileToString(ArrayList[] pile) {
		String output = "";
		for(int i = 0; i < 5; i++) {
			output+= " Pile " + (i+1) + ": ";
			for(Object o: pile[i]) {
				output += (String) o + " ";
			}
			output += "\n";
		}
		return output;
	}

	public static String stateToString() {
		String s = "User Piles: \n";
		s+= pileToString(userPiles);
		s+= "Computer piles: \n";
		s+=pileToString(computerPiles);
		return s;

	}

	public static void battle() {
		String userCard = (String) userPiles[userIndex].get(userPiles[userIndex].size()-1);
		String computerCard = (String) computerPiles[computerIndex].get(computerPiles[computerIndex].size()-1);
		String card1 = "";
		String card2 = "";
		ArrayList player1 = userPiles[userIndex];
		ArrayList player2 = userPiles[computerIndex];
		if (userTurn) {
			card1 = userCard;
			card2 = computerCard;
			player1 = userPiles[userIndex];
			player2 = computerPiles[computerIndex];
			if (card1.equals("S")) {
				System.out.println("Invalid move! Try Again!");
				return;
			}

		} else {
			card1 = computerCard;
			card2 = userCard;
			player1 = computerPiles[computerIndex];
			player2 = userPiles[userIndex];
			if (card1.equals("S")) {
				System.out.println("Invalid move! Try Again!");
				return;
			}
		}
		int winner = 1;
		if (card2.equals("C")){
			winner = 4;
		} else { 
			if(card1.equals("A") && card2.equals("S")) 
				winner = 5;
			else if(card1.equals("C") && card2.equals("C"))
				winner = 4;
			else if (card1.equals("C") && !card2.equals("C"))
				winner = 6;
			else if(card2.equals("S"))
				winner = 3;
			else if (card1.equals("A") || card2.equals("A")){
				winner = 1;
			}else {
				if (card2.equals("S")){
					winner = 2;
				} else {
					if(card1.compareTo(card2) <0)
						winner = 2;
					else if (card1.compareTo(card2)==0)
						winner = 3;
					else 
						winner = 1;
				}
			}
		}


		//round ends
		if(winner == 4) {
			if(userTurn){
				System.out.println("User won!");
			} else{
				System.out.println("Computer won!");
			}
			System.out.println("Game over!");
			System.exit(0);
		}
		if(winner == 6) {
			if(userTurn){
				System.out.println("Computer won!");
			} else{
				System.out.println("User won!");
			}
			System.out.println("Game over!");
			System.exit(0);
		}
		if (winner == 3 || winner == 2) 
			player1.remove(player1.size()-1);


		if (winner == 3 || winner == 1) 
			player2.remove(player2.size()-1);

		if (winner == 5) 
			System.out.println("Both cards remain in their respective piles.");


		userTurn = !userTurn;


	}

	public static void main (String[] args){

		userPiles = initializeUserPile();

		System.out.print(stateToString());
		int num;
		//rounds 
		for (int i=0; i<25; i++){

			if (userTurn){
				System.out.print("Do you want to discard or attack (d/a)? ");
				String answer = input.next();
				if (answer.equals("d")) {
					do {
						System.out.print("Enter user pile index to discard from (1-5): ");
						num = input.nextInt();
					} while (userPiles[num-1].isEmpty() || userPiles[num-1].get(userPiles[num-1].size()-1) == "C");
					userPiles[num-1].remove(userPiles[num-1].size()-1);
					userTurn = false;
				} else {
					do{
						System.out.print("-------------------------------------------------------------------\n" +
								"User turn\nEnter user pile index (1-5): ");
						userIndex = input.nextInt() -1;
					}while(userPiles[userIndex].isEmpty());
					do{
						System.out.print("Enter computer pile index (1-5): ");
						computerIndex = input.nextInt() -1;
					}while (computerPiles[computerIndex].isEmpty());
					battle(); 
				}
			} else {
				do{
					userIndex = randBetween(0,4);
					computerIndex = randBetween(0,4);
				}while(userPiles[userIndex].isEmpty() || computerPiles[computerIndex].isEmpty());
				System.out.println("-------------------------------------------------------------------\n" 
						+ "Computer turn: computer attacks user pile " + (userIndex +1) 
						+ " with the computer pile " + (computerIndex + 1) );

				battle(); 

			}

			System.out.print(stateToString());
		}
	}
}


