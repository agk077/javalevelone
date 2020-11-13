package ru.geekbrains.agk077.javalevelone.lesson06;
/*
    Created by agk077@ya.ru (tango!) 13.11.2020
    Домашнее задание к уроку 6, Java уровень 1
 */

public class Zoo {
    public static void main(String[] args) {
        Cat cat = new Cat("Пуся");
        cat.printInfo();
        cat.run(300);
        cat.jump(1.5);
        cat.sail(1);

        Dog dog = new Dog("Торри");
        dog.printInfo();
        dog.run(500);
        dog.jump(5);
        dog.sail(10);

        // Task 5-2*: Добавить подсчет созданных котов, собак и животных (из методички).
        Animal animals[] = new Animal[5];
        animals[0] = new Cat("Жужа");
        animals[1] = new Dog("Жучка");
        animals[2] = new Dog("Лайка");
        animals[3] = new Cat("Соня");
        animals[4] = new Cat("Киса");

        int catsCount = 0;
        int dogsCount = 0;
        for (Animal animal:animals) {
            if (animal instanceof Cat) catsCount++;
            if (animal instanceof Dog) dogsCount++;
            animal.printInfo();
        }
        System.out.printf("Кошек всего: %d\n", catsCount);
        System.out.printf("Собак всего: %d\n", dogsCount);
        System.out.printf("Всего животных: %d\n", (catsCount + dogsCount));
    }
}
