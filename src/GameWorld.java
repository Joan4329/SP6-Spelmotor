import java.util.LinkedList;
import java.util.List;

public class GameWorld {
	private List<GameObject> updateableObjects = new LinkedList<GameObject>();
	private List<DGameObject> drawableObjects  = new LinkedList<DGameObject>();
	
	public void addObject(UGameObject o){
		updateableObjects.add(o);
	}
	public void addObject(DGameObject o){
		drawableObjects.add(o);
	}
	public void addObject(DUGameObject o){
		// Does this work or does DUGameObjects call DGameObject's function?
		updateableObjects.add(o);
		drawableObjects.add(o);
	}
	
	// return bool value for error handling?
	public void deleteObject(UGameObject o){
		updateableObjects.remove(o);
	}
	public void deleteObject(DGameObject o){
		updateableObjects.remove(o);
	}
	public void deleteObject(DUGameObject o){
		// Does this work or does DUGameObjects call DGameObject's function?
		updateableObjects.remove(o);
		drawableObjects.remove(o);
	}
	
	public List<GameObject> getUpdateableObjects(){
		// Return copy of list to protect list from changes
		return updateableObjects;
	}
	
	public List<DGameObject> getDrawableObjects(){
		// Return copy of list to protect list from changes
		return drawableObjects;
	}
}
