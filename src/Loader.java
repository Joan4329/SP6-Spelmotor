import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Loader {
	public static Level readLevelFile(String filename){
		
		// Level Formatting (Tile Map):
		/* imageFilename0,imageFilename1,imageFilename2
		 * tileSize
		 * width,height
		 * 0,1,1,1,2
		 * 0,1,1,2,2
		 * 0,2,2,2,2
		 * 2,2,2,2,2
		 * */
		
		try{
			
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			// First load all imageSources into array
			String[] imageSources;
			String line = br.readLine();
			imageSources = line.split(",");
			
			// Then check if there is a tileSize value by looking for absence of a comma (since the line describing height and width has a comma and tileSize line does not)
			int tileSize = 0;
			line = br.readLine();
			if (!line.contains(",")){
				tileSize = Integer.parseInt(line);
				line = br.readLine();
			}
			
			// Get width and height values.
			String[] tempWHValues = line.split(",");
			int WHValues[] = {Integer.parseInt(tempWHValues[0]), Integer.parseInt(tempWHValues[1])};
			
			// Get map data into array
			int mapData[][] = new int[WHValues[0]][WHValues[1]];
			int i = 0;
			while((line = br.readLine()) != null){
				String[] mapDataString = line.split(",");
				for (int j = 0; j < mapDataString.length; j++){
					mapData[i][j] = Integer.parseInt(mapDataString[j]);
				}
				
				i++;
			}
			
			br.close();
			if (tileSize != 0)
				return new Level(WHValues[0],WHValues[1], mapData, imageSources, tileSize);
			
			return new Level(WHValues[0],WHValues[1], mapData, imageSources);
		} catch (IOException e){
			System.exit(1);
		}
		return null;
		
	}
	
}
