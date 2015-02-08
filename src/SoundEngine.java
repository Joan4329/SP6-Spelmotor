import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

public class SoundEngine {

	private static Clip soundClip;
	
	public static void playSound(URL soundFilePath){
		try{
			
			AudioInputStream auI = AudioSystem.getAudioInputStream(soundFilePath);
			soundClip = AudioSystem.getClip();
			soundClip.open(auI);
			
			soundClip.setFramePosition(0);
			if (!soundClip.isActive())
				soundClip.start();
			
		} catch (IOException e){
			e.printStackTrace();
			System.exit(1);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		
	}
}
