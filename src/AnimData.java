import java.awt.Image;

public class AnimData {
	// Keeps track of all the images for an object and all of its animations
	
	private Image images[];
	private AnimFrameData anims[];
	
	public AnimData(Image images[], AnimFrameData anims[]){
		this.images = images;
		this.anims = anims;
	}
	
	public Image[] getImages(){
		return images;
	}
	public AnimFrameData[] getAnims(){
		return anims;
	}

}
