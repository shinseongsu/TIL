class Car {
    Car() { }

    public void horn() {
        System.out.println("빵빵!");
    }
}

class FireTruck extends Car {
    public void horn() {
        super.horn();
        System.out.println("위이일!");
    }
}

class Ambulance extends Car {
    public void horn() {
        super.horn();
        System.out.println("삐뽀삐뽀!");
    }
}

public class Pratice2 {
    public static void main(String[] args) {
        // Test Code
        FireTruck truck = new FireTruck();
        truck.horn();

        Ambulance amb = new Ambulance();
        amb.horn();
    }
}
