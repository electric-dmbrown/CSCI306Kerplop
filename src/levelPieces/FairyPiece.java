package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

import java.util.Random;

/*
 * FairyPiece Class
 * 
 * Represents the 'Fairy' Game piece
 */
public class FairyPiece extends GamePiece implements Moveable{
    
    private Random rnd; //Random value for determining fairy's movement
    
    /*
     * FairyPiece Constructor
     * 
     * Sets the game piece values symbol, label, and location to the inputed values
     * Also sets rnd to a new randdom value
     */
    public FairyPiece(char symbol, String label, int location) {
        super(symbol, label, location);
        rnd = new Random();
    }
    
    
    /*
     * InteractionResult function
     * Determines the player's and the fairy's location
     * if they are at the same location, interact returns ADVANCE
     * 
     * else returns no interaction
     */
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        // TODO Auto-generated method stub
        if (super.getLocation() == playerLocation) {
            return InteractionResult.ADVANCE;
        }
        else {
            return InteractionResult.NONE;
        }
        
    }
    
    /*
     * move function
     * Determines where to move the fairy piece on the game board.
     * moves randomly
     */
    @Override
    public void move(Drawable[] gameBoard, int playerLocation) {
    	int newLoc = rnd.nextInt(gameBoard.length-1);
    	newLoc = rnd.nextInt(gameBoard.length-1);
        if(gameBoard[newLoc] == null) {
        	gameBoard[newLoc] = gameBoard[super.getLocation()];
        	gameBoard[super.getLocation()] = null;
        	super.setLocation(newLoc);
        }
    }
}