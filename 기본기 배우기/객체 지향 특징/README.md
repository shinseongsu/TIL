# 객체지향의 기본적인 개념들 짚고 가기

## 클래스와 인스턴스
### 클래스

객체지향을 지원하는 대부분의 프로그래밍 언어에서는 객체 구현을 위해 `클래스(class)`를 지원합니다.  
예를 들어 파이썬에서는 다음처럼 `class`로 객체를 표현할 수 있습니다.

```python
# 아무 내용이 없는 비어있는 클래스
def User:
    pass
```

### 인스턴스

그리고 이 클래스를 다음처럼 하나의 인스턴스로 만들 수 있습니다. 이를 클래스를 인스턴스화 한다고 합니다.

```python
>>> user_1 = User()
>>> user_2 = User()
```

`user_1`과 `user_2`는 같은 클래스로부터 만들어졌지만, 서로 다른 인스턴스입니다. 즉, 이둘은 같은 형태(클래스)를 취하고 있지만, 각자 다른 메모리 공간에 존재하고, 각자 독립된 내용을 담을 수 있습니다.

```python
>>> user_1 == user_2
False
```

## 속성과 메소드

### 속성

클래스의 `속성(attribute)`은 클래스 내에 담기는 데이터들을 말하며 `멤버 변수`라고도 이야기합니다. 크래스 속성은 크게 클래스 변수와 인스턴스 변수로 나눠볼 수 있습니다.

#### 인스턴스 변수

`인스턴스 변수`는 인스턴스별로 독립적으로 가질 수 있는 값입니다. 다음은 인스턴스 변수를 정의한 예시입니다.

```python
class User:
    def __init__(self, name: str, job: str) -> None:
        self.name = name
        self.job = job
```

이렇게 정의한 인스턴스 변수는 다음처럼 인스턴스별로 다르게 설정할 수 있습니다.

```python
user_1 = User(name="grab", job="data_engineer")
user_2 = User(name="heumsi", job="project_manager)
```

인스턴스 변수는 다음과 같이 접근합니다.

```python
>>> user_1.name
grab
>>> user_1.job
data_engineer
```

#### 클래스 변수

`클래스 변수`는 클래스 자체에 정의되는 변수입니다. 같은 클래스의 인스턴스들은 같은 클래스 변수값을 가지게 됩니다.

```python
class User:
    num_users: int = 0

    def __init__(self, name: str, job: str) -> None:
        self.name = name
        self.job = job
        User.num_users += 1
```

클래스 변수 역시 인스턴스 변수와 같은 방식으로 접근합니다.

```python
# 클래스 변수는 인스턴스화 하지 않아도 접근이 가능합니다.
>>> User.num_users
0

# 인스턴스화한 후에도 접근이 가능합니다.
>>> user_1 = User(name="grab", job="data_engineer")
>>> user_1.num_users

# 서로 다른 인스턴스더라도 클래스 변수는 공유됩니다.
>>> user_2 = User(name="heumsi", job="project_manager")
>>> user_2.num_users
```

인스턴스별로 독립된 메모리 공간을 가지는 인스턴스 변수와 달리, 클래스 변수는 같은 클래스의 인스턴스들이 공유합니다.

### 메소드

메서드는 클래스가 가지고 있는 함수이자 객체가 할 수 있는 행위를 말합니다.  
메소드는 크게 공개형(public) 메서드와 비공개형 (private) 메소드로 나눠볼 수 있습니다.

#### 공개할 메서드

공개형 메서드는 이 클래스가 외부에 제공해주는 메서드입니다. 다음 예시에서 `work()`는 공개형 메서드입니다.

```python
class User:
    def __init__(self, name: str, job: str) -> None:
        self.name = name
        self.job = job

    def work(self) -> None:
        if self.job == "data_enginner":
            print("데이터 엔지니어링 관련된 일을 합니다.")
        elif self.job == "project_manager":
            print("프로젝트 매니징 관련된 일을 합니다.")
```

이렇게 정의된 공개형 메서드는 클래스 외부에서 다음처럼 사용할 수 있습니다.

```python
>>. user_1 = User(name="grab", job="data_engineer")
>> user_1.work()

"데이터 엔지니링 관련된 일을 합니다."
```

#### 비공개형 메소드

비공개형 메서드는 클래스 내부에서만 사용하는 메서드입니다. 다음 예시에서 `_get_work_type()` 메서드는 비공개할 메서드입니.

> TIP  
> 파이썬의 경우 자바와 다르게 접근 제어자 문법이 없습니다. 다만 변수나 메서드 이름 앞에 _(underscore)를 붙임으로써 비공개 변수, 메서드임을 명시하는게 관습니다.

```python
class User:
    def __init__(self, name: str, job: str) -> None:
        self.name = name
        self.job = job
    
    def work(self) -> None:
        work_type = self._get_work_type()
        print(f"{work_type} 관련된 일을 합니다.")

    def _get_work_type(self) -> str:
        if self.job == "data_enginner":
            return "데이터 엔지니어링"
        elif self.job == "project_manager":
            return "프로젝트 매니징"
```

비공개형 메서드는 외부에서 접근하지 못하거나, 할 수 있더라도 하지 않는게 괍습니다. 위의 예시처럼 비공개형 메서드는 공개형 메서드의 로직의 일부를 내부적으로 재사용하고, 의미를 분리하기 위해 사용하기 위한 목적으로 사용하곤 합니다.

>> TIP  
>> 접근 제어자
>>
>> 접근 제어자는 변수 혹은 함수(메서드)에 대한 접근을 제어하는 역할을 합니다.
>>
>> 예를 들면 자바와 같은 객체지향 언어에는 `private`, `protected`, `public` 과 같은 접근 제어자가 있습니다. private으로 표시된 변수나 메서드는 클래스 내부에서만 접근할 수 있습니다. 클래스 외부에서 접근하려고 할 시, 컴파일 시점에 에러를 뱉습니다. 객체지향 언어에서는 보통 이런 제어자를 통해 공개형, 비공개형에 대한 표시를 아주 명확히 하곤 합니다.

### 상속

객체지향 프로그래밍 언어들은 대부분 크래스 문법과 상속을 제공합니다. `상속(inheritance)`은 이전에 정의한 클래스의 데이터와 메서드를 그대로 내려받는 기능입니다. 이떄 상속해주는 클래스를 "부모 클래스" 혹은 "기반 클래스"라고 하며, 상속받는 클래스를 "자식 클래스" 혹은 "파생 클래스"라고 합니다. 

다음은 파이썬에서 상속의 예시입니다.

```python
class Job:
    def do(self) -> None:
        print(f"{self.work_type} 관련된 일을 합니다.")

class DataEnginner(Job):
    work_type = "데이터 엔지니어링"

class ProjectManager(Job):
    work_type = "프로젝트 매니저"
```

`DataEngineer,` `ProjectManager` 클래스가 Job 클래스를 상속받았습니다. Job 클래스는 부모 클래스, `DataEngineer`, `ProjectManager` 클래스는 자식 클래스가 됩니다.

`DataEngineer`, `ProjectManager` 클래스는 Job을 상속받았으므로, Job 클래스에서 정의한 `do(self)` 메서드를 그대로 사용할 수 있습니다.

```python
>>> data_enginner = DataEnginner()
>>> data_enginner.do()

"데이터 엔지니어링 관련된 일을 합니다"
```

### 인터페이스

#### 인터페이스

`인터페이스(interface)`는 객체의 행위(메서드)만을 정의한 것으로, 구체적으로는 클래스의 메서드의 명세라고 볼 수 있습니다.

파이썬에서는 인터페이스가 따로 없이 추상 클래스로 인터페이스를 구현하였습니다.

```python
from abc import ABC, abstractmethod

class Job(ABC):
    @abstractmethod
    def do(self) -> None:
        pass
```

### 구현체

인터페이스는 보통 그대로 인스턴스화 할 수 없습니다. 예를 들어 다음 코드는 에러를 뱉습니다. 

```python
>>> job = Job()

TypeError: can't instantiate abstract class Job with abstract methods do
```

인터페이스는 객체의 뼈대만을 담당하고 있습니다. 실제로는 다음처럼 인터페이스 객체를 상속받는 구현 클래스도 구현 해야 합니다.

```python
class DataEngineer(Job):
    def do(self) -> None:
        print("테이터 엔지니어링 관련된 일을 합니다.")

class ProjectManager(Job):
    def do(self) -> None:
        print("프로젝트 매니징 관련된 일을 합니다.")
```

```python
>>> data_engineer = DataEngineer()
>>> data_enginner.do()

"데이터 엔지니어링 관련된 일을 합니다"
```

#### 인터페이스 사용 이유

인터페이스는 왜 사용하는 걸까요?

우리가 은행에 가서 은행원에게 돈을 입금해달라고 합니다. 우리는 은행원이 우리에게 돈을 입금해주는 행위를 제공하고 있습니다.

마찬가지로 위에서 정의한 Job을 외부에서 사용하는 코드(보통 클라이언트고합니다.)는 Job이 어떤 행위를 제공하는 자(Job의 퍼블릭 메서드)에 주로 관심이 있습니다. Job이 어떤 데이터를 들고있으며, 행위를 하기 위해 구체적으로 어떤 알고리즘을 가지고 있는지 클라이언트 입장에서는 중요하지 않습니다. 우리는 Job이 어떤 행위를 제공하는지 보려면 그저 Job 이라고 하는 인터페이스만 보면 됩니다.  
**그렇게 되면 자연스럽게 구현(저수준 코드)를 의존하기 보단 인터페이스(고수준)에 의존하게 되어 결합도를 낮출 수 있습니다.** (-> 다형성)

또한 `DataEngineer(Job)`, `ProjectManager(Job)`와 같은 구현 클래스가 Job 추상 클래스를 상속받는 것을 통해 이 두 클래스가 같은 개념 아래 묶어 있는 것을 알 수 있습니다. 즉, 구현 클래스 간의 관계를 파악하기도 쉬어집니다.