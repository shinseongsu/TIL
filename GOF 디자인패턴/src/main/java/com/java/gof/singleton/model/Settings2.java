package com.java.gof.singleton.model;

public class Settings2 {

    private static Settings2 instance;

    private Settings2() { }

    // 단점 : synchronized 때문에 성능에 문제가 있다.
    public static synchronized Settings2 getInstance() {
        if(instance == null) {
            instance = new Settings2();
        }

        return instance;
    }

}
