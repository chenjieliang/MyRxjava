package com.jarvis.rxjava.rx;

/**
 * 被观察者
 * @author chenjieliang on 20-10-12
 */
public interface ObservableSource<T> {

    void subscribe(Observer<T> observer);
}
