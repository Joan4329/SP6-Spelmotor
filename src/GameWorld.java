import java.util.LinkedList;
import java.util.List;

public class GameWorld {
	// Static lists?
	private List<Updateable> updateableObjects = new LinkedList<Updateable>();
	private List<Drawable> drawableObjects  = new LinkedList<Drawable>();
	
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
	
	public List<Updateable> getUpdateableObjects(){
		// Return copy of list to protect list from changes
		return updateableObjects;
	}
	
	public List<Drawable> getDrawableObjects(){
		// Return copy of list to protect list from changes
		return drawableObjects;
	}
}
