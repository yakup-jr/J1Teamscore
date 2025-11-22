package ru.teamscore.core;

public class SignRepetition {

    private SignRepetition() {
    }

    public static int countDigitSignInARow(int[] values) {
        if (values.length == 0) {
            return 0;
        }

        int maxCount = 0;
        int currentCount = 0;
        DigitType currentType = DigitType.POSITIVE;

        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0 && currentType == DigitType.POSITIVE) {
                currentCount++;
            } else if (values[i] > 0 && currentType != DigitType.POSITIVE) {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 1;
                currentType = DigitType.POSITIVE;
            } else if (values[i] < 0 && currentType == DigitType.NEGATIVE) {
                currentCount++;
            } else if (values[i] < 0 && currentType != DigitType.NEGATIVE) {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 1;
                currentType = DigitType.NEGATIVE;
            } else if (values[i] == 0 && currentType == DigitType.ZERO) {
                currentCount++;
            } else if (values[i] == 0 && currentType != DigitType.ZERO) {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 1;
                currentType = DigitType.ZERO;
            }
        }
        maxCount = Math.max(maxCount, currentCount);

        return maxCount;
    }

}
