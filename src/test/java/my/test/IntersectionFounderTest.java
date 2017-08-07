package my.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public abstract class IntersectionFounderTest {

    protected abstract IntersectionFounder getFounder();

    @Test
    public void test() {
        int[][] segments = new int[][]{
                {12, 20},
                {5, 8},
                {7, 13},
                {10, 17}
        };

        Point point = getFounder().findPoint(segments);
        assertEquals(12, point.getPoint());
        assertEquals(3, point.getSegmentsCount());
    }

    @Test
    public void testAllFromOnePoint() {
        int[][] segments = new int[][]{
                {12, 20},
                {12, 18},
                {12, 13},
                {12, 17}
        };

        Point point = getFounder().findPoint(segments);
        assertEquals(12, point.getPoint());
        assertEquals(4, point.getSegmentsCount());
    }

    @Test
    public void testThereAreNoCommonPoints() {
        int[][] segments = new int[][]{
                {1, 2},
                {4, 5},
                {6, 10},
                {100, 200}
        };

        Point point = getFounder().findPoint(segments);
        assertEquals(1, point.getPoint());
        assertEquals(1, point.getSegmentsCount());
    }

    @Test
    public void testWithTwoTargetPoints() {
        int[][] segments = new int[][]{
                {-7, -1},
                {-7, -4},
                {1, 7},
                {1, 7}
        };

        Point point = getFounder().findPoint(segments);
        assertEquals(-7, point.getPoint());
        assertEquals(2, point.getSegmentsCount());
    }

    @Test
    public void testWithNegativePoints() {
        int[][] segments = new int[][]{
                {-12, 20},
                {-5, 8},
                {7, 13},
                {10, 17},
                {-12, 19},
                {17, 19},
                {-16, 19},
                {16, 19},
                {7, 10}
        };

        Point point = getFounder().findPoint(segments);
        assertEquals(7, point.getPoint());
        assertEquals(6, point.getSegmentsCount());
    }

    @Test
    public void testWithOneSegment() {
        int[][] segments = new int[][]{
                {12, 20}
        };

        Point point = getFounder().findPoint(segments);
        assertEquals(12, point.getPoint());
        assertEquals(1, point.getSegmentsCount());
    }

    @Test
    public void testIfEmptyOrNull() {
        try {
            getFounder().findPoint(new int[0][0]);
            fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            getFounder().findPoint(null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }
}