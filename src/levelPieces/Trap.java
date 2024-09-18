package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Trap extends GamePiece {
	

	public Trap(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation == super.getLocation()-1) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
