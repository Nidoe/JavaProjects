/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */
package umc.csgo.utils;

/* Imports */

public final class LocationUtils {
	/*
	 * Get2dDistance:
	 * 	Calculate the distance between two 2D points
	 */
	public static final int get2dDistance( int x1, int y1, int x2, int y2 ) {
		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);
		double distance = Math.sqrt(dx*dx + dy*dy);
		return (int)distance;
	}
}
