package ru.geekbrains.Java_2;

public class Robot implements Jumper, Runner {
    public String name;
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
    public boolean isAbleToRun(Treadmill treadmill) {
        if (treadmill.getDistance() <= this.maxRunDistance) {
            System.out.println("Робот " + this.name + " смог пробежать дистанцию " + treadmill.getDistance() + " м.");
            return true;
        } else {
            System.out.println("Робот " + this.name + " не смог пробежать дистанцию " + treadmill.getDistance() + " м.");
            return false;
        }

    }

    @Override
    public boolean isAbleToJump(Wall wall) {
        if (wall.getHeight() <= this.maxJumpHeight) {
            System.out.println("Робот " + this.name + " перепрыгнул через стену высотой " + wall.getHeight() + " см.");
            return true;
        } else {
            System.out.println("Робот " + this.name + " не смог перепрыгнуть через стену высотой " + wall.getHeight() + " см.");
            return false;
        }
    }
}


