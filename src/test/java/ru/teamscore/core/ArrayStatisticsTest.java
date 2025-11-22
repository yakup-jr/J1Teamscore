package ru.teamscore.core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStatisticsTest {

    @Test
    void mode_NotEmpty_returnMode() {
        int[] singleElement = {2};
        int[] singleMode = {1, 5, 2, 5, 9, 5, 7};
        int[] multipleMode = {8, 4, 3, 8, 4, 1};
        int[] everyMode = {1, 2, 3, 4, 5};

        ArrayStatistics statisticsSingleElement = new ArrayStatistics(singleElement);
        assertArrayEquals(new int[]{2}, statisticsSingleElement.mode());

        ArrayStatistics statisticsSingleMode = new ArrayStatistics(singleMode);
        assertArrayEquals(new int[]{5}, statisticsSingleMode.mode());

        ArrayStatistics statisticsMultipleMode = new ArrayStatistics(multipleMode);
        assertArrayEquals(new int[]{4, 8}, statisticsMultipleMode.mode());

        ArrayStatistics statisticsEveryMode = new ArrayStatistics(everyMode);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, statisticsEveryMode.mode());
    }

    @Test
    void mode_Empty_returnEmptyArray() {
        int[] emptyMode = {};

        ArrayStatistics statisticsEmptyMode = new ArrayStatistics(emptyMode);

        assertArrayEquals(new int[]{}, statisticsEmptyMode.mode());
    }

    @Test
    void median_whenNotEmpty_returnMedian() {
        int[] singleElement = {2};
        int[] oddCount = {7, 7, 3, 1, 7};
        int[] evenCount = {6, 6, 2, 2};
        int[] negativesOdd = {-5, 0, 10, -1, 3};
        int[] negativesEven = {-10, -20, -30, -5};

        ArrayStatistics statistics = new ArrayStatistics(singleElement);
        assertEquals(2, statistics.median());

        statistics = new ArrayStatistics(oddCount);
        assertEquals(7, statistics.median());

        statistics = new ArrayStatistics(evenCount);
        assertEquals(4.0, statistics.median());

        statistics = new ArrayStatistics(negativesOdd);
        assertEquals(0, statistics.median());

        statistics = new ArrayStatistics(negativesEven);
        assertEquals(-15.0, statistics.median());
    }

    @Test
    void median_whenEmpty_returnNaN() {
        int[] empty = {};

        ArrayStatistics statistics = new ArrayStatistics(empty);

        assertEquals(Double.NaN, statistics.median());

    }

    @Test
    void average_whenNotEmpty_returnAverage() {
        int[] singleElement = {2};
        int[] shuffle = {-10, 0, 5, 10, 20};
        int[] allNegative = {-2, -4, -6, -8};
        int[] precisionExact = {1, 1, 10};
        int[] precisionFraction = {9, 10, 10};

        ArrayStatistics statistics = new ArrayStatistics(singleElement);
        assertEquals(2.0, statistics.average(), 0.0001);

        statistics = new ArrayStatistics(shuffle);
        assertEquals(5.0, statistics.average(), 0.0001);

        statistics = new ArrayStatistics(allNegative);
        assertEquals(-5.0, statistics.average(), 0.0001);

        statistics = new ArrayStatistics(precisionExact);
        assertEquals(4.0, statistics.average(), 0.0001);

        statistics = new ArrayStatistics(precisionFraction);
        assertEquals(9.66666667, statistics.average(), 0.0001);
    }

    @Test
    void average_whenEmpty_returnNaN() {
        int[] empty = {};
        ArrayStatistics statistics = new ArrayStatistics(empty);
        assertEquals(Double.NaN, statistics.average());
    }

    @Test
    void variance_whenNotEmpty_returnVariance() {
        int[] array1 = {2, 4, 4, 4, 5, 5, 7, 9};
        int[] array2 = {1, 2, 3};

        ArrayStatistics statistics1 = new ArrayStatistics(array1);
        assertEquals(4, statistics1.variance(), 0.0001);

        ArrayStatistics statistics2 = new ArrayStatistics(array2);
        assertEquals(0.666667, statistics2.variance(), 0.0001);
    }

    @Test
    void variance_whenEmpty_returnNaN() {
        int[] empty = {};
        ArrayStatistics statistics = new ArrayStatistics(empty);
        assertEquals(Double.NaN, statistics.variance());
    }

    @Test
    void geometricMean_whenNotEmpty_returnGeometricMean() {
        int[] simple = {2, 8};
        int[] multi = {1, 2, 4, 8};
        int[] withZero = {1, 2, 0};

        ArrayStatistics statisticsSimple = new ArrayStatistics(simple);
        assertEquals(4.0, statisticsSimple.geometricMean(), 0.0001);

        ArrayStatistics statisticsMulti = new ArrayStatistics(multi);
        assertEquals(2.8284, statisticsMulti.geometricMean(), 0.0001);

        ArrayStatistics statisticsWithZero = new ArrayStatistics(withZero);
        assertEquals(0.0, statisticsWithZero.geometricMean(), 0.0001);
    }

    @Test
    void geometricMean_whenEmpty_returnNaN() {
        int[] empty = {};
        ArrayStatistics statistics = new ArrayStatistics(empty);
        assertEquals(Double.NaN, statistics.geometricMean());
    }

    @Test
    void shuffle_whenNotEmpty_returnShuffleArray() {
        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayStatistics statistics = new ArrayStatistics(original);

        int[] shuffled = statistics.shuffle();

        assertNotSame(original, shuffled);
        assertEquals(original.length, shuffled.length);

        int[] sortedOriginal = original.clone();
        int[] sortedShuffled = shuffled.clone();
        Arrays.sort(sortedOriginal);
        Arrays.sort(sortedShuffled);
        assertArrayEquals(sortedOriginal, sortedShuffled);

        boolean isDifferent = !Arrays.equals(original, shuffled);
        int attempts = 0;
        while (!isDifferent && attempts < 10) {
            shuffled = statistics.shuffle();
            isDifferent = !Arrays.equals(original, shuffled);
            attempts++;
        }

        assertTrue(isDifferent);
    }

    @Test
    void shuffle_whenEmpty_returnEmptyArray() {
        int[] empty = {};
        ArrayStatistics statistics = new ArrayStatistics(empty);
        assertArrayEquals(new int[]{}, statistics.shuffle());
    }

    @Test
    void sample_whenNotEmpty_returnSampleArray() {
        int[] original = {10, 20, 30, 40, 50};
        int sampleSize = 10;

        ArrayStatistics statistics = new ArrayStatistics(original);
        int[] sample = statistics.sample(sampleSize);
        assertEquals(sampleSize, sample.length);

        Set<Integer> originalSet = new HashSet<>();
        for (int value : original) {
            originalSet.add(value);
        }

        for (int value : sample) {
            assertTrue(originalSet.contains(value));
        }
    }

    @Test
    void sample_whenEmpty_returnZeroArrayWithParametrizedLength() {
        int[] empty = {};
        int sampleSize = 5;

        ArrayStatistics statistics = new ArrayStatistics(empty);
        int[] sample = statistics.sample(sampleSize);

        assertArrayEquals(new int[]{}, sample);
    }

}
