package com.java.gof.singleton.model;

import java.io.Serializable;

public class Settings6 implements Serializable {

    private Settings6() { }

    private static class SettingsHolder {
        private static final Settings6 INSTANCE = new Settings6();
    }

    public static Settings6 getInstance() {
        return SettingsHolder.INSTANCE;
    }

}
