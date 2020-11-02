package ru.geekbrains.Java_2;


import java.util.Scanner;

public class Main {
    public static String[][] massString;
    public static int[][] massInt;

    public static void main(String[] args) {
        // Для вызова ошибки MyArraySizeException измените размер подаваемого на вход массива.
        // Для вызова ошибки MyArrayDataFormatException введите символ вместо числа в ячейку.
        massString = new String[4][4];
        massInt = new int[4][4];
        massInit(massString);
        try {
            int sum = MassSum(massString);
            System.out.println("Сумма эементов массива равна " + sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printErrorPosition();
        }
    }

    public static int MassSum(String[][] mass) {
        int sum = 0;
        if (mass.length != 4) throw new MyArraySizeException();
        for (int i = 0; i < 4; i++) {
            if (mass[i].length != 4) throw new MyArraySizeException();
            for (int j = 0; j < 4; j++) {
                if (isNumeric(mass[i][j])) {
                    massInt[i][j] = Integer.parseInt(mass[i][j]);
                    sum = sum + massInt[i][j];
                } else {
                    MyArrayDataException myArrayDataException = new MyArrayDataException();
                    myArrayDataException.i = i;
                    myArrayDataException.j = j;
                    throw myArrayDataException;
                }
            }
        }
        printMass(massInt);
        return sum;
    }

    public static void massInit(String[][] massString) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите эелементы массива(числа), каждый элемент с новой строки ");
        for (int i = 0; i < massString.length; i++) {
            for (int j = 0; j < massString[i].length; j++) {
                massString[i][j] = scanner.next();
            }
        }
    }

    public static void printMass(int[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+");
    }
}
