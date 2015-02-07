import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;

public abstract class DGameObject extends GameObject implements Drawable {
	
	private int drawOrder;
	private Image image;
	private String imageFile;
	private Renderer renderer;
	private double rotation;
	
	public DGameObject(Vector coords, int drawOrder, String imageFile, Renderer renderer, double rotation){
		super(coords);
		if (drawOrder < 0)
			throw new IllegalArgumentException("drawOrder can't be negative.");
		this.drawOrder = drawOrder;
		
		URL path = getClass().getResource(imageFile);
		ImageIcon img = new ImageIcon(path);
		image = img.getImage();
		
		this.setImageFile(imageFile);
		this.renderer = renderer;
		this.rotation = rotation;
		
		// Take image as argument too
	}
	
	public void draw(){
		// Draw object's image at its position
		renderer.drawObject(getCoordinates().getX(), getCoordinates().getY(), imageFile, rotation);
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

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}
}
