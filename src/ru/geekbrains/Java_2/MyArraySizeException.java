package ru.geekbrains.Java_2;

public class MyArraySizeException extends RuntimeException {
    @Override
    public void printStackTrace() {
        System.out.println("Подан массив неверного размера(нужен 4Х4)!");
    }
}
