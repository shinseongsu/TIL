# 의존성 응집도, 결합도

## 의존성

객체 A 입장에서 객체 B의 존재를 알고 있을 때, "객체 A는 객체 B에 의존성이 있다." 라고 합니다.  
의존성은 크게 2가지로 나눠볼 수 있습니다.

## 정적 의존성

코드 레벨에서 객체 A 내에서 객체 B에 접근하는 경우입니다. 다음 예시를 보겠습니다.

```python
from abc import ABC, abstractmethod

class Job(ABC):
    @abstractmethod
    def do(self) -> None:
        pass

class DataEngineer(Job):
    def do(self) -> None:
        print(f"데이터 엔지니어링 관련된 일을 합니다.")

class User:
    def __init__(self, name: str, job: DataEngineer) -> None:
        self.name = name
        self.job = job

    def work(self) -> None:
        self.job.do()
```

위 코드에서 User의 생성자(`__init__(self) 메서드`)에서 DataEngineer 객체를 파라미터로 받고 있습니다.  
즉, User가 DataEngineer 이라고 하는 객체의 존재를 알고 있는 것입니다. 이처럼 코드 레벨에서 직접적으로 두 객체의 의존 관계를 파악할 수 있을 때, 정적 의존성이 있다고 합니다. 컴파일 의존성이라고도 합니다.

위의 경우 User 객체가 DataEngineer 객체가 정적 의존성이 있습니다.

### 동적 의존성

코드 레벨에서 의존성이 드러나지 않지만, 실제 실행 과정에서 두 객체 간 의존 관계가 있을 때 동적 의존성 관계에 있다고 합니다. 다음 예시를 보곘습니다.

```python
from abc import ABC

class Job(ABC):
    def do(self) -> None:
        print(f"{self.work_type} 관련된 일을 합니다.")

```