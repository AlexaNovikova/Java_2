package ru.geekbrains.Java_2;

public class MyArrayJavaException extends ArrayIndexOutOfBoundsException {
    public MyArrayJavaException() {
        super();
        System.out.println("Ошибка! Не двумерный массив!");
    }
}
