/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 8
 * Date: 4/3/2013
 */

/* Worker class
 * 
 * Contains an enum that stores the efficiency based on the position level of the worker.
 * 
 * The class stores a unique ID per worker, name, a queue of Jobs, the total workload, the current workload, and a static number of workers to keep track in setting the unique ID
 * 
 *  
 * 
 */


package workers;
import jobs.Jobs;

import java.util.ArrayList;

public class Worker {
	public enum position{
		
		Senior(1),
		Mid(2),
		Entry(3);
		
		private final int efficiency;
		
		position(int effi){
			this.efficiency = effi;
		}
		
		int getEfficiency(){
			return this.efficiency;
		}
		
		
	}
	final int id;
	private String name;
	private position PositionLevel;
	private ArrayList<Jobs> JobQueue;
	static int numWorkers;
	int currentJobDaysLeft;
	int workload;
	Jobs currentJob;
	
	public Worker(String n, position title){
		this.id = workerCount();
		setName(n);
		setPositionLevel(title);
		JobQueue = new ArrayList<Jobs>();
		numWorkers++;
	}

	private void setName(String name){
		this.name = name;
	}
	private void setPositionLevel(position pos){
		this.PositionLevel = pos;
	}
	private int workerCount(){
		return numWorkers + 1;
	}
	public String getName(){
		return this.name;
	}
	public String getPositionLevel(){
		return this.PositionLevel.name();
	}
	private void setcurrentJob(Jobs job){
		this.currentJob = job;
		this.currentJobDaysLeft = this.PositionLevel.efficiency * job.getJobDaysRequired();
	}
	public String getCurrentJobName(){
		return this.currentJob.getName();
	}
	public void addJob(Jobs job){
		if(this.JobQueue.isEmpty()){
			this.setcurrentJob(job);
		}
		this.JobQueue.add(job);
		this.workload = this.workload + job.getJobDaysRequired() * this.PositionLevel.efficiency;
	}
	public int getCurrentStatus(){
		return this.workload;
	}
	public int jobsLeft(){
		return this.JobQueue.size();
	}
}
