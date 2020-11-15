package ru.geekbrains.agk077.javalevelone.lesson07;

public class Cat {
    private String name;
    private int appetite;

    // Task 3: добавляем поле сытости
    private boolean full;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

        // в начале кот голоден
        this.full = false;
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return full;
    }

    public void eat(Plate plate) {
        // Task 2: Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества
        // Task 4: Считаем, что если коту мало еды в тарелке, то он её просто не трогает
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            this.full = true;
        } else {
            System.out.println("Для кота \'" + name + "\' в тарелке недостаточно еды.");
        }
    }
}
