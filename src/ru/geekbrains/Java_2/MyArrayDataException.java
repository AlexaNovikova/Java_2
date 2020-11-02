package ru.geekbrains.Java_2;


public class MyArrayDataException extends RuntimeException {
    int i;
    int j;

    public void printErrorPosition() {
        System.out.println("Введен символ вместо числа в ячейке: " + i + " " + j);
    }

}
