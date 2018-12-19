package com.mic.librxcore;



public class LambdaObserver<T> implements Observer<T>{
    private Consumer<T> onNext;
    public LambdaObserver(Consumer<T> onNext) {
        this.onNext = onNext;
    }

    @Override
    public void onSubscribe() {

    }

    @Override
    public void onNext( T item) {
        onNext.onNext(item);
    }

    @Override
    public void onError( Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
