package bigf.Sort;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        intervals.sort((interval1, interval2) -> Integer.compare(interval1.start, interval2.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                // Need to merge
                end = Math.max(end, interval.end);
            } else {
                // do not need merge
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // Need to add the last one
        res.add(new Interval(start, end));
        return res;
    }
}
