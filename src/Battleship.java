/** 
 * @author Giorgos Argyrides
*/

import java.util.Random;
import java.util.Scanner;

public class Battleship {

	public static final int gridSize = 8;
	public static final int shipCount = 5;
	private String ships[];
	private char hitsTable[][];
	private char shipsTable[][];

	public Battleship() {
		ships = new String[shipCount];
		ships[0] = new String("AA");
		ships[1] = new String("BBB");
		ships[2] = new String("CCC");
		ships[3] = new String("DDDD");
		ships[4] = new String("FFFFF");
		hitsTable = new char[gridSize][gridSize];
		shipsTable = new char[gridSize][gridSize];
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				hitsTable[i][j] = '-';
				shipsTable[i][j] = '-';
			}
		}
	}

	/**
	 * Prints the game grid.
	 */
	public void printGameGrid(Boolean showShips) {
		if (showShips) {
			System.out.println("\n The ships are revealed in the grid below.");
		}
		System.out.print("\n ");
		for (int i = 1; i <= gridSize; i++) {
			System.out.print(" " + i);
		}
		System.out.println();
		for (int i = 0; i < gridSize; i++) {
			System.out.print((char) (65 + i));
			for (int j = 0; j < gridSize; j++) {
				if (showShips) {
					System.out.print(" " + shipsTable[i][j]);
				} else {
					System.out.print(" " + hitsTable[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Places the ships on the grid randomly.
	 */
	public void placeShips() {
		Random rand = new Random();
		int xEnd = 0, yEnd = 0, xStart = 0, yStart = 0;
		String ship = "";
		for (int i = 0; i < shipCount; i++) {
			ship = ships[i];
			boolean worked = false;
			while (!worked) {
				worked = true;
				xStart = rand.nextInt(7);
				yStart = rand.nextInt(7);
				int orientation = rand.nextInt(3);
				switch (orientation) {
					case 0: // horizontal right
						xEnd = xStart + ship.length() - 1;
						yEnd = yStart;
						break;
					case 1: // horizontal left
						xEnd = xStart;
						xStart = xStart - ship.length() + 1;
						yEnd = yStart;
						break;
					case 2: // vertical down
						xEnd = xStart;
						yEnd = yStart + ship.length() - 1;
						break;
					case 3: // vertical up
						xEnd = xStart;
						yEnd = yStart;
						yStart = yStart - ship.length() + 1;
						break;
				}
				if (xEnd > 7 || xStart < 0 || yEnd > 7 || yStart < 0) {
					worked = false;
					continue;
				}
				if (yStart == yEnd) {
					for (int j = xStart; j <= xEnd; j++) {
						if (shipsTable[j][yStart] != '-') {
							worked = false;
						}
					}
				} else {
					for (int j = yStart; j <= yEnd; j++) {
						if (shipsTable[xStart][j] != '-') {
							worked = false;
						}
					}
				}
			}
			if (yStart == yEnd) {
				for (int j = xStart; j <= xEnd; j++) {
					shipsTable[j][yStart] = ship.charAt(j - xStart);
				}
			} else {
				for (int j = yStart; j <= yEnd; j++) {
					shipsTable[xStart][j] = ship.charAt(j - yStart);
				}
			}
		}
	}

	/**
	 * Prints the help menu containing the available commands.
	 */
	public void printHelpMenu() {
		System.out.println(
				"\nAvailable commands: " + "\n 1) show ships - displays the dashboard along with the positions of ships"
						+ "\n 2) XY - fire at the coordinates XY. Where X is in [A-H] and Y is in [1-8]"
						+ "\n 3) quit - exit from the game" + "\n 4) help - shows a list with the available commands"
						+ "\n Note: O indicates a miss and X indicates a hit");
	}

	/**
	 * Fires at the coordinates x y of the grid. If a ship is placed at the given
	 * coordinates, then the ships gets hit, else the fire misses.
	 * 
	 * @param x the fire X-axis coordinate
	 * @param y the fire Y-axis coordinate
	 * @return returns true if fire was a hit
	 */
	public boolean fire(int x, int y) {
		if (hitsTable[x][y] != '-') {
			System.out.println("You have already fired at this position, try again!");
		} else if (shipsTable[x][y] == '-') {
			hitsTable[x][y] = 'O';
			System.out.println("\nMiss!");
		} else {
			hitsTable[x][y] = 'X';
			System.out.println("\nHit!");
			return true;
		}
		return false;
	}

	/**
	 * Checks if the user's input is valid and if not, then it prints a menu with
	 * the available commands.
	 * 
	 * @param command the user's input
	 * @return returns true if the input is valid.
	 */
	public boolean checkInput(String command) {
		if (command.length() != 2 || command.charAt(0) > 'h' || command.charAt(0) < 'a' || command.charAt(1) > '8'
				|| command.charAt(1) < '1') {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int hits = 0;
		String command;
		Scanner scan = new Scanner(System.in);
		Battleship battleship = new Battleship();
		battleship.placeShips();
		System.out.println("\n***** Welcome to the Battleship game! *****");
		battleship.printHelpMenu();
		battleship.printGameGrid(false);
		do {
			System.out.print("> ");
			command = scan.nextLine();
			command = command.toLowerCase();
			if (command.equals("show ships")) {
				battleship.printGameGrid(true);
			} else if (command.equals("help")) {
				battleship.printHelpMenu();
			} else if (command.equals("quit")) {
				battleship.printGameGrid(true);
				System.out.println(" \nThank you for playing. Goodbye!\n");
				break;
			} else {
				if (battleship.checkInput(command) == false) {
					System.out.println("Wrong input!");
					battleship.printHelpMenu();
				} else {
					int x = command.charAt(0) - 'a';
					int y = command.charAt(1) - '1';
					if (battleship.fire(x, y) == true) {
						hits++;
					}
				}
			}
			battleship.printGameGrid(false);
		} while (!command.equals("quit") && hits < 17);
		if (hits == 17) {
			System.out.println(" \nCongratulations! You won!!!\nThank you for playing. Goodbye!\n");
		}
		scan.close();
	}
}
