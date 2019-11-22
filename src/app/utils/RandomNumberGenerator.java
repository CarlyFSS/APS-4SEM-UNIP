package app.utils;

import java.util.Random;

public class RandomNumberGenerator {

    Random rand = new Random();

    public int genRandomNumber(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    public int[] genRandomNumberArray(int size, int min, int max) {
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = genRandomNumber(min, max);
        }

        return arr;
    }
}