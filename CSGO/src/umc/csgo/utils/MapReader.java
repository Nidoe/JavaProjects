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

public class MapReader {

	private static ObjectInputStream input;
	
	// Open the map file in an object input stream
	public static void openFile(File map) throws IOException {
		try {
			input = new ObjectInputStream(new FileInputStream(map));
			
		} catch(IOException e) {
			System.err.println("Error: Unable to open map file.");
			throw e;
		}
	}
	
	// Read the data from the object input stream, saving it
	// to a map the user can then store in memory
	// Remember to catch those errors!
	public static Map readRecords() throws ClassNotFoundException, IOException {
		Map map = null;
		try{
			while(true) {
				map = (Map) input.readObject();
				return map;
			}
		} catch(EOFException e) {
			System.err.println("Error: Reached end of file prematurely. File may be corrupted.");
			throw e;
		} catch(ClassNotFoundException e) {
			System.err.println("Error: Class 'map' not found. Unable to create object.");
			throw e;
		} catch(IOException e) {
			System.err.println("Error: Unable to read map from file.");
			throw e;
		}
	}
	
	// Always make sure and close the file and input stream when
	// you are done to prevent corruption
	public static void closeFile() throws IOException {
		try {
			input.close();
		} catch (IOException e) {
			System.err.println("Could not close input file. Make sure it isn't open elsewhere.");
			throw e;
		}		
	}
	
}
