import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class InputHander implements MouseMotionListener,KeyListener{
	static public ArrayList<Integer> pressed = new ArrayList<Integer>() ;
	static public int MX, MY;
	
	public InputHander(MyGrid grid) {
		grid.addKeyListener(this);
		grid.addMouseMotionListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!pressed.contains(new Integer(e.getKeyCode())))
			pressed.add( new Integer(e.getKeyCode()) );
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(InputHander.pressed.contains(e.getKeyCode()))
			pressed.remove(new Integer( e.getKeyCode()));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println(e.getX() + "   " + e.getY());
		MX = e.getX();
		MY = e.getY();
	}	
}
