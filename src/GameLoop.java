import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameLoop extends JFrame{
	
	private boolean isRunning = true;
	private static final int fps = 60;
	
	private int windowWidth = 1280;
	private int windowHeight = 720;
	
	private Insets insets;
	private BufferedImage backBuffer;
	InputManager input;
	
	private int x = 10;
	private int y = 10;
	
	public void run(){
		
		init();
		
		while(isRunning){
			long time = System.currentTimeMillis();
			
			//input();
			update();
			render();
			
			time = (1000 / fps) - (System.currentTimeMillis() - time);
			
			if(time > 0)
			{
				try
				{
					Thread.sleep(time);
				}
				catch(Exception e){}
			}
		}
		
		setVisible(false);
	}
	
	private void init(){
		setTitle("Pewpewvideogeim");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		insets = getInsets();
		int widthInset = insets.left + insets.right;
		int heightInset = insets.top + insets.bottom;
		setSize(windowWidth + widthInset, windowHeight + heightInset);
		backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
		
		input = new InputManager(this);
	}
	
	private void update(){
		if(input.keyPressed(KeyEvent.VK_UP))
			y--;
		
		if(input.keyPressed(KeyEvent.VK_DOWN))
			y++;
		
		if(input.keyPressed(KeyEvent.VK_LEFT))
			x--;
		
		if(input.keyPressed(KeyEvent.VK_RIGHT))
			x++;
			
	}
	
	private void render(){
		Graphics g = getGraphics();
		
		Graphics bbg = backBuffer.getGraphics();
		
		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, 1000, 1000);
		
		bbg.setColor(Color.RED);
		bbg.fillRect(0, 0, 10, 10);
		bbg.fillRect(x, y, 10, 10);
		
		bbg.drawString("" + x + " ," + y, 25, 25);
		if(input.keyPressed(KeyEvent.VK_UP))
			bbg.fillRect(50, 50, 10, 10);
		
		g.drawImage(backBuffer, insets.left, insets.top, this);
	}
	
}
