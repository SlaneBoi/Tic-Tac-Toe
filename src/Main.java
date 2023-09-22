import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	protected static boolean gameOn;
	private static int position;
	char[][] board = {{' ', ' ', ' '},
			  		  {' ', ' ', ' '},
			  		  {' ', ' ', ' '}};
	
	public Main() {
		int choice = 0;
		while(true){
			System.out.println("TIC TAC TOE");
			System.out.println("===========");
			System.out.println("1. New Game");
			System.out.println("2. Exit");
			System.out.print(">> ");
			choice = scanNumber();
			
			if (choice == 1) {
				clear();
				newGame();
				clear();
			}else if(choice == 2) {
				System.out.println("Thank you for playing!");
				System.exit(0);
			}
			
		}
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
	
	public void clear() {
		for(int i = 0; i < 25; i++) {
			System.out.println();
		}
	}
	
	public void newGame() {
		
		int choice = 0;
		
		while(true) {
			System.out.println("Choose your game mode");
			System.out.println("=====================");
			System.out.println("1. 1 player (User vs Computer)");
			System.out.println("2. 2 player (User vs User)");
			System.out.print(">> ");
			choice = scanNumber();
			
			if(choice == 1) {
				clear();
				pvc();
				break;
			}else if(choice == 2) {
				clear();
				pvp();
				break;
			}
			System.out.println("Press Enter to Continue..");
			System.out.println();
		}
	}
	
	public void pvc() {
		//player vs computer (user vs computer)
		User user = new User();
		Computer comp = new Computer();
		GameController gameCtrl = new GameController();
		
		String uname;
		
		System.out.println("+-------------------------+");
		System.out.println("1 Player (User vs Computer)");
		System.out.println("+-------------------------+");
		
		do {
			System.out.print("-> Player, please input your username [3-10 characters]: ");
			uname = scan.nextLine();
		}while(!(uname.length()>3 && uname.length()<10));
		
		user.setName(uname);
		
		System.out.print("-> " + user.getName() + ", choose your mark ('X' or 'O'): ");
		gameCtrl.playerInput(user, comp);
		
		while(true) {
			
			//user turn
			System.out.println(user.getName() + "'s turn!");
			printBoard(board);
			placeMarker(user);
			
			if(isGameFinished(board, user)) {
				scan.nextLine();
				break;
			}
			printBoard(board);
			clear();
			
			//computer turn
			System.out.println(comp.getName() + "'s turn!");
			placeMarker(comp);
			
			if(isGameFinished(board, comp)) {
				scan.nextLine();
				break;
			}
			printBoard(board);
			
			System.out.println("Press Enter to Continue..");
			scan.nextLine();
			
			clear();
		}
	}
	

	public void pvp() {
		//player vs player (user vs user)
		User user1 = new User();
		User user2 = new User();
		GameController gameCtrl = new GameController();
		
		String uname1, uname2;
		
		System.out.println("+---------------------+");
		System.out.println("2 Player (User vs User)");
		System.out.println("+---------------------+");
		
		do {
			System.out.print("Player 1, please input your username [3-10 characters]: ");
			uname1 = scan.nextLine();
		}while(!(uname1.length()>3 && uname1.length()<10));
		
		do {
			System.out.print("Player 2, please input your username [3-10 characters]: ");
			uname2 = scan.nextLine();
		}while(!(uname2.length()>3 && uname2.length()<10));
		
		user1.setName(uname1);
		user2.setName(uname2);
		
		System.out.println();
		System.out.print(user1.getName() + ", choose your mark ('X' or 'O'): ");
		gameCtrl.playerInput(user1, user2);
		
		System.out.println("\nFlipping a coin...\n");

		String whosTurn = gameCtrl.whosTurn();
		System.out.println("The first to play is: " + whosTurn);
		
		System.out.println("Are you ready?");
		gameOn = gameCtrl.playGame();
		System.out.println("The Game is on: " + gameOn);
		
		while(gameOn) {
			
			if(whosTurn == "user1") {
				System.out.println(user1.getName() + "'s turn!");
				printBoard(board);
				placeMarker(user1);
				if(isGameFinished(board, user1)) {
					scan.nextLine();
					break;
				}
				clear();
				
				whosTurn = "user2";
				
			}else if(whosTurn == "user2") {
				System.out.println(user2.getName() + "'s turn!");
				printBoard(board);
				placeMarker(user2);
				if(isGameFinished(board, user2)) {
					scan.nextLine();
					break;
				}
				clear();
				
				whosTurn = "user1";
				
			}			
		}	
	}

	private boolean isGameFinished(char[][] board2, Player player) {
		
		//wincheck
		if(winCheck(player)==true) {
			clear();
			printBoard(board);
			System.out.println(player.getName() + " wins!");
			System.out.println("Congratulations!");
			return true;
		}		
		
		//emptyslot?
		for(int i=0; i < board.length; i++) {
			for(int j=0; j < board[i].length; j++) {
				if(board[i][j] == ' ') {
					return false;
				}
			}
		}
		clear();
		printBoard(board);
		System.out.println("The game ended in a tie!");
		return true;
	}

	public boolean winCheck(Player player) {
		if((board[0][0] == player.getMarker() && board[0][1] == player.getMarker() && board[0][2] == player.getMarker()) ||
		   (board[1][0] == player.getMarker() && board[1][1] == player.getMarker() && board[1][2] == player.getMarker()) ||
		   (board[2][0] == player.getMarker() && board[2][1] == player.getMarker() && board[2][2] == player.getMarker()) ||
		   
		   (board[0][0] == player.getMarker() && board[1][0] == player.getMarker() && board[2][0] == player.getMarker()) ||
		   (board[0][1] == player.getMarker() && board[1][1] == player.getMarker() && board[2][1] == player.getMarker()) ||
		   (board[0][2] == player.getMarker() && board[1][2] == player.getMarker() && board[2][2] == player.getMarker()) ||
		  
		   (board[0][0] == player.getMarker() && board[1][1] == player.getMarker() && board[2][2] == player.getMarker()) ||
		   (board[0][2] == player.getMarker() && board[1][1] == player.getMarker() && board[2][0] == player.getMarker()) ) {
			return true;
		}
		
		return false;
	}
	
	public void placeMarker(Player player) {
		
		switch(player.move(board)) {
			case 1:
				board[0][0] = player.getMarker();
				break;
			case 2:
				board[0][1] = player.getMarker();
				break;
			case 3:
				board[0][2] = player.getMarker();
				break;
			case 4:
				board[1][0] = player.getMarker();
				break;
			case 5:
				board[1][1] = player.getMarker();
				break;
			case 6:
				board[1][2] = player.getMarker();
				break;
			case 7:
				board[2][0] = player.getMarker();
				break;
			case 8:
				board[2][1] = player.getMarker();
				break;
			case 9:
				board[2][2] = player.getMarker();
				break;
		}
	}
	
	public void printBoard(char[][] board) {
		System.out.println("+-+-+-+");
		System.out.println("|" + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|");
		System.out.println("+-+-+-+");
		System.out.println("|" + board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|");		
		System.out.println("+-+-+-+");
		System.out.println("|" + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|");		
		System.out.println("+-+-+-+");	
	}

	public static void main(String[] args) {
		new Main();
	}
}
