package my.test;

public class EfficientIntersectionFounderNoDataStructuresTest extends IntersectionFounderTest {
    @Override
    protected IntersectionFounder getFounder() {
        return new EfficientIntersectionFounderNoDataStructures();
    }
}

