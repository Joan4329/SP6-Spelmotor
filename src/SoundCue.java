import java.net.URL;
import java.util.Random;

public class SoundCue {
//	String nameOfSound;
//	int falloff;
//	int priority
	private String[] soundSources;
	
	public void playSound(){
		Random rand = new Random();
		URL path = getClass().getClassLoader().getResource(soundSources[rand.nextInt(soundSources.length)]);
		SoundEngine.playSound(path);
	}
}
