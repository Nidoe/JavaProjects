/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.assets;

/* Imports */

public abstract class Item extends Actor {
	
	/* UML
	 * --Class-------------
	 * 
	 *   Item (Abstract)
	 * 
	 * --Attributes--------
	 * 
	 * - itemCount:int (static default=0)
	 * 
	 * --Methods-----------
	 * 
	 * c Item()
	 * c Item(int,int)
	 * + getItemCount():int (static)
	 * # incItemCount():void (static)
	 * # decItemCount():void (static)
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/*
	 * Functions:
	 * 	# incItemCount():void
	 * 		Increments the itemCount by 1
	 * 	# decItemCount():void
	 * 		Decrements the itemCount by 1
	 */
	
	/* Attributes - Instanced */
	
	/* Attributes - Static */
	
	private static int itemCount = 0;
	
	/* Constructors */

	public Item(Map map) {
		super(map);
	}

	public Item(Map map, int x, int y) {
		super(map, x, y);
	}
	
	/* Getters and Setters - Instanced */
	
	/* Getters and Setters - Static */
	
	public static int getItemCount() { return Item.itemCount; };
	
	/* Methods - Instanced */
	
	/* Methods - Static */
	
	protected static void incItemCount() { Item.itemCount++; };
	protected static void decItemCount() { Item.itemCount--; };
	
	/* Methods - Abstract */

}
