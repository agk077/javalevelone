package ru.geekbrains.agk077.javalevelone.lesson06;

public abstract class Animal {
    public String name;

    // Task 3: У каждого животного есть ограничения на действия.
    protected double maxRunDist;
    protected double maxJumpDist;
    protected double maxSailDist;

    public Animal (String name) {
        this.name = name;
    }

    // Task 2: Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
    public abstract void run(double distance);
    public abstract void jump(double distance);
    public abstract void sail(double distance);

    public abstract void printInfo();

}
