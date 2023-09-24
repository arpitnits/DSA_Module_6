package Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class MinimumPlatforms {

    //arriving -> arrival = 1,
    //departing -> arrival = 0
    private static int ARRIVAL = 1;
    private static int DEPT = 0;

    static class StationEvent {
        int time;
        int arrival;

        StationEvent(int time, int arrival) {
            this.time = time;
            this.arrival = arrival;
        }

    }

    //ASC
    static class TimeComparator implements Comparator<StationEvent> {
        @Override
        public int compare(StationEvent o1, StationEvent o2) {
            return o1.time - o2.time;
        }
    }

    //ARRIVAL -> DEPT
    //DESC (1 -> 0)
    static class ArrivalComparator implements Comparator<StationEvent> {
        @Override
        public int compare(StationEvent o1, StationEvent o2) {
            return o2.arrival - o1.arrival;
        }
    }
    public static int findPlatform(int[] arr, int[] dept, int n) {
        List<StationEvent> stationEvents = new ArrayList<>();

        for(int i=0;i<n;i++) {
            stationEvents.add(new StationEvent(arr[i], ARRIVAL));
            stationEvents.add(new StationEvent(dept[i], DEPT));
        }

        stationEvents.sort(new TimeComparator().thenComparing(new ArrivalComparator()));

        int minPlatforms = 0, busyPlatforms = 0;

        for(StationEvent stationEvent : stationEvents) {
            if(stationEvent.arrival == ARRIVAL) {
                busyPlatforms++;
            } else {
                busyPlatforms--;
            }

            minPlatforms = Math.max(minPlatforms, busyPlatforms);
        }
        return minPlatforms;
    }
}
