package ru.teamscore.core;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Array statistics.
 */
public record ArrayStatistics(int[] values) {
    /**
     * Mode int [ ].
     *
     * @return the int [ ]
     */
    public int[] mode() {
        Map<Integer, Integer> valuesCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int value : values) {
            valuesCount.put(value, valuesCount.getOrDefault(value, 0) + 1);
        }

        int maxCount = valuesCount.values().stream().mapToInt(Integer::valueOf).max().orElse(0);

        valuesCount.forEach((value, count) -> {
            if (count == maxCount) {
                result.add(value);
            }
        });

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Median double.
     *
     * @return the double
     */
    public double median() {
        if (values.length == 0) {
            return Double.NaN;
        }

        int[] sortedValues = Arrays.stream(values.clone()).sorted().toArray();

        if (sortedValues.length % 2 == 0) {
            return ((double) (sortedValues[sortedValues.length / 2 - 1] +
                sortedValues[sortedValues.length / 2]) / 2);
        } else {
            return sortedValues[sortedValues.length / 2];
        }
    }

    /**
     * Average double.
     *
     * @return the double
     */
    public double average() {
        if (values.length == 0) {
            return Double.NaN;
        }

        return Arrays.stream(values).average().orElse(0.0);
    }

    /**
     * Variance double.
     *
     * @return the double
     */
    public double variance() {
        double average = average();
        double result = 0;

        for (int value : values) {
            result += Math.pow(value - average, 2);
        }

        return result / values.length;
    }

    /**
     * Geometric mean double.
     *
     * @return the double
     */
    public double geometricMean() {
        double result = 1;

        for (int value : values) {
            result *= value;
        }

        return Math.pow(result, (double) 1 / values.length);
    }

    /**
     * Shuffle int [ ].
     *
     * @return the int [ ]
     */
    public int[] shuffle() {
        int[] shuffledArray = new int[values.length];
        int[] possibleIndexes = new int[values.length];

        int i = 0;
        while (i < values.length) {
            int possibleIndex = ThreadLocalRandom.current().nextInt(0, values.length);

            if (possibleIndexes[possibleIndex] != -1) {
                shuffledArray[possibleIndex] = values[i];
                possibleIndexes[possibleIndex] = -1;
                i++;
            }
        }

        return shuffledArray;
    }

    /**
     * Sample int [ ].
     *
     * @param length the length
     * @return the int [ ]
     */
    public int[] sample(int length) {
        if (values.length == 0) {
            return new int[0];
        }

        int[] sampleArray = new int[length];
        int[] possibleIndexes = new int[length];

        int count = 0;
        while (count != length) {
            int possibleIndex = ThreadLocalRandom.current().nextInt(0, length);

            if (possibleIndexes[possibleIndex] != -1) {
                int randomSourceIndex = ThreadLocalRandom.current().nextInt(0, values.length);
                sampleArray[possibleIndex] = values[randomSourceIndex];
                possibleIndexes[possibleIndex] = -1;
                count++;
            }
        }
        return sampleArray;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ArrayStatistics that)) return false;

        return Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return "ArrayStatistics{" +
            "values=" + Arrays.toString(values) +
            '}';
    }
}
