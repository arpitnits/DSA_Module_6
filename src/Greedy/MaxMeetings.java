package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMeetings {

    static  class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    //ASC
    static class EndTimeComparator implements Comparator<Meeting> {

        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.end - o2.end;
        }
    }
    public static int maxMeetings(int[] start, int[] end, int n) {
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0;i<n;i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        meetings.sort(new EndTimeComparator());

        int currTime = -1, maxMeetings =0;
        for(Meeting meeting : meetings) {
            if(currTime < meeting.start) {
                maxMeetings++;
                currTime = meeting.end;
            }
        }
        return maxMeetings;
    }
}
