package com.jarvis.rxjava.rx;

/**
 * 观察者
 * @author chenjieliang on 20-10-12
 */
public interface Observer<T> {

     void onSubscribe();

     void onNext(T t);

     void onComplete();

     void onError(Throwable throwable);
}
