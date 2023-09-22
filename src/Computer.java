import java.util.Random;

public class Computer extends Player{

	Random rand = new Random();
	GameController gameCtrl = new GameController();
	
	public Computer() {
		super();
//		super.name = "Computer";
		this.name = "Computer";
	}

	@Override
	public int move(char[][] board) {
		
		int computerMove;
		
		while(true) {
			computerMove = rand.nextInt(9) + 1;
			if(gameCtrl.isValidMove(board, computerMove)) {
				System.out.println("Computer chooses " + computerMove);
				break;
			}
		}
				
		return computerMove;
		
	}
	

	
	
}
