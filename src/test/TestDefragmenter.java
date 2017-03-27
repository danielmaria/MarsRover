package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utility.CommandType;
import utility.Defragmenter;

public class TestDefragmenter {
	private Defragmenter df;
	
	@Before
	public void set(){
		df = new Defragmenter();
	}
	
	@Test
	public void testCommandTypePlateuArea() {
		String message = "5 5";
		CommandType ct = df.defragmentCommandType(message);
		assertEquals(ct, CommandType.PA);
	}
	// Vericar nome
	@Test
	public void testCommandTypePlateuAreaWithNoWhitespace() {
		String message = "5D5";
		CommandType ct = df.defragmentCommandType(message);
		assertEquals(ct, CommandType.CE);
	}
	
	@Test
	public void testCommandTypeRoverLocation() {
		String message = "5 5 N";
		CommandType ct = df.defragmentCommandType(message);
		assertEquals(ct, CommandType.RL);
	}
	
	@Test
	public void testCommandTypeRoverLocationWithLetterInTheWrongLocation() {
		String message = "N 5 5";
		CommandType ct = df.defragmentCommandType(message);
		assertEquals(ct, CommandType.CE);
		message = "5 N 5";
		ct = df.defragmentCommandType(message);
		assertEquals(ct, CommandType.CE);
	}
	
	
	@Test
	public void testCommandTypeRoverDrives() {
		String message = "MLMRMMR";
		CommandType ct = df.defragmentCommandType(message);
		assertEquals(ct, CommandType.RD);
	}

	@Test 
	public void testCommandTypeRoverDrivesWithLetteInCommand() {
		String message = "MLMMRD";
		CommandType ct = df.defragmentCommandType(message);
		assertEquals(ct, CommandType.CE);
		message = "MLMDMR";
		ct = df.defragmentCommandType(message);
		assertEquals(ct, CommandType.CE);
		message = "DMLMMR";
		ct = df.defragmentCommandType(message);
		assertEquals(ct, CommandType.CE);
	}
	

}
