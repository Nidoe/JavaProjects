/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.utils;

/* Imports */

public interface Moveable {
	
	/* UML
	 * --Interface---------
	 * 
	 *   Moveable
	 * 
	 * --Attributes--------
	 * 
	 * --Methods-----------
	 * 
	 *   moveEast(int):void
	 *   moveWest(int):void
	 *   moveNorth(int):void
	 *   moveSouth(int):void
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/*
	 * Functions:
	 * 	move<N/E/S/W>(int):void
	 * 		Move x number of units north, east
	 * 		south or west
	 * 		These are interface methods, so they
	 * 		must be implemented in whatever class
	 * 		implements Moveable using the description
	 * 		above
	 */
	
	boolean moveEast(int x);
	boolean moveWest(int x);
	boolean moveNorth(int x);
	boolean moveSouth(int x);
}
