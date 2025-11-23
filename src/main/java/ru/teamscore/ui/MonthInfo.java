package ru.teamscore.ui;

import java.time.LocalDate;

/**
 * The type Month info.
 */
public class MonthInfo {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[][] dates = {
            {2023, 11, 12},
            {1900, 01, 01},
            {2020, 02, 12}
        };
        for (int[] date : dates) {
            ru.teamscore.core.MonthInfo monthInfo =
                new ru.teamscore.core.MonthInfo(LocalDate.of(date[0], date[1],
                    date[2]));
            System.out.printf("| %16s | %16s | %16s | %16s | %16s | %16s | %16s|%n",
                monthInfo.time(),
                monthInfo.getMonthName(),
                monthInfo.getMonthNumber(), monthInfo.getFirstDayNameOfMonth(),
                monthInfo.getLastDayOfMonth(), monthInfo.getDaysInMonth(),
                monthInfo.getQuartalWithYear());
        }
    }

}
