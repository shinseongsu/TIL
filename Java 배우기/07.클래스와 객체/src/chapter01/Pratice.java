package chapter01;

class Animal {
    String name;
    Double weight;
    String classification;

    Animal(String name, Double weight, String classification) {
        this.name = name;
        this.weight = weight;
        this.classification = classification;
    }

    public void printInfO() {
        System.out.println("name = " + name);
        System.out.println("weight = " + weight);
        System.out.println("classifications = " + classification);
    }

    public void eat() {
        System.out.println("냠냠!");
    }

    public void sleep() {
        System.out.println("쿨쿨!");
    }

    public void walk() {
        System.out.println("걷기!");
    }

    public void run() {
        System.out.println("뛰기!");
    }

}

public class Pratice {
    public static void main(String[] args) {
        // TestCode
        Animal animal1 = new Animal("강아지", 5.0, "포우류");
        Animal anumal2 = new Animal("구피", 0.01, "어류");

        animal1.printInfO();
        anumal2.printInfO();

    }

}
