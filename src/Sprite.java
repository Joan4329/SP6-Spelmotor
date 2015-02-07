
public class Sprite extends DUGameObject {

	// Doesn't do anything more than DUGameObject except that it's not abstract. It's here so that application-programmers don't have to create their own class for simple sprites
	
	public Sprite(Vector coords, int drawOrder, String imageFile, Renderer renderer, double rotation, Vector velocity){
		super(coords, drawOrder, imageFile, renderer, rotation, velocity);
	}
	
}
