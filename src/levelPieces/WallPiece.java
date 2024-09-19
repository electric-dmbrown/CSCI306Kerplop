package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * Wall Piece class
 * 
 * Represent the 'Wall' game board piece
 */
public class WallPiece extends GamePiece {
    
    /*
     * WallPiece constructor
     * 
     * Sets the game piece values symbol, label, and location to the inputed values
     */
    public WallPiece(char symbol, String label, int location) {
        super(symbol, label, location);
    }
    
    /*
     * InteractionResult function
     * Determines the player's and the wall's location
     * if they are at the same location, interact returns HIT
     * as the player falls off of the wall
     * 
     * else returns no interaction
     */
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        // TODO Auto-generated method stub
        if (super.getLocation() == playerLocation) {
            return InteractionResult.HIT;
        }
        else {
            return InteractionResult.NONE;
        }
        
    }

}