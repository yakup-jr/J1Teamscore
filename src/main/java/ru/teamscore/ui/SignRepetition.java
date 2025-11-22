package ru.teamscore.ui;

import ru.teamscore.util.RandomGenerator;

import java.util.Arrays;
import java.util.Scanner;

public class SignRepetition {

    public static void main(String[] args) {
        System.out.println("Input count random numbers: ");
        Scanner sc = new Scanner(System.in);
        int countRandomNumbers = sc.nextInt();

        int[] randomValues = RandomGenerator.generateRandomNumbersInRange(countRandomNumbers, -100, 101);
        int maxSeries = ru.teamscore.core.SignRepetition.countDigitSignInARow(randomValues);

        System.out.printf("Generated values: %s%n", Arrays.toString(randomValues));
        System.out.printf("Max series: %d", maxSeries);
    }

}
