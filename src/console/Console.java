package console;

import java.util.Scanner;

import plateau.Plateu;
import rover.Rover;
import utility.CommandType;
import utility.Defragmenter;

public class Console {
	private static Defragmenter defragmenter = new Defragmenter();
	private static boolean exit = false;
	private static Scanner sc = new Scanner(System.in);
	private static Rover rover;
	private static Plateu plateu;
	
	public Console() {
	}

	public static void main(String[] args) {
		while(!exit){
			System.out.println("Console: ");
			String message = sc.nextLine().toUpperCase();
			if (message.equals("EXIT")){
				exit = true;
			} else {
				send(message);
			}
		}
	}
	
	public static void send(String messenge){
		CommandType commandType = defragmenter.defragmentCommandType(messenge);
		switch (commandType) {
		case PA:
			plateu = new Plateu(defragmenter.getNumbers().get(0), defragmenter.getNumbers().get(1));
			System.out.println(commandType.getConfirmationMessage());
			break;
		case RL:
			if (plateu != null) {
				rover = new Rover(plateu, defragmenter.getDirection(), defragmenter.getNumbers().get(0), defragmenter.getNumbers().get(1));
				System.out.println(commandType.getConfirmationMessage());
			} else {
				System.out.println(commandType.getDenialMessage());
			}
			break;
		case RD:
			if (plateu != null && rover != null) {
				rover.drive(defragmenter.getCommands());
				System.out.println(commandType.getConfirmationMessage() + rover);
				rover = null;
				plateu = null;
			} else {
				System.out.println(commandType.getDenialMessage());
			}
			break;
		case CE:
			System.out.println(commandType.getDenialMessage());
			break;
		default:
			break;
		}
	}
}
