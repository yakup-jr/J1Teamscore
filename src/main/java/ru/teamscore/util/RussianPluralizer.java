package ru.teamscore.util;

import java.time.temporal.ChronoUnit;

public class RussianPluralizer {
    private static final String[] minutes = {"минута", "минуты", "минут"};
    private static final String[] hours = {"час", "часа", "часов"};
    private static final String[] days = {"день", "дня", "дней"};

    private RussianPluralizer() {
    }

    public static String formatUnitWithDeclension(long date, ChronoUnit unit) {
        if (date < 1) {
            return "";
        }

        return switch (unit) {
            case DAYS -> formatUnitWithValues(date, days);
            case HOURS -> formatUnitWithValues(date, hours);
            case MINUTES -> formatUnitWithValues(date, minutes);
            default -> throw new UnsupportedOperationException("Works only with days, hours, " +
                "minutes");
        };
    }

    private static String formatUnitWithValues(long date, String[] values) {
        String format = "%s %s";
        if (date % 10 == 1 && date % 100 != 11) {
            return String.format(format, date, values[0]);
        } else if (date % 10 > 1 && date % 10 < 5 &&
            (date % 100 < 11 || date % 100 > 15)) {
            return String.format(format, date, values[1]);
        } else {
            return String.format(format, date, values[2]);
        }
    }
}
