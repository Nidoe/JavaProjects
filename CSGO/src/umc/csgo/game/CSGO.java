
/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.game;

/* Imports */
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import umc.csgo.assets.EWEAPON;
import umc.csgo.player.*;
import umc.csgo.utils.MapReader;
import umc.csgo.utils.MapWriter;
import umc.csgo.assets.Map;

public class CSGO {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		/*
		 * Declare Variables
		 */
		
		// Utility Variables
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		String input;

		// Map Variables
		ArrayList<File> mapFileList = new ArrayList<File>();
		HashMap<String,Map> mapHash = new HashMap<String,Map>();
		
		// Player Variables
		ArrayList<Player> playerList = new ArrayList<Player>();
		Iterator<Player> playerIter;
		HashMap<String,Stats> statsMap = new HashMap<String,Stats>();
		File playerStatsFile;
		File newPlayerStatsFile;
		
		
		/*
		 * Choose a map or make a new one
		 */
		
		// Make a list of all existing files
		File mapFolder = new File("bin/maps/");
		// If the maps folder does not already exist, make it
		if(mapFolder.mkdir()) {
			System.out.println("Maps folder does not exist. Creating.");
		}
		// For ever map file in the directory, save it to the map file list
		for(File fMap : mapFolder.listFiles()) {
			if(fMap.getName().endsWith(".map")) {
				mapFileList.add(fMap);
			}
		}
		
		// Load those maps into the mapHash HashMap
		Iterator<File> itMap = mapFileList.iterator();
		while(itMap.hasNext()) {
			Map map;
			File fMap;
			// Get each map
			fMap = itMap.next();
			// Load them into memory and deserialize the map
			MapReader.openFile(fMap);
			
			map = MapReader.readRecords();
			
			MapReader.closeFile();
			
			
			// Let the user know the map loaded successfully
			System.out.println("Map "+map.getName()+" loaded.");
			// Then store the map into the mapHash
			mapHash.put(map.getName().toLowerCase(), map);
		}
		
		System.out.println();
		
		// Time to choose which map we are going to use
		Map map;
		while(true) {
			// Print out the maps we currently have in the mapHash
			/*
			 *  Hint:
			 *  Try using the following code (replace Class, HashMap, and obj)
			 *  	for( Entry<Class,Class> obj : HashMap<Class,Class>.entrySet() )
			 *  It will work like an iterator, where obj is an entry in the HashMap
			 *  you provide it. After that, you can access the key and value of the
			 *  Entry with obj.getKey() and obj.getValue()
			 */
			System.out.println("Please select a map from the choices below:");
			
			
			for(Entry<String, Map> mapit : mapHash.entrySet()){
				String name = mapit.getKey();
				System.out.println(name);
			}
			
			// And let them make a new map if they would like
			System.out.println("New Map");
			
			// Grab the next line and see what they chose
			input = scanner.nextLine();
			input = input.toLowerCase(); // to lower case to make map name comparison easier
			
			// New Map
			if(input.equalsIgnoreCase("new map")) {
				while(true) {
					System.out.println("Please enter a map name, with prefix, followed by height and width\n"+
							"'cs_' for hostage situation, 'de_' for defusal mission\n"+
							"example: de_dust 10 15");
					String name, width, height;
					/*
					 * The below code is advanced. If you'd like to know how it works, please send an
					 * email to Sean Lander (TA), or look at the documentation. This uses Regular Expressions
					 * and is not required knowledge. Just know that it works.
					 */
					input = scanner.nextLine();
					if(Pattern.compile("(de|cs)_\\w+ \\d+ \\d+").matcher(input).matches()) {
						String[] data = input.split(" ");
						name = data[0];
						width = data[1];
						height = data[2];
					} else {
						System.out.println("Please provide a name, width and height in the format provided.");
						continue;
					}
					/*
					 * Confusing code done.
					 */
					
					// Map information has been gathered. Make the new map
					map = new Map(name, Integer.parseInt(width), Integer.parseInt(height));
					// And write it to a file using object serialization
					// Remember to catch any exceptions thrown and close those files!
					MapWriter.openMap(name);
					MapWriter.addMapData(map);
					
					MapWriter.closeFile();
					
					break;
				}
			} else if(mapHash.containsKey(input)) {
				map = mapHash.get(input);
			} else {
				System.out.println("That map choice was not recognized.");
				continue;
			}
			break;
		}
		
		System.out.println();
		
		/*
		 * Create the players for this match
		 */
		
		// Open the players.stats file
		
		playerStatsFile = new File("players.stats");
		
		// Make sure and create it if it doesn't exist!
		try {
			if(playerStatsFile.createNewFile()) {
				System.out.println("Stats file did not exist. Creating it.");
			}
		} catch (IOException e) {
			System.err.println("Error: Unable to open or create the player stats file.");
			System.exit(1);
		}
		
		Scanner statsScanner = null; // Set to null so it is initialized
		// Create a scanner that uses the playerStats file
		try {
			
			statsScanner = new Scanner(playerStatsFile);
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: Player stats file not found.");
			System.exit(1);
		}
		while(statsScanner.hasNext()) {
			// Read in each line, splitting the csv on the comma
			input = statsScanner.nextLine();
			String[] data = input.split(",");
			String name, shotsFired, shotsHit, kills, deaths;
			name = data[0]; shotsFired = data[1]; shotsHit = data[2];
			kills = data[3]; deaths = data[4];
			statsMap.put(name,
					new Stats(name,
							Integer.parseInt(shotsFired),
							Integer.parseInt(shotsHit),
							Integer.parseInt(kills),
							Integer.parseInt(deaths)
							)
			);
		}
		// Remember to close the scanner!
		
		statsScanner.close();
		
		System.out.println("Please create some players. Provide their name and they will have their "+
				"team and weapon automatically assigned to them.");
		
		String name;
		int weaponCount = EWEAPON.values().length;
		int weaponIndex;
		EWEAPON weapon;
		int randomX;
		int randomY;
		
		while(true) {
			// Grab the name, or done, from the input
			input = scanner.nextLine();
			
			if(input.equalsIgnoreCase("done")) break;
			
			name = input.toLowerCase();
			
			// Get the stats associated with this name
			Stats stats = statsMap.get(name);
			// If it doesn't exist, add it to the stats hashmap
			if(stats == null) {
				stats = new Stats(name);
				statsMap.put(name, stats);
			}
			
			weaponIndex = rand.nextInt(weaponCount);
			weapon = EWEAPON.values()[weaponIndex];
			randomX = rand.nextInt(map.getWidth());
			randomY = rand.nextInt(map.getHeight());
			
			// Randomly choose a team, weapon and starting location for the player
			if(rand.nextBoolean()) {
				playerList.add(new CounterTerrorist(map, name, stats, weapon, randomX, randomY));
			} else {
				playerList.add(new Terrorist(		map, name, stats, weapon, randomX, randomY));
			}
			
			System.out.println("Add more players or enter 'done' to start the match");
		}
		
		
		System.out.println();
		
		
		
		
		/*
		 * Print the players' initial stats
		 */
		
		
		System.out.println("Current Players' Stats:");
		
		Player temp;
		Iterator<Player> i = playerList.iterator();
		
		while(i.hasNext()){
			temp = (Player) i.next();
			System.out.println(temp.getStats());
		}
		
		
		System.out.println();
		
		
		
		/*
		 * Play the match
		 * This is code from Lab 5, so some of it should be familiar
		 */
		
		
		Player current;
		int randomDistance;
		int randomTarget;
		Player target;
		
		System.out.println("3...2...1...Get to the bomb site!");
		
		System.out.println();
		
		while( CounterTerrorist.getCounterTerroristLivingCount() > 0 &&
				Terrorist.getTerroristLivingCount() > 0 ) {
			playerIter = playerList.iterator();
			while( playerIter.hasNext() ) {
				// Get Current Player and Check That They Are Alive
				current = playerIter.next();
				if( !current.getIsAlive() ) continue;
				
				// Move Player Randomly
				switch(rand.nextInt(4)) {
				case 0:
					randomDistance = rand.nextInt(map.getWidth())/2;
					current.moveEast(randomDistance);
					break;
				case 1:
					randomDistance = rand.nextInt(map.getWidth())/2;
					current.moveWest(randomDistance);
					break;
				case 2:
					randomDistance = rand.nextInt(map.getHeight())/2;
					current.moveNorth(randomDistance);
					break;
				case 3:
					randomDistance = rand.nextInt(map.getHeight())/2;
					current.moveSouth(randomDistance);
					break;
				}
				
				// Choose Random Person to Shoot
				randomTarget = rand.nextInt(playerList.size());
				target = (Player)playerList.get(randomTarget);
				if( current != target ) {
					current.shoot(target);
					System.out.println();
				}
			}
		}
		
		System.out.println("***Round Over***");
		
		System.out.println();
		
		System.out.println("Counter Terrorists Remaining: "+CounterTerrorist.getCounterTerroristLivingCount());
		System.out.println("Terrorists Remaining: "+Terrorist.getTerroristLivingCount());
		
		System.out.println();
		
		if(CounterTerrorist.getCounterTerroristLivingCount() > Terrorist.getTerroristLivingCount()) { 
			System.out.println("Congratulations, Counter Terrorists Have Won!");
		} else {
			System.out.println("Terrorists Have Won! Better Luck Next Time!");
		}
		
		System.out.println();
		
		Stack<CounterTerrorist> cts = new Stack<CounterTerrorist>();
		Stack<Terrorist> ts = new Stack<Terrorist>();
		playerIter = playerList.iterator();
		while( playerIter.hasNext() ) {
			current = playerIter.next();
			if( current.getClass() == CounterTerrorist.class ) cts.push((CounterTerrorist)current);
			else ts.push((Terrorist)current);
		}
		
		System.out.println("Counter Terrorists:");
		
		while( !cts.empty() ) {
			(cts.pop()).printHealth();
		}
		
		System.out.println();
		
		System.out.println("Terrorists:");
		
		while( !ts.empty() ) {
			(ts.pop()).printHealth();
		}
		
		
		System.out.println();
		
		
		
		/*
		 * Print the players' updated stats
		 */
		
		
		System.out.println("Players' stats after the match:");
		Player player;
		playerIter = playerList.iterator();
		// Go through all the players, updating their stats in
		// the main stats hashmap
		while(playerIter.hasNext()) {
			player = playerIter.next();
			System.out.println(player.getStats());
			statsMap.put(player.getName(), player.getStats());
		}
		
		// Create a new stats file called players.newstats
		// Remember exception handling!
		newPlayerStatsFile = new File("players.newstats");
		try{
			
			newPlayerStatsFile.createNewFile();
			
		}catch(Exception e){
			System.out.println("Unable to create newstats file.");
		}
		
		// Create a Formatter to allow you to write to the new file
		Formatter mooBot = null;
		
		try{
			mooBot = new Formatter("players.newstats");
		}catch(Exception e){
			System.out.println("Unable to write to newstats file.");
		}
		
		
		
		
		// Loop through the stats hash, writing to the new file
		for(Entry<String,Stats> entry : statsMap.entrySet()) {
			// Get the stats from the hash value and print it
			// to the file using the formatter
			// Hint: "%s,%d,%d,%d,%d\n"
			// This format will make a comma delimited csv,
			// but it only holds certain values. Look at what
			// Stats has as attributes, and what is read in earlier,
			// and see if you can figure out what the order is
			Stats stats = entry.getValue();
			mooBot.format("%s,%d,%d,%d,%d\n",
					stats.getName(),
					stats.getShotsFired(),
					stats.getShotsHit(),
					stats.getKills(),
					stats.getDeaths());
		}
		// Always close your Streams
		mooBot.close();
		
		if(playerStatsFile.delete()) {
			System.out.println("Removed the old stats file.");
		} else {
			System.out.println("Unable to delete the old stats file.");
		}
		
		if(newPlayerStatsFile.renameTo(playerStatsFile)) {
			System.out.println("Renamed new stats file.");
		} else {
			System.out.println("Unable to rename new stats file.");
		}
		
		// Always close your Streams
		scanner.close();
		
	}

}
