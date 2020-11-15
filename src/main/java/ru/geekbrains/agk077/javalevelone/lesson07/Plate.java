package ru.geekbrains.agk077.javalevelone.lesson07;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        this.food -= amount;
    }

    // Task 6: Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
    public void increaseFood(int amount) {
        this.food +=amount;
    }

    public void info() {
        System.out.println("В тарелке: " + food + " еды");
    }
}
