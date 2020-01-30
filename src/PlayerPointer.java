import java.awt.Color;

import java.awt.event.KeyEvent;

public class PlayerPointer {
	int X,Y,oX,oY;
	int dir = 0;
	int temp =-1; 
	
	PlayerPointer(int X, int Y){
		this.X = X;
		this.Y = Y;
	}
	
	public void draw() {	
		SinasGameOfLife.myobjects[oX][oY].draw();
		SinasGameOfLife.grid.setColor(X,Y,Color.RED);
	}
	
	public void logic() {
		boolean flag = false;
		oX = X;
		oY = Y;
		if(InputHander.pressed.contains(KeyEvent.VK_UP)) {
			X--;
			flag = true;
		} 
		if(InputHander.pressed.contains(KeyEvent.VK_DOWN)) {
			
			X++;
			flag = true;
		}
		if(InputHander.pressed.contains(KeyEvent.VK_RIGHT)) {
			Y++;
			flag = true;
		}
		if(InputHander.pressed.contains(KeyEvent.VK_LEFT)) {
			Y--;
			flag = true;
		}
		
		
		if (Y > SinasGameOfLife.size*2-1)
			Y = SinasGameOfLife.size*2-1;
		if (Y <= 0)
			Y = 0;
		if (X > SinasGameOfLife.size-1)
			X = SinasGameOfLife.size-1;
		if (X <= 0)
			X = 0;
		
		if(InputHander.pressed.contains(KeyEvent.VK_SPACE)) {
			SinasGameOfLife.myobjects[X][Y].state = !SinasGameOfLife.myobjects[X][Y].state;

			if(!flag)
				InputHander.pressed.remove(new Integer(KeyEvent.VK_SPACE));

		}
		
		if(InputHander.pressed.contains(KeyEvent.VK_P)) {
			SinasGameOfLife.paused = !SinasGameOfLife.paused ;
			InputHander.pressed.remove(new Integer(KeyEvent.VK_P));
			
		}

	}

}
