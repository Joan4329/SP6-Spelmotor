
public class Initialization {
	
	private int windowWidth = 1280;
	private int windowHeight = 720;
	private int fps = 60;
	
	
	public void init(){
		GameWorld world = new GameWorld();
		Vector camera = new Vector(0, 0);
		Renderer renderer = new Renderer(windowWidth, windowHeight, camera);
		GameLogic logic = new GameLogic();
		GameLoop loop = new GameLoop(fps, renderer, world, logic);
		
		loop.run();
	}
	
}
