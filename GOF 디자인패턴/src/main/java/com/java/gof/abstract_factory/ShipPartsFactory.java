package com.java.gof.abstract_factory;

public interface ShipPartsFactory {

    Anchor createAnchor();

    Wheel createWheel();

}
