import java.awt.Color;


public class GoLCell {
	
	public boolean state = false;
	
	int X,Y,n;
	
	GoLCell(int X, int Y){
		this.X = X;
		this.Y = Y;
		
		
		if(X == 20 || X == 21 || X==22)   { 
			if(Y == 20 || Y == 21 || Y ==22) state = true;
		}
		
	}
	
	public void earlyLogic() {
		n=0;
		for(int i =-1; i<2; i++) {
			for(int j =-1; j<2; j++) {
				
				if (  
					(i != 0 || j!=0) && 
					X+i < SinasGameOfLife.grid.getWd()&&
					Y+j < SinasGameOfLife.grid.getHt()&&
					X+i >= 0 &&
					Y+j >= 0&&
					SinasGameOfLife.myobjects[Y+j][X+i].state == true)
					{
					n++;
				}
				
			}
		}
	}
	
	public void lateLogic() {
		if(state && n <2) state = false;
		else if(state && n >3) state = false;
		else if(!state && n == 3) state =true;
	}
	
	public void draw() {
		if(state) {
			 SinasGameOfLife.grid.setColor(Y,X,Color.BLACK);
		}else{
			SinasGameOfLife.grid.setColor(Y,X,Color.WHITE);
		}
		
	}
	
	public void Logic() {
		
	}
}
