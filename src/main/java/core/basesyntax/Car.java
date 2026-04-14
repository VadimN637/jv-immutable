package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private int year;
    private String color;
    private List<Wheel> wheels;
    private Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;

        this.wheels = new ArrayList<>();
        if (wheels != null) {
            for (Wheel w : wheels) {
                this.wheels.add(w.clone());
            }
        }

        this.engine = engine == null ? null : engine.clone();
    }

    // ✅ REQUIRED GETTERS (fix your error)

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine == null ? null : engine.clone();
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel w : wheels) {
            copy.add(w.clone());
        }
        return copy;
    }

    // "immutable-style" updates (as tests expect)
    public Car changeEngine(Engine engine) {
        this.engine = engine.clone();
        return this;
    }

    public Car changeColor(String newColor) {
        this.color = newColor;
        return this;
    }

    public Car addWheel(Wheel newWheel) {
        this.wheels.add(newWheel.clone());
        return this;
    }

    @Override
    public Car clone() {
        return new Car(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public String toString() {
        return "Car{"
                + "year=" + year
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", engine=" + engine
                + '}';
    }
}
