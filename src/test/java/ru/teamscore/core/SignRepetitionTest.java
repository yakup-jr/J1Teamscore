package ru.teamscore.core;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignRepetitionTest {
    @ParameterizedTest
    @MethodSource("provideCountDigitSignInARowTest")
    void countDigitSignInARowTest(int[] values, int expected) {
        assertEquals(expected, SignRepetition.countDigitSignInARow(values));
    }

    static Stream<Arguments> provideCountDigitSignInARowTest() {
        return Stream.of(
            Arguments.of(new int[]{5, 0, 5}, 1),
            Arguments.of(new int[]{1, 2, -3, -4, -5}, 3),
            Arguments.of(new int[]{1, 2, -1, -2, -3, -4, -5, 6, 7, 8}, 5),
            Arguments.of(new int[]{}, 0)
        );
    }
}
