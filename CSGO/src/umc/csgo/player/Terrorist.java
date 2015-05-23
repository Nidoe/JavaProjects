/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.player;

/* Imports */
import umc.csgo.assets.*;

public class Terrorist extends Player {
	
	/* Attributes - Static */
	
	private static int terroristLivingCount = 0;
	
	/* Constructor */

	public Terrorist(Map map) {
		super(map);
	}

	public Terrorist(Map map, String name, Stats stats) {
		super(map, name, stats);
	}

	public Terrorist(Map map, String name, Stats stats, EWEAPON weapon) {
		super(map, name, stats, weapon);
	}

	public Terrorist(Map map, String name, Stats stats, EWEAPON weapon, int x, int y) {
		super(map, name, stats, weapon, x, y);
	}
	
	/* Methods - Instanced */
	
	public void printIntroduction() {
		System.out.println("Terrorist "+this.getName()+" has entered the game.");
	}
	
	public int getLivingCount() { return Terrorist.getTerroristLivingCount(); };
	protected void incLivingCount() { Terrorist.incTerroristLivingCount(); };
	protected void decLivingCount() { Terrorist.decTerroristLivingCount(); };
	
	/* Methods - Static */
	
	public static int getTerroristLivingCount() { return Terrorist.terroristLivingCount; };
	private static void incTerroristLivingCount() { Terrorist.terroristLivingCount++; };
	private static void decTerroristLivingCount() { Terrorist.terroristLivingCount--; };

}
