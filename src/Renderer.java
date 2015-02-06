import java.awt.*;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Renderer extends JFrame{
	
	private int windowWidth;
	private int windowHeight;
	
	private Insets insets;
	private Image backBuffer;
	private Graphics bbg;
	private Graphics g;
	
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
		bbg = backBuffer.getGraphics();
	}
	
	public void drawObject(double x, double y, String image){
		URL path = getClass().getResource(image);
		ImageIcon img = new ImageIcon(path);
		this.image = img.getImage();
		
		// Draw object offset by the cameras position.
		// Maybe change to closest integer instead of just cutting?
		bbg.drawImage(this.image, ((int)x - (int)camera.getX()), ((int)y - (int)camera.getY()), null);
	}
	
	public void draw(){
		g = getGraphics();
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
