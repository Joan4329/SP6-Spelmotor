
public class Vector {
	private double x;
	private double y;
	
	public Vector(){
		x = 0;
		y = 0;
	}
	
	public Vector(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public static Vector addVectors(Vector a, Vector b){
		return new Vector(a.x + b.x, a.y + b.y);
	}
	
	public static Vector subtrVectors(Vector a, Vector b){
		return new Vector(a.x - b.x, a.y - b.y);
	}
	
	public static double dotProduct(Vector a, Vector b){
		return a.x * b.x + a.y * b.y;
	}
	
	public static Vector scalarMulti(int a, Vector b){
		return new Vector(a * b.x, a * b.y);
	}
	
	public double getX(){
		return x;
	}
	public void setX(double x){
		this.x = x;
	}
	public double getY(){
		return y;
	}
	public void setY(double y){
		this.y = y;
	}
}
