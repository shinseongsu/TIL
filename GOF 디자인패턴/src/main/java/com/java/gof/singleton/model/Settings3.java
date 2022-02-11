package com.java.gof.singleton.model;

public class Settings3 {

    private static final Settings3 INSTANCE = new Settings3();

    private Settings3() { }

    // 멀티 쓰레드 환경에도 안전
    // 단점 : 객체 만들때 시간이 오래걸리면 load될때 시간이 걸릴 수 있다.
    public static Settings3 getInstance() {
        return INSTANCE;
    }

}
