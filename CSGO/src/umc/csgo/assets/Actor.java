/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.assets;

/* Imports */

public abstract class Actor {
	
	/* UML
	 * --Class-------------
	 * 
	 *   Actor (Abstract)
	 * 
	 * --Attributes--------
	 * 
	 * - x:int
	 * - y:int
	 * - map:Map
	 * - actorCount:int (static default=0)
	 * 
	 * --Methods-----------
	 * 
	 * c Actor()
	 * c Actor(int,int)
	 * c Actor(int,int,Map)
	 * 
	 * # setX(int):void
	 * + getX():int
	 * # setY(int):void
	 * + getY():int
	 * # setMap(Map):void
	 * + getMap(Map):void
	 * + getActorCount():int (static)
	 * # incActorCount():void (static)
	 * # decActorCount():void (static)
	 * 
	 * --Abstract----------
	 * 
	 * --------------------
	 */
	
	/*
	 * Functions:
	 * 	# setX(int):void
	 * 		Checks to make sure the provided x
	 * 		exists within the confines of the map,
	 * 		constraining x between 0 and the map's
	 * 		width
	 * 
	 * 	# setY(int):void
	 * 		Checks to make sure the provided y
	 * 		exists within the confines of the map,
	 * 		constraining y between 0 and the map's
	 * 		height
	 * 
	 * 	# incActorCount:void (static)
	 * 		Increments the actorCount by 1
	 * 
	 * 	# decActorCount:void (static)
	 * 		Decrements the actorCount by 1
	 */

	/* Attributes - Instanced */
	
	private int x;
	private int y;
	private Map map;
	
	/* Attributes - Static */
	
	private static int actorCount = 0;
	
	/* Constructors */
	
	public Actor(Map map) {
		this.setMap(map);
		this.setX(0);
		this.setY(0);
		Actor.incActorCount();
	}
	
	public Actor(Map map, int x, int y) {
		this.setMap(map);
		this.setX(x);
		this.setY(y);
		Actor.incActorCount();
	}
	
	/* Getters and Setters - Instanced */
	
	protected void setX(int x) {
		if( x > 0 ) {
			if( x < map.getWidth() ) {
				this.x = x;
			} else {
				this.x = map.getWidth();
			}
		} else {
			this.x = 0;
		}
	};
	
	public int getX() { return this.x; };
	
	protected void setY(int y) {
		if( y > 0 ) {
			if( y < map.getHeight() ) {
				this.y = y;
			} else {
				this.y = map.getHeight();
			}
		} else {
			this.y = 0;
		}
	};
	
	public int getY() { return this.y; };
	
	protected void setMap(Map map) { this.map = map; };
	
	public Map getMap() { return this.map; };
	
	/* Getters and Setters - Static */
	
	public static int getActorCount() { return Actor.actorCount; };
	
	/* Methods - Instanced */
	
	/* Methods - Static */
	
	protected static void incActorCount() { Actor.actorCount++; };
	protected static void decActorCount() { Actor.actorCount--; };
	
	/* Methods - Abstract */

}
