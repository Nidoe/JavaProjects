/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 10
 * Date: April 17, 2013
 */

package umc.csgo.player;

public class Stats {
	
	/*
	 * Attributes
	 */
	
	private String name;
	private float accuracy;
	private int shotsFired = 0;
	private int shotsHit = 0;
	private float kdratio;
	private int kills = 0;
	private int deaths = 0;
	
	/*
	 * Constructors
	 */
	
	public Stats(String name) {
		setName(name);
		addShotsFired(0);
		addShotsHit(0);
		calculateAccuracy();
		addKills(0);
		addDeaths(0);
		calculateKDRatio();
	}
	
	public Stats(String name, int shotsFired, int shotsHit, int kills, int deaths) {
		setName(name);
		addShotsFired(shotsFired);
		addShotsHit(shotsHit);
		calculateAccuracy();
		addKills(kills);
		addDeaths(deaths);
		calculateKDRatio();
	}
	
	/*
	 * Add two stats together
	 */
	
	protected void addStats(Stats stats) {
		this.addShotsFired(stats.getShotsFired());
		this.addShotsHit(stats.getShotsHit());
		this.calculateAccuracy();
		this.addKills(stats.getKills());
		this.addDeaths(stats.getDeaths());
		this.calculateKDRatio();
	}
	
	/*
	 * Setters and Incrementers
	 */
	
	protected void setName(String name) {
		this.name = name;
	}
	protected void addShotsFired(int shotsFired) {
		this.shotsFired += shotsFired;
		calculateAccuracy();
	}
	protected void addShotsHit(int shotsHit) {
		this.shotsHit += shotsHit;
		calculateAccuracy();
	}
	protected void addKills(int kills) {
		this.kills += kills;
		calculateKDRatio();
	}
	protected void addDeaths(int deaths) {
		this.deaths += deaths;
		calculateKDRatio();
	}
	
	/*
	 * Get the Accuracy and KD Ratio
	 */
	
	private void calculateAccuracy() {
		this.accuracy = ((float)this.shotsHit)/((float)this.shotsFired);
	}
	private void calculateKDRatio() {
		this.kdratio = ((float)this.kills)/((float)this.deaths);
	}
	
	/*
	 * Getters
	 */
	
	public String getName() { return this.name; }
	public float getAccuracy() { return this.accuracy; }
	public int getShotsFired() { return this.shotsFired; }
	public int getShotsHit() { return this.shotsHit; }
	public float getKDRatio() { return this.kdratio; }
	public int getKills() { return this.kills; }
	public int getDeaths() { return this.deaths; }
	
	/*
	 * ToString for Stats Class
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player: "+this.getName()+"\n"+
				"Accuracy: "+this.getAccuracy()+"\n"+
				"Kill/Death: "+this.getKills()+"/"+this.getDeaths()+" = "+this.getKDRatio();
	}

}
