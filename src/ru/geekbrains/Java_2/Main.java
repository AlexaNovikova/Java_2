package ru.geekbrains.Java_2;

//        1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
//        Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
//        2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны
//        выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль
//        (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина (для дорожки) или высота (для стены),
//        а участников ограничения на бег и прыжки.
//        3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
//        Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.


import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Object[] participants = new Object[]{createRobot(), createHuman(), createCat(), createCat(), createHuman(), createRobot()};
        Object[] barriers = new Object[]{createTreadmill(), createWall(), createTreadmill(), createWall()};

        for (Object participant : participants) {
            if (participant instanceof Jumper) {
                for (int j = 0; j < barriers.length; j++) {
                    if (barriers[j] instanceof Wall) {
                        ((Jumper) participant).jump((Wall) barriers[j]);
                    }
                }
            }
            if (participant instanceof Runner) {
                for (int j = 0; j < barriers.length; j++) {
                    if (barriers[j] instanceof Treadmill) {
                        ((Runner) participant).run((Treadmill) barriers[j]);
                    }
                }
            }
        }
    }


    public static Human createHuman() {
        Random random = new Random();
        String[] names = {"Костя", "Женя", "Маша", "Света", "Виктор", "Саша", "Оля", "Олег", "Роман"};
        int age = random.nextInt(70) + 10;
        String name = names[random.nextInt(9)];
        return new Human(age, name, createLimit(150, 40), createLimit(8000, 1000));
    }

    public static Robot createRobot() {
        Random random = new Random();
        String[] names = {"Bob", "John", "Silver", "PP9", "K4", "LL9", "LJK", "EE49", "PP87"};
        int techNumber = random.nextInt(70) + 10;
        String name = names[random.nextInt(9)];
        return new Robot(name, techNumber, createLimit(150, 100), createLimit(10000, 5000));
    }

    public static Cat createCat() {
        Random random = new Random();
        String[] names = {"Мурка", "Тучка", "Маша", "Барсик", "Снежок", "Капа", "Кнопка"};
        int age = random.nextInt(10) + 1;
        String name = names[random.nextInt(7)];
        return new Cat(age, name, createLimit(100, 20), createLimit(3000, 100));
    }

    public static int createLimit(int max, int min) {
        Random random = new Random();
        int Limit = random.nextInt(max) + min;
        return Limit;
    }

    public static Wall createWall() {
        return new Wall(createLimit(150, 20));
    }

    public static Treadmill createTreadmill() {
        return new Treadmill(createLimit(10000, 400));
    }

}
