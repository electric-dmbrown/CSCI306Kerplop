package levelPieces;

/**
* Coin Game piece
* 
* @author Deklan Brown
* 
* 
*
*/

import gameEngine.Drawable;
import gameEngine.InteractionResult;
//import gameEngine.Moveable;


/*
 * Coin class 
 * 
 * increments the point counter for win.
 */
public class Coin extends GamePiece {
	
	/*
	 * constructor for the coin class
	 * 
	 * simply calls the parent constructor.
	 */
	public Coin(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	/*
	 * Overrides interact to give the coin unique functionality
	 * 
	 * if the player and the coin share the same location then return get point
	 * otherwise return none.
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(super.getLocation() == playerLocation) {
			return InteractionResult.GET_POINT;
		} else {
			return InteractionResult.NONE;
		}
	}
	
	/*@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
	}*/
	
	/*
	 * main method for any desired testing
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
