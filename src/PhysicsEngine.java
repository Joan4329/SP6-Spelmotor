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
		
		boolean test = (a.getXMax() < b.getXMin() || (b.getXMax() < a.getXMin()) ||
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
		
		if (velocity.getX() + newX < terminalVelocity){
			newVelocity.setX(velocity.getX() - newX);
		}else if (velocity.getX() < terminalVelocity) {
			newVelocity.setX(terminalVelocity);
		}
		
		return newVelocity;
	}
	
	public static boolean inside(AABB aabb, Vector p){
		// Checks if point p is inside AABB aabb.
		
		boolean inside = (aabb.getXMax() < p.getX() || (p.getX() < aabb.getXMin()) ||
						  aabb.getYMax() < p.getY() || (p.getY() < aabb.getYMin()));

		return !inside;
	}
	
	public static Vector moveOutOfCollision(AABB a, AABB b, Vector v){
		// Moves AABB a out of AABB b depending on Vector v (Velocity of a).
		
		Vector newVector = new Vector();
		double xDif = 0;
		double yDif = 0;
		double ratio = Math.abs(v.getX() / v.getY());
		
		// To make sure a is moved slightly beyond the edge of b.
		double xIncrement = 0.001;
		double yIncrement = 0.001;
		
		// Check which direction "a" is moving and calculate distance from the closest edges of a and b.
		if (v.getX() < 0){
			xDif = a.getXMin() - b.getXMax(); 
		}else if (v.getX() > 0){
			xDif = a.getXMax() - b.getXMin();
		}
		
		if (v.getY() < 0){
			yDif = a.getYMin() - b.getYMax();
		}else if (v.getY() > 0){
			yDif = a.getYMax() - b.getYMin();
		}
		
		// Changing increment to be negative if the difference is.
		xIncrement = xIncrement * (xDif / Math.abs(xDif));
		yIncrement = yIncrement * (yDif / Math.abs(yDif));
		
		// If the speed on one axis is 0 only move on the other axis.
		if (v.getX() == 0){
			newVector.setY(a.getYMin() - (yDif + yIncrement));
			return newVector;
		}else if (v.getY() == 0){
			newVector.setX(a.getXMin() - (xDif + xIncrement));
			return newVector;
		}
		
		// Move a out of b using the shortest distance.
		if (Math.abs(xDif) < Math.abs(yDif)){
			newVector.setX(a.getXMin() - (xDif + xIncrement));
			newVector.setY(a.getYMin() - ((yDif / ratio) + yIncrement));
		}else{
			newVector.setY(a.getYMin() - (yDif + yIncrement));
			newVector.setX(a.getXMin() - ((xDif * ratio) + xIncrement));
		}
		
		return newVector;
	}
	
	public static Vector movement(Vector position, Vector velocity){
		Vector newPosition = new Vector();
		
		newPosition.setX(position.getX() + velocity.getX());
		newPosition.setY(position.getY() + velocity.getY());
		
		return newPosition;
	}
	
}
