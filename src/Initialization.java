
public class Initialization {
	
	private int windowWidth = 1280;
	private int windowHeight = 720;
	private int fps = 60;
	
	
	public void init(){
		GameWorld world = new GameWorld();
		Renderer renderer = new Renderer(windowWidth, windowHeight, world);
		GameLoop loop = new GameLoop(fps, renderer);
		
		// Test, not final
		DGameObject o1 = new Sprite(15, 15, 0,"");
		DGameObject o2 = new Sprite(57, 26, 0,"");
		DGameObject o3 = new Sprite(155, 155, 0,"");
		DGameObject o4 = new Sprite(1005, 235, 0,"");
		DGameObject o5 = new Sprite(256, 600, 0,"");
		
		world.addObject(o1);
		world.addObject(o2);
		world.addObject(o3);
		world.addObject(o4);
		world.addObject(o5);
		// End test
		
		loop.run();
	}
	
}
