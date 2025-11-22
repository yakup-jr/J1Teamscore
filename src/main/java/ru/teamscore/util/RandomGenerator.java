package ru.teamscore.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    private RandomGenerator() {
    }

    public static int generateRandomNumberInRange(int leftRange, int rightRange) {
        return ThreadLocalRandom.current().nextInt(leftRange, rightRange);
    }

    public static int[] generateRandomNumbersInRange(int count, int leftRange, int rightRange) {
        int[] values = new int[count];

        for (int i = 0; i < count; i++) {
            values[i] = generateRandomNumberInRange(leftRange, rightRange);
        }

        return values;
    }

}
