package ru.geekbrains.Java_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Integer[][] mass = new Integer[5][4];
        Integer[] errorMass = new Integer[5];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                mass[i][j] = random.nextInt(10) + 1;
            }
        }
        for (int i = 0; i < errorMass.length; i++) {
            errorMass[i] = random.nextInt(15);
        }
        try {
            System.out.println("В метод подан двумерный массив: ");
            System.out.println();
            Arrays.stream(mass).map(Arrays::toString).forEach(System.out::println);
            partMassSpiral(mass);
            System.out.println();
            System.out.println("Попытка передать одномерный массив");
            System.out.println();
            Arrays.stream(errorMass).forEach((n)-> System.out.print(n+ " "));
            System.out.println();
            partMassSpiral(errorMass);  // в метод подан одномерный массив
        } catch (MyArrayJavaException e) {
            e.printStackTrace();
        }

    }

    public static void  partMassSpiral   (Object object) {
        if (object instanceof Integer[][]) {
            Integer[][] mass = (Integer[][]) object;
            ArrayList<Integer> arrayList = new ArrayList<>();
            int massIndexRow = 0;
            int massIndexColumn = 0;
            int begin = 0;
            int end = 0;
            int kolMassElements = mass.length * mass[0].length;
            while (kolMassElements > 0) {
                for (int j = begin; j < mass.length - end; j++) {
                    if (mass[j].length < 2) throw new MyArrayJavaException();
                    arrayList.add(mass[j][massIndexColumn]);
                    kolMassElements--;
                }
                begin++;
                if (kolMassElements == 0) break;
                for (int i = begin; i < mass[mass.length - 1].length - end; i++) {
                    arrayList.add(mass[mass.length - 1 - massIndexRow][i]);
                    kolMassElements--;
                }
                if (kolMassElements == 0) break;
                for (int j = mass.length - begin - 1; j > end; j--) {
                    arrayList.add(mass[j][mass[massIndexColumn].length - massIndexColumn - 1]);
                    kolMassElements--;
                }
                if (kolMassElements == 0) break;
                end++;
                for (int i = mass[massIndexRow].length - begin; i >= end; i--) {
                    arrayList.add(mass[massIndexRow][i]);
                    kolMassElements--;
                }
                massIndexColumn++;
                massIndexRow++;
            }
            System.out.println();
            arrayList.forEach((n) -> System.out.print(n++ + "  "));
            System.out.println();
        } else throw new MyArrayJavaException();
    }

}


