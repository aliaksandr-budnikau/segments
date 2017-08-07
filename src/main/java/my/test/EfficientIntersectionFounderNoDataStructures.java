package my.test;

import java.util.Arrays;

public class EfficientIntersectionFounderNoDataStructures extends AbstractIntersectionFounder implements IntersectionFounder {

    public Point findPoint(int[][] segments) {
        checkArguments(segments);

        Edge[] points = collectOneDirectionalArray(segments);
        Arrays.sort(points);

        int leftPointWithMaxCount = points[0].getX();
        int maxCount = 0;
        int counter = 0;
        for (Edge edge : points) {
            if (edge.isLeft()) {
                counter++;
                if (counter > maxCount) {
                    maxCount = counter;
                    leftPointWithMaxCount = edge.getX();
                }
            } else {
                counter--;
            }
        }
        return getPoint(leftPointWithMaxCount, maxCount);
    }

    private Point getPoint(int leftPointWithMaxCount, int maxCount) {
        Point point = new Point();
        point.setPoint(leftPointWithMaxCount);
        point.setSegmentsCount(maxCount);
        return point;
    }

    private Edge[] collectOneDirectionalArray(int[][] segments) {
        Edge[] points = new Edge[segments.length << 1];
        for (int i = 0, j = 0; i < segments.length; i++, j += 2) {
            points[j] = new Edge(segments[i][0], true);
            points[j + 1] = new Edge(segments[i][1], false);
        }
        return points;
    }

    private class Edge implements Comparable<Edge> {
        private boolean left;
        private int x;

        public Edge(int x, boolean left) {
            this.x = x;
            this.left = left;
        }

        public int getX() {
            return x;
        }

        public boolean isLeft() {
            return left;
        }

        @Override
        public int compareTo(Edge o) {
            return this.getX() - o.getX();
        }
    }
}