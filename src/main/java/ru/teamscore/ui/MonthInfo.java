package ru.teamscore.ui;

import java.time.LocalDate;

public class MonthInfo {

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
            System.out.printf("| %20s | %20s | %20s | %20s | %20s | %20s | %20s|%n",
                monthInfo.time(),
                monthInfo.getMonthName(),
                monthInfo.getMonthNumber(), monthInfo.getFirstDayNameOfMonth(),
                monthInfo.getLastDayOfMonth(), monthInfo.getDaysInMonth(),
                monthInfo.getQuartalWithYear());
        }
    }

}
