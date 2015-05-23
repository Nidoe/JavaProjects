/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */
package umc.csgo.utils;

// Imports

import java.io.*;

import umc.csgo.assets.Map;

public class MapWriter {
	
	private static ObjectOutputStream output;
	
	// Open the file given by mapName
	// Make sure it's in the right directory!
	public static void openMap(String mapName) throws IOException {
		try {
			File map = new File("bin/maps/" + mapName + ".map");
			output = new ObjectOutputStream(new FileOutputStream(map));
			
		} catch(IOException e) {
			System.err.println("Error: Unable to open map file.");
			throw e;
		}
	}
	
	// Take the map's data and write it, using object serialization, to the file
	public static void addMapData(Map map) throws IOException {
		try {
			output.writeObject(map);
		} catch(IOException e) {
			System.err.println("Error: Unable to write map to file.");
			throw e;
		}
	}
	
	// Close the output stream when you are done using it
	public static void closeFile() throws IOException {
		
		try {
			output.close();
		} catch (IOException e) {
			System.err.println("Could not close input file. Make sure it isn't open elsewhere.");
			throw e;
		}
		
		
	}

}
