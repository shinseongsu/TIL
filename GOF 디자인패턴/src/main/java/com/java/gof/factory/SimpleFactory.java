package com.java.gof.factory;

import com.java.gof.factory.domain.BlackShip;
import com.java.gof.factory.domain.WhiteShip;

public class SimpleFactory {

    public Object createProduct(String name) {
        if(name.equals("whiteship")) {
            return new WhiteShip();
        } else if (name.equals("blackship")) {
            return new BlackShip();
        }

        throw new IllegalArgumentException();
    }

}
