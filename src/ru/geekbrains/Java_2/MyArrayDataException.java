package ru.geekbrains.Java_2;


public class MyArrayDataException extends RuntimeException {
    int i;
    int j;

    @Override
    public void printStackTrace() {
        System.out.println("Введен символ вместо числа в ячейке: " + i + " " + j);
    }

}
