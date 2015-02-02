
public abstract class DUGameObject extends DGameObject implements Updateable {
	
	// attributes inherited from DGameObject
	
	
	public DUGameObject(int x, int y, int drawOrder, String imageFile){
		super(x, y, drawOrder, imageFile);
		
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
