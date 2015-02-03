import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;


public class Renderer extends JFrame{
	
	private int windowWidth;
	private int windowHeight;
	
	private Insets insets;
	private BufferedImage backBuffer;
	
	private List<GameObject> objects = new LinkedList<GameObject>();
	GameWorld world;
	
	public Renderer(int width, int height, GameWorld gameWorld){
		windowWidth = width;
		windowHeight = height;
		world = gameWorld;
		
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
		backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
	}
	
	public void draw(){
		
		Graphics g = getGraphics();
		
		// Creates a backbuffer to draw to.
		Graphics bbg = backBuffer.getGraphics();
		
		// Draws to backbuffer.
		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, 1000, 1000);
		
		bbg.setColor(Color.RED);
		bbg.fillRect(0, 0, 10, 10);
		bbg.fillRect(10, 10, 10, 10);
		
		objects = world.getDrawableObjects();
		
		for(GameObject o : objects){
			bbg.setColor(Color.BLACK);
			bbg.fillRect(o.getX(), o.getY(), 10, 10);
		}
		
		// Draws backbuffer to screen.
		g.drawImage(backBuffer, insets.left, insets.top, this);
	}
}
