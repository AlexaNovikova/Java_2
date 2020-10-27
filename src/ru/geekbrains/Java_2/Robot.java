package ru.geekbrains.Java_2;

public class Robot implements Jumper, Runner {
    private String name;
    private int techNumber;
    int maxJumpHeight;
    int maxRunDistance;

    Robot(int techNumber, String name) {
        this.techNumber = techNumber;
        this.name = name;
    }

    Robot(String name, int techNumber, int maxRunDistance, int maxJumpHeight) {
        this(techNumber, name);
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHeight() <= this.maxJumpHeight) {
            System.out.println("Робот " + name + " перепрыгнул через стену высотой " + wall.getHeight()+ " см.");
        } else System.out.println("Робот " + name + " не смог перепрыгнуть через стену высотой " + wall.getHeight()+ " см.");
    }


    @Override
    public void run(Treadmill treadmill) {
        if (treadmill.getDistance() <= this.maxRunDistance) {
            System.out.println("Робот " + name + " смог пробежать дистанцию " + treadmill.getDistance()+ " м.");
        } else System.out.println("Робот " + name + " не смог пробежать дистанцию " + treadmill.getDistance()+ " м.");
    }
}
