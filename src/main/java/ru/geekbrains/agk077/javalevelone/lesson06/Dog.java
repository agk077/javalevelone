package ru.geekbrains.agk077.javalevelone.lesson06;

import java.util.Random;

// Task 1: Создать класс Собака с наследованием от класса Животное.
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        Random random = new Random();

        // Task 5: * Добавить животным разброс в ограничениях.
        this.maxJumpDist = random.nextInt(3);
        this.maxRunDist = random.nextInt(1000);
        this.maxSailDist = random.nextInt(100);
    }

    @Override
    public void run(double distance) {
        if (distance <= maxRunDist) {
            System.out.printf("Собака \'%s\' пробежала %.1f метров\n", name, distance);
        } else {
            System.out.printf("Собака \'%s\' не может пробежать %.1f метров\n", name, distance);
        }
    }

    @Override
    public void jump(double distance) {
        if (distance <= maxJumpDist) {
            System.out.printf("Собака \'%s\' подпрыгнула на %.1f метров\n", name, distance);
        } else {
            System.out.printf("Собака \'%s\' не может подпрыгнуть на %.1f метров\n", name, distance);
        }
    }

    @Override
    public void sail(double distance) {
        if (distance <= maxJumpDist) {
            System.out.printf("Собака \'%s\' проплыла на %.1f метров\n", name, distance);
        } else {
            System.out.printf("Собака \'%s\' не может проплыть %.1f метров\n", name, distance);
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Собака \'" + name + "\' " +
                "может подпрыгнуть на " + maxJumpDist + " метров, " +
                "может бегать на " + maxRunDist + " метров, " +
                "и может проплыть " + maxSailDist + " метров");
    }
}
