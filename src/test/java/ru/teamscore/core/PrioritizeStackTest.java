package ru.teamscore.core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrioritizeStackTest {

    @Test
    void size_returnSize() {
        PrioritizeStack stack =
            PrioritizeStack.valueOf(Arrays.asList(Element.valueOf(new Object(), 1),
                Element.valueOf(new Object(), 1), Element.valueOf(new Object(), 1),
                Element.valueOf(new Object(), 1)));
        assertEquals(4, stack.size());

        stack = PrioritizeStack.valueOf(Arrays.asList(Element.valueOf(new Object(), 1),
            Element.valueOf(new Object(), 1), Element.valueOf(new Object(), 1),
            Element.valueOf(new Object(), 1), Element.valueOf(new Object(), 1)));
        assertEquals(5, stack.size());

        stack = PrioritizeStack.valueOf(List.of());
        assertEquals(0, stack.size());
    }

    @Test
    void push_whenEmpty() {
        PrioritizeStack stack = new PrioritizeStack();

        assertEquals(0, stack.size());
        stack.push(Element.valueOf(new Object(), 1));
        assertEquals(1, stack.size());
    }

    @Test
    void push_StackSorted() {
        Object value1 = new Object();
        Object value2 = new Object();
        Object value3 = new Object();

        PrioritizeStack stack = PrioritizeStack.valueOf(List.of(
            Element.valueOf(value1, 1),
            Element.valueOf(value2, 2)
        ));

        assertEquals(2, stack.size());
        assertEquals(Element.valueOf(value2, 2), stack.peek());
        stack.push(Element.valueOf(value3, 3));
        assertEquals(3, stack.size());
        assertEquals(Element.valueOf(value3, 3), stack.peek());
    }

    @Test
    void pop_returnFirstElement() {
        Object value1 = new Object();
        Object value2 = new Object();

        PrioritizeStack stack = PrioritizeStack.valueOf(List.of(Element.valueOf(value1, 1),
            Element.valueOf(value2, 2)));

        assertEquals(2, stack.size());
        assertEquals(Element.valueOf(value2, 2), stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void peek_returnFirstElement() {
        Object value1 = new Object();
        Object value2 = new Object();
        Object value3 = new Object();

        PrioritizeStack stack = PrioritizeStack.valueOf(List.of(Element.valueOf(value1, 1),
            Element.valueOf(value2, 2), Element.valueOf(value3, 3)));

        assertEquals(3, stack.size());
        Element expected = Element.valueOf(value3, 3);
        assertEquals(expected, stack.peek());
        assertEquals(3, stack.size());
    }

    @Test
    void valueOf_returnPrioritizeStack() {
        Object value1 = new Object();
        Object value2 = new Object();
        Object value3 = new Object();

        List<Element> elements = List.of(Element.valueOf(value1, 1),
            Element.valueOf(value3, 3), Element.valueOf(value2, 2));
        PrioritizeStack stack = PrioritizeStack.valueOf(elements);

        assertEquals(3, stack.size());
        assertEquals(Element.valueOf(value3, 3), stack.pop());
        assertEquals(Element.valueOf(value2, 2), stack.pop());
        assertEquals(Element.valueOf(value1, 1), stack.pop());
    }

    @Test
    void valueOf_nullList_ThrowException() {
        assertThrows(IllegalArgumentException.class, () -> PrioritizeStack.valueOf(null));
    }
}
