package ru.teamscore.core;

import java.time.Duration;
import java.time.LocalDateTime;

public class Countdown {
    private Countdown() {
    }

    public static Duration calculateBefore(LocalDateTime from, LocalDateTime to) {
        if (from.isAfter(to)) {
            return Duration.ZERO;
        }
        return Duration.between(from, to);
    }
}
