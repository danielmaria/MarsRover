package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plateau.Plateu;
import rover.Rover;
import utility.Direction;

public class TestRover {
	Rover rover;
	Plateu plateu;
	@Before
	public void setAtributes(){
		plateu = new Plateu(5, 5);
		rover = new Rover(plateu, Direction.N, 1, 1);
	}
	
	@Test
	public void testTurnRight(){ 
		rover.turnRight();
		assertEquals(rover.getDirection(), Direction.E);
		rover.turnRight();
		assertEquals(rover.getDirection(), Direction.S);
		rover.turnRight();
		assertEquals(rover.getDirection(), Direction.W);
		rover.turnRight();
		assertEquals(rover.getDirection(), Direction.N);
		
	}
	
	@Test
	public void testTurnLeft(){ 
		rover.turnLeft();
		assertEquals(rover.getDirection(), Direction.W);
		rover.turnLeft();
		assertEquals(rover.getDirection(), Direction.S);
		rover.turnLeft();
		assertEquals(rover.getDirection(), Direction.E);
		rover.turnLeft();
		assertEquals(rover.getDirection(), Direction.N);
	}
	
	@Test
	public void testMoveToNorth(){
		rover.move();
		assertEquals(rover.getPositionX(), 1);
		assertEquals(rover.getPositionY(), 2);
	}
	
	@Test
	public void testMoveToSouth(){
		rover.turnLeft();
		rover.turnLeft();
		rover.move();
		assertEquals(rover.getPositionX(), 1);
		assertEquals(rover.getPositionY(), 0);
	}
	
	@Test
	public void testMoveToWest(){
		rover.turnLeft();
		rover.move();
		assertEquals(rover.getPositionX(), 0);
		assertEquals(rover.getPositionY(), 1);
	}
	
	@Test
	public void testMoveToEast(){
		rover.turnRight();
		rover.move();
		assertEquals(rover.getPositionX(), 2);
		assertEquals(rover.getPositionY(), 1);
	}
	
	@Test
	public void testTryPassDimensionXUsingNorthDirectionPlateu(){
		boolean canMove;
		canMove = rover.move();
		assertTrue(canMove);
		canMove = rover.move();
		assertTrue(canMove);
		canMove = rover.move();
		assertTrue(canMove);
		canMove = rover.move();
		assertTrue(canMove);
		assertEquals(rover.getPositionY(), 5);
		canMove = rover.move();
		assertFalse(canMove);
		assertEquals(rover.getPositionX(), 1);
		assertEquals(rover.getPositionY(), 5);
	}
	
	@Test
	public void testTryPassDimensionXUsingSouthDirectionPlateu(){
		boolean canMove;
		rover.turnRight();
		rover.turnRight();
		assertEquals(rover.getDirection(), Direction.S);
		canMove = rover.move();
		assertTrue(canMove);
		assertEquals(rover.getPositionY(), 0);
		canMove = rover.move();
		assertFalse(canMove);
		assertEquals(rover.getPositionX(), 1);
		assertEquals(rover.getPositionY(), 0);
	}
	
	@Test
	public void testTryPassDimensionYUsingEastDirectionPlateu(){
		boolean canMove;
		rover.turnRight();
		assertEquals(rover.getDirection(), Direction.E);
		canMove = rover.move();
		assertTrue(canMove);
		canMove = rover.move();
		assertTrue(canMove);
		canMove = rover.move();
		assertTrue(canMove);
		canMove = rover.move();
		assertTrue(canMove);
		assertEquals(rover.getPositionX(), 5);
		canMove = rover.move();
		assertFalse(canMove);
		assertEquals(rover.getPositionX(), 5);
		assertEquals(rover.getPositionY(), 1);
	}
	
	@Test
	public void testTryPassDimensionYUsingWestDirectionPlateu(){
		boolean canMove;
		rover.turnLeft();
		assertEquals(rover.getDirection(), Direction.W);
		canMove = rover.move();
		assertTrue(canMove);
		assertEquals(rover.getPositionX(), 0);
		canMove = rover.move();
		assertFalse(canMove);
		assertEquals(rover.getPositionX(), 0);
		assertEquals(rover.getPositionY(), 1);
	}
}
