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
	
	/**
	 * testFairy: test that the fairy is able to reach all of the spaces on the board.
	 */
	@Test
	void testFairy() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
	
		// Leave space 0 open
		FlowerPiece flower1 = new FlowerPiece('f',"FLOWER",1);
		gameBoard[1] = flower1;
		FlowerPiece flower2 = new FlowerPiece('f',"FLOWER",2);
		gameBoard[2] = flower2;
		FlowerPiece flower3 = new FlowerPiece('f',"FLOWER",3);
		gameBoard[3] = flower3;
		FlowerPiece flower4 = new FlowerPiece('f',"FLOWER",4);
		gameBoard[4] = flower4;
		FlowerPiece flower5 = new FlowerPiece('f',"FLOWER",5);
		gameBoard[5] = flower5;
		// Leave space 6 open
		FlowerPiece flower7 = new FlowerPiece('f',"FLOWER",7);
		gameBoard[7] = flower7;
		FlowerPiece flower8 = new FlowerPiece('f',"FLOWER",8);
		gameBoard[8] = flower8;
		FlowerPiece flower9 = new FlowerPiece('f',"FLOWER",9);
		gameBoard[9] = flower9;
		FlowerPiece flower10 = new FlowerPiece('f',"FLOWER",10);
		gameBoard[10]= flower10;
		FlowerPiece flower11 = new FlowerPiece('f',"FLOWER",11);
		gameBoard[11] = flower11;
		// Leave space 12 open
		// Leave space 13 open for player
		FlowerPiece flower14 = new FlowerPiece('f',"FLOWER",14);
		gameBoard[14] = flower14;
		FlowerPiece flower15 = new FlowerPiece('f',"FLOWER",15);
		gameBoard[15] = flower15;
		FlowerPiece flower16 = new FlowerPiece('f',"FLOWER",16);
		gameBoard[16] = flower16;
		FlowerPiece flower17 = new FlowerPiece('f',"FLOWER",17);
		gameBoard[17] = flower17;
		FlowerPiece flower18 = new FlowerPiece('f',"FLOWER",18);
		gameBoard[18] = flower18;
		FlowerPiece flower19 = new FlowerPiece('f',"FLOWER",19);
		gameBoard[19] = flower19;
		// Leave space 20 open
	
		FairyPiece fairy1 = new FairyPiece('F', "Fairy", 6);
		gameBoard[6] = fairy1;
		int count0 = 0;
		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		for (int i = 0; i<200; i++) {
			fairy1.move(gameBoard, 13);
			int loc = fairy1.getLocation();
		
			if (loc != 0 && loc != 6 && loc != 12 && loc != 13 && loc != 20) { // fails if goes to any other place besides the open ones
				fail("Invalid square selected");
			}
			if (loc == 0) {
				count0 ++;
			}
			if (loc == 6) {
				count6 ++;
			}
			if (loc == 12) {
				count12 ++;
			}
			if (loc == 20) {
				count20 ++;
			}
		}
		assert(count0 > 1); // Tests that fairy went to position 0 at least once
		assert(count6 > 1); // Tests that fairy went to position 6 at least once
		assert(count12 > 1); // Tests that fairy went to position 12 at least once
		assert(count20 > 1); // Tests that fairy went to position 20 at least once

	}

}
