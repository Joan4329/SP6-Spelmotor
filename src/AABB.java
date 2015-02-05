//import java.awt.Image;

// Used by PhysicsEngine to perform collision checks. When creating new GameObject subclasses make this an attribute if collision is wanted for object. 
public class AABB {
	private Vector coordinates;
	private Vector box;
	
	public AABB(Vector size){
		box = size;
	}
	
	public AABB(double x, double y){
		box = new Vector(x, y);
	}
	
	public AABB(Vector size, Vector coords){
		box = size;
		coordinates = coords;
	}
	
	public AABB(double x, double y, Vector coords){
		box = new Vector(x, y);
		coordinates = coords;
	}
	
	public Vector getSize(){
		return box;
	}
	
	public void setSize(double x, double y){
		box.setX(x);
		box.setY(y);
	}
	
	public Vector getCoords(){
		return coordinates;
	}
	
	public void setCoords(Vector coords){
		coordinates = coords;
	}
	
	public double getXMax(){
		return coordinates.getX() + box.getX();
	}
	
	public double getYMax(){
		return coordinates.getY() + box.getY();
	}
	
	public double getXMin(){
		return coordinates.getX();
	}
	
	public double getYMin(){
		return coordinates.getY();
	}
}
