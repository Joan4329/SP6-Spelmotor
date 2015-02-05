//import java.awt.Image;

// Used by PhysicsEngine to perform collision checks. When creating new GameObject subclasses make this an attribute if collision is wanted for object. 
public class BoundingSphere {
	private Vector center;
	private double radius;
	
	public BoundingSphere(double r){
		center = new Vector();
		radius = r;
	}
	
	public BoundingSphere(double r, double offsetX, double offsetY){
		center = new Vector(offsetX, offsetY);
		radius = r;
	}
	
//	Maybe this?
//	public BoundingSphere(double r, Image img){
//		center = new Vector(img.getWidth(ImageObserver)/2, img.getHeight(ImageObserver)/2)
//	}
	
	public Vector getVector(){
		return center;
	}
	public void setVector(double x, double y){
		center.setX(x);
		center.setY(y);
	}
	public double getRadius(){
		return radius;
	}
	public void setRadius(double r){
		radius = r;
	}
	

}
