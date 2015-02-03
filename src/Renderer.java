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
	
	Image image;
	
	private List<Drawable> objects = new LinkedList<Drawable>();
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
		//backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
		backBuffer = createImage(windowWidth, windowHeight);
	}
	
	public void draw(){
		
		g = getGraphics();
		
		// Creates a backbuffer to draw to.
		bbg = backBuffer.getGraphics();
		
		// Draws to backbuffer.
		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, 1000, 1000);
		
		bbg.setColor(Color.RED);
		bbg.fillRect(0, 0, 10, 10);
		bbg.fillRect(10, 10, 10, 10);
		
		URL path = getClass().getResource("images/test.png");
		ImageIcon img = new ImageIcon(path);
		image = img.getImage();
		
	    bbg.drawImage(image, 100, 100, null);
		
		// Draws backbuffer to screen.
		g.drawImage(backBuffer, insets.left, insets.top, this);
	}
}
