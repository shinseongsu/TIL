package com.java.gof.singleton.model;

import java.io.Serializable;

public class Settings7 implements Serializable {

    private Settings7() { }

    private static class SettingsHolder {
        private static final Settings7 INSTANCE = new Settings7();
    }

    public static Settings7 getInstance() {
        return Settings7.SettingsHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }

}
