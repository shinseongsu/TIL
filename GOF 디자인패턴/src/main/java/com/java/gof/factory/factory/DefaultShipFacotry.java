package com.java.gof.factory.factory;

import com.java.gof.factory.domain.Ship;

public abstract class DefaultShipFacotry implements ShipFactory {

    @Override
    public void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }

}
