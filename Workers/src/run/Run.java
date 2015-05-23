/*
 * Name: Luv Somani
 * Class: CS3330
 * Lab: 8
 * Date: 4/3/2013
 */
/*
 * Main class Run that creates 8 easy jobs, 6 medium jobs, and 2 hard jobs. Also creates 7 workers with various efficiency.
 * 
 * The class assigns random jobs to random workers and prints out the final workload of each employee after all jobs have been randomly assigned.
 * 
 * I did not do the day by day implementation of the algorithm but I feel as if showing your employer this simulation multiple times would get the point across.
 *
 *
 */
package run;
import java.util.ArrayList;
import java.util.Random;

import jobs.*;
import jobs.Jobs.job;
import workers.Worker;
import workers.Worker.position;
public class Run {

	public static void main(String[] args) {
			ArrayList<Jobs> JobsList = new ArrayList<Jobs>();
			JobsList.add(new Jobs(job.Easy));
			JobsList.add(new Jobs(job.Easy));
			JobsList.add(new Jobs(job.Easy));
			JobsList.add(new Jobs(job.Easy));
			JobsList.add(new Jobs(job.Easy));
			JobsList.add(new Jobs(job.Easy));
			JobsList.add(new Jobs(job.Easy));
			JobsList.add(new Jobs(job.Easy));
			JobsList.add(new Jobs(job.Medium));
			JobsList.add(new Jobs(job.Medium));
			JobsList.add(new Jobs(job.Medium));
			JobsList.add(new Jobs(job.Medium));
			JobsList.add(new Jobs(job.Medium));
			JobsList.add(new Jobs(job.Medium));
			JobsList.add(new Jobs(job.Hard));
			JobsList.add(new Jobs(job.Hard));
			
			ArrayList<Worker>WorkerList = new ArrayList<Worker>();
			
			WorkerList.add(new Worker("Bob",position.Senior));
			WorkerList.add(new Worker("Sally", position.Mid));
			WorkerList.add(new Worker("Matt",position.Mid));
			WorkerList.add(new Worker("Jen",position.Entry));
			WorkerList.add(new Worker("Eric",position.Entry));
			WorkerList.add(new Worker("Frank",position.Entry));
			WorkerList.add(new Worker("Boris",position.Entry));
			Random rand = new Random();
			while(JobsList.size() > 0){
				int workerindex = rand.nextInt(WorkerList.size());
				int jobindex = rand.nextInt(JobsList.size());
				WorkerList.get(workerindex).addJob(JobsList.remove(jobindex));				
			}
			
			for(int i = 0; i < WorkerList.size(); i++){
				System.out.println(WorkerList.get(i).getName()+" is now working on " + WorkerList.get(i).jobsLeft() +" jobs that will take " + WorkerList.get(i).getCurrentStatus() + "days");
			}
			
			
		
	}

}
