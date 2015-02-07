import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;

public class InputManager implements KeyListener{
	
	boolean[] keys = new boolean[256];
	
	public InputManager(Component c){
		c.addKeyListener(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
				keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
			keys[e.getKeyCode()] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	public boolean keyPressed(int keyCode){
		return keys[keyCode];
	}
	
	/*
	 if(input.keyPressed(KeyEvent.VK_UP))
			y--;
	 */
	
}
