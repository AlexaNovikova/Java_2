package ru.geekbrains.Java_2;

public class Cat implements Runner, Jumper {
    private String name;
    private int age;
    private int maxRunDistance;
    private int maxJumpHeight;

    Cat(int age, String name, int maxJumpHeight, int maxRunDistance) {
        this.age = age;
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHeight() <= this.maxJumpHeight) {
            System.out.println("Кот " + name + " перепрыгнул через стену высотой " + wall.getHeight() + " см");
        } else System.out.println("Кот " + name + " не смог перепрыгнуть через стену высотой " + wall.getHeight()+ " см.");
    }


    @Override
    public void run(Treadmill treadmill) {
        if (treadmill.getDistance() <= this.maxRunDistance) {
            System.out.println("Кот/кошка " + name + " смог/смогла пробежать дистанцию " + treadmill.getDistance()+ " м.");
        } else System.out.println("Кот " + name + " не смог/смогла пробежать дистанцию " + treadmill.getDistance()+ " м.");
    }
}
