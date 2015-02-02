import java.awt.*;
import javax.swing.JFrame;

public class GameLoop extends JFrame{
	
	private boolean isRunning;
	private static final int fps = 60;
	
	public void run()
	{
		
		init();
		
		while(isRunning)
		{
			long time = System.currentTimeMillis();
			
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
	
	private void init()
	{
		setTitle("Pewpewvideogeim");
		setSize(1280, 720);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
