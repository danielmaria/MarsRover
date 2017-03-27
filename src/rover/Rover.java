package rover;

import java.util.ArrayList;

import plateau.Plateu;
import utility.Direction;

public class Rover {
	private int positionX;
	private int positionY;
	private String cod;
	private Direction direction;
	Plateu yourPlateu;
	
	public Rover(Plateu p, Direction d, int x, int y){
		this.direction = d;
		this.positionX = x;
		this.positionY = y;
		this.yourPlateu = p;
	}
	
	public void turnRight(){
		if (this.direction == Direction.N) {
			this.direction =  Direction.E;
		} else if (this.direction == Direction.E) {
			this.direction =  Direction.S;
		} else  if (this.direction == Direction.S) {
			this.direction =  Direction.W;
		} else  if (this.direction == Direction.W) {
			this.direction =  Direction.N;
		}
	}
	
	public void turnLeft(){
		if (this.direction == Direction.N) {
			this.direction =  Direction.W;
		} else if (this.direction == Direction.W) {
			this.direction =  Direction.S;
		} else  if (this.direction == Direction.S) {
			this.direction =  Direction.E;
		} else  if (this.direction == Direction.E) {
			this.direction =  Direction.N;
		}
	}

	public boolean move() {
		if (this.direction == Direction.N) {
			if (this.positionY < this.yourPlateu.getDimensionY()){
				this.positionY += 1;
				return true;
			}
		} else if (this.direction == Direction.S) {
			if (this.positionY > 0){
				this.positionY -= 1;
				return true;
			}
		} else if (this.direction == Direction.E) {
			if (this.positionX < this.yourPlateu.getDimensionX()){
				this.positionX += 1;
				return true;
			}
		} else if (this.direction == Direction.W) {
			if (this.positionX > 0){
				this.positionX -= 1;
				return true;
			}
		}
		return false;
	}
	
	public void drive(ArrayList<String> commands){
		for (String command : commands) {
			switch (command) {
			case "M":
				move();
				break;
			case "L":
				turnLeft();
				break;
			case "R":
				turnRight();
				break;
			default:
				break;
			}
		}
	}
	
	public String toString(){
		return this.getPositionX() + " " + this.getPositionY() + " " + this.getDirection();
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	
}
