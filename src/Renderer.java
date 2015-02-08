import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Renderer extends JFrame{
	
	private int windowWidth;
	private int windowHeight;
	
	private Insets insets;
	private Image backBuffer;
	private Graphics2D bbg;
	private Graphics2D g;
	
	private Vector camera;
	
	Image image;
	
	public Renderer(int width, int height, Vector camera){
		windowWidth = width;
		windowHeight = height;
		this.camera = camera;
		
		init();
	}
	
	private void init(){
		// Initializes window.
		setTitle("Pewpewvideogeim");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		// Sets window size to windowWidth and windowHeight and adds the insets(borders) so window size is unaffected.
		insets = getInsets();
		int widthInset = insets.left + insets.right;
		int heightInset = insets.top + insets.bottom;
		setSize(windowWidth + widthInset, windowHeight + heightInset);
		//backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
		backBuffer = createImage(windowWidth, windowHeight);
		bbg = (Graphics2D)backBuffer.getGraphics();
	}
	
	public void drawObject(double x, double y, String image, double rotation){
			
		try {
			// Reads image file
			BufferedImage bi = ImageIO.read(new File(getClass().getResource(image).toURI()));
			
			// Rotates image and offsets it with the cameras position
			AffineTransform at = new AffineTransform();
			
            at.translate(x - camera.getX(), y - camera.getY());
            at.rotate(Math.toRadians(rotation));
            at.translate(-bi.getWidth()/2, -bi.getHeight()/2);
            
            // Draws image to backbuffer 
            bbg.drawImage(bi, at, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public void drawObjectImage(double x, double y, BufferedImage image, double rotation){
		BufferedImage bi = image;
		
		// Rotates image and offsets it with the cameras position
		AffineTransform at = new AffineTransform();
		
		at.translate(x - camera.getX(), y - camera.getY());
        at.rotate(Math.toRadians(rotation));
        at.translate(-bi.getWidth()/2, -bi.getHeight()/2);
        
        // Draws image to backbuffer 
        bbg.drawImage(bi, at, null);
	}
	
	public void draw(){
		// No "clearing" of backbuffer.
		g = (Graphics2D)getGraphics();
		// Draws backbuffer to screen.
		g.drawImage(backBuffer, insets.left, insets.top, this);
	}
	
	public Vector getCamera(){
		return camera;
	}
	
	public void setCamera(Vector xy){
		camera = xy;
	}
	
}
