//Ammar  Khalid
//241

package Assignment1;

import java.util.Scanner;

public class MazeRunner {
	public static void main(String args[]) {
		mainMenu();

	}

public static void mainMenu() {
	Scanner scan = new Scanner(System.in);
	int i=1;
	int highscore = 0;
	while (i>0) {
		System.out.println("a. Play Game");
		System.out.println("b. Instructions");
		System.out.println("c. Credits");
		System.out.println("d. High Score");
		System.out.println("e. Exit");
		
		System.out.print("Enter any option: ");
		char ui = scan.next().charAt(0);
		
		System.out.println("");
		
		
		switch(ui) {
		case 'a':
			int score = playGame(0);
			if (score > highscore) {
				highscore = score;
			}
			break;
		case 'b':
			displayInstructions();
			break;
		case 'c':
			System.out.println("Made by Ammar, 241547086");
			System.out.println("");
			break;
		case 'd':
			System.out.println("Highscore is: "+highscore);
			System.out.println("");
			break;
		case 'e':
			i--;
			break;
		default:
			System.out.println("Wrong input");
		}
	}
	scan.close();
	
}

public static String[][] initializeMaze() {
	//Create Maze
	String[][] maze = {
			{"#","#","#","#","#","#","#"},
			{"#","S",".",".",".",".","#"},
			{"#","#","#","#","#",".","#"},
			{"#","#","#","#","#",".","#"},
			{"#","#","#","#","#",".","#"},
			{"#","#","#","#","#","F","#"},
			{"#","#","#","#","#","#","#"}
			
					
	};
	return maze;

}

public static int[] initializePosition(String [][] maze) {
	//set starting position in maze to position array
	int[] position = new int[2];
	for (int i=0; i<=6; i++) {
		for (int j=0; j<=6; j++) {
			if (maze[i][j] == "S") {
				position[0] = i;
				position[1] = j;
				break;
			}
		}
	}
	return position; //returns starting position in the maze
}

public static boolean isValidMove(char move, String[][] maze, int[] position) {
	int i = position[0];
	int j = position[1];
	switch(move) {
	case 'A':
		j--;
		break;
	case 'S':
		i++;
		break;
	case 'D':
		j++;
		break;
	case 'W':
		i--;
		break;
	case 'a':
		j--;
		break;
	case 's':
		i++;
		break;
	case 'd':
		j++;
		break;
	case 'w':
		i--;
		break;
	default:
		i=-1;
		j=-1;
		break;
	}
	
	if (i<0) {
		return false;
	}
	else if (maze[i][j] == "#") {
		return false;
	}
	else {
		return true;
	}
	
}

public static void movePlayer(String[][] maze, boolean validity, int[] position, char move) {
	int i = position[0];
	int j = position[1];
	switch(move) {
	case 'A':
		j--;
		break;
	case 'S':
		i++;
		break;
	case 'D':
		j++;
		break;
	case 'W':
		i--;
		break;
	case 'a':
		j--;
		break;
	case 's':
		i++;
		break;
	case 'd':
		j++;
		break;
	case 'w':
		i--;
		break;
	}
	
	if (validity == true) {
		position[0] = i;
		position[1] = j;
	}
}

public static boolean hasPlayerWon(String[][] maze, int[] position) {
	if (maze[position[0]][position[1]] == "F") {
		return true;
	}
	else {
		return false;
	}
}
public static void displayInstructions() {
	System.out.println("W = Move Up");
	System.out.println("A = Move Left");
	System.out.println("S = Move Down");
	System.out.println("D = Move Right");
	System.out.println("");
}

public static int playGame(int score) {
	
	String[][] maze = initializeMaze();
	int[] position = initializePosition(maze);
	displayInstructions();
	
	int turns= 0;
	int z=1;
	while (z>0) {
		System.out.print("Please give an input: ");
		Scanner scan = new Scanner(System.in);
		char move = scan.next().charAt(0);
		boolean wrong_input = false;
		switch(move) {
		case 'A':
			z--;
			break;
		case 'S':
			z--;
			break;
		case 'D':
			z--;
			break;
		case 'W':
			z--;
			break;
		case 'a':
			z--;
			break;
		case 's':
			z--;
			break;
		case 'd':
			z--;
			break;
		case 'w':
			z--;
			break;
		default:
			wrong_input = true;
			break;
		}
		
		if (isValidMove(move, maze, position) == true) {
			movePlayer(maze, true, position, move);
			System.out.println("You moved!");
			turns++;
		}
		else if (wrong_input == true) {
			System.out.println("Wrong input!");
		}
		else {
			System.out.println("You hit a wall!");
			turns++;
			z++;
		}
		
		if (hasPlayerWon(maze, position) == true) {
			System.out.println("You win!");
			z--;
		}
		else {
			z++;
		}
		
	}
	System.out.println(turns);
	return turns;
	
}

}
