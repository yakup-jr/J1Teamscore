package ru.teamscore.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PrioritizeStack {
    private final List<Element> elements;

    public PrioritizeStack() {
        this.elements = new ArrayList<>();
    }

    private PrioritizeStack(List<Element> elements) {
        this.elements = new ArrayList<>(elements);
    }

    public int size() {
        return elements.size();
    }

    public void push(Element element) {
        elements.add(element);
        elements.sort(Comparator.comparing(Element::getPriority).reversed());
    }

    public Element pop() {
        Element element = elements.get(0);
        elements.remove(0);
        return element;
    }

    public Element peek() {
        return elements.get(0);
    }

    public static PrioritizeStack valueOf(List<Element> elements) {
        if (elements == null) {
            throw new IllegalArgumentException("elements cant be null");
        }

        return new PrioritizeStack(
            elements.stream().sorted(Comparator.comparing(Element::getPriority).reversed())
                .toList());
    }
}
