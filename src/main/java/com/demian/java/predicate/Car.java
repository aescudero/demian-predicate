package com.demian.java.predicate;

import java.util.function.Predicate;

public class Car {

    private final boolean hasTurbo;
    private final int maxSpeed;
    private final CarType type;

    public Car(boolean hasTurbo, int maxSpeed, CarType type) {
        this.hasTurbo = hasTurbo;
        this.maxSpeed = maxSpeed;
        this.type = type;
    }

    public enum CarType {
        FERRARI(c -> c.hasTurbo && c.maxSpeed > 150),
        HONDA(c -> c.hasTurbo),
        TOYOTA(c -> c.hasTurbo && c.maxSpeed > 300);

        private final Predicate<Car> activateBonus;

        CarType(Predicate<Car> activateBonus) {
            this.activateBonus = activateBonus;
        }

        public int getSpeed(Car car) {
            if (activateBonus.test(car)) {
                return car.maxSpeed * 2;
            }
            return car.maxSpeed;
        }

    }

    public void run() {
        System.out.println("Speed: " + type.getSpeed(this));
    }

    public static void main(String[] args) {
        Car ferrari = new Car(true, 300, CarType.FERRARI);
        Car honda = new Car(true, 200, CarType.HONDA);
        Car toyota = new Car(false, 300, CarType.TOYOTA);

        ferrari.run();
        honda.run();
        toyota.run();
    }

}
