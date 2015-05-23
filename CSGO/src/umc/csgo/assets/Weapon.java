/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.assets;

/* Imports */

public class Weapon extends Item {
	
	/* UML
	 * --Class-------------
	 * 
	 *   Weapon
	 * 
	 * --Attributes--------
	 * 
	 * - weapon:EWEAPON
	 * - weaponCount:int (static)
	 * 
	 * --Methods-----------
	 * 
	 * c Weapon()
	 * c Weapon(EWEAPON)
	 * c Weapon(int,int)
	 * c Weapon(EWEAPON,int,int)
	 * - setWeapon(EWEAPON):void
	 * + getWeapon():EWEAPON
	 * + getWeaponCount():int (static)
	 * + getDamage():int
	 * + getClipSize():int
	 * + getAccuracy():double
	 * + toString():String (overload)
	 * - incWeaponCount():void (static)
	 * - decWeaponCount():void (static)
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/* Attributes - Instanced */
	
	private EWEAPON weapon;
	
	/* Attributes - Static */
	
	private static int weaponCount = 0;
	
	/* Constructors */

	public Weapon(Map map) {
		super(map);
		Weapon.incWeaponCount();
	}
	
	public Weapon(Map map, EWEAPON weapon) {
		super(map);
		this.setWeapon(weapon);
		Weapon.incWeaponCount();
	}

	public Weapon(Map map, int x, int y) {
		super(map, x, y);
		Weapon.incWeaponCount();
	}
	
	public Weapon(Map map, EWEAPON weapon, int x, int y) {
		super(map, x, y);
		Weapon.incWeaponCount();
	}
	
	/* Getters and Setters - Instanced */
	
	private void setWeapon(EWEAPON weapon) { this.weapon = weapon; };
	public EWEAPON getWeapon() { return this.weapon; };
	
	/* Getters and Setters - Static */
	
	public static int getWeaponCount() { return Weapon.weaponCount; };
	
	/* Methods - Instanced */
	
	public int getDamage() { return this.getWeapon().getDamage(); };
	public int getClipSize() { return this.getWeapon().getClipSize(); };
	public double getAccuracy() { return this.getWeapon().getAccuracy(); };
	
	@Override
	public String toString() {
		return this.getWeapon().toString();
	}
	
	/* Methods - Static */
	
	private static void incWeaponCount() { Weapon.weaponCount++; };
	// private static void decWeaponCount() { Weapon.weaponCount--; }; // More useful in something like C++ where there are destructors
	
	/* Methods - Abstract */

}
