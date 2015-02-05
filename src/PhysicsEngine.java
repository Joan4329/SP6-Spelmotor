public class PhysicsEngine {

	// Collision detections
	// Sphere vs Sphere
	public static boolean checkSphereCollision(BoundingCircle a, BoundingCircle b){
		
		Vector centerVector = Vector.subtrVectors(b.getVector(), a.getVector());
		double distanceSquared = Vector.dotProduct(centerVector, centerVector);
		double radiusSquared = (a.getRadius() + b.getRadius()) * (a.getRadius() + b.getRadius());
		
		if (distanceSquared < radiusSquared)
			return true;
		
		return false;
	}
	public static boolean chechBoxCollision(AABB a, AABB b){
		
		boolean test = (a.getXMax() < b.getXMax() || (b.getXMax() < a.getXMin()) ||
						a.getYMax() < b.getYMin() || (b.getYMax() < a.getYMin()));
		
		return !test;
	}
}
