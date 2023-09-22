import java.util.Scanner;

public class User extends Player{
	Scanner scan = new Scanner(System.in);
	GameController gameCtrl = new GameController();

	@Override
	public int move(char[][] board) {
		
		int userInput;
		
		while(true) {
			
			do {
				System.out.print("Where would you like to place? [1-9]: ");
				userInput = scanNumber();
			} while (!(userInput >= 1 && userInput <= 9));
			
			if(gameCtrl.isValidMove(board, userInput)) {
				break;
			}else {
				System.out.println("The position has been taken! Choose another position!");		
			}
		}
		
		return userInput;
	}	
	
	private int scanNumber() {
		int choice=0;
		while(true) {
			try {
				choice = scan.nextInt();
				scan.nextLine();
				break;
			} catch (Exception e) {
				System.out.println("Please input number");
				scan.nextLine();
			}
		}
		return choice;
	}
	

}
