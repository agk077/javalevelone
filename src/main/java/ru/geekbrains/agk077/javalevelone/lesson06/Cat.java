package ru.geekbrains.agk077.javalevelone.lesson06;

import java.util.Random;

// Task 1: Создать класс Кот с наследованием от класса Животное.
public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        Random random = new Random();

        // Task 5: * Добавить животным разброс в ограничениях.
        this.maxJumpDist = random.nextInt(5);
        this.maxRunDist = random.nextInt(1000);
        this.maxSailDist = 0;
    }

    @Override
    public void run(double distance) {
        if (distance <= maxRunDist) {
            System.out.printf("Кот \'%s\' пробежал %.1f метров\n", name, distance);
        } else {
            System.out.printf("Кот \'%s\' не может пробежать %.1f метров\n", name, distance);
        }
    }

    @Override
    public void jump(double distance) {
        if (distance <= maxJumpDist) {
            System.out.printf("Кот \'%s\' подпрыгнул на %.1f метров\n", name, distance);
        } else {
            System.out.printf("Кот \'%s\' не может подпрыгнуть на %.1f метров\n", name, distance);
        }
    }

    @Override
    public void sail(double distance) {
        System.out.println("Sorry, кошки не умеют плавать");
    }

    @Override
    public void printInfo() {
        System.out.println("Кот/кошка \'" + name + "\' " +
                "может подпрыгнуть на " + maxJumpDist + " метров, " +
                "может бегать на " + maxRunDist + " метров, " +
                "и не может плавать.");
    }

}
