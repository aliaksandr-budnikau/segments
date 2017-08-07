package my.test;

public class Simple2IntersectionFounderTest extends IntersectionFounderTest {
    @Override
    protected IntersectionFounder getFounder() {
        return new Simple2IntersectionFounder();
    }
}
