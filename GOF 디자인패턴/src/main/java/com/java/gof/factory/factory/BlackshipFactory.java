package com.java.gof.factory.factory;

import com.java.gof.factory.domain.BlackShip;
import com.java.gof.factory.domain.Ship;

public class BlackshipFactory extends DefaultShipFacotry {

    @Override
    public Ship createShip() {
        return new BlackShip();
    }


}
