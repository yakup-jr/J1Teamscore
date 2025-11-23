package ru.teamscore.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Random generator.
 */
public class RandomGenerator {

    private RandomGenerator() {
    }

    /**
     * Generate random number in range int.
     *
     * @param leftRange  the left range
     * @param rightRange the right range
     * @return the int
     */
    public static int generateRandomNumberInRange(int leftRange, int rightRange) {
        return ThreadLocalRandom.current().nextInt(leftRange, rightRange);
    }

    /**
     * Generate random numbers in range int [ ].
     *
     * @param count      the count
     * @param leftRange  the left range
     * @param rightRange the right range
     * @return the int [ ]
     */
    public static int[] generateRandomNumbersInRange(int count, int leftRange, int rightRange) {
        int[] values = new int[count];

        for (int i = 0; i < count; i++) {
            values[i] = generateRandomNumberInRange(leftRange, rightRange);
        }

        return values;
    }

}
