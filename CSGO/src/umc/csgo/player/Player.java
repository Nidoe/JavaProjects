/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.player;

/* Imports */
import java.util.Stack;
import java.util.Random;
import umc.csgo.utils.DamageUtils;
import umc.csgo.utils.LocationUtils;

import umc.csgo.assets.*;
import umc.csgo.utils.*;

public abstract class Player extends Actor implements Moveable {
	
	/* Attributes - Instanced */
	
	private String name;
	private int health;
	private boolean isAlive;
	private Weapon weapon;
	private Stack<Bullet> ammo;
	private Stats stats;
	
	/* Attributes - Static */
	
	private static int playerCount = 0;
	
	/* Constructors */
	
	public Player(Map map) {
		super(map);
		this.defaults();
	}
	
	public Player(Map map, String name, Stats stats) {
		super(map);
		this.defaults();
		this.setName(name);
		this.setStats(stats);
	}
	
	public Player(Map map, String name, Stats stat, EWEAPON weapon) {
		super(map);
		this.defaults();
		this.setName(name);
		this.setStats(stats);
		this.setWeapon(new Weapon(map, weapon));
	}
	
	Player(Map map, String name, Stats stats, EWEAPON weapon, int x, int y) {
		super(map, x,y);
		this.defaults();
		this.setName(name);
		this.setStats(stats);
		this.setWeapon(new Weapon(map, weapon));
	}
	
	private void defaults() {
		this.setName("Player");
		this.setHealth(100);
		this.setIsAlive(true);
		this.setWeapon(new Weapon(this.getMap(), EWEAPON.KNIFE));
		this.initAmmo();
		Player.incPlayerCount();
		this.incLivingCount();
		this.stats = new Stats(this.getName());
	}
	
	/* Getters and Setters - Instanced */
	
	protected void setName(String name) { this.name = name; };
	public String getName() { return this.name; };
	
	protected void setHealth(int health) {
		this.health = health;
		if( this.health <= 0 && this.getIsAlive()) {
			this.health = 0;
			this.die();
			Player.decPlayerCount();
			this.decLivingCount();
		}
	};
	public int getHealth() { return this.health; };
	
	protected void setIsAlive(boolean isAlive) { this.isAlive = isAlive; };
	public boolean getIsAlive() { return this.isAlive; };
	
	protected void setWeapon(Weapon weapon) { this.weapon = weapon; };
	public Weapon getWeapon() { return this.weapon; };
	
	private void initAmmo() { this.ammo = new Stack<Bullet>(); };
	protected Stack<Bullet> getAmmo() { return this.ammo; };
	
	private void setStats(Stats stats) { this.stats = stats; }
	public Stats getStats() { return this.stats; }
	
	/* Getters and Setters - Static */
	
	public static int getPlayerCount() { return Player.playerCount; };
	
	/* Methods - Instanced */
	
	public void printHealth() {
		if(this.getIsAlive()) {
			System.out.println("Player " + this.getName() + " has " + this.getHealth() + " health.");
		} else {
			System.out.println("Player " + this.getName() + " is dead.");
		}
	}
	
	protected void reload() {
		System.out.println(this.getName() + ": Reloading!");
		int numBullets = this.getWeapon().getClipSize();
		int damage = this.getWeapon().getDamage();
		for( int i = 0 ; i < numBullets ; i++ ) {
			ammo.push(new Bullet(damage));
		}
	}
	
	public boolean moveEast(int x) {
		if( x >= 0 ) {
			if( this.getX() + x < this.getMap().getWidth() ) {
				this.setX(this.getX()+x);
				return true;
			} else {
				this.setX(this.getMap().getWidth());
			}
		}
		return false;
	}
	
	public boolean moveWest(int x) {
		if( x >= 0 ) {
			if( this.getX() + x > 0 ) {
				this.setX(this.getX()-x);
				return true;
			} else {
				this.setX(0);
			}
		}
		return false;
	}
	
	public boolean moveNorth(int x) {
		if( x >= 0 ) {
			if( this.getY() + x < this.getMap().getHeight() ) {
				this.setY(this.getY()+x);
				return true;
			} else {
				this.setX(this.getMap().getHeight());
			}
		}
		return false;
	}
	
	public boolean moveSouth(int x) {
		if( x >= 0 ) {
			if( this.getY() + x > 0 ) {
				this.setY(this.getY()-x);
				return true;
			} else {
				this.setY(0);
			}
		}
		return false;
	}
	
	public void shoot(Player enemy) {
		//if ammo is empty, then reload.
		if(this.getAmmo().empty()) {
			this.reload();
		} else {
			// If the enemy is alive, shoot them
			if( enemy.getIsAlive() ) {
				if( enemy.getClass() == this.getClass() ) {
					System.out.println(this.getName() + ": I almost shot " + enemy.getName() + " by mistake!");
				} else {
					Random chanceToHit = new Random();
					System.out.println(this.getName()+": I'm shooting at "+enemy.getName()+" with my "+this.getWeapon()+".");
					this.getStats().addShotsFired(1);
					if( chanceToHit.nextDouble() < this.getWeapon().getAccuracy() ) {
						this.getStats().addShotsHit(1);
						if(enemy.beingShot(this, (Bullet)this.getAmmo().pop())) {
							this.getStats().addKills(1);
						}
					} else {
						this.getAmmo().pop();
						System.out.println(this.getName()+": I missed!");
					}
				}
			// Otherwise, well, they're dead
			} else {
				System.out.println(this.getName()+": Looks like "+enemy.getName()+" is dead!");
			}
		}
	}
	
	private boolean beingShot(Player enemy, Bullet bullet) {
		// Calculate the damage based on the bullet and the distance the player was shot from
		int distance = LocationUtils.get2dDistance(this.getX(), this.getY(), enemy.getX(), enemy.getY());
		int damage = DamageUtils.getDamage(bullet.getDamage(), distance);
		System.out.println(this.getName()+": I was shot by "+enemy.getName()+" for "+damage+" damage from a distance of "+distance+"!");
		// Update health
		this.setHealth(this.getHealth() - damage);
		// If the player is still alive, print updated health
		if(this.getIsAlive()) {
			this.printHealth();
			return false;
		}
		return true;
	}
	
	private void die() {
		this.setIsAlive(false);
		System.out.println("Player " + this.getName() + " has died.");
		this.getStats().addDeaths(1);
	}
	
	/* Methods - Static */
	
	protected static void incPlayerCount() { Player.playerCount++; };
	protected static void decPlayerCount() { Player.playerCount--; };
	
	/* Methods - Abstract */
	
	public abstract void printIntroduction();
	public abstract int getLivingCount();
	protected abstract void incLivingCount();
	protected abstract void decLivingCount();

}
