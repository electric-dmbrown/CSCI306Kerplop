package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Coin extends GamePiece implements Moveable{
	
	public static boolean gotit = false;
	
	public Coin(char symbol, String label, int location) {
		super(symbol, label, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(super.getLocation() == playerLocation) {
			gotit = true;
			return InteractionResult.GET_POINT;
		} else {
			return InteractionResult.NONE;
		}
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
