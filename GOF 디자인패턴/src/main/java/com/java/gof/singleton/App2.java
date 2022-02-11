package com.java.gof.singleton;

import com.java.gof.singleton.model.Settings;
import com.java.gof.singleton.model.Settings7;

import java.io.*;

public class App2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Settings settings = Settings.INSTANCE;

        Settings settings1 = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(settings);
        }

        try(ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            settings1 = (Settings) in.readObject();
        }

        // Enum은 기본적으로 Serialize를 지원한다.
        System.out.println(settings == settings1);
    }

}
