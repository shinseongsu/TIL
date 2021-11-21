package com.rxjava;

import io.reactivex.rxjava3.core.Flowable;

import java.util.concurrent.TimeUnit;

public class EffectedSample {

    private static State calcMethod;

    public static void main(String[] args) throws InterruptedException {

        calcMethod = State.ADD;

        Flowable<Long> flowable =
                Flowable.interval(300L, TimeUnit.MILLISECONDS)
                .take(7)
                .scan((sum, data) -> {
                    if(calcMethod == State.ADD) {
                        return sum + data;
                    } else {
                        return sum * data;
                    }
                });

        flowable.subscribe(data -> System.out.println("data=" + data));

        Thread.sleep(1000);
        System.out.println("계산 방법 변경");
        calcMethod = State.MULTIPLY;

        Thread.sleep(2000);

        // result
        // ===============
        // data=0
        // data=1
        // data=3
        // 계산 방법 변경
        // data=9
        // data=36
        // data=180
        // data=1080
    }
}
