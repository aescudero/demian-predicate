package com.demian.java.predicate;

@FunctionalInterface
public interface TriPredicate<T, U, D> {
    boolean test(T t, U u, D d);

}
