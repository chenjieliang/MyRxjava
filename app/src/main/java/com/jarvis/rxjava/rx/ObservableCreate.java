package com.jarvis.rxjava.rx;

/**
 * 被观察者具体实现类
 * @author chenjieliang on 20-10-12
 */
public final class ObservableCreate<T> extends Observable<T> {

    final ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer<T> observer) {
        EmitterCreate emitterParent = new EmitterCreate(observer);
        observer.onSubscribe();

        source.subscribe(emitterParent);
    }

    static class EmitterCreate<T> implements Emitter<T> {

        Observer<T> observerSource;

        public EmitterCreate(Observer<T> observerSource) {
            this.observerSource = observerSource;
        }

        @Override
        public void onNext(T t) {
            observerSource.onNext(t);
        }

        @Override
        public void onComplete() {
            observerSource.onComplete();
        }

        @Override
        public void onError(Throwable throwable) {
            observerSource.onError(throwable);
        }
    }
}
