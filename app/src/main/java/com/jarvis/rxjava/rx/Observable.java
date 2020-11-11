package com.jarvis.rxjava.rx;

import com.jarvis.rxjava.rx.operators.Function;
import com.jarvis.rxjava.rx.operators.ObservableMap;

/**
 * @author chenjieliang on 20-10-12
 */
public abstract class Observable<T> implements ObservableSource<T> {

    @Override
    public final void subscribe(Observer<T> observer) {
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<T> observer);

    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe){
        return new ObservableCreate<>(observableOnSubscribe);

    }

    public <R> Observable<R> map(Function<T,R> function){
        return new ObservableMap<T,R>(this,function);
    }
}
