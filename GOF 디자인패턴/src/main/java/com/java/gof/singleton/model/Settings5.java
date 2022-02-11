package com.java.gof.singleton.model;

public class Settings5 {

    private Settings5() {  }

    // static inner 클래스
    private static class SettingsHoldder {
        private static final Settings5 INSTANCE = new Settings5();
    }

    public static Settings5 getInstance() {
        return SettingsHoldder.INSTANCE;
    }

}
