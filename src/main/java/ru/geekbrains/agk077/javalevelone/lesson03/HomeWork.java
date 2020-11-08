package ru.geekbrains.agk077.javalevelone.lesson03;
/*
    Created by agk077@ya.ru 01.11.2020
    Домашнее задание к уроку 3, Java уровень 1
 */

import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Task 1: Написать программу, которая загадывает случайное число от 0 до 9
        {
            int retry;
            Random random = new Random();
            do {
                System.out.println("***************************");
                System.out.println("Новая игра. Угадайте число от 0 до 9.");
                int rndValue = random.nextInt(10);
                boolean userWon = false;
                for (int i = 1; i <= 3; i++) {
                    System.out.printf("Попытка %d: \n", i);
                    int userValue = scanner.nextInt();
                    if (userValue > rndValue) {
                        System.out.println("Ваше число больше загаданного.");
                    } else if (userValue < rndValue) {
                        System.out.println("Ваше число меньше загаданного.");
                    } else {
                        System.out.println("Поздравляем, вы угадали!");
                        userWon = true;
                        i = 4; // выходим из цикла for проставляя значения итератора
                    }
                }
                if(!userWon) System.out.println("Вы проиграли. Загаданное число было равно: " + rndValue);
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                retry = scanner.nextInt();
            } while (retry == 1);

            System.out.println("Конец игры. Спасибо за участие");
            System.out.println("******************************");
        }

        // Task 2* : Создать массив из слов String[] words
        {
            String[] words =  {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                    "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                    "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                    "pepper", "pineapple", "pumpkin", "potato"};

            Random random = new Random();
            int rndValue = random.nextInt(words.length);
            System.out.println("Новая игра - отгадай слово.");

            boolean userWon = false;
            do {
                System.out.println("Угадайте слово, ваш вариант: ");
                String userWord = scanner.next().toLowerCase();
                if (userWord.equals(words[rndValue])) userWon = true;
                else {
                    System.out.println("Вы ввели неверное слово, подсказка - " + checkWords(words[rndValue], userWord));
                }

            } while (!userWon);
            System.out.println("Правильно, Вы угадали слово!");
        }

        scanner.close();
    }

    public static String checkWords(String wordTrue, String wordAnswer) {
        String hint = "";
        int howLong = wordTrue.length() < wordAnswer.length() ? wordTrue.length() : wordAnswer.length();

        boolean hadHint = false; // флаг наличия подсказки
        for (int i = 0; i < howLong; i++) {
            if (wordTrue.charAt(i) == wordAnswer.charAt(i)) {
                hint += wordTrue.charAt(i);
                hadHint = true;
            } else {
                hint += "#";
            }
        }
        if (hadHint) {
            if (hint.length() < 15) {
                for (int i = hint.length(); i < 15; i++) {
                    hint += "#";
                }
            }
            return hint;
        } else {
            return "нет совпадений";
        }
    }
}
