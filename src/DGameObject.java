
public abstract class DGameObject extends GameObject implements Drawable {
	
	private int drawOrder;
	// private ImageFile image;
	
	public DGameObject(int x, int y, int drawOrder){
		super(x, y);
		if (drawOrder < 0)
			throw new IllegalArgumentException("drawOrder can't be negative.");
		this.drawOrder = drawOrder;
		// Take image as argument too
	}
	
	public void draw(){
		// Draw object's image at its position
		
	}
	
	public int getDrawOrder(){
		return drawOrder;
	}
}
