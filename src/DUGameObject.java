
public abstract class DUGameObject extends DGameObject implements Updateable {
	
	// attributes inherited from DGameObject
	
	public DUGameObject(Vector coords, int drawOrder, String imageFile, Renderer renderer, double rotation){
		super(coords, drawOrder, imageFile, renderer, rotation);
		// Possibly do some more stuff that UGameObject does...
	}
	
	public void update(){
		
	}
	
	
	// Inherited from DGameObject
//	public void draw(){
//		// Draw object's image at its position
//		
//	}
	
//	public int getDrawOrder(){
//		return drawOrder;
//	}
}
