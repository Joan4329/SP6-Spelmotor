import java.util.LinkedList;
import java.util.List;

public class GameWorld {
	// Static lists?
	private List<GameObject> updateableObjects = new LinkedList<GameObject>();
	private List<GameObject> drawableObjects  = new LinkedList<GameObject>();
	
	public void addObject(UGameObject o){
		updateableObjects.add(o);
	}
	public void addObject(DGameObject o){
		drawableObjects.add(o);
	}
	public void addObject(DUGameObject o){
		// Does this work or does DUGameObjects call UGameObject's function?
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
		// Does this work or does DUGameObjects call UGameObject's function?
		updateableObjects.remove(o);
	}
	
	public List<GameObject> getUpdateableObjects(){
		// Return copy of list to protect list from changes
		List<GameObject> temp = updateableObjects;
		return temp;
	}
	
	public List<GameObject> getDrawableObjects(){
		// Return copy of list to protect list from changes
		List<GameObject> temp = drawableObjects;
		return temp;
	}
}
