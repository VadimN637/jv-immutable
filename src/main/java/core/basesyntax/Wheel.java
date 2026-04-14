package core.basesyntax;

public final class Wheel {
    private final int radius;

    public Wheel(int radius) {
        this.radius = radius;
    }

    public Wheel(Wheel other) {
        this.radius = other.radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wheel wheel = (Wheel) o;
        return radius == wheel.radius;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(radius);
    }

    @Override
    public String toString() {
        return "Wheel{"
                + "radius=" + radius
                + '}';
    }
}
