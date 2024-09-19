package levelPieces;

/**
* Level set up class for setting up both of the levels
* 
* @author Garrison Cook
* @author Deklan Brown
* 
*
*/

import java.util.ArrayList;
import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {
	private final int BOARD_SIZE = 21; // the board size;
	private int currentL; // integer representing the current level;
	private Drawable[] board1; // the game board for the first level. To be populated with the game pieces.
	private Drawable[] board2; // the game board for the second level. To be populated with the game pieces.
	private ArrayList<Moveable> move1; // the moving pieces for the first level
	private ArrayList<Moveable> move2; // the moving pieces for the second level
	private ArrayList<GamePiece> interact1; // the interacting pieces for the first level
	private ArrayList<GamePiece> interact2; // the interacting pieces for the second level
	private int start1 = 0; // the starting location for the first level
	private int start2 = 0; // the starting location for the second level
	
	
	/*
	 * the constructor for level set up that sets up all the arrays and array lists
	 */
	public LevelSetup() {
		currentL = 1; //set current level to 1 for the first board
		board1 = new Drawable[BOARD_SIZE]; //create the first game board
		board2 = new Drawable[BOARD_SIZE]; //create the second game board
		move1 = new ArrayList<Moveable>(); //create the movable pieces list for the first game
		move2 = new ArrayList<Moveable>(); //create the movable pieces list for the second game
		interact1 = new ArrayList<GamePiece>(); //create the movable pieces list for the first game
		interact2 = new ArrayList<GamePiece>(); //create the movable pieces list for the second game
	}
	
	/*
	 * createLevel creates the level based on the level number passed into the function.
	 */
	public void createLevel(int levelNum) {
		currentL = levelNum; //sets the current level to the levelNum
		
		//if the the current level is 1 create the fist level otherwise create the second.
		if(currentL == 1) {
			//create the pieces for the for the fist level
			Slime slime1 = new Slime('s',"SLIME",2);
			FairyPiece fairy1 = new FairyPiece('F',"Fairy",4);
			Trap trap1 = new Trap('t',"Trap",14);
			Coin coin1 = new Coin('C',"Coin",15);
			
			//add the pieces to the board.
			board1[2] = slime1;
			board1[4] = fairy1;
			board1[14] = trap1;
			board1[15] = coin1;
			
			//add all the interacting pieces to the ArrayList
			interact1.add(slime1);
			interact1.add(fairy1);
			interact1.add(trap1);
			interact1.add(coin1);
			
			//add the moving pieces to the ArrayList
			move1.add(slime1);
			move1.add(fairy1);
			
			//set the start location
			start1 = 8;
		} else {
			/*
             * Here we declare new pieces to be added to the board
             */
            WallPiece wall1 = new WallPiece('W', "Wall", 3);
            FairyPiece fairy2 = new FairyPiece('F', "Fairy", 11);
            Coin coin2 = new Coin('C', "Coin", 1);
            FlowerPiece flower1 = new FlowerPiece('f', "Flower", 15);
            Tree tree1 = new Tree();
            Coin coin3 = new Coin('C', "Coin", 18);
            Trap trap2 = new Trap('t', "Trap", 7);
            Slime slime2 = new Slime('s', "Slime", 4);
            
            /*
             * This adds all the pieces to the game board in there starting position
             */
            board2[1] = coin2;
            board2[3] = wall1;
            board2[4] = slime2;
            board2[7] = trap2;
            board2[11] = fairy2;
            board2[13] = tree1;
            board2[15] = flower1;
            board2[18] = coin3;
            
            /*
             * This adds all the pieces that can be interacted with to the interact array
             */
            interact2.add(coin2);
            interact2.add(wall1);
            interact2.add(slime2);
            interact2.add(trap2);
            interact2.add(fairy2);
            interact2.add(flower1);
            interact2.add(coin3);
            
            /*
             * This adds all the pieces that can be moved to the move array
             */
            move2.add(slime2);
            move2.add(fairy2);
            
            /*
             * This sets the player's starting position on the board to 14
             */
            start2 = 14;
            
        }
	}
	
	/*
	 * depending on the levelnum returns the first or the second board.
	 */
	public Drawable[] getBoard() {
		if(currentL == 1) {
			return board1;
		} else {
			return board2;
		}
	}
	
	/*
	 * depending on the levelnum returns the first or the second moving pieces list.
	 */
	public ArrayList<Moveable> getMovingPieces(){
		if(currentL == 1) {
			return move1;
		} else {
			return move2;
		}
	}
	
	/*
	 * depending on the levelnum returns the first or the second interacting pieces list.
	 */
	public ArrayList<GamePiece> getInteractingPieces(){
		if(currentL == 1) {
			return interact1;
		} else {
			return interact2;
		}
	}
	
	/*
	 * depending on the levelnum returns the first or the second starting location.
	 */
	public int getPlayerStartLoc(){
		if(currentL == 1) {
			return start1;
		} else {
			return start2;
		}
	}
	
	/*
	 * main method for any desired testing
	 */
	public static void main(String[] args) {
		
	}
}
