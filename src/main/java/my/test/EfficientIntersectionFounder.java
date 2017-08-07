package my.test;

import com.lodborg.intervaltree.IntegerInterval;
import com.lodborg.intervaltree.Interval;
import com.lodborg.intervaltree.Interval.Bounded;
import com.lodborg.intervaltree.IntervalTree;

import java.util.Set;

public class EfficientIntersectionFounder extends AbstractIntersectionFounder implements IntersectionFounder {

    public Point findPoint(int[][] segments) {
        checkArguments(segments);
        IntervalTree<Integer> tree = new IntervalTree<>();

        for (int[] segment : segments) {
            tree.add(new IntegerInterval(segment[0], segment[1], Bounded.CLOSED));
        }

        int leftPointWithMaxCount = segments[0][0];
        int maxCount = 0;
        for (int[] segment : segments) {
            Set<Interval<Integer>> intervals = tree.query(segment[0]);
            if (intervals.size() > maxCount) {
                maxCount = intervals.size();
                leftPointWithMaxCount = segment[0];
            } else if (intervals.size() == maxCount) {
                if (segment[0] < leftPointWithMaxCount) {
                    leftPointWithMaxCount = segment[0];
                }
            }
        }
        Point point = new Point();
        point.setPoint(leftPointWithMaxCount);
        point.setSegmentsCount(maxCount);
        return point;
    }
}
