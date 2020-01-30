import java.util.concurrent.TimeUnit;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SinasGameOfLife {
	public static MyGrid grid; 
	static int size = 50;
	public static GoLCell[][] myobjects;
	public static int gameSpeed = 30;
	public static boolean paused = false;
	
	public static void main(String[] args) throws InterruptedException {
		

		
		
		grid = new MyGrid(size);
		
		myobjects = new GoLCell[grid.getHt()][grid.getWd()];
		
			
		for (int i =0; i < grid.getHt(); i++) {
			for (int j =0; j < grid.getWd(); j++) {
				myobjects[i][j] = new GoLCell(j,i);
			}
		}		
		
		PlayerPointer PP = new PlayerPointer((grid.getHt()-1)/2,(grid.getWd())/2);
		
		
		for(;;) {
			
			PP.logic();
			if(!paused) {
				for (int i =0; i < grid.getHt(); i++) {
					for (int j =0; j < grid.getWd(); j++) {
						myobjects[i][j].earlyLogic();
					}
				}
		
				for (int i =0; i < grid.getHt(); i++) {
					for (int j =0; j < grid.getWd(); j++) {
						myobjects[i][j].lateLogic();
					}
				}
				
				
				for (int i =0; i < grid.getHt(); i++) {
					for (int j =0; j < grid.getWd(); j++) {
						myobjects[i][j].draw();
					}
				}
			}
			PP.draw();
			
			grid.REPAINT();
			TimeUnit.MILLISECONDS.sleep(gameSpeed);

		}
		
		
		
	}
}

