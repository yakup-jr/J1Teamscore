package ru.teamscore.core;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * The type Countdown.
 */
public class Countdown {
    private Countdown() {
    }

    /**
     * Calculate before duration.
     *
     * @param from the from
     * @param to   the to
     * @return the duration
     */
    public static Duration calculateBefore(LocalDateTime from, LocalDateTime to) {
        if (from.isAfter(to)) {
            return Duration.ZERO;
        }
        return Duration.between(from, to);
    }
}
