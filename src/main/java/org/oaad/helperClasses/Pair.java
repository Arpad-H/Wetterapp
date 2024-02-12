package org.oaad.helperClasses;

import java.util.Objects;

/**
 * Represents a tuple of two objects
 * @param <A> Type of the first object
 * @param <B> Type of the second object
 * @Author Arpad Horvath
 */
public class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

}