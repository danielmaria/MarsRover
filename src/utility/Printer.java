package utility;

import plateau.Plateu;
import rover.Rover;

public class Printer {
	String area[][];
	
	public Printer(Plateu plateu){
		int x = plateu.getDimensionX();
		int y = plateu.getDimensionY();
		area = new String[x][y];
		fillsPlateu();
	}

	private void fillsPlateu() {
		int i = 0;
		int j = 0;
		for (i=0; i<area.length; i++) {
			for (j=0; j<area[i].length; j++) {
				area[i][j] = " [ ] ";
			}
		}
	}
	
	public void printRover(Rover rover){
		int x = rover.getPositionX() - 1;
		int y = rover.getPositionY() - 1;
		area[x][y] = " ["+ rover.getDirection().getView() +"] ";
	} 
	
	public String toString(){
		int i = 0;
		int j = 0;
		String aux = "";
		for (i=0; i<area.length; i++) {
			for (j=0; j<area[i].length; j++) {
				aux += area[i][j];
			}
			aux += "\n";
		}
		return aux;
	}
}
