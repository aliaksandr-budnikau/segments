package my.test;

public class AbstractIntersectionFounder {

    protected void checkArguments(int[][] segments) {
        if (segments == null || segments.length == 0) {
            throw new IllegalArgumentException();
        }
    }
}
