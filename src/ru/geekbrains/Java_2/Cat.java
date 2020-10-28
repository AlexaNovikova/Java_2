package ru.geekbrains.Java_2;

public class Cat implements Runner, Jumper {
    public String name;
    private int age;
    public int maxRunDistance;
    public int maxJumpHeight;

    Cat(int age, String name, int maxJumpHeight, int maxRunDistance) {
        this.age = age;
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public boolean isAbleToRun(Treadmill treadmill) {
        if (treadmill.getDistance() <= this.maxRunDistance) {
            System.out.println("Кот/кошка " + this.name + " смог/ла пробежать дистанцию " + treadmill.getDistance() + " м.");
            return true;
        } else {
            System.out.println("Кот/кошка " + this.name + " не смог/ла пробежать дистанцию " + treadmill.getDistance() + " м.");
            return false;
        }

    }

    @Override
    public boolean isAbleToJump(Wall wall) {
        if (wall.getHeight() <= this.maxJumpHeight) {
            System.out.println("Кот/кошка " + this.name + " перепрыгнул/а через стену высотой " + wall.getHeight() + " см.");
            return true;
        } else {
            System.out.println("Кот/кошка " + this.name + " не смог/ла перепрыгнуть через стену высотой " + wall.getHeight() + " см.");
            return false;
        }
    }
}
