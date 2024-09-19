package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * FlowerPiece Class
 * 
 * Represents the 'Flower' gameboard piece
 */
public class FlowerPiece extends GamePiece {
    
    /*
     * FlowerPiece Constructor
     * 
     * Sets the game piece values symbol, label, and location to the inputed values
     */
    public FlowerPiece(char symbol, String label, int location) {
        super(symbol, label, location);
    }
    
    /*
     * InteractionResult function
     * Determines the player's and the flower's location
     * 
     * always interact returns NONE
     */
    @Override
    public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
        return InteractionResult.NONE;
    }

}