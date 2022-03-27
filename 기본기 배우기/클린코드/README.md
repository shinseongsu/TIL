# 깔끔한 코드를 위하여 클린코드

## Convention

코딩을 하면서 이름을 지을 때 대표적인 컨밴션으로 `snake_case`, `camelCase`, `pascalCase`, `kebab-case` 4가지가 있다.

snake_case: Python, Ruby 등에서 권장함

camelCase : Java, Javascript 등에서 권장함

PascalCase : 대부분 프로그래밍 언어에서 클래스를 네이밍할 떄 사용함

kebab-case: HTML Element를 표현할 떄 사용함.

## 변수와 상수

일반적으로 변수와 상수를 네이밍할 때는 명사 혹은 형용사 구문 형태로 짓습니다.

```
user_data = ... #명사
is_valid  = ... #형용사
```

## 함수와 메소드

일반적으로 함수와 메서드를 네이밍할 떄는 동사 혹은 형용사 구문 형태로 짓습니다.

```python
def send_data():
    ...

def import_is_valid():
    ...
```

## 클래스

일반적으로 클래스 이름을 네이밍할 떄는 명사 구분 형태로 짓습니다.

```python
class Client:
    ...

class RequestBody:
    ...
```

## Tips

1. 구체적이고 명시적으로 적을 것

```python
#as-is
dt = "2021091KST"
for i in data:
    ...

#to_be
datetime_with_timezone = "20210901KST"
for product in products:

```

2. 불필요한(애매한) 표현은 제거할 것

```python
# as-is
product_with_price = Product("아이폰", 3000)
the_message = 1 # 불필요한 관사 포함
name_string = "grab" # 변수명에 타입을 부가적으로 표현함

# to_be
product = Product("아이폰", 3000);
message = 1
name = "grab"
```

> 길다고 나쁜 게 아닙니다. 짧고 애매한 표현보다 길고 직관적인 표현이 낫습니다.

# 클린 코드 - 주석, 포맷팅

## 주석

모든 내용을 주석으로 넣게 되면 코드가 지저분할 수 있습니다. 대부분은 좋은 Naming으로 충분히 해결이 가능합니다.

네이밍으로 표현할 수 없는 영역은 주석으로 표현해주면 됩니다.

- 법적인 정보를 담을 때

```python
# Copyright (C) 2021 ...
```

- 의도를 명확하게 설명할 때

```python
# throughput을 늘리기 위해 스레드를 10개까지 늘린다.
for idx range(10):
    thread = threading.Thread(target=...)
    thread.start()
```

- 중요성을 강조할 때

```python
# 최종 결제를 하기 전에 진행해야 하는 validation 함수
def validate_buyalbe(wallet, price, ...):
    ...
```

- 결과를 경고할 때

```python
# WARING: API 서버가 항상 암호한지 알 수 없음.
def connect_api_server():
    ...
```

## 관용적으로 사용되는 키워드

`TODO`: 당장은 아니지만 다음에 해야 할 때

`FIXME`: 치명적인 에러를 발생하는 코드는 아니지만 수정해야 할때

`XXX`: 더 생각해볼 필요가 있을 때

```python
# TODO@grab: 객체의 책임 더 분리하기
class GrabStore:
    ...
    # FIXME: 반복문의 depth를 줄이기
    def sell_food(self):
        for food in food_list:
            for discount in discount_list:
                ...
```

## 포맷팅

### Vertical Formatting

- 한 파일에 코드를 다 넣지 말고, 개념에 맞게 파일을 나눠 사용한다.

```python
# as-is
# store.pyy에 전부 있음
class FruitsStore:
    ...

class ComputerStore:
    ...


# to-be
# fruit_store.py
class FruitsStore:
    ...

# computer_store.py
class ComputerStore:
    ...
```

- 다른 개념의 코드는 Spacing으로 분리하기

- 비슷한 개념의 코드는 붙여서 사용하기

```python
def test_user_buy_product():
    user = User()
    product = Product()

    product.set_sold_out(True)
    user_get(product)

    assert result == "success"
```

### Horizontal Formatting

- 한 줄에 코드를 다 넣기 보단 변수 등을 활용해서 가독성 높이기

```python
# as-is
product_list.extend([Product("모니터"), Product("키보드"), Product("노트북")])

# to-be
items = [Product("모니터"), Product("키보드"), Product("노트북")]
product_list.extend(items)
```

- 네이밍 잘해서 길이 줄이기

```python
# as-is
user_with_name_and_email = User("그랩", "grab@world.com")

# to-be
user = User("그랩", "grab@wrold.com")
```

## 함수

**함수의 역활은 하나만 할 수 있도록 하자 (SRP)**

함수의 역활이 많아진다면, 오류가 날 가능성이 커지고 가능성이 떨어집니다. 또한 함수에 대한 테스트를 진행하기가 어렵습니다.

- as-is

```python
def create_user(email. password):
    # validation 로직
    if "@" not in email or len(password) < 6:
        raise Exception("유지 정보를 제대로 입력하세요")

    user = {"email": email, "password": password}

    database = Database("mysql")
    database.add(user)

    email_client = EmailClient()
    email_client.set_config(...)
    email_client.send(email, "회원가입을 축하합니다.")

    return True
```

- to-be

```python
def create_use(email, password):
    validate_create_user(email, password)

    user = build_user(email, password)

    save_user(user)
    sned_email(email)

    return


def validate_create_user(email, password):
    if "@" not in email or len(password) < 6:
        raise Exception("유저 정보를 제대로 입력하세요")


def build_user(email, password):
    return {
        "email": email,
        "password": password
    }

def save_user(user):
    database = Database("mysql")
    database.add(user)


def send_email(email):
    email_client = EmailClinet()
    email_clinet.set_config(...)
    email_client.send(email, "회원가입을 축하합니다")

```

**반복하지 말자 (DRY)**

관심사를 잘 분리하고 의존성을 줄이기 위해 반복되는 코드를 하나의 함수로 만들어 사용합니다.

- as-is

```python
def create_user(email, password):
    # validation 로직
    if "@" not in email or len(password) < 6:
        raise Exception("유저 정보를 제대로 입력하세요")

     ...

def update_user(emmail, password):
    # validation 로직
    if "@" not in email or len(password) < 6:
        raise Exception("유저 정보를 제대로 입력하세요")
```

- to-be

```python
def validate_create_user(email, password):
    if "@" not in email or len(password) < 6:
        raise Exception("유저 정보를 제대로 입력하세요")


def create_user(email, password):
    validate_create_user(email, password)
    ...


def update_user(email, password):
    validate_create_user(email, password)
    ...
```

**파라미터 수는 적게 유지하기**

```python
# as-is
def save_user(user_name, email, password, created_at):

# to-bw
def save_user(user:User):

```

**사이드 이펙트를 잘 핸들링 하자**

사이드 이펙트(Side Effect)는 함수가 실행됐을 때 함수 이외의 어떤 것들에 변화를 주는 것을 뜻합니다. 사이드 이펙트를 잘 다루지 못하면, 예측하지 못하는 문제들이 발생할 수 있습니다.

```python
# 사이드 이펙트가 없습니다.
def get_user_instance(email, password):
    user = User(email, password)
    return user

# 사이드 이펙트가 있습니다.
def update_user_instance(user):
    user.email = "new email"  # 인자로 받은 user 객체를 업데이트합니다.
    ...

# 사이드 이펙트가 있습니다.
def create_user(email, password):
    user = User(email, password)
    start_db_session() # 외부의 DB session에 변화를 줄 수 있습니다.
    ...

```

- 잘 핸들링 하는 방법

1. 코드를 통해 충분히 예측할 수 있도록 네이밍을 잘하는 것이 중요합니다.

   - update, set 같은 직관적인 prefix를 붙여서 사이드 이펙트가 있을 수 있음을 암시합니다.

2. 함수의 사이드 이펙트가 있는 부분과 없는 부분으로 잘 나눠서 관리합니다.

   - 명령(side effect O)과 조회(side effect X)를 분리하는 `CQRS` 방식이 있습니다.

3. 일반적으로 update를 남발하기 보단 순수 함수 형태로 사용하는 것이 더 직관적이고 에러를 방지할 수 있습니다.

- as-is

```python
carts = []

# 사이드 이펙트를 발생시킴
def add_cart(product):
    carts.append(product)

product = Product(...)
add_cart(product)
```

- to-be

```python
carts = []

# 사이드 이펙트가 없는 순수 함수
def get_added_cart(product):
    return [...carts, product]

product = Product(...)
carts = get_added_cart(product)

```

## 클래스

**단일 책임 원칙(SRP)**

하나의 클래스는 하나의 책임만 가지도록 합니다.

- as-is

```python
# store가 많은 역활을 혼자서 수행합니다.
class Store:
    def communicate_user():
        ...

    def manage_products():
        ...

    def manage_money():
        ...

```

- to-be

```python
# 책임을 나눠서 Manager 클래스에게 책임을 전가합니다.
class CounterManager:
    def communicate_user():
        ...

class ProductManager:
    def manage_money():
        ...


class Store:
    def __init__(counter_manger: CounterManager, product_manager: ProductManager, owner: Owner):
        self.counter_manager = counter_manager
        self.product_manager = product_manager
        self.owner = owner

    def sell_product():
        self.counter_manager.communicate_user()
        ...

    def manage_products():
        ...

```

**응집도를 높이자.**

- 응집도는 클래스의 변수와 메서들이 얼마나 유기적으로 엮여있나를 나타내는 지표입니다.

  - 응집도가 높을수록 클래스의 메소드들은 인스턴스 변수들을 많이 사용합니다.
  - 응집도가 낮을 수록 클래스의 메서드들은 변수들을 적게 혹은 사용하지 않습니다.

- as-is

```python
class LowcCohesion:
    def __init__(self):
        self.a = ...
        self.b = ...
        self.c = ...

    def process_a(self):
        print(self.a)

    def process_b(self):
        print(self.b)

    def process_c(self):
        print(self.c)
```

- to-be

```python
class HighCohesion:
    def __init__(self):
        self.abc = ...

    def process_a(self):
        self.abc.process_a()

    def process_b(self):
        self.abc.process_b()

    def process_c(self):
        self.abc.process_c()
```

**변경하기 쉽게 만들자**

새 기능을 수정하거나 기존 기능을 변경할 때, 코드의 변경을 최소화하는 게 중요합니다.

일반적으로 클래스(객체)는 구현(Concrete)와 추상(Abstract)으로 나뉘게 됩니다. 구현에는 실제 동작하는 구체적인 코드가, 추상은 인터페이스나 추상 클래스처럼 기능을 개념화한 코드가 들어갑니다.

일반적으로 변경하기 쉽게 위해선 추상화를 해두고 구체 클래스에 의존하지 않고 추상 클래스(인터페이스)에 의존하도록 코드를 짜는 것이 중요합니다.

- as-is

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
        self.employese = employese

    # employee가 다양해 질수록 코드를 계속 변경해야 한다.
    def make_work(self):
        for employee in self.employees
            if type(employee) == Developer:
                employee.coding()
            elif type(employee) == Designer:
                employee.design()
            elif type(employee) == Analyst:
                employee.analyze()
```

- to-be

```python
class Employee(metaclass=abc.ABCMeta):
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

# 상속을 통해 쉽게 구현이 가능함 -> 확장이 열려있다.
class Manager(Employee):
    def work(self):
        print("매니징을 합니다")


class Company:
    def __init__(self, employees: List(Employee)):
        self.employees = employee

    # employee가 늘더라도 변경에는 닫혀있다.
    def make_work(self):
        for employee in self.employees:
            employee.work()
```


## 에러 핸들링

**오류 코드보다는 예외 사용하기**

오류 코드를 사용하게 되면 상단에 오류인지 확인하는 불필요한 로직이 들어가게 됩니다. 오류의 범주에 들어가지 않은 상태를 나타내는 것이 아니라면, 예외(Exception)로 명시적으로 에러 처리를 표현 해주는게 좋습니다.

- as-is

```python
from enum import Enum

class ErrorCodes(Enum):
    VALUE_ERROR="VALUE_ERROR"

def we_can_raise_error():
    ...
    return ERROR_CODES.VALUES_ERROR

def use_ugly_function():
    result = we_can_occur_error()
    if result == ErrorCodes.VALUE_ERROR:
        # 처리코드
    ...        
```

- to-be

```python
def we_can_raise_error():
    if ...
        raise ValueError("에러발생")

def use_awesome_function():
    try:
        we_can_occur_error()
        ...
    except ValueError as e:
        # 에러 처리 로직        
```

**예외 클래스 잘 정의하기**

- 기본 Exception만 쓰기 보단 내장된 built in Exception을 잘 활용하면 좋습니다.

- 상황에 맞게 Custom Exception을 만들어 사용하는 것도 좋습니다.

```python
class CustomException(Exception):
    ...

class WithParameterCutomException(Exception):
    def __init__(self, msg, kwargs):
        self.msg = msg
        self.kwargs = kwargs

    def __str__():
        return f"messag {self.msg} with parameter {self(self.kwargs)}"

raise WithParameterCustomException("문제가 있습니다", {"name": "grab"})            
```

**에러 핸들링 잘하기**

- 에러를 포착한다면 잘 핸들링해줘야 한다.

```python
def we_can_raise_error():
    ...
    raise Exception("Error!")

# BAD: 에러가 났는지 확인 할 수 없게 됩니다.
def use_ugly_function():
    try:
        we_can_raise_error()
        ...
    except:
        pass

# BAD: 로그만 남긴다고 끝이 아닙니다.
def use_ugly_function2():
    try:
        we_can_raise_error()
        ...
    except Exception as e:
        print(f"에러 발생{e}")        

# GOOD
def use_awesome_function():
    try:
        we_can_raise_error()
        ...
    except Exception as e:
        logging.error(...) # Error Log 남기긱
        notify_error(...) # 에측 불가능한 외부 I/O 이슈라면 회사 내 채널에 알리기(이메일, 슬랙 etc)
        raise OtherException(e)
    finally:
        ... # 에러가 발생하더라도 항상 실행되어야 하는 로직이 있다면 finally 문을 넣어주기
```

- 에러 핸들링을 모을 수 있으면 한곳으로 모읍니다. 보통 같은 수준의 로직을 처리한다면 한 곳으로 모아서 처리하는게 더 에러를 포착하기 쉽습니다.

- as-is
  
```python
def act_1():
    try:
        we_can_raise_error1()
        ...
    except:
        # handling
    
def act_2():
    try:
        we_can_raise_error2()
        ...
    except:
        # handling

def act_3():
    try:
        we_can_raise_error3()
        ...
    except:
        # handling

# 에러가 날 지점을 한눈에 확인 할 수 없습니다.
# act_1이 실패하면 act_2가 실행되면 안 된다면? 핸들링하기 어려워집니다.
def main():
    act_1()
    act_2()
    act_3()                
```

- to-be

```python
def act_1():
    we_can_raise_error1()
    ...

def act_2():
    we_can_raise_error2()
    ...

def act_3():
    we_can_raise_error3()
    ...

# 직관적이며 에러가 날 지점을 확인하고 처리할 수 있습니다.
# 트랜잭션 같이 한 단위로 묶어야하는 처리에도 유용합니다.
def main():
    try:
        act_1()
        act_2()
        act_3()
    except SomeException1 as e1:
        ...
    except SomeException2 as e2:
        ...
    except SomeException3 as e3:
        ...
    finally:
        ...    
```

## 코드 indent 줄이기 (Guard Clausing, Polymorphism)

if-else 조건문을 많이 사용하게 되면 코드 라인이 길어지고 indent가 많아져 가독성이 떨어지는 문제가 발생합니다.  
이때, Guard Clausing 과 Polymorshism(다형성)을 사용하면 코드를 클린하게 짤 수 있습니다.

**Guard clause**

일반적으로 if-else문이 중첩(nested)될수록 코드는 복잡해지고 보기 지저분해집니다.

```python
# BAD
if:
    ...
    if:
        ...
        if:
            ...
            while:
            ...
...
```

nested 코드를 줄이고 가독성을 높이기 위해선, 코드 상단에 fail이 되는 로직을 위로 넣어두는 것이 좋습니다.


- as-is

```python
def say_hi_spring_user(developer):
    if developer.is_front-end:
        raise Exception("you are front engineer!")
    elif developer.is_back_end:
        if developer.likes_python:
            raise Exception("you user pyhon!")
        elif developer.likes_java:
            if developer.use_spring:
                return "hello! spring User"
            else:
                raise("you use other java framework!")
    raise Exception("who are you?")
```

- to-be

```python
# Fail이 되는 부분을 상위로 올리면 코드를 더 쉽게 읽을 수 있습니다.
def say_hi_to_spring_user(developer):
    if not developer.is_backend:
        raise Exception("you are not backend engineer!")

    if not developer.likes_java:
        raise Exception("you don't like java TT")

    if not developer.use_spring:
        raise Exception("you don't use spring!")

    return "hello! spring user"
```

**Polymorphism(다형성)**

객체지향의 꽃이라고 불리는 다형성을 활용하여 if-condition을 줄일 수 있습니다.

- as-is

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

    def make_work(self):
        for employee in self.employees:
            if type(employee) == Developer:
                employee.coding()
            elif type(employee) == Designer:
                employee.design()
            elif type(employee) == Analyst:
                employee.analyze()
```

- to-be

```python
# Employee로 추상화해둡니다.
class Employee(metaclass=abc.ABCMeta):
    @abc.abstractmethd
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

class Company:
    def __init__(self, emplyees: List[Employee]):
        self.emplyees = employees

    # if문을 사용하지 않고 다형성을 통해서 이를 해결합니다.
    def make_work(self):
        for employee in self.employees:
            employee.work()
```


