package ru.geekbrains.Java_2;

public class Human implements Runner, Jumper {
    private String name;
    private int age;
    private int maxRunDistance;
    private int maxJumpHeight;

    Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    Human(int age, String name, int maxJumpHeight, int maxRunDistance) {
        this(age, name);
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHeight() <= this.maxJumpHeight) {
            System.out.println("Человек " + this.name + " перепрыгнул через стену высотой " + wall.getHeight()+ " см.");
        } else
            System.out.println("Человек " + this.name + " не смог перепрыгнуть через стену высотой " + wall.getHeight()+ " см.");
    }


    @Override
    public void run(Treadmill treadmill) {
        if (treadmill.getDistance() <= this.maxRunDistance) {
            System.out.println("Человек " + this.name + " смог пробежать дистанцию " + treadmill.getDistance()+ " м.");
        } else System.out.println("Человек " + this.name + " не смог пробежать дистанцию " + treadmill.getDistance()+ " м.");
    }
}
