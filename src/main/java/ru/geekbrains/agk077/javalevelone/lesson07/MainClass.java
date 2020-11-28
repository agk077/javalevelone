package ru.geekbrains.agk077.javalevelone.lesson07;

public class MainClass {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(100);
        plate.info();
        cat.eat(plate);
        plate.info();

        Cat cat2 = new Cat("Мурзик", 120);
        cat2.eat(plate);

        // Task 5: Создать массив котов и тарелку с едой
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Перик", 15);
        cats[1] = new Cat("Пухлик", 85);
        cats[2] = new Cat("Ярик", 25);

        System.out.println("\nКормим наш кошатник)");
        for (Cat oneCat : cats) {
            oneCat.eat(plate);
        }
        for (Cat oneCat : cats) {
            System.out.println("Кот \'" + oneCat.getName() + (oneCat.isFull() ? "\' сыт" : "\' голоден"));
        }
    }
}
