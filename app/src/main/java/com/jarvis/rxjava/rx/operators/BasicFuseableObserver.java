package com.jarvis.rxjava.rx.operators;

import com.jarvis.rxjava.rx.Observable;
import com.jarvis.rxjava.rx.Observer;

/**
 * @param <T> the upstream value type
 * @param <R> the downstream value type
 * @author chenjieliang on 20-10-12
 */
public abstract class BasicFuseableObserver<T,R> implements Observer<T> {

    protected final Observer<R> actual;

    public BasicFuseableObserver(Observer<R> actual) {
        this.actual = actual;
    }
}
