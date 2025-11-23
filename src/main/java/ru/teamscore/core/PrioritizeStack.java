package ru.teamscore.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Prioritize stack.
 */
public class PrioritizeStack {
    private final List<Element> elements;

    /**
     * Instantiates a new Prioritize stack.
     */
    public PrioritizeStack() {
        this.elements = new ArrayList<>();
    }

    private PrioritizeStack(List<Element> elements) {
        this.elements = new ArrayList<>(elements);
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return elements.size();
    }

    /**
     * Push.
     *
     * @param element the element
     */
    public void push(Element element) {
        elements.add(element);
        elements.sort(Comparator.comparing(Element::getPriority).reversed());
    }

    /**
     * Pop element.
     *
     * @return the element
     */
    public Element pop() {
        Element element = elements.get(0);
        elements.remove(0);
        return element;
    }

    /**
     * Peek element.
     *
     * @return the element
     */
    public Element peek() {
        return elements.get(0);
    }

    /**
     * Value of prioritize stack.
     *
     * @param elements the elements
     * @return the prioritize stack
     */
    public static PrioritizeStack valueOf(List<Element> elements) {
        if (elements == null) {
            throw new IllegalArgumentException("elements cant be null");
        }

        return new PrioritizeStack(
            elements.stream().sorted(Comparator.comparing(Element::getPriority).reversed())
                .toList());
    }
}
