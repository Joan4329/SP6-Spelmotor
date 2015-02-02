
public class AnimFrameData {
	// Keeps track of where an animation starts and how many frames/images it has.
	
	private int startFrame;
	private int numberOfFrames;
	
	public AnimFrameData(int startFrame, int numberOfFrames){
		this.startFrame = startFrame;
		this.numberOfFrames = numberOfFrames;
	}
	
	public int getStartFrame(){
		return startFrame;
	}
	
	public int getNumberOfFrames(){
		return numberOfFrames;
	}
}
