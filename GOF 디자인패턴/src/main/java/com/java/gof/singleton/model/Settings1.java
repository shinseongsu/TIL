package com.java.gof.singleton.model;

public class Settings1 {

    private static Settings1 instance;

    private Settings1() { }

    // 단점 : 멀티 쓰레드 환경에서 인스턴스가 만들어지기 전에 if를 통과할 수 있다.s
    public static Settings1 getInstance() {
        if(instance == null) {
            instance = new Settings1();
        }

        return instance;
    }

}
