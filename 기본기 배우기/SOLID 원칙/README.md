# SOLID 원칙

## Single Responsibility

### 개념

`Single Responsibility Principle(단일 책임 원칙)` 은 객체는 하나의 책임만을 지녀야 한다는 법칙입니다.

여러 책임을 동시에 가지는 객체는 처음에 코드를 짤 때는 편합니다. 하지만 코드가 복잡해질수록 에러가 날 확률도 높아지며 직관적으로 코드를 이해하기 어려워집니다. 따라서 객체를 설계하기 전 책임을 확실하게 부여하는 것이 중요합니다.

### AS-IS

```python
# 하나의 클래스(객체)가 여러 책임을 가지고 있습니다.
class Employee:
    def coding(self):
        print("코딩을 합니다")
    
    def design(self):
        print("디자인을 합니다")

    def analyze(self):
        print("분석을 합니다")
```

### TO-BE

```python
# 각 객체는 역활을 나눠서 가지고 있습니다.
class Developer:
    def coding(self):
        print("코딩을 합니다")

class Designer:
    def design(self):
        print("디자인을 합니다")

class Analyst:
    def analyze(self):
        print("분석을 합니다")
```

- work(self)로 메소드 이름을 통일하고 추상적으로 사용하면 더 유연하게 사용할 수 있다.


## Open Closed

### 개념

`Open Closed Principle(개발 폐쇄 원칙)`은 객체의 확장에는 열려있고, 수정에는 닫혀있게 해야 한다는 법칙입니다.

기족의 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계되어야 합니다. OCP에서 중요한 부분은 요구사항이 변경되었을 떄 코드의 변경되어야 할 부분되어야 할 부분과 그렇지 않아야 할 부분이 명확하게 구분되어 있어야 한다는 점이다.

보통 이를 지키기 위해선 인터페이스나 추상 클래스를 통해 추상화시키고 이를 상속, 구현하게 됩니다. 새로운 기능을 추가한다고 할 때, 다형성을 사용해서 기존 코드를 변경하지 않으면서 (변경에 닫혀있음), 추상 클래스를 상속받아 쉽게 코드를 추가할 수 있습니다.(확장에 열려있음)

### AS-IS

```python
class Developer:
    def coding(self):
        print("코딩을 합니다")

class Designer:
    def design(self):
        print("디자인을 합니다")

class Analyst:
    def analyze(self):
        print("분석을 합니다")

class Company:
    def __init__(self, employees):
        self.employees = employees

    # employee가 다양해질수록 코드를 계속 변경해야 한다.
    def make_work(self):
        for employee in self.employees:
            if type(employee) == Developer:
                employee.coding()
            elif type(employee) == Designer:
                employee.design()
            elif type(employee) == Analyst:
                employee.analyze()
```

### TO-BE

```python
# 각 객체들의 역활을 아우르는 추상 클래스(고수준)을 생성합니다.
class Employee(metaclass=abc.ABCMeta):
    @abc.abstractmethod
    def work(self):
        ...

class Developer(Employee):
    def work(self):
        print("코딩을 합니다")

class Designer(Employee):
    def work(self):
        print("디자인을 합니다")

class Analyst(Employee):
    def work(self):
        print("분석을 합니다")

# 상속을 통해 쉽게 구현이 가능합니다. -> 확장에 열려있다.
class Manager(Employee):
    def work(self):
        print("매니징을 합니다")

class Company:
    def __init__(self, employees: List[Employee]):
        self.employees = employees

    # employee가 늘어나더라도 변경에는 닫혀있다.
    def make_work(self):
        for employee in self.employees:
            employee.work()
```

## Liskov Substtitution

### 개념

`Liskov Substitution Principle(리스코브 치환 원칙)` 은 부모 객체의 역할은 자식 객체도 할 수 있어야 된다는 원칙입니다.

B 객체가 A 객체의 자식이라면 B객체의 타입을 A로 바꾸더라도 작동에 문제가 없어야 합니다. 상위 타입에서 정한 명세를 하위 타입에서도 그대로 지킬 수 있을 때 상속을 해야 합니다.

일반적으로 Liskov Substituion Principle이 지켜지지 않으면 Open Closed Principle을 위반하게 됩니다.

### 위반한 사례1

```python
import abc

class Employee(metaclass=abc.ABCMeta):
    @abc.abstractmethd
    def work(self):
        ...

class Developer(Employee):
    def work(self):
        print("코딩을 합니다")
        return ["if...", "for..."]

class FrontEndDeveloper(Developer):
    def work(self):
        print("프론트엔드 개발을 합니다")
        # 결과를 반환하지 않음

if __name__ == "__main__":
    def make_code(developer: Developer):
        code = developer.work()
        print(f"총 {len(code)}줄의 코드를 작성하였습니다")

    make_code(Developer())
    make_code(FrontEndDeveloper())
```

### 위반한 사례2

```python
# 유명한 직사각형, 직사각형 사례
# 일반적으로 정사각형은 직사각형입니다. 즉 정사각형 is 직사각형의 관계이며, 이는 상속이 가능합니다.
class Rectangle:
    def get_width(self):
        return self.width

    def get_height(self):
        return self.height

    def set_width(self, width):
        self.width = width

    def set_height(self, height):
        self.height = height


class Square(Rectangle):
    def set_width(self, width):
        self.width = width
        self.height = width

    def set_height(self, height):
        self.width = height
        self.height = height

if __name__ == "__main__":
    square = Square()
    square.set_width(20)
    square.set_height(30)
    check = square.get_width() == 20 && square.get_height() == 30 # 부모의 명세가 다름
```

## Interface Segregation

### 개념 

`Interafce Segregation Principle(인터페이스 분리 원칙)`은 클라이언트가 자신이 이용하지 않는 메서드는 의존하지 않아야 한다는 원칙입니다.

SOLID의 1 원칙인 Single Responsibility Principle은 객체가 하나의 책임만을 가져야 한다고 했는데, 여기서는 인터페이스(혹은 추상 클래스)가 하나의 책임만을 가져야 한다고 보시면 됩니다.

인터페이스를 책임에 맞게 잘 쪼개둔다면, 클라이언트 입정에서는 필요한 역할만 구현(혹은 상속)하여 사용할 수 있습니다.

### AS-IS

```python
import abc import *

class Smartphone(metaclass=ABCMeta):
    @abstractmethodd
    def call(self):
        ...

    @abstractmethod
    def send_message(self):
        ...

    @abstractmethod
    def see_youtube(self):
        ...

    @abstractmethod
    def take_picture(self):
        ...

# 카메라가 없는 클래스에서 take_picture는 불필요한 메서드가 된다.
class PhoneWithNoCamera(Smartphone):
    ...
```

### TO-BE

```python
# 인터페이스를 역할 단위로 나눈다.
class Telephone(metaclass=ABCMeta):
    @abstractmethod
    def call(self):
        ...

    @abstractmethod
    def send_message(self):
        ...

class Camera(metaclass=ABCMeta):
    @abstractmehtod
    def take_picture(self):
        ...

class Application(metaclass=ABCMeta):
    @abstractmethod
    def see_youtbe(self):
        ...

class PhoneWithNoCamera(Telephone, Application:
    ...
```

## Dependency Inversion

### 개념

`Dependency Inversion Principle(의존성 역전 원칙)` 은 의존성을 항상 고수준으로 향하게 하여 예측할 수 없는 의존성의 변화를 줄이자는 원칙입니다.

일반적으로 의존성을 가지는 대상이 변경되면 의존하는 주체도 함께 변경됩니다. 만약 자주 바뀌는 구현체(저수준)을 의존하게 된다면 코드의 변경이 잦을 것이며, 버그와 사이드 이펙트가 날 확률이 높아집니다. 이때 코드가 덜 바뀌는 인터페이스나 추상 클래스(고수준)를 의존한다면 상대적으로 안정적인 코드를 작성할 수 있습니다.

> TIP  
> 고수준은 상위 수준 + 추상화되어 있는 개념입니다. 일반적으로 잘 변하지 않는 특성을 가집니다. 코드 개념에서 고수준은 인터페이스, 추상클래스 등을 예로 들 수 있습니다.
> &nbsp;  
> 저수준은 추상화된 개념을 구체적으로 구현하는 개념입니다. 인터페이스, 추상크래스를 구현하는 구현체(클래스)나 함수 들 실제 동작에 관여하는 코드라고 보시면 됩니다.

### AS-IS

```python
class App():
    def __init__(self:
        self.inmemory_db = InMemoryDatabase() # 구현체에 의존하고 있습니다.

    def save_user(self, data):
        self.inmenory_db.store_data(data)

if __name__ == "__main__":
    app = App()
    app.save_user({"id":1, "name", "grab"})
```

만약 App 에서 다른 데이터베이스를 사용하고 싶다면, 코드를 직접 변경해야 합니다. 또한 App을 테스트하는 코드를 작성할 때도 의존성이 강하게 결합되어 테스트가 쉽지 않습니다.

### TO-BE

1. 의존성 역전

```python
class App():
    def __init__(self):
        # 고수준을 의존하지만 구현체를 구현하는 코드가 함계 들어있어 반쪽짜리 의존성 역전입니다.
        self.inmemory_db : Database = InMemoryDatabase()

    def save_user(self, data):
        self.inmemory_db.store_Data(data)


if __name__ == "__main__":
    app = App()
    app.save_user({"id": 1, "name": "grab"})
```

2. 의존성 주입과 함께

일반적으로 의존성 역전을 하면서 의존성 주입을 함께 사용합니다.

의존성 주입을 사용하게 되면 객체의 생성을 외부에 맡기게 됩니다. 그러면 해당 클래스는 외부 의존성에 조금 더 자유롭게 되며 테스트를 작성할 때도 용이합니다.

```python
class App():
    def __init__(self, database: Database): # 고수준에 의존합니다.
        self.databse = database
    
    def save_user(self, data):
        self.database.store_data(data)

if __name__ == "__main__":
    inmemory_db = InMemoryDatabase()
    app = App(inmemory_db) # 외부에서 의존성을 생성 후 주입해 줍니다.
    app.save_user({"id":1, "name":"grab"})
```

> TIP  
> 의존성 주입을 해주기 위해선 결국 이를 사용하는 클라이언트에서 의존성들을 잉일이 넣어줘야 합니다. 만약 잘 못 코드를 작성하면 의존성 관계가 복잡해질 수 있습니다.  
> &nbsp;  
> 그래서 보통 의존성 주입을 별도로 관리해주는 라이브러리나 프레임워크를 사용합니다.