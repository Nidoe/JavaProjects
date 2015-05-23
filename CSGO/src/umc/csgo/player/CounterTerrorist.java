/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.player;

/* Imports */
import umc.csgo.assets.*;

public class CounterTerrorist extends Player {
	
	/* Attributes - Static */
	
	private static int counterTerroristLivingCount = 0;
	
	/* Constructor */

	public CounterTerrorist(Map map) {
		super(map);
	}

	public CounterTerrorist(Map map, String name, Stats stats) {
		super(map, name, stats);
	}

	public CounterTerrorist(Map map, String name, Stats stats, EWEAPON weapon) {
		super(map, name, stats, weapon);
	}

	public CounterTerrorist(Map map, String name, Stats stats, EWEAPON weapon, int x, int y) {
		super(map, name, stats, weapon, x, y);
	}
	
	/* Methods - Instanced */
	
	public void printIntroduction() {
		System.out.println("Counter Terrorist "+this.getName()+" has entered the game.");
	}
	
	public int getLivingCount() { return CounterTerrorist.getCounterTerroristLivingCount(); };
	protected void incLivingCount() { CounterTerrorist.incCounterTerroristLivingCount(); };
	protected void decLivingCount() { CounterTerrorist.decCounterTerroristLivingCount(); };
	
	/* Methods - Static */
	
	public static int getCounterTerroristLivingCount() { return CounterTerrorist.counterTerroristLivingCount; };
	private static void incCounterTerroristLivingCount() { CounterTerrorist.counterTerroristLivingCount++; };
	private static void decCounterTerroristLivingCount() { CounterTerrorist.counterTerroristLivingCount--; };

}
