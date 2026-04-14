package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    // constructor with deep copy
    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;

        // deep copy of list
        this.wheels = new ArrayList<>();
        if (wheels != null) {
            for (Wheel w : wheels) {
                this.wheels.add(new Wheel(w));
            }
        }

        // deep copy of engine
        this.engine = engine == null ? null : new Engine(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    // return deep copy
    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel w : wheels) {
            copy.add(new Wheel(w));
        }
        return copy;
    }

    public Engine getEngine() {
        return engine == null ? null : new Engine(engine);
    }

    // "change engine" = new Car
    public Car changeEngine(Engine newEngine) {
        return new Car(this.year, this.color, this.wheels, newEngine);
    }

    // "change color" = new Car
    public Car changeColor(String newColor) {
        return new Car(this.year, newColor, this.wheels, this.engine);
    }

    // "add wheel" = new Car
    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);
        newWheels.add(new Wheel(newWheel));
        return new Car(this.year, this.color, newWheels, this.engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return year == car.year &&
                Objects.equals(color, car.color) &&
                Objects.equals(wheels, car.wheels) &&
                Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    @Override
    public String toString() {
        return "Car{" +
                "year=" + year +
                ", color='" + color + '\'' +
                ", wheels=" + wheels +
                ", engine=" + engine +
                '}';
    }
}
