package levelPieces;

/**
* Slime Game piece
* 
* @author Deklan Brown
* 
* 
*
*/

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;


/*
 * Slime class
 * 
 * Represent the a slime that travels in a single direction and damages the player if they
 * are to either side of the slime.
 */
public class Slime extends GamePiece implements Moveable{
	
	/*
	 * Constructor for the slime class just calls the super constructor.
	 */
	public Slime(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Override interact to give the slime unique interaction.
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		//check if player is to either side of the slime. if it is damage the player otherwise do no interaction
		if(super.getLocation()-1 == playerLocation || super.getLocation()+1 == playerLocation) {
			return InteractionResult.HIT; //return hit when hit.
		}
		return InteractionResult.NONE; //don't interact if not near player.
	}
	
	/*
	 * override the move method to make the slime move in a unique way.
	 */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		//the slime always moves in one direction but wraps around the board to the otherside 
		int newLocation = (super.getLocation() + 1) % gameBoard.length;
		
		//if the board at the new location is null move there
		if(gameBoard[newLocation] == null) {
			gameBoard[newLocation] = gameBoard[super.getLocation()]; //place slime in new location on board
			gameBoard[super.getLocation()] = null; //set old location on board to null.
			super.setLocation(newLocation); //set the pieces new location internally.
			return; //exit to avoid running other code.
		}
		//try two space over if the space to the right was blocked.
		newLocation = (super.getLocation() + 2) % gameBoard.length;
		
		//if the board at the new location is null move there
		if(gameBoard[newLocation] == null) {
			gameBoard[newLocation] = gameBoard[super.getLocation()]; //place slime in new location on board
			gameBoard[super.getLocation()] = null; //set old location on board to null.
			super.setLocation(newLocation); //set the pieces new location internally.
			return; //exit
		}
	}

}
