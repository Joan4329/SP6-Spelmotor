
public class AnimatedSprite extends Sprite {

	private AnimData animData;
	private int activeAnimNum;
	private int activeFrameNum;
	private double frameTime;
	private double animFPS = 24;
	// Default FPS of animations. Probably change to something else?
	
	public AnimatedSprite(int x, int y, int drawOrder, String imageFile){
		super(x, y, drawOrder, imageFile);
	}
	
	public void initialize(AnimData ad, int startingNumber){
		// Get the animations here instead of in constructor?
		animData = ad;
		changeAnim(startingNumber);
	}
	
	public void changeAnim(int num){
		activeAnimNum = num;
		activeFrameNum = 0;
		
		// This is in the course litterature but AFAIK it has no real purpose
		//animTime = 0f;
		
		// Set image attribute of AnimatedSprite (from DGameObject base class) to the current image in the animation
		setImage(animData.getImage(animData.getAnim(activeAnimNum).getStartFrame()));
	}
	
public void updateAnim(double dTime){
		frameTime += dTime;
		// Check if enough time has passed and then change animation's current frame number
		if (frameTime > (1/animFPS)){
			// will typecasting to int cause any issues?
			activeFrameNum = (int)(frameTime * animFPS);
			// Loop/Wrap the animation.
			if (activeFrameNum >= animData.getAnim(activeAnimNum).getNumberOfFrames()){
				activeFrameNum = activeFrameNum % animData.getAnim(activeAnimNum).getNumberOfFrames();
			}
			
			// Set correct image to current position in animation. getStartFrame() + activeFrameNum because an animation
			// can start at something other than zero if it isn't the first animation for the object.
			setImage(animData.getImage(animData.getAnim(activeAnimNum).getStartFrame() + activeFrameNum));
			
			// Start over frameTime based on speed of animation (so that it can skip next frame for example)
			frameTime = frameTime % (1/animFPS);
		}
			
	}
}
