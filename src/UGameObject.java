
public abstract class UGameObject extends GameObject implements Updateable {

	private Vector velocity;
	
	public UGameObject(Vector coords){
		super(coords);
		velocity = new Vector();
		// Possibly do some more stuff
	}
	public UGameObject(Vector coords, Vector velocity){
		super(coords);
		this.velocity = velocity;
		// Possibly do some more stuff
	}
	public void update(long time){
		super.setCoordinates(Vector.addVectors(super.getCoordinates(), Vector.scalarMulti((int)time, velocity)));
	}
	
	public Vector getVelocity(){
		return velocity;
	}
	public void setVelocity(Vector v){
		velocity = v;
	}
}
