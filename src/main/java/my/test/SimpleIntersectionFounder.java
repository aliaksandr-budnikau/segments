package my.test;

import java.util.HashMap;
import java.util.NavigableSet;
import java.util.TreeSet;

public class SimpleIntersectionFounder extends AbstractIntersectionFounder implements IntersectionFounder {

    public Point findPoint(int[][] segments) {
        checkArguments(segments);
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashMap<Integer, Integer> countersMap = new HashMap<>();
        for (int[] segment : segments) {
            int currentLeftPoint = segment[0];
            treeSet.add(currentLeftPoint);
            countersMap.put(currentLeftPoint, 0);
        }

        int leftPointWithMaxCounterKey = 0;
        int maxCounter = 0;
        for (int[] segment : segments) {
            int currentLeftPoint = segment[0];
            int currentRightPoint = segment[1];
            NavigableSet<Integer> keys = treeSet.subSet(currentLeftPoint, true, currentRightPoint, true);
            for (int key : keys) {
                int counter = countersMap.get(key) + 1;
                countersMap.put(key, counter);
                if (counter > maxCounter) {
                    maxCounter = counter;
                    leftPointWithMaxCounterKey = key;
                } else if (counter == maxCounter) {
                    if (key < leftPointWithMaxCounterKey) {
                        leftPointWithMaxCounterKey = key;
                    }
                }
            }
        }
        Point point = new Point();
        point.setPoint(leftPointWithMaxCounterKey);
        point.setSegmentsCount(maxCounter);
        return point;
    }
}
