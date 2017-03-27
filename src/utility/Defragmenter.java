package utility;

import java.util.ArrayList;

public class Defragmenter {
	
	private ArrayList<Integer> numbers = new ArrayList<>();
	private Direction direction;
	private ArrayList<String> commands = new ArrayList<>();
	
	public CommandType defragmentCommandType(String message) {
		char[] chars = message.toCharArray();
		if(chars.length == 3){
			for (int i = 0; i <= chars.length - 1; i++) {
				if (i != 1 && isNumeric(Character.toString(chars[i]))){
					numbers.add(Integer.parseInt(Character.toString(chars[i])));
					continue;
				} else if (i == 1 && Character.isWhitespace(chars[i])){
					continue;
				} else {
					return CommandType.CE;
				}
			}
		return CommandType.PA;
		} else if (chars.length == 5){
			for (int i = 0; i <= chars.length - 1; i++) {
				if ((i != 1 || i != 3) && isNumeric(Character.toString(chars[i]))){
					numbers.add(Integer.parseInt(Character.toString(chars[i])));
					continue;
				} else if ((i != 1 || i != 3) && Character.isWhitespace(chars[i])){
					continue;
				} else if (commandToDirection(Character.toString(chars[i])) != null && (i == (chars.length -1))){
					direction = commandToDirection(Character.toString(chars[i]));
					continue;
				} else {
					return CommandType.CE;
				}
			}
		return CommandType.RL;
		} else {
			for (int i = 0; i <= chars.length - 1; i++) {
				if (isCommandDrives(Character.toString(chars[i]))){
					commands.add(Character.toString(chars[i]));
					continue;
				} else {
					return CommandType.CE;
				}
			}
			return CommandType.RD;
		}
	}
	
//	public ArrayList<Integer> defragmentNumbers(String messenge){
//		
//	}
	
	private Direction commandToDirection(String c){
		switch (c) {
		case "N":
			return Direction.N;
		case "W":
			return Direction.W;
		case "E":
			return Direction.E;
		case "S":
			return Direction.S;
		default:
			return null;
		}
	}
	
	private boolean isNumeric(String c){
		try {  
			int d = Integer.parseInt(c);
		} catch(NumberFormatException nfe) {  
			return false;  
		}  
		return true;  
	}
	
	private boolean isCommandDrives(String c){
		switch (c) {
		case "M":
			return true;
		case "L":
			return true;
		case "R":
			return true;
		default:
			return false;
		}
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public ArrayList<Integer> getNumbers() {
		return numbers;
	}
	
	public ArrayList<String> getCommands() {
		return commands;
	}
}
