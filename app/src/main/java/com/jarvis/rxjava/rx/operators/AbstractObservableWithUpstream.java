package com.jarvis.rxjava.rx.operators;

import com.jarvis.rxjava.rx.Observable;
import com.jarvis.rxjava.rx.ObservableSource;

/**
 * 被观察者（上游）
 * 装饰器类
 * @author chenjieliang on 20-10-12
 */
public abstract class AbstractObservableWithUpstream<T,U> extends Observable<U> {

    //被观察者（源头）
    protected ObservableSource<T> observableSource;

    public AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.observableSource = observableSource;
    }
}
