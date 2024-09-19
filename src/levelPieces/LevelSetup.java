package levelPieces;

import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {
	private final int BOARD_SIZE = 21;
	private int currentL;
	private Drawable[] board1;
	private Drawable[] board2;
	private ArrayList<Moveable> move1;
	private ArrayList<Moveable> move2;
	private ArrayList<GamePiece> interact1;
	private ArrayList<GamePiece> interact2;
	private int start1 = 0;
	private int start2 = 0;
	
	public LevelSetup() {
		currentL = 1;
		board1 = new Drawable[BOARD_SIZE];
		board2 = new Drawable[BOARD_SIZE];
		move1 = new ArrayList<Moveable>();
		move2 = new ArrayList<Moveable>();
		interact1 = new ArrayList<GamePiece>();
		interact2 = new ArrayList<GamePiece>();
	}
	
	public void createLevel(int levelNum) {
		currentL = levelNum;
		if(currentL ==levelNum) {
			Slime slime1 = new Slime('s',"SLIME",2);
			FairyPiece fairy1 = new FairyPiece('F',"Fairy",4);
			board1[2] = slime1;
			board1[4] = fairy1;
			interact1.add(slime1);
			interact1.add(fairy1);
			move1.add(slime1);
			move1.add(fairy1);
		} else {
			
		}
	}
	
	public Drawable[] getBoard() {
		if(currentL == 1) {
			return board1;
		} else {
			return board2;
		}
	}
	
	public ArrayList<Moveable> getMovingPieces(){
		if(currentL == 1) {
			return move1;
		} else {
			return move2;
		}
	}
	
	public ArrayList<GamePiece> getInteractingPieces(){
		if(currentL == 1) {
			return interact1;
		} else {
			return interact2;
		}
	}
	
	public int getPlayerStartLoc(){
		if(currentL == 1) {
			return start1;
		} else {
			return start2;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
