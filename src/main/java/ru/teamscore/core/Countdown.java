package ru.teamscore.core;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Countdown {

    private Countdown() {

    }

    public static String calculateBefore(LocalDateTime from, LocalDateTime to) {
        if (from.isAfter(to)) {
            return "Уже наступило!";
        }

        return String.format("Осталось: %s %s %s", getDaysBeforeWithCase(from, to),
            getHoursBeforeWithCase(from, to), getMinutesBeforeWithCase(from, to));
    }

    private static String getDaysBeforeWithCase(LocalDateTime from, LocalDateTime to) {
        long days = from.until(to, ChronoUnit.DAYS);

        if (days < 1) {
            return "";
        }

        if (days % 10 == 1 && days % 100 != 11) {
            return String.format("%s день", days);
        } else if (days % 10 > 1 && days % 10 < 5 && (days % 100 < 11 || days % 100 > 15)) {
            return String.format("%s дня", days);
        } else {
            return String.format("%s дней", days);
        }
    }

    private static String getHoursBeforeWithCase(LocalDateTime from, LocalDateTime to) {
        long hours = from.until(to, ChronoUnit.HOURS) - 24 * from.until(to, ChronoUnit.DAYS);

        if (hours < 1) {
            return "";
        }

        if (hours % 10 == 1 && hours % 100 != 11) {
            return String.format("%s час", hours);
        } else if (hours % 10 > 1 && hours % 10 < 5 && (hours % 100 < 11 || hours % 100 > 15)) {
            return String.format("%s часа", hours);
        } else {
            return String.format("%s часов", hours);
        }
    }


    private static String getMinutesBeforeWithCase(LocalDateTime from, LocalDateTime to) {
        long minutes = from.until(to, ChronoUnit.MINUTES) - 60 * from.until(to, ChronoUnit.HOURS);

        if (minutes < 1) {
            return "";
        }

        if (minutes % 10 == 1 && minutes % 100 != 11) {
            return String.format("%s минута", minutes);
        } else if (minutes % 10 > 1 && minutes % 10 < 5 &&
            (minutes % 100 < 11 || minutes % 100 > 15)) {
            return String.format("%s минуты", minutes);
        } else {
            return String.format("%s минут", minutes);
        }
    }

}
