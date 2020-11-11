package com.jarvis.rxjava.rx.operators;

/**
 * @author chenjieliang on 20-10-12
 */
public interface Function<T,R> {
    R apply(T t);
}
