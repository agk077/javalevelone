package ru.geekbrains.agk077.javalevelone.lesson01;

/*
    Created by agk077@ya.ru 26.10.2020
    Домашнее задание к уроку 1 Java уровень 1
 */

import java.util.Random;

public class HomeWork {

    // Task 1: прописать метод main()
    public static void main(String[] args) {

        // Task 2: Создать переменные и инициализировать значения
        // Примитивные типы
        byte byteValue = 100;
        short shortValue = 100;
        int intValue = 1001;
        long longValue = 10001;
        float floatValue = 1.01f;
        double doubleValue = 1.0001;
        char charValue = 'a';
        boolean boolValue = true;

        // Ссылочный тип переменных
        String stringValue = "Обычная строка, объектный тип данных";

        // Примитивные тесты
        System.out.println("Task 3, calculate = " + calculate(10, 20, 30, 40));

        Random random = new Random();
        int x1 = random.nextInt(20);
        int x2 = random.nextInt(20);
        System.out.println("Task 4, сумма чисел " + x1 + " и " + x2 + " в диапазоне 10..20? "
                + between10and20(x1, x2));

        isPosOrNeg(intValue);
        System.out.println("Task 6, -100 отрицательное число? " + isNegative(-100));
        greetings("Александра");
    }

    // Task 3: метод вычисляющий выражение a * (b + (c / d))
    public static int calculate(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    // Task 4: метод, проверяющий что сумма чисел лежит в пределах от 10 до 20(включительно)
    public static boolean between10and20(int v1, int v2) {
        return (v1 + v2) >= 10 & (v1 + v2) <= 20;
    }

    // Task 5: метод должен напечатать в консоль положительное ли число передали, или отрицательное
    public static void isPosOrNeg(int value) {
        if (value >= 0) {
            System.out.println(value + " - положительное число");
        } else {
            System.out.println(value + " - отрицательное число");
        }
    }

    // Task 6: метод должен вернуть true, если переданное число отрицательное
    public static boolean isNegative(int value) {
        return value <= 0;
    }

    // Task 7: метод должен вывести в консоль сообщение «Привет, указанное_имя!»
    public static void greetings(String name) {
        System.out.println("Привет, " + name + "!");
    }
}
