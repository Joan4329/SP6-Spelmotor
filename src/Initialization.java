
public class Initialization {
	
	private int windowWidth = 1280;
	private int windowHeight = 720;
	private int fps = 60;
	
	
	public void init(){
		Renderer renderer = new Renderer(windowWidth, windowHeight);
		GameLoop loop = new GameLoop(fps, renderer);
		loop.run();
	}
	
}
