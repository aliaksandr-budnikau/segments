package my.test;

import java.util.HashMap;
import java.util.HashSet;

public class Simple2IntersectionFounder extends AbstractIntersectionFounder implements IntersectionFounder {

    public Point findPoint(int[][] segments) {
        checkArguments(segments);
        HashMap<Integer, Integer> leftPointsAndTheirCountersMap = new HashMap<>();
        int leftPointWithMaxCounterKey = segments[0][0];
        int maxCounter = 0;
        HashSet<Integer> alreadyCountedLeftPoints = new HashSet<>();

        for (int i = 0; i < segments.length; i++) {
            int currentLeftPoint = segments[i][0];
            if (alreadyCountedLeftPoints.contains(currentLeftPoint)) {
                continue;
            }
            leftPointsAndTheirCountersMap.put(currentLeftPoint, 0);
            for (int j = 0; j < segments.length; j++) {
                int segmentLeftPoint = segments[j][0];
                int segmentRightPoint = segments[j][1];
                if (isInsideSegment(currentLeftPoint, segmentLeftPoint, segmentRightPoint)) {
                    int counter = leftPointsAndTheirCountersMap.get(currentLeftPoint) + 1;
                    leftPointsAndTheirCountersMap.put(currentLeftPoint, counter);
                    if (counter > maxCounter) {
                        maxCounter = counter;
                        leftPointWithMaxCounterKey = currentLeftPoint;
                    } else if (counter == maxCounter) {
                        if (currentLeftPoint < leftPointWithMaxCounterKey) {
                            leftPointWithMaxCounterKey = currentLeftPoint;
                        }
                    }
                }
            }
            alreadyCountedLeftPoints.add(currentLeftPoint);
        }
        Point point = new Point();
        point.setPoint(leftPointWithMaxCounterKey);
        point.setSegmentsCount(maxCounter);
        return point;
    }

    private boolean isInsideSegment(int currentLeftPoint, int leftPoint, int rightPoint) {
        return leftPoint <= currentLeftPoint && currentLeftPoint <= rightPoint;
    }
}
