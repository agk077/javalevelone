package ru.geekbrains.agk077.javalevelone.lesson08;

/*
ДЗ урок 8 Java уровень 1 by agk077@ya.ru (tango!)
Игра Пятнашки с визуальным интерфейсом построенном на кнопках (JButton)
24.11.20
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class TagGame extends JFrame {
    JButton[] jbs = new JButton[16];
    int currentEmptySlot = 15;

    public TagGame() {
        setBounds(500,500,400,300);
        setTitle("Игра Пятнашки");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 4));

        // Создаем и заполняем массив из рандомных чисел от 1 до 15ти
        final int N = 15;
        ArrayList<Integer> arrayList = new ArrayList<>(N);
        Random random = new Random();

        while (arrayList.size() < N) {
            int i = random.nextInt(N) + 1;
            if (!arrayList.contains(i)) {
                arrayList.add(i);
            }
        }

        int[] rndArr = arrayList.stream().mapToInt(i -> i).toArray();
        for (int i = 0; i < rndArr.length; i++) {
            System.out.println(rndArr[i]);
        }

//        Вариант заполнения массива числами для быстрой проверки возможности выиграть
//        int[] rndArr = new int[15];
//        for (int i = 0; i < rndArr.length; i++) {
//            rndArr[i] = i + 1;
//        }
//        rndArr[10] = 15;
//        rndArr[11] = 11;
//        rndArr[14] = 12;


        for (int i = 0; i < jbs.length - 1; i++) {
            jbs[i] = new JButton("" + rndArr[i]);
            jbs[i].setName("" + i);
            jbs[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton btn = (JButton) e.getSource();
                    moveButton(btn);
                }
            });
            jbs[i].setText("" + rndArr[i]);
            add(jbs[i]);
        }

        // adding last empty button
        jbs[jbs.length - 1] = new JButton("");
        jbs[jbs.length - 1].setName("15");
        jbs[jbs.length - 1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                moveButton(btn);
                if (currentEmptySlot == 15) checkWin();
            }
        });
        add(jbs[jbs.length - 1]);

        setVisible(true);
        jbs[15].setEnabled(false);

    }

    private void checkWin() {
        boolean isWon = true;
        for (int i = 0; i < jbs.length - 1; i++) {
            if (Integer.parseInt(jbs[i].getText()) != (i + 1)) {
                isWon = false;
                break;
        }
        }
        if (isWon)
            JOptionPane.showMessageDialog(null,
                    "Ура! Вы победили!");
    }

    private void moveButton(JButton btn) {
        int btnID = Integer.parseInt(btn.getName());
        if (btnID + 1 == currentEmptySlot ||
        btnID - 1 == currentEmptySlot ||
        btnID - 4 == currentEmptySlot ||
        btnID + 4 == currentEmptySlot) {
            System.out.println("Кнопка " + btn.getText() + " может быть перемещена на свободный слот");
            jbs[currentEmptySlot].setText(btn.getText());
            jbs[currentEmptySlot].setEnabled(true);
            currentEmptySlot = btnID;
            jbs[currentEmptySlot].setText("");
            jbs[currentEmptySlot].setEnabled(false);
        }
    }


    public static void main(String[] args) {
        TagGame tagGame = new TagGame();
    }
}
