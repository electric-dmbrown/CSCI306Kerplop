package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Slime extends GamePiece implements Moveable{

	public Slime(char symbol, String label, int location) {
		super(symbol, label, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(super.getLocation()-1 == playerLocation || super.getLocation()+1 == playerLocation) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int newLocation = (super.getLocation() + 1) % gameBoard.length;
		if(gameBoard[newLocation] == null) {
			gameBoard[newLocation] = gameBoard[super.getLocation()];
			gameBoard[super.getLocation()] = null;
			super.setLocation(newLocation);
		}
		//super.setLocation(newLocation);
	}

}
