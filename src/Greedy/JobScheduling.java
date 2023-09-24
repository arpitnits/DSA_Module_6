package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobScheduling {

    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    //ProfitComparator - DESC
    class ProfitComparator implements Comparator<Job> {
        @Override
        public int compare(Job j1, Job j2) {
            return j2.profit - j1.profit;
        }
    }


    int[] jobScheduling(Job[] arr, int n) {
        //sort jobs in desc order of profit
        List<Job> jobList = new ArrayList<>(Arrays.asList(arr));

        //O(nlogn)
        jobList.sort(new ProfitComparator());

        boolean[] slotFilled = new boolean[n+1];
        Arrays.fill(slotFilled, false);

        int profit=0, slotUsed =0;

        for(Job job : jobList) {
            int deadline = job.deadline;
            while (deadline > 0 && slotFilled[deadline]) {
                deadline--;
            }
            if(deadline>0) {
                profit+= job.profit;
                slotFilled[deadline] = true;
                slotUsed++;
            }
        }

        int[] ans = new int[2];
        ans[0] = slotUsed;
        ans[1] = profit;
        return ans;
    }
}
