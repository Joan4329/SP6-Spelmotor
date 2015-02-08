import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

public class SoundEngine {

	public static void playSound(URL soundFilePath){
		try{
			
			AudioInputStream auI = AudioSystem.getAudioInputStream(soundFilePath);
			Clip soundClip = AudioSystem.getClip();
			soundClip.open(auI);
			
			if (!soundClip.isRunning())
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
