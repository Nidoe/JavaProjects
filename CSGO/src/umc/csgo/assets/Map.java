/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.assets;

// Imports

import java.io.Serializable;

public class Map implements Serializable{

	/* Attributes - Instanced */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 0000;
	private final String name;
	private final int width;
	private final int height;
	
	/* Constructor */
	
	public Map(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}
	
	/* Getters and Setters - Instanced */
	
	public int getWidth() { return this.width; };
	public int getHeight() { return this.height; };
	public String getName() { return this.name; };
	
}
