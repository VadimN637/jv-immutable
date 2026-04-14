package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;

        this.wheels = new ArrayList<>();

        if (wheels != null) {
            for (Wheel wheel : wheels) {
                if (wheel != null) {
                    this.wheels.add(new Wheel(wheel.getRadius()));
                } else {
                    this.wheels.add(null);
                }
            }
        }

        if (engine != null) {
            this.engine = new Engine(engine.getHorsePower(), engine.getManufacturer());
        } else {
            this.engine = null;
        }
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        if (engine == null) {
            return null;
        } else {
            return new Engine(engine.getHorsePower(), engine.getManufacturer());
        }
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(wheel != null ? new Wheel(wheel.getRadius()) : null);
        }
        return copy;
    }

    public Car changeEngine(Engine engine) {
        return new Car(year, color, this.wheels, engine);
    }

    public Car changeColor(String newColor) {
        return new Car(year, newColor, this.wheels, this.engine);
    }

    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = new ArrayList<>(this.wheels);

        if (newWheel != null) {
            newWheels.add(new Wheel(newWheel.getRadius()));
        }

        return new Car(year, color, newWheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Car)) {
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
}
