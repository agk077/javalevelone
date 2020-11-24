package ru.geekbrains.agk077.javalevelone.lesson08;

/*
Заглушка к ДЗ урок 8 Java уровень 1
План сделать игру пятнашки с использованием кнопок, но только начал.
24.11.20
 */

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.*;

public class TagGame extends JFrame {
    JButton[] jbs = new JButton[16];

    public TagGame() {
        setBounds(500,500,400,300);
        setTitle("GridLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 4));


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

        Action action = new SimpleAction();
        for (int i = 0; i < jbs.length - 1; i++) {
            jbs[i] = new JButton("" + rndArr[i]);
            jbs[i].setAction(action);
            jbs[i].setName("" + i);
            jbs[i].setText("" + rndArr[i]);
            add(jbs[i]);
        }

        jbs[jbs.length - 1] = new JButton("NEW");
        add(jbs[jbs.length - 1]);
        jbs[jbs.length - 1].setName("15");
        jbs[jbs.length - 1].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                int btnID = Integer.parseInt(btn.getName());
                jbs[btnID - 1].setText("" + btnID);
            }
        });
        setVisible(true);
//        jbs[15].setEnabled(false);

        for (int i = 0; i < jbs.length; i++) {
            System.out.println(jbs[i].getHeight());
        }

    }

    // Внутренний класс
    class SimpleAction extends AbstractAction {
        private static final long serialVersionUID = 1L;
        SimpleAction() {
            // Параметры команды
            // putValue(NAME, "Класс Action!");
            putValue(SHORT_DESCRIPTION, "Это подсказка");
            // putValue(MNEMONIC_KEY, new Integer('A'));
        }
        // Обработка события нажатия на кнопку
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            System.out.println("Нажатие на кнопку <" + btn.getName() + ">");
            btn.setEnabled(false);
            // можно выключить команду, не зная, к каким компонентам она присоединена
//            if (btn.getName().equalsIgnoreCase(BUTTON_NAME)) {
//                btn.setEnabled(false);
//                // Изменение надписи
//                // putValue(NAME, "Disabled button");
//                btn.setText("Disabled button");
//            }
        }
    }

    public static void main(String[] args) {
        TagGame tagGame = new TagGame();
    }
}
