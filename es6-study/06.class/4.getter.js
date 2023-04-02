class Student {
  constructor(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  get fullName() {
    return `${this.lastName} ${this.firstName}`;
  }

  set fullName(value) {
    console.log("set", value);
  }
}

const student = new Student("수지", "배");
console.log(student.fullName);
student.fullName = "김철수";
