import java.awt.Image;
import java.awt.Toolkit;

public abstract class DGameObject extends GameObject implements Drawable {
	
	private int drawOrder;
	private Image image;
	
	public DGameObject(int x, int y, int drawOrder, String imageFile){
		super(x, y);
		if (drawOrder < 0)
			throw new IllegalArgumentException("drawOrder can't be negative.");
		this.drawOrder = drawOrder;
		
		image = Toolkit.getDefaultToolkit().getImage("..//images//" + imageFile);
		// Take image as argument too
	}
	
	public void draw(){
		// Draw object's image at its position
		
	}
	
	public int getDrawOrder(){
		return drawOrder;
	}
	
	public Image getImage(){
		return image;
	}
	public void setImage(Image newImage){
		image = newImage;
	}
}
