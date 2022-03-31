class Car {
    Car() { }
    public void horn() {
        System.out.println("빵빵!");
    }
}

class FireTruck extends Car {
    public void horn() {
        System.out.println("위이잉!");
    }
}

class Ambulance extends Car {
    public void horn() {
        System.out.println("삐뽀삐뽀!");
    }
}

public class Pratice {
    public static void main(String[] args) {
        // Test Code
        Car car = new Car();
        car.horn();

        car = new FireTruck();
        car.horn();

        car = new Ambulance();
        car.horn();

        Car car2[] = {new Car(), new FireTruck(), new Ambulance()};

        for(Car item: car2) {
            item.horn();
        }

    }
}
