package com.dp;

import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {
	static class Jobs{
		int startTime;
		int endTime;
		int profit;
		public Jobs(int startTime,int endTime,int profit) {
			this.startTime=startTime;
			this.endTime=endTime;
			this.profit=profit;
		}
	}
	class endTimeComparator implements Comparator<Jobs>{

		@Override
		public int compare(Jobs o1, Jobs o2) {
			if(o1.endTime<o2.endTime)
				return -1;
			else 
				return 1;
		}
	}
	int maxProfit(Jobs[] jobs){
		if(jobs==null){
			return 0;
		}
		Arrays.sort(jobs,new endTimeComparator());
		int[] t=new int[jobs.length];
		for(int i=0;i<jobs.length;i++){
			t[i]=jobs[i].profit;
		}
		
		for(int i=1;i<jobs.length;i++){
			for(int j=0;j<i;j++){
				if(jobs[j].endTime<=jobs[i].startTime){
					if(t[j]+jobs[i].profit>t[i]){
						t[i]=t[j]+jobs[i].profit;
					}
				}
			}
		}
		int max=0;
		for(int i=0;i<t.length;i++){
			if(max<t[i])
				max=t[i];
		}
		
		return max;
	}
	public static void main(String[] args) {
		JobScheduling jc=new JobScheduling();
		Jobs[] jobs={new Jobs(6,7,4),new Jobs(5,8,11),new Jobs(7,9,2),new Jobs(1,3,5),new Jobs(2,5,6),new Jobs(4,6,5)};
		System.out.println(jc.maxProfit(jobs));
	}
}
