package ru.geekbrains.agk077.javalevelone.lesson02;
/*
    Created by agk077@ya.ru 29.10.2020
    Домашнее задание к уроку 2, Java уровень 1
 */

import java.util.Arrays;
import java.util.Random;

public class HomeWork {
    public static void main(String[] args) {

        // Task 1: Задать целочисленный массив, заменить 0 на 1, 1 на 0;
        {
            int[] arrayofBits = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            System.out.println("Task 1, массив в начале:");
            System.out.println(Arrays.toString(arrayofBits));
            for (int i = 0; i < arrayofBits.length; i++) {
                if (arrayofBits[i] == 0)
                    arrayofBits[i] = 1;
                else
                    arrayofBits[i] = 0;
            }
            System.out.println("Массив после изменений:");
            System.out.println(Arrays.toString(arrayofBits));
            System.out.println("------------------------------");
        }

        // Task 2: Задать пустой целочисленный массив размером 8. заполнить его значениями 0 3 6 9 12 15 18 21
        {
            int[] array = new int[8];
            System.out.println("Task 2, массив в начале:");
            System.out.println(Arrays.toString(array));
            for (int i = 0; i < array.length; i++) {
                array[i] = i * 3;
            }
            System.out.println("Массив после изменений:");
            System.out.println(Arrays.toString(array));
            System.out.println("------------------------------");
        }

        // Task 3: Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], числа меньшие 6 умножить на 2
        {
            int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            System.out.println("Task 3, массив в начале:");
            System.out.println(Arrays.toString(array));
            for (int i = 0; i < array.length; i++) {
                if (array[i] < 6) array[i] *=2;
            }
            System.out.println("Массив после изменений:");
            System.out.println(Arrays.toString(array));
            System.out.println("------------------------------");
        }

        // Task 4: Создать квадратный двумерный целочисленный массив, заполнить его диагональные элементы единицами;
        {
            int arrayLength = 15;
            int[][] array = new int[arrayLength][arrayLength];

            // from top left to bottom right
            for (int i = 0; i < arrayLength; i++) {
                array[i][i] = 1;
            }
            // from bottom left to top right
            for (int i = arrayLength - 1, j = 0; i >= 0; i--, j++) {
                array[i][j] = 1;
            }
            // show array values
            System.out.println("Task 4, массив с заполнеными диагоналями");
            for (int i = 0; i < arrayLength; i++) {
                for(int j = 0; j < arrayLength; j++) {
                    System.out.print(array[i][j] + " | ");
                }
                System.out.println();
            }
            System.out.println("------------------------------");
        }

        // Task 5: ** Задать одномерный массив и найти в нем минимальный и максимальный элементы
        {
            int arrayLength = 20;
            int[] array = new int[arrayLength];

            // fill array random values
            Random random = new Random();
            for (int i = 0; i < arrayLength; i++) {
                array[i] = random.nextInt(100);
            }
            System.out.println("Task 5, значения в массиве: " + Arrays.toString(array));

            int min = array[0];
            int max = array[0];

            for (int j : array) {
                if (j <= min) min = j;
                if (j >= max) max = j;
            }

            System.out.println("min value = " + min + ", max value = " + max);
            System.out.println("------------------------------");
        }

        // Task 6: ** Написать метод, который определяет бананс по сумме отдельных частей массива
        {
            int[] array = {2, 2, 2, 1, 2, 2, 10, 1};
            // int[] array = {1, 1, 1, 2, 1};
            // int[] array = {2, 2, 2, 1, 2, 2, 10, 3};
            //int[] array = {1};
            System.out.print("Task 6, значения в массиве: " + Arrays.toString(array));
            System.out.println(" баланс есть? " + checkArrayBalance(array));
        }

    }

    public static boolean checkArrayBalance (int[] array) {
        boolean balance = false;
        if (array.length <= 1) {
            System.out.println(" ** массив слишком короткий **");
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j <= i; j++) {
                leftSum += array[j];
            }
            for (int k = i + 1; k < array.length; k++) {
                rightSum += array[k];
            }
            if (leftSum == rightSum) balance = true;
            // System.out.println("Devider = " + i + ", left sum = " + leftSum + ", right sum = " + rightSum);
            // System.out.println("Total sum = " + (leftSum + rightSum) + ", left sum = " + leftSum + ", right sum = " + rightSum);
        }
        return balance;
    }
}
