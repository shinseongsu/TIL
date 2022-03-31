class Animal {
    String desc;

    Animal() { }

    Animal(String desc) {
        this.desc = desc;
    }

    public void printInfo() {
        System.out.println(this.desc);
    }
}

class Cat extends Animal {
    String desc;
    Cat() {
//        this.desc = "고양이 입니다.";
        // super.desc = "고양이 입니다.";
        super("고양이 입니다.");
    }
}

public class Pratice {
    public static void main(String[] args) {
        // Test Code
        Cat cat = new Cat();
        cat.printInfo();
    }

}
