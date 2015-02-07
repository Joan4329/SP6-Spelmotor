import java.util.List;

public class GameLoop{
	
	private boolean isRunning = true;
	private int fps = 60;
	
	InputManager input;
	Renderer renderer;
	GameWorld world;
	
	public GameLoop(int fps, Renderer renderer, GameWorld world){
		this.fps = fps;
		this.renderer = renderer;
		this.world = world;
	}
	
	public void run(){
		
		init();
		
		while(isRunning){
			long time = System.currentTimeMillis();
			
			update();
			
			List<DGameObject> drawableObjects = world.getDrawableObjects();
			for (DGameObject o : drawableObjects){
				o.draw();
			}
			
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
		
	}
	
}
