package ru.geekbrains.Java_2;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;
    public static float[] arr = new float[size];

    public static void main(String[] args) {

        method_first(arr);
        method_second(arr);
    }

    public static void method_first ( float[] arr){

        for (int i=0; i< arr.length; i++){
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        for (int i=0; i<arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println(b-a);
    }

    public static void method_second ( float[] arr){
        float [] a1 = new float[h];
        float [] a2 = new float[h];
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        var t1 = new Thread(() -> {initAndChangeMass(a1);});
        var t2 = new Thread(() -> {initAndChangeMass(a2);});
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long b = System.currentTimeMillis();
        System.out.println(b-a);
    }


    public static void initAndChangeMass ( float[] arr){
        for (int i=0; i<arr.length; i++)
        {arr[i]=1;
        }
        for ( int i=0; i<arr.length; i++){
                arr[i]= (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

        }
}
