package com.jarvis.rxjava.rx.operators;

import com.jarvis.rxjava.rx.ObservableSource;
import com.jarvis.rxjava.rx.Observer;

/**
 * @author chenjieliang on 20-10-12
 */
public class ObservableMap<T,R> extends AbstractObservableWithUpstream<T,R> {

    Function<T,R> function;

    public ObservableMap(ObservableSource<T> observableSource,Function<T,R> function) {
        super(observableSource);
        this.function = function;
    }


    @Override
    protected void subscribeActual(Observer<R> observer) {
        MapObserver<T,R> mapObserver = new MapObserver<>(observer,function);
        mapObserver.onSubscribe();
        observableSource.subscribe(mapObserver);
    }

    static class MapObserver<T,R> extends BasicFuseableObserver<T,R> {

        final Function<T,R> mapper;

        public MapObserver(Observer<R> actual,Function<T,R> mapper) {
            super(actual);
            this.mapper = mapper;
        }

        @Override
        public void onSubscribe() {
            actual.onSubscribe();
        }

        @Override
        public void onNext(T t) {
           R r = mapper.apply(t);
           actual.onNext(r);
        }

        @Override
        public void onComplete() {
            actual.onComplete();
        }

        @Override
        public void onError(Throwable throwable) {
            actual.onError(throwable);
        }
    }

}
