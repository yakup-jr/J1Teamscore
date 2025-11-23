package ru.teamscore.core;

/**
 * The type Sign repetition.
 */
public class SignRepetition {

    private SignRepetition() {
    }

    /**
     * Count digit sign in a row int.
     *
     * @param values the values
     * @return the int
     */
    public static int countDigitSignInARow(int[] values) {
        if (values.length == 0) {
            return 0;
        }

        int maxCount = 0;
        int currentCount = 0;
        int prevChangeValue = 0;

        for (int value : values) {
            if ((value > 0 && prevChangeValue < 1) || (value < 0 && prevChangeValue > -1) ||
                (value == 0 && prevChangeValue != 0)) {
                maxCount = Math.max(maxCount, currentCount);
                prevChangeValue = value;
                currentCount = 0;
            }
            currentCount++;
        }
        maxCount = Math.max(maxCount, currentCount);

        return maxCount;
    }
}
