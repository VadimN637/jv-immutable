package core.basesyntax;

public final class Engine {
    private final int horsePower;
    private final String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public Engine(Engine other) {
        this.horsePower = other.horsePower;
        this.manufacturer = other.manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    // "upgrade engine" = create new instance
    public Engine changeEngine(Engine engine) {
        return new Engine(engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return horsePower == engine.horsePower &&
                java.util.Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(horsePower, manufacturer);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "horsePower=" + horsePower +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
