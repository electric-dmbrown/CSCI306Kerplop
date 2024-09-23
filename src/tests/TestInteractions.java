package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import levelPieces.*;
import gameEngine.*;

class TestInteractions {
	
	/**
	 * test that the trap piece interacts properly. 
	 */
	@Test
	void testTrapInteract() {
		Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE]; // set up the board
		
		/**
		 * set up pieces for testing
		 */
		Trap trap1 = new Trap('t',"TRAP",11);
		gameboard[11] = trap1;
		
		/**
		 * test that the player gets killed when to the let of the trap
		 */
		assert(InteractionResult.KILL == trap1.interact(gameboard, 10));
		
		/**
		 * test that all other spots return none.
		 */
		for(int p = 0; p < 10; p++) {
			assert(InteractionResult.NONE == trap1.interact(gameboard, p));
		}
		for(int p = 12; p < GameEngine.BOARD_SIZE; p++) {
			assert(InteractionResult.NONE == trap1.interact(gameboard, p));
		}
	}
	
	/**
	 * test that the slime interacts properly.
	 */
	@Test
	void testSlimeInteract() {
		Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE]; // set up the board
		
		/**
		 * set up pieces for testing
		 */
		Slime slime1 = new Slime('s',"SLIME",11);
		gameboard[11] = slime1;
		
		/*
		 * test that the slime hit to both sides and does not hit when player is on the
		 * same space.
		 */
		assert(InteractionResult.HIT == slime1.interact(gameboard, 10));
		assert(InteractionResult.NONE == slime1.interact(gameboard, 11));
		assert(InteractionResult.HIT == slime1.interact(gameboard, 12));
		
		/**
		 * test that all other spaces return none.
		 */
		for(int p = 0; p < 10; p++) {
			assert(InteractionResult.NONE == slime1.interact(gameboard, p));
		}
		for(int p = 13; p < GameEngine.BOARD_SIZE; p++) {
			assert(InteractionResult.NONE == slime1.interact(gameboard, p));
		}
	}
	
	/**
	 * test that the coin interacts properly.
	 */
	@Test
	void testCoinInteract() {
		Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE]; // set up the board
		
		/**
		 * set up pieces for testing
		 */
		Coin coin1 = new Coin('c',"COIN",11);
		gameboard[11] = coin1;
		
		/**
		 * Test that the coin returns get_point when the player is on the same space.
		 */
		assert(InteractionResult.GET_POINT == coin1.interact(gameboard, 11));
		
		/*
		 * test that all other spaces return none.
		 */
		for(int p = 0; p < 11; p++) {
			assert(InteractionResult.NONE == coin1.interact(gameboard, p));
		}
		for(int p = 12; p < GameEngine.BOARD_SIZE; p++) {
			assert(InteractionResult.NONE == coin1.interact(gameboard, p));
		}
	}
	
	/*
	 * tests wall interactions
	 */
	@Test
	void testWallInteract() {
		Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE];
		WallPiece wall1 = new WallPiece('W',"Wall",11);
		gameboard[11] = wall1; // sets the wall to position 11
		
		/*
		 * Tests if the player interacts with the wall, it returns HIT
		 */
		assert(InteractionResult.HIT == wall1.interact(gameboard, 11));
		
		/*
		 * Tests if the player doesn't interact with anything that it returns NONE
		 */
		for(int p = 0; p < 11; p++) {
			assert(InteractionResult.NONE == wall1.interact(gameboard, p));
		}
		for(int p = 12; p < GameEngine.BOARD_SIZE; p++) {
			assert(InteractionResult.NONE == wall1.interact(gameboard, p));
		}
	}
	
	/*
	 * tests fairy interactions
	 */
	@Test
	void testFairyInteract() {
		Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE];
		FairyPiece fairy1 = new FairyPiece('F',"Fairy",11);
		gameboard[11] = fairy1; // sets the fairy to position 11

		/*
		 * Tests if the player interacts with the fairy, it returns ADVANCE
		 */
		assert(InteractionResult.ADVANCE == fairy1.interact(gameboard, 11));
		
		/*
		 * Tests if the player doesn't interact with anything that it returns NONE
		 */
		for(int p = 0; p < 11; p++) {
			assert(InteractionResult.NONE == fairy1.interact(gameboard, p));
		}
		for(int p = 12; p < GameEngine.BOARD_SIZE; p++) {
			assert(InteractionResult.NONE == fairy1.interact(gameboard, p));
		}
	}
	
	/*
	 * tests flower interactions
	 */
	@Test
	void testFlowerInteract() {
		Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE];
		FlowerPiece flower1 = new FlowerPiece('f',"Flower",11);
		gameboard[11] = flower1; // sets the flower to position 11
		
		/*
		 * Tests if the player interacts with the flower, it returns NONE
		 */
		assert(InteractionResult.NONE == flower1.interact(gameboard, 11));
		
		/*
		 * Tests if the player doesn't interact with anything that it returns NONE
		 */
		for(int p = 0; p < 11; p++) {
			assert(InteractionResult.NONE == flower1.interact(gameboard, p));
		}
		for(int p = 12; p < GameEngine.BOARD_SIZE; p++) {
			assert(InteractionResult.NONE == flower1.interact(gameboard, p));
		}
	}

}
