package com.java.gof.abstract_factory;

import com.java.gof.factory.domain.Ship;
import com.java.gof.factory.domain.WhiteShip;
import com.java.gof.factory.factory.DefaultShipFacotry;

public class WhiteshipFactory extends DefaultShipFacotry {

    private ShipPartsFactory shipPartsFactory;

    public WhiteshipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
