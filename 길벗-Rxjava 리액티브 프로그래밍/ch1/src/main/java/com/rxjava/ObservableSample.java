package com.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObservableSample {

    public static void main(String[] args) throws Exception {
        Observable<String> observable =
                Observable.create(new ObservableOnSubscribe<String>() {

                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                        String[] datas = { "Hello, World!", "안녕, RxJava!" };

                        for(String data : datas) {
                            if(emitter.isDisposed()) {
                                return;
                            }

                            emitter.onNext(data);
                        }
                        emitter.onComplete();
                    }
                });

        observable
                .observeOn(Schedulers.computation())
                .subscribe(new Observer<String>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String item) {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": " + item);
                    }

                    @Override
                    public void onError(@NonNull Throwable error) {
                        error.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        String threadName = Thread.currentThread().getName();
                        System.out.println(threadName + ": 완료");
                    }
                });

        Thread.sleep(500L);
    }
}
