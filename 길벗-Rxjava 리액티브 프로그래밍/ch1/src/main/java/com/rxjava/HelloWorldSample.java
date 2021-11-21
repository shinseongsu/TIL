package com.rxjava;

import io.reactivex.rxjava3.core.Flowable;

public class HelloWorldSample {
    public static void main(String[] args) {
        Flowable<String> flowable = Flowable.just("Hello", "World");

        flowable.subscribe(data -> System.out.println(data));

        // result
        // ==============
        // Hello
        // World
    }
}
