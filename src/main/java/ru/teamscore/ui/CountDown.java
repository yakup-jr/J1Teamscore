package ru.teamscore.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CountDown {

    public static void main(String[] args) {
        System.out.printf("Обратный отсчет%n" +
            "Формат ввода: dd.MM.yyyy HH:mm" +
            "Введите дату и время события:%n");
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime to = LocalDateTime.parse(sc.nextLine(), formatter);

        System.out.println(ru.teamscore.core.Countdown.calculateBefore(LocalDateTime.now(), to));
    }

}
