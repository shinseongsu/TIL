package com.java.gof.singleton;

import com.java.gof.singleton.model.Settings1;
import com.java.gof.singleton.model.Settings5;
import com.java.gof.singleton.model.Settings6;
import com.java.gof.singleton.model.Settings7;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Settings7 settings = Settings7.getInstance();

        // 리플렉션 사용
//        Constructor<Settings5> constructor = Settings5.class.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        Settings5 settings1 = constructor.newInstance();

        // 직렬화 & 역직렬화 이용하기
        Settings7 settings1 = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(settings);
        }

       try(ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
           settings1 = (Settings7) in.readObject();
        }

        System.out.println(settings == settings1);
    }

}
