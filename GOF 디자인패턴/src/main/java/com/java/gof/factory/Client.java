package com.java.gof.factory;

import com.java.gof.factory.domain.Ship;
import com.java.gof.factory.factory.BlackshipFactory;
import com.java.gof.factory.factory.ShipFactory;
import com.java.gof.factory.factory.WhiteshipFactory;

public class Client {

    public static void main(String[] args) {
       Client client = new Client();
       client.print(new WhiteshipFactory(), "whiteship", "whiteship@naver.com");
       client.print(new BlackshipFactory(), "blackship", "blackship@kakao.com");

//       Ship whiteship = new WhiteshipFactory().orderShip("whiteShip", "whiteShip@naver.com");
//       System.out.println(whiteship);
//
//       Ship blackship = new BlackshipFactory().orderShip("blackShip", "blackship@kakao.com");
//        System.out.println(blackship);

    }

    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }

}