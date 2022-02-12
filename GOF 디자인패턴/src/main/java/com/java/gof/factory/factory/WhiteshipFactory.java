package com.java.gof.factory.factory;


import com.java.gof.factory.domain.Ship;
import com.java.gof.factory.domain.WhiteShip;

public class WhiteshipFactory extends DefaultShipFacotry {

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
