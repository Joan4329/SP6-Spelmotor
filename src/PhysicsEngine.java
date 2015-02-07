public class PhysicsEngine {

	// Collision detections
	// Sphere vs Sphere
	public static boolean checkCircleCollision(BoundingCircle a, BoundingCircle b){
		
		Vector centerVector = Vector.subtrVectors(b.getVector(), a.getVector());
		double distanceSquared = Vector.dotProduct(centerVector, centerVector);
		double radiusSquared = (a.getRadius() + b.getRadius()) * (a.getRadius() + b.getRadius());
		
		if (distanceSquared < radiusSquared)
			return true;
		
		return false;
	}
	
	public static boolean checkBoxCollision(AABB a, AABB b){
		
		boolean test = (a.getXMax() < b.getXMax() || (b.getXMax() < a.getXMin()) ||
						a.getYMax() < b.getYMin() || (b.getYMax() < a.getYMin()));
		
		return !test;
	}
	
	public static boolean checkCircleAABB(BoundingCircle circle, AABB box){
		double sqDist = sqDistPointAABB(circle.getVector(), box);
		double r = circle.getRadius();
		
		return sqDist <= r * r;
	}
	
	public static double sqDistPointAABB(Vector p, AABB aabb){
		double sqDist = 0.0f;
		double v;
		double minX, minY, maxX, maxY;
		
		minX = aabb.getXMin();
		minY = aabb.getYMin();
		maxX = aabb.getXMax();
		maxY = aabb.getYMax();
		
		v = p.getX();
		
		if (v < minX)
			sqDist += (minX - v) * (minX - v);
		
		if (v > maxX)
			sqDist += (v - maxX) * (v - maxX);
		
		v = p.getY();
		
		if (v < minY)
			sqDist += (minY - v) * (minY - v);
		
		if (v > maxY)
			sqDist += (v - maxY) * (v - maxY);
		
		return sqDist;
	}
	
	public static Vector gravity(Vector velocity, double modifier, double terminalVelocity, int fps, double gameTimeFactor){
		Vector newVelocity = velocity;
		double newX;
		
		newX = ((1 / fps) * modifier) * gameTimeFactor;	
		
		if(velocity.getX() + newX < terminalVelocity){
			newVelocity.setX(velocity.getX() - newX);
		}else if(velocity.getX() < terminalVelocity) {
			newVelocity.setX(terminalVelocity);
		}
		
		return newVelocity;
	}
	
}
