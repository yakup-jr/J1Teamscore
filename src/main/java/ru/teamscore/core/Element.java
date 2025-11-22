package ru.teamscore.core;

import java.util.Objects;

public class Element {
    private final Object value;
    private final int priority;

    private Element(Object value, int priority) {
        this.value = value;
        this.priority = priority;
    }


    public Object getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    public static Element valueOf(Object value, int priority) {
        if (value == null) {
            throw new IllegalArgumentException("value cant be null");
        }

        if (priority < 0) {
            throw new IllegalArgumentException("priority cant be less than 0");
        }
        return new Element(value, priority);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Element element)) return false;
        return priority == element.priority && Objects.equals(value, element.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, priority);
    }
}
