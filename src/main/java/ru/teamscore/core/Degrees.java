package ru.teamscore.core;

public class Degrees {

    private Degrees() {
    }

    public static int calculateCountDigits(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        double count = exponent * Math.log10(base);

        return (int) count + 1;
    }
}
