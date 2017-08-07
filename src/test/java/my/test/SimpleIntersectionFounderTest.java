package my.test;

public class SimpleIntersectionFounderTest extends IntersectionFounderTest {
    @Override
    protected IntersectionFounder getFounder() {
        return new SimpleIntersectionFounder();
    }
}
