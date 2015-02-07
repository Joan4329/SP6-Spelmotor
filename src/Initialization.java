
public class Initialization {
	
	private int windowWidth = 1280;
	private int windowHeight = 720;
	private int fps = 60;
	
	
	public void init(){
		GameWorld world = new GameWorld();
		Vector camera = new Vector(0, 0);
		Renderer renderer = new Renderer(windowWidth, windowHeight, camera);
		GameLoop loop = new GameLoop(fps, renderer, world);
		
		Sprite o = new Sprite(new Vector(30, 30), 0, "/images/test.png", renderer, 0, new Vector(0, 0));
		world.addObject(o);
		o = new Sprite(new Vector(55, 70), 0, "/images/test.png", renderer, 36, new Vector(0, 0));
		world.addObject(o);
		o = new Sprite(new Vector(100, 100), 0, "/images/test.png", renderer, 113, new Vector(0, 0));
		world.addObject(o);
		o = new Sprite(new Vector(130, 120), 0, "/images/test.png", renderer, 90, new Vector(0, 0));
		world.addObject(o);
		o = new Sprite(new Vector(150, 150), 0, "/images/test.png", renderer, 45, new Vector(0, 0));
		world.addObject(o);
		
		// GameWorld not sent to GameLoop?
		
		loop.run();
	}
	
}
