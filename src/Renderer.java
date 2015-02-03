import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;


public class Renderer extends JFrame{
	
	private int windowWidth;
	private int windowHeight;
	
	private Insets insets;
	private BufferedImage backBuffer;
	
	public Renderer(int width, int height){
		windowWidth = width;
		windowHeight = height;
		
		init();
	}
	
	public void setWidth(int width){
		windowWidth = width;
	}
	
	public void setHeight(int height){
		windowHeight = height;	
	}
	
	private void init(){
		setTitle("Pewpewvideogeim");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		insets = getInsets();
		int widthInset = insets.left + insets.right;
		int heightInset = insets.top + insets.bottom;
		setSize(windowWidth + widthInset, windowHeight + heightInset);
		backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
	}
	
	public void draw(){
		Graphics g = getGraphics();
		Graphics bbg = backBuffer.getGraphics();
		
		bbg.setColor(Color.WHITE);
		bbg.fillRect(0, 0, 1000, 1000);
		
		bbg.setColor(Color.RED);
		bbg.fillRect(0, 0, 10, 10);
		bbg.fillRect(10, 10, 10, 10);
		
		g.drawImage(backBuffer, insets.left, insets.top, this);
	}
}
