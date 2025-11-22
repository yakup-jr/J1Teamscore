package ru.teamscore.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStatisticsTest {

    static Stream<Arguments> provideMode() {
        return Stream.of(
            Arguments.of(new int[]{}, new int[]{}),
            Arguments.of(new int[]{2}, new int[]{2}),
            Arguments.of(new int[]{1, 5, 2, 5, 9, 5, 7}, new int[]{5}),
            Arguments.of(new int[]{8, 4, 3, 8, 4, 1}, new int[]{4, 8}),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}),
            Arguments.of(new int[]{-5, 10, -5, 10, 0}, new int[]{-5, 10})
        );
    }

    @ParameterizedTest
    @MethodSource("provideMode")
    void mode(int[] values, int[] expected) {
        ArrayStatistics statistics = new ArrayStatistics(values);
        assertArrayEquals(expected, statistics.mode());
    }

    static Stream<Arguments> provideMedian() {
        return Stream.of(
            Arguments.of(new int[]{}, Double.NaN),
            Arguments.of(new int[]{2}, 2.0),
            Arguments.of(new int[]{7, 7, 3, 1, 7}, 7.0),
            Arguments.of(new int[]{6, 6, 2, 2}, 4.0),
            Arguments.of(new int[]{-5, 0, 10, -1, 3}, 0.0),
            Arguments.of(new int[]{-10, -20, -30, -5}, -15.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideMedian")
    void median(int[] values, double expected) {
        ArrayStatistics statistics = new ArrayStatistics(values);
        assertEquals(expected, statistics.median(), 0.0001);
    }

    static Stream<Arguments> provideAverage() {
        return Stream.of(
            Arguments.of(new int[]{}, Double.NaN),
            Arguments.of(new int[]{2}, 2.0),
            Arguments.of(new int[]{-10, 0, 5, 10, 20}, 5.0),
            Arguments.of(new int[]{-2, -4, -6, -8}, -5.0),
            Arguments.of(new int[]{1, 1, 10}, 4.0),
            Arguments.of(new int[]{9, 10, 10}, 9.66666667)
        );
    }

    @ParameterizedTest
    @MethodSource("provideAverage")
    void average(int[] values, double expected) {
        ArrayStatistics statistics = new ArrayStatistics(values);
        assertEquals(expected, statistics.average(), 0.0001);
    }

    static Stream<Arguments> provideVariance() {
        return Stream.of(
            Arguments.of(new int[]{}, Double.NaN),
            Arguments.of(new int[]{2, 4, 4, 4, 5, 5, 7, 9}, 4.0),
            Arguments.of(new int[]{1, 2, 3}, 0.666667)
        );
    }

    @ParameterizedTest(name = "Вход: {0}, Ожидается дисперсия: {1}")
    @MethodSource("provideVariance")
    void variance(int[] values, double expected) {
        ArrayStatistics statistics = new ArrayStatistics(values);
        assertEquals(expected, statistics.variance(), 0.0001);
    }

    static Stream<Arguments> provideGeometricMean() {
        return Stream.of(
            Arguments.of(new int[]{}, Double.NaN),
            Arguments.of(new int[]{2, 8}, 4.0),
            Arguments.of(new int[]{1, 2, 4, 8}, 2.8284),
            Arguments.of(new int[]{1, 2, 0}, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideGeometricMean")
    void geometricMean(int[] values, double expected) {
        ArrayStatistics statistics = new ArrayStatistics(values);
        assertEquals(expected, statistics.geometricMean(), 0.0001);
    }

    @Test
    void shuffle_whenNotEmpty_returnShuffleArray() {
        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayStatistics statistics = new ArrayStatistics(original);

        int[] shuffled = statistics.shuffle();

        assertEquals(original.length, shuffled.length);
        //warning: might be equal. Chance: 1/10!
        assertFalse(Arrays.equals(original, shuffled));

        int[] sortedOriginal = original.clone();
        int[] sortedShuffled = shuffled.clone();
        Arrays.sort(sortedOriginal);
        Arrays.sort(sortedShuffled);
        assertArrayEquals(sortedOriginal, sortedShuffled);
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
        ArrayStatistics statistics = new ArrayStatistics(original);

        int[] sample = statistics.sample(10);
        assertEquals(10, sample.length);
    }

    @Test
    void sample_whenEmpty_returnZeroArrayWithParametrizedLength() {
        int[] empty = {};

        ArrayStatistics statistics = new ArrayStatistics(empty);
        int[] sample = statistics.sample(5);

        assertArrayEquals(new int[]{}, sample);
    }

}
