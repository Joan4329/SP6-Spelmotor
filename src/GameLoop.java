import java.awt.event.KeyEvent;

public class GameLoop{
	
	private boolean isRunning = true;
	private int fps = 60;
	
	InputManager input;
	
	private int x = 10;
	private int y = 10;
	
	Renderer renderer;
	
	public GameLoop(int fps, Renderer renderer){
		this.fps = fps;
		this.renderer = renderer;
	}
	
	public void run(){
		
		init();
		
		while(isRunning){
			long time = System.currentTimeMillis();
			
			update();
			renderer.draw();
			
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
		
	}
	
	private void init(){
		input = new InputManager(renderer);
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
	
}
