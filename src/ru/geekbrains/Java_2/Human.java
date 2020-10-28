package ru.geekbrains.Java_2;

public class Human implements Runner, Jumper {
    public String name;
    private int age;
    public int maxRunDistance;
    public int maxJumpHeight;

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
    public boolean isAbleToRun(Treadmill treadmill) {
        if (treadmill.getDistance() <= this.maxRunDistance) {
            System.out.println("Человек " + this.name + " смог пробежать дистанцию " + treadmill.getDistance() + " м.");
            return true;
        } else {
            System.out.println("Человек " + this.name + " не смог пробежать дистанцию " + treadmill.getDistance() + " м.");
            return false;
        }

    }

    @Override
    public boolean isAbleToJump(Wall wall) {
        if (wall.getHeight() <= this.maxJumpHeight) {
            System.out.println("Человек " + this.name + " перепрыгнул через стену высотой " + wall.getHeight() + " см.");
            return true;
        } else {
            System.out.println("Человек " + this.name + " не смог перепрыгнуть через стену высотой " + wall.getHeight() + " см.");
            return false;
        }
    }
}
