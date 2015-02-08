public class Level {
	private int tileSize = 32;
	private int width;
	private int height;
	private int tiles[][];
	private String[] imageSources;
	
	public Level(int w, int h, int tiles[][], String[] imageSources){
		width = w;
		height = h;
		this.tiles = tiles;
		this.imageSources = imageSources;
	}
	
	// Constructor to change the default tileSize if 32x32 is not the right format
	public Level(int w, int h, int tiles[][], String[] imageSources, int tileSize){
		width = w;
		height = h;
		this.tiles = tiles;
		this.imageSources = imageSources;
		this.tileSize = tileSize;
	}
	
	public void draw(Renderer renderer){
		for (int i = 0; i < height; i++){
			for (int j = 0; j < width; j++){
				renderer.drawObject((double) j*tileSize, (double) i*tileSize, imageSources[tiles[i][j]], 0);
			}
		}
	}
}
