package com.jarvis.rxjava.rx;

/**
 * 数据发射器
 * @author chenjieliang on 20-10-12
 */
public interface Emitter<T> {

    void onNext(T t);

    void onComplete();

    void onError(Throwable throwable);
}
