
class Person {
    String name;
    int age;
    public int a1;
    private int a2;

    Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Person.printInfo");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
    }
}

// Person 상속, 접근 제어자 확인
class Student1 extends Person {
    Student1() {
        a1 = 1;
        // a2 = 2;
    }
}

// Person 상속, super 사용
class Student2 extends Person {
    String name;
    int stdId;

    Student2(String name, int age, int stdId) {
        this.name = name;
//        super.name = name; // 부모 멤버 변수 값이 변경
//        super(name, age);  // 부모 생성자
        this.age = age;
        this.stdId = stdId;
    }

    public void printInfo() {
        System.out.println("Student2.printInfo");
        System.out.println("name : " + name);
        System.out.println("age : " + age);
        System.out.println("stdId : " + stdId);
    }
}


public class Main {
    public static void main(String[] args){

        // Test code
        // 1. 상속
        System.out.println("==========");
        Student1 s1 = new Student1();
        s1.name = "a";
        s1.age = 25;
        s1.printInfo();

        // 2. super, super(), 오버라이딩
        System.out.println("==========");
        Student2 s2 = new Student2("b", 32, 1);
        s2.printInfo();

    }

}
