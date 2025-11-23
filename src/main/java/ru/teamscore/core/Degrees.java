package ru.teamscore.core;

/**
 * The type Degrees.
 */
public class Degrees {

    private Degrees() {
    }

    /**
     * Calculate count digits int.
     *
     * @param base     the base
     * @param exponent the exponent
     * @return the int
     */
    public static int calculateCountDigits(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        double count = exponent * Math.log10(base);

        return (int) count + 1;
    }
}
