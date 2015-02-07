
public abstract class DUGameObject extends DGameObject implements Updateable {
	
	// attributes inherited from DGameObject
	
	// Since no inheritence (multiple inheritence) is possible from UGameObject this class needs to have its own velocity attribute.
	private Vector velocity;
	
		// Possibly do some more stuff that UGameObject does...
	public DUGameObject(Vector coords, int drawOrder, String imageFile, Renderer renderer, double rotation, Vector velocity){
		super(coords, drawOrder, imageFile, renderer, rotation);
		this.velocity = velocity;
	}
	
	// Same as above, these are needed because this class doesn't inherit from UGameObject
	public void update(long time){
		super.setCoordinates(Vector.addVectors(super.getCoordinates(), Vector.scalarMulti((int)time, velocity)));
	}
	public Vector getVelocity(){
		return velocity;
	}
	public void setVelocity(Vector v){
		velocity = v;
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
