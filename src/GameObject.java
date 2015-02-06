
public abstract class GameObject {
	private Vector coordinates;
	public GameObject(Vector coords){
		coordinates = coords;
	}
	
	public Vector getCoordinates(){
		return coordinates;
	}

	public void setCoordinates(Vector coords){
		coordinates = coords;
	}
}
