/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 8
 * Date: 4/3/2013
 */

/*Jobs class
 * 
 * Contains an enum of job difficulties
 * 
 * This class stores a unique ID, name, difficulty, and a static total jobs to aid in creating a unique ID per job.
 * 
 */

package jobs;

public class Jobs {
	public enum job{
		Easy(1),
		Medium(2),
		Hard(4);
		
		private int daysReq;
		job(int days){
			this.daysReq = days;
		}
	}
	
	final int id;
	private String name;
	public job difficulty;
	static int totalJobs = 0;
	
	public Jobs(job jobDiff){
		this.id = setID();
		setName("DEFAULT");
		difficulty = jobDiff;
		totalJobs++;
	}
	public Jobs(String n, job jobDiff){
		this.id = setID();
		setName(n);
		difficulty = jobDiff;
		totalJobs++;
	}
	private static int getTotalJobs(){
		return totalJobs;
	}
	private int setID(){
		return getTotalJobs() + 1;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	public int getJobDaysRequired(){
		return this.difficulty.daysReq;
	}
}
