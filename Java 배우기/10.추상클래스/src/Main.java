abstract class Person {
    abstract void printInfo();
}

// 추상 클래스 상속
class Student extends Person {

    @Override
    void printInfo() {
        System.out.println("Student.printInfo");
    }
}

public class Main {
    public static void main(String[] args) {

        // 추상 클래스 사용
        Person p1 = new Student();
        p1.printInfo();

        Person p2 = new Person() {
            @Override
            void printInfo() {
                System.out.println("Main.printInfo");
            }
        };
        p2.printInfo();

    }
}
