import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GameLoop extends JFrame{
	
	private boolean isRunning = true;
	private static final int fps = 60;
	
	private int windowWidth = 1280;
	private int windowHeight = 720;
	
	public void run()
	{
		
		init();
		
		while(isRunning)
		{
			long time = System.currentTimeMillis();
			
			//update();
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
	
	private void init()
	{
		setTitle("Pewpewvideogeim");
		
		Insets insets = getInsets();
		int widthInset = insets.left + insets.right;
		int heightInset = insets.top + insets.bottom;
		setSize(windowWidth + widthInset, windowHeight + heightInset);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void render(){
		Insets insets = getInsets();
		Graphics g = getGraphics();
		
		BufferedImage backBuffer = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
		Graphics bbg = backBuffer.getGraphics();
		
		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, 1000, 1000);
		
		bbg.setColor(Color.RED);
		bbg.fillRect(0, 0, 10, 10);
		bbg.fillRect(10, 10, 10, 10);
		
		g.drawImage(backBuffer, insets.left, insets.top, this);
	}
	
}
