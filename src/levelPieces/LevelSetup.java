package levelPieces;

import java.util.ArrayList;
import gameEngine.Moveable;

public class LevelSetup {
	private int currentLevel;
	
	public LevelSetup() {
		currentLevel = 1;
	}
	
	public void createLevel(int levelNum) {
		currentLevel = levelNum;
	}
	
	public GamePiece[] getBoard() {
		switch(currentLevel) {
		case 1:
			return;
			break;
		case 2:
			return;
			break;
		}
		
	}
	
	public ArrayList<Moveable> getMovingPieces(){
		
	}
	
	public ArrayList<GamePiece> getInteractingPieces(){
		
	}
	
	public int getPlayerStartLoc(){
		return 2;
	}
	
	public static void main(String[] args) {
		
	}
}
