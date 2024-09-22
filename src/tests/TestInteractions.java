package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import levelPieces.*;
import gameEngine.*;

class TestInteractions {

	@Test
	void testTrapInteract() {
		Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE];
		
		Trap trap1 = new Trap('t',"TRAP",11);
		gameboard[11] = trap1;
		
		assert(InteractionResult.KILL == trap1.interact(gameboard, 10));
		for(int p = 0; p < 10; p++) {
			assert(InteractionResult.NONE == trap1.interact(gameboard, p));
		}
		
		for(int p = 12; p < GameEngine.BOARD_SIZE; p++) {
			assert(InteractionResult.NONE == trap1.interact(gameboard, p));
		}
	}
	
	@Test
	void testSlimeInteract() {
		Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE];
		Slime slime1 = new Slime('s',"SLIME",11);
		gameboard[11] = slime1;
		
		assert(InteractionResult.HIT == slime1.interact(gameboard, 10));
		assert(InteractionResult.NONE == slime1.interact(gameboard, 11));
		assert(InteractionResult.HIT == slime1.interact(gameboard, 12));
		
		for(int p = 0; p < 10; p++) {
			assert(InteractionResult.NONE == slime1.interact(gameboard, p));
		}
		for(int p = 13; p < GameEngine.BOARD_SIZE; p++) {
			assert(InteractionResult.NONE == slime1.interact(gameboard, p));
		}
	}
	
	@Test
	void testCoinInteract() {
		Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE];
		Coin coin1 = new Coin('c',"COIN",11);
		gameboard[11] = coin1;
		
		assert(InteractionResult.GET_POINT == coin1.interact(gameboard, 11));
		
		for(int p = 0; p < 11; p++) {
			assert(InteractionResult.NONE == coin1.interact(gameboard, p));
		}
		for(int p = 12; p < GameEngine.BOARD_SIZE; p++) {
			assert(InteractionResult.NONE == coin1.interact(gameboard, p));
		}
	}

}
