package ab.Sep;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class canAttendMeetings {

     class Interval implements Comparable<Interval>{
     int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

      @Override
      public int compareTo(Interval that) {
             return this.start == that.start ? this.end - that.end : this.start - this.start;
      }
     }

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return false;
        }
        Collections.sort(Arrays.asList(intervals));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>( intervals.length, new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });
        // Sort interval by start time
        Arrays.sort(
                intervals,
                new Comparator<Interval>() {
                    public int compare(Interval a, Interval b) {
                        return a.start - b.start;
                    }
                });

        // Add the first meeting's end time into min-heap
        allocator.add(intervals[0].end);
        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i].end);
        }
        return allocator.size();
    }

    //Chronological Ordering
    public int minMeetingRooms2(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        //Seperate out start time and end time into seperate array
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        // Sort the intervals by end time
        Arrays.sort(
                end,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });

        // Sort the intervals by start time
        Arrays.sort(
                start,
                new Comparator<Integer>() {
                    public int compare(Integer a, Integer b) {
                        return a - b;
                    }
                });

        // The two pointers in the algorithm: e_ptr and s_ptr.
        int startPointer = 0, endPointer = 0;
        int usedRooms = 0;
        while (startPointer < intervals.length) {

            // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
            if (start[startPointer] >= end[endPointer]) {
                usedRooms -=1;
                endPointer +=1;
            }

            // We do this irrespective of whether a room frees up or not.
            // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
            // remain the same in that case. If no room was free, then this would increase used_rooms

            usedRooms += 1;
            startPointer += 1;

        }
        return usedRooms;
    }
}