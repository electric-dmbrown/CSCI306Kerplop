package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import gameEngine.*;
import levelPieces.*;

class TestMovingPieces {
	
	/**
	 * TestSlimeMovements: Test that the slime moves to the right one space when the space
	 * to the right is open and two space if the space to the right is blocked. Tests that
	 * the slime wraps around the board. And finally test that the piece doesn't move with
	 * two blocked spaces to the right.
	 */
	@Test
	void testSlimeMovements() {
		Drawable[] gameboard = new Drawable[GameEngine.BOARD_SIZE]; // set up the board
		
		/*
		 * Set up all the pieces for the slime testing.
		 */
		Slime slime1 = new Slime('s',"SLIME",17);
		FlowerPiece flower1 = new FlowerPiece('f',"FLOWER",19);
		FlowerPiece flower2 = new FlowerPiece('f',"FLOWER",1);
		FlowerPiece flower3 = new FlowerPiece('f',"FLOWER",2);
		gameboard[17] = slime1;
		gameboard[19] = flower1;
		gameboard[1] = flower2;
		gameboard[2] = flower3;
		
		/*
		 * Test that the slime can move one space to the right when not blocked
		 */
		slime1.move(gameboard,6);
		assert(slime1 == gameboard[18]);
		
		/*
		 * test that the slime can move two space when space immediately to the right is blocked.
		 */
		slime1.move(gameboard,6);
		assert(slime1 == gameboard[20]);
		
		/*
		 * Test that the slime can wrap around the board.
		 */
		slime1.move(gameboard, 6);
		assert(slime1 == gameboard[0]);
		
		/*
		 * Test that slime does not move if two space right are blocked.
		 */
		slime1.move(gameboard, 6);
		assert(slime1 == gameboard[0]);
	}

}
