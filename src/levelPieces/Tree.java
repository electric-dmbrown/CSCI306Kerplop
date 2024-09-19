package levelPieces;

import gameEngine.Drawable;

/*
 * Tree Class
 * 
 * Represents the drawable tree piece that does nothing
 */
public class Tree implements Drawable{

    /*
     * Draw function
     * 
     * draws the symbol of the tree on the gameboard
     */
    @Override
    public void draw() {
        System.out.println("T");
        
    }
}