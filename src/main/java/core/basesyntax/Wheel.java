package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    // TESTS REQUIRE setter
    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Wheel clone() {
        return new Wheel(this.radius);
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }
}
