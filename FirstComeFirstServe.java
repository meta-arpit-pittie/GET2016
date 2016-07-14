/*
 * To calculate First Come First
 * Assumption: Arrival time is in ascending order
 * Author: Arpit Pittie
 */
package Session1;

public class FirstComeFirstServe {

	/*
	 * Method to calculate the wait time and finish time
	 * according t the First Come First Serve Scheduling
	 * @param: arrival time of the jobs
	 * @param: Execution time of the jobs
	 * @return: array of wait time and finish time of the jobs
	 */
	public int[][] FCFS(int arrival_time [], int job_size[]) {
		int[][] FCFSresult = new int[arrival_time.length][2];
		int i=0;
		
		while(i < arrival_time.length) {
			if(i == 0) {	/*For the first job arriving*/
				FCFSresult[0][0] = 0;
				FCFSresult[0][1] = (arrival_time[0] + job_size[0]) - 1;
				i++;
			} else {
				if(FCFSresult[i-1][1] >= arrival_time[i]) { /*all the other jobs*/
					FCFSresult[i][0] = (FCFSresult[i-1][1] + 1) - arrival_time[i];
					FCFSresult[i][1] = FCFSresult[i-1][1] + job_size[i];
				} else {	/*Resuming work after being idle*/
					FCFSresult[i][0] = 0;
					FCFSresult[i][1] = (arrival_time[i] + job_size[i]) - 1;
				}
				i++;
			}
		}
		
		return FCFSresult;
	}
}
