package my.test;

public class EfficientIntersectionFounderTest extends IntersectionFounderTest {
    @Override
    protected IntersectionFounder getFounder() {
        return new EfficientIntersectionFounder();
    }
}

