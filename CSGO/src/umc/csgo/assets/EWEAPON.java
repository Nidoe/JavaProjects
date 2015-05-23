/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.assets;

/* Imports */

public enum EWEAPON {
	
	/*
	 * Weapons:
	 * 	KNIFE:
	 * 		damage:		10
	 * 		clipSize:	3
	 * 		accuracy:	100%
	 * 	M4A4:
	 * 		damage:		40
	 * 		clipSize:	30
	 * 		accuracy:	60%
	 * 	AK47:
	 * 		damage:		50
	 * 		clipSize:	30
	 * 		accuracy:	40%
	 * 	P2000:
	 * 		damage:		20
	 * 		clipSize:	12
	 * 		accuracy:	60%
	 * 	GLOCK18:
	 * 		damage:		10
	 * 		clipSize:	20
	 * 		accuracy:	50%
	 */
	
	KNIFE(10,3,1.0),
	M4A4(40,30,0.6),
	AK47(50,30,0.4),
	P2000(20,12,0.6),
	GLOCK18(10,20,0.5);
	
	/* UML
	 * --Enum--------------
	 * 
	 *   EWEAPON
	 * 
	 * --Attributes--------
	 * 
	 * - damage:int (final)
	 * - clipSize:int (final)
	 * - accuracy:double (final)
	 * 
	 * --Methods-----------
	 * 
	 * c EWEAPON(int,int,double)
	 * + getDamage():int
	 * + getClipSize():int
	 * + getAccuract():double
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */

	/* Attributes - Instanced */
	
	private final int damage;
	private final int clipSize;
	private final double accuracy;
	
	/* Attributes - Static */
	
	/* Constructor */
	
	EWEAPON(int damage, int clipSize, double accuracy) {
		this.damage = damage;
		this.clipSize = clipSize;
		this.accuracy = accuracy;
	}
	
	/* Getters and Setters - Instanced */
	
	public int getDamage() { return this.damage; };
	public int getClipSize() { return this.clipSize; };
	public double getAccuracy() { return this.accuracy; };
	
	/* Getters and Setters - Static */
	
	/* Methods - Instanced */
	
	/* Methods - Static */
	
	/* Methods - Abstract */

}
