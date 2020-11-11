package com.jarvis.rxjava.rx;

/**
 * @author chenjieliang on 20-10-12
 */
public interface ObservableOnSubscribe<T> {

    /**
     *　由用户实现具体数据发布业务，调用发射器将数据发给下游
     * @param emitter
     */
    void subscribe(Emitter<T> emitter);
}
