
public class AnimatedSprite extends Sprite {

	private AnimData animData;
	private int activeAnimNum;
	private int activeFrameNum;
	private double frameTime;
	private double animFPS = 24;
	// Default FPS of animations. Probably change to something else?
	
	public AnimatedSprite(Vector coords, int drawOrder, String imageFile, Renderer renderer, double rotation, Vector velocity){
		super(coords, drawOrder, imageFile, renderer, rotation, velocity);
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
	
	// Create an overloaded method of changeAnim or updateAnim that takes int FPS as argument? 
	
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
	
	public AnimData getAnimData(){
		return animData;
	}
	public void setAnimData(AnimData ad){
		// This method can be used to change the appearance, but not behaviour, of an animated object. i.e. If a flag turns into a tree. 
		animData = ad;
	}
	// No set-methods for these because changeAnim is meant to be used to change activeAnimNum. activeFrameNum doesn't need to be changed anywhere else.
	// Might need those set-methods anyway but set to protected or something so that classes that inherits them can override methods and use these attributes.
	public int getActiveAnimNum(){
		return activeAnimNum;
	}
	public int getActiveFrameNum(){
		return activeFrameNum;
	}
//	public double getFrameTime(){
//		return frameTime;
//	}
	public double getAnimFPS(){
		return animFPS;	
	}
	public void setAnimFPS(double fps){
		animFPS = fps;
	}
}
