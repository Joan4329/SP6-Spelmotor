import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener{
	
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP)
			up = true;
		
		if (key == KeyEvent.VK_DOWN)
			down = true;
		
		if (key == KeyEvent.VK_LEFT)
			left = true;
		
		if (key == KeyEvent.VK_RIGHT)
			right = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP)
			up = false;
		
		if (key == KeyEvent.VK_DOWN)
			down = false;
		
		if (key == KeyEvent.VK_LEFT)
			left = false;
		
		if (key == KeyEvent.VK_RIGHT)
			right = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
