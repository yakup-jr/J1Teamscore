package ru.teamscore.ui;

import ru.teamscore.core.Countdown;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static ru.teamscore.util.RussianPluralizer.formatUnitWithDeclension;

/**
 * The type Count down.
 */
public class CountDown {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.printf("Обратный отсчет%n" +
            "Формат ввода: dd.MM.yyyy HH:mm" +
            "Введите дату и время события:%n");
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime to = LocalDateTime.parse(sc.nextLine(), formatter);

        Duration duration = Countdown.calculateBefore(LocalDateTime.now(), to);

        if (duration.isZero()) {
            System.out.println("Уже наступило!");
        } else {
            long days = duration.toDays();
            long hours = duration.toHours() - 24 * days;
            long minutes = duration.toMinutes() - 60 * hours - 24 * 60 * days;

            String daysWithCase = formatUnitWithDeclension(days, ChronoUnit.DAYS);
            String hoursWithCase = formatUnitWithDeclension(hours, ChronoUnit.HOURS);
            String minutesWithCase = formatUnitWithDeclension(minutes, ChronoUnit.MINUTES);

            System.out.printf("Осталось: %s %s %s%n", daysWithCase, hoursWithCase, minutesWithCase);
        }
    }

}
