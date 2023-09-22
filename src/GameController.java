import java.util.Scanner;

public class GameController {

	Scanner scan = new Scanner(System.in);
	
	public void playerInput(User user1, User user2) {
		char marker = ' ';
		while (marker != 'X' && marker != 'x' && marker != 'O' && marker != 'o') {
			marker = scan.next().charAt(0);
			if (Character.toUpperCase(marker) == 'X') {
				user1.setMarker('X');
				user2.setMarker('O');
			} else if (Character.toUpperCase(marker) == 'O') {
				user1.setMarker('O');
				user2.setMarker('X');

			} else
				System.out.println("Error: Please Enter 'X' or 'O':/");

		}
		System.out.println("\n+---------------------------+");
		System.out.println(user1.getName() + " uses '" + user1.getMarker() + "' as marker.");
		System.out.println(user2.getName() + " uses '" + user2.getMarker() + "' as marker.");
		System.out.println("+---------------------------+");
	}
	
	public void playerInput(User user, Computer comp) {
		char marker = ' ';
		while (marker != 'X' && marker != 'x' && marker != 'O' && marker != 'o') {
			marker = scan.next().charAt(0);
			if (Character.toUpperCase(marker) == 'X') {
				user.setMarker('X');
				comp.setMarker('O');
			} else if (Character.toUpperCase(marker) == 'O') {
				user.setMarker('O');
				comp.setMarker('X');

			} else
				System.out.println("Error: Please Enter 'X' or 'O':/");

		}
		System.out.println("\n+---------------------------+");
		System.out.println(user.getName() + " uses '" + user.getMarker() + "' as marker.");
		System.out.println("Computer uses '" + comp.getMarker() + "' as marker.");
		System.out.println("+---------------------------+");
	}
	
	
	public String whosTurn() {

		int flip = (int) (Math.random() + 1);

		if (flip == 0)
			return "user1";
		else
			return "user2";
	}
	
	public boolean playGame() {

		Character response = ' ';
		while (response != 'Y' && response != 'y' && response != 'N' && response != 'n') {
			response = scan.next().charAt(0);
			if (Character.toUpperCase(response) == 'Y') {
				return true;

			} else if (Character.toUpperCase(response) == 'N') {
				return false;
			}
			System.err.println("ERROR: Enter 'Y' or 'N' Only :/");
		}

		return false;
	}
	
	public boolean isValidMove (char[][] board, int position) {
		
		switch(position) {
		case 1:
			return (board[0][0] == ' ');
		case 2:
			return (board[0][1] == ' ');
		case 3:
			return (board[0][2] == ' ');
		case 4:
			return (board[1][0] == ' ');
		case 5:
			return (board[1][1] == ' ');
		case 6:
			return (board[1][2] == ' ');
		case 7:
			return (board[2][0] == ' ');
		case 8:
			return (board[2][1] == ' ');
		case 9:
			return (board[2][2] == ' ');
		default:
			return true;
		}
		
	}
	
	


}
