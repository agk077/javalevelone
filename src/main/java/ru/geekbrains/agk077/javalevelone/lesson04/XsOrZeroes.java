package ru.geekbrains.agk077.javalevelone.lesson04;
/*
    Created by agk077@ya.ru (tango!) 09.11.2020
    Домашнее задание к уроку 4, Java уровень 1

 */

import java.util.Random;
import java.util.Scanner;

public class XsOrZeroes {
    // Переменные - основные параметры игры
    public static final int FIELD_SIZE = 5;
    public static final int DOTS_TO_WIN = 3;
    public static final int LINE_LIMIT = 5;

    // Константы • X O
    public static final char DOT_FREE = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_ZERO = 'O';

    // Переменные - игровое поле, работа с клавиатурой, случайные числа
    public static char[][] map;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        // Инициализация игрового поля
        initField();

        // Вывод игрового поля
        printField();

        // Главный игровой цикл
        while (true) {
            // Ход игрока
            playerTurn();
            // Печать игрового поля
            printField();
            // Проверка победителя
            if (checkWin(DOT_X)) {
                System.out.println("Человеческий игрок одержал победу!");
                break;
            }
            // Проверка полностью заполненного поля
            if (fieldIsFull()) {
                System.out.println("Ничья!!!");
                break;
            }
            // Ход ИИ
            aiTurn();
            // Вывод игрового поля
            printField();
            // Проверка победителя
            if (checkWin(DOT_ZERO)) {
                System.out.println("Совершеннейшее существо победило!!!");
                break;
            }
            // Проверка заполненности карты
            if (fieldIsFull()) {
                System.out.println("Ничья!!!");
                break;
            }
        }
        // Игра закончена
        System.out.println("Игра завершена!!!");

        // Закрываем консоль
        scanner.close();
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(FIELD_SIZE); // [0 .. SIZE)
            y = random.nextInt(FIELD_SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_ZERO;
    }

    private static boolean fieldIsFull() {
        for (int y = 0; y < FIELD_SIZE; y++) {
            for (int x = 0; x < FIELD_SIZE; x++) {
                if (map[y][x] == DOT_FREE) return false;
            }
        }
        return true;
    }

    // Task 2: переписать проверку победы циклами
    private static boolean checkWin(char dot) {

        // проверяем горизонтальные линии
        for (int i = 0; i < FIELD_SIZE; i++) {
            boolean checkLine = false;
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (map[i][j] != dot) {
                    checkLine = false;
                    break;
                } else {
                    checkLine = true;
                }
            }
            if (checkLine) return true;

        }

        // проверяем вертикальные линии
        for (int i = 0; i < FIELD_SIZE; i++) {
            boolean checkLine = false;
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (map[j][i] != dot) {
                    checkLine = false;
                    break;
                } else {
                    checkLine = true;
                }
            }
            if (checkLine) return true;
        }

        // проверяем диагонали
        // левый верхний угол -> нижний правый
        {
            boolean checkLine = false;
            for (int i = 0; i < FIELD_SIZE; i++) {
                if (map[i][i] != dot) {
                    checkLine = false;
                    break;
                } else {
                    checkLine = true;
                }
            }
            if (checkLine) return true;
        }
        // нижний левый -> верхний правый
        {
            boolean checkLine = false;
            for (int i = FIELD_SIZE - 1, j = 0; i >= 0; i--, j++) {
                if (map[i][j] != dot) {
                    checkLine = false;
                    break;
                } else {
                    checkLine = true;
                }
            }

        }

        return false;
    }

    private static void printField() {
        // Сделали отступ
        for (int i = 0; i < LINE_LIMIT; i++) {
            System.out.println();
        }

        // Верхняя "Легенда"
        for (int i = 0; i <= FIELD_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Выводим игровое поле
        for (int y = 0; y < FIELD_SIZE; y++) {
            System.out.print((y + 1) + " ");
            for (int x = 0; x < FIELD_SIZE; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }

        // Дополнительный отступ
        System.out.println();
    }

    private static void initField() {
        map = new char[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                map[i][j] = DOT_FREE;
            }
        }
    }

    private static void playerTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате x y в диапазоне [1.." + FIELD_SIZE + "]");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= FIELD_SIZE) return false;
        if (y < 0 || y >= FIELD_SIZE) return false;
        if (map[y][x] != DOT_FREE) return false;
        return true;
    }

}
