# 프로그래밍 패러당미 흐름 흝고가기 - 절차지향

## 프로그래밍 패러다임이란

프로그래밍 패러다임은 프로그래밍할 때 관점을 제공해주고, 설계를 결정하도록 돕는 패러다임입니다. 예를 들어 프로그래밍을 함수적 호출 과정을 중심으로 바라보고 설계한다면 절차지향 프로그래밍이고 되고, 객체의 책임과 협력을 중심으로 설계한다면 객체지향 프로그래밍이 됩니다.

프로그래밍 패러다임은 프로그래밍 언어에도 자연스럽게 반영되는데, 이를테면 C언어는 대표적인 절차지향 언어이며, 자바는 대표적인 객체지향 언어입니다. 이 두 패러다임을 모두 수용하기도 하는데, 파이썬이 이런 멀티 패러다임 언어라고 볼 수 있습니다.

- 절차지향 프로그래밍
- 객체지향 프로그래밍
- 함수지향 프로그래밍

> TIP  
> 현재 가장 대표적인 프로그래밍 패러다임은 객체 지향 프로그래밍 입니다.  
> 다만 silver bullet은 없듯이 비판적인 관점에서 프로그래밍 패러다임을 바라보는 것도 중요합니다.

## 절차지향 프로그래밍

### 개녕

`절차지향(Procedure Oriented) 프로그래밍`은 프로시저 콜, 즉 함수 호출을 중심으로 프로그래밍을 생각하는 것입니다.

재사용 가능한 코드들은 별도의 함수로 분리하고 함수 간의 호출로 하고자 하는 일을 수행합니다. 이건 프로세스는 주로 "함수"와 "조건문", "루프문"을 활용하여 코드를 구성합니다.

또한 절차지향 프로그래밍은 데이터를 중앙 집중식으로 관리합니다. 즉 프로세스 로직과 데이터가 별도의 위치에 분리되어 있습니다. 프로세스 로직 부분에서는 어떤 프로세스 로직 부분에서는 어떤 데이터가 들어오는지 모르기 때문에 로직 내에 조건문 사용이 많은 경향이 있습니다.

### 예시

절차지향 프로그래밍 관점으로 코드를 짜는 간단한 파이썬 코드 예시를 살펴봅니다. 사용자로부터 파일을 입력받아 파일을 파싱한 후, 이 내용을 저장소에 저장하는 코드입니다.

```python
def read_input_file(file_path: str) -> str:
    if file_path.endwith(".txt"):
        reader = get_file_reader(file_type="txt")
        return reader.read(file_path)
    elif file_path.endwith(".csv"):
        reader = get_file_reader(file_type="csv")
        return reader.read(file_path)
    elif file_path.endwith(".xlsx"):
        reader = get_file_reader(file_type="xlsx")
        return reader.read(file_path)
    else:
        raise ValueError("파일 확장자는 txt, csv, xlsx 중 하나여야 합니다.")

def get_file_reader(file_type: str) -> Reader:
    if file_type == "txt":
        ...
    elif file_type == "csv":
        ...
    elif file_type == "xlsx":
        ...

def parse_input_data(data: str) -> List[str]:
    ...

def save_data(data: List[str]) -> None:
    ...

def main() -> None:
    data = read_input_file("input_file.txt")
    parsed_data = parse_input_data(data)
    save_data(parsed_data)

if __name__ == "__main__":
    main()
```

`main` 함수는 하위 함수들의 호출로 이루어져 있습니다. `main` 함수만 보면 이 프로그램이 전체적으로 어떤 일을 하는지 쉽게 파악할 수 있습니다. 절차지향 코드는 이렇게 전체 로직을 작은 함수 단위로 나누고 프로그래밍 메인 로직이 시작되는 곳부터 하위 로직이 실행되는 곳 까지 TOP -> DOWN 식으로 구성되곤 합니다.

### 장단점

절차지향 프로그래밍으로 작성된 코드는 일반적으로 이해하기 쉽습니다. TOP -> DOWN 식이고, 함수라는 작은 단위로 나눠져 있기 떄문이죠, 로직이 복잡한 것이나 계속해서 기능을 확장해나가야 하는 것이 아니라면, 유지보수도 용이합니다. 우리가 프로그래밍을 처음 배우면 보통 절차지향으로 배우는 이유이기도 합니다.

그러나 절차지향은 전체 로직이 매우 복잡하거나 동적으로 로직을 바꿔야 하는 등의 기능 확장이 필요할 때 유지 보수하기가 어려워집니다. 또한 데이터와 함수가 분리되어 있기에 함수가 많아질수록 데이터의 변경 사항을 추적하기도 어려워집니다.

따라서 절차지향은 프로그램이 수행하는 알고리즘이 명확하고, 기능 확장 등이 자주 일어나지 않는 상황에서 사용하기에 좋습니다.

# 객체 지향

## 객체지향 프로그래밍

### 개념

`객체지향(Object Oriented) 프로그래밍` 은 객체라고 하는 단위에 책임을 명확히 하고 서로 협력하도록 프로그래밍을 하는 패러다임입니다.

모든 것을 객체로 나누어 생각하고, 필요할 때 객체들을 활용하고 서로 협력하여 일을 수행합니다.

절차지향과 다르게 객체는 데이터 함수[메소드]를 함께 가지고 있습니다. 객체 내부의 데이터는 외부에 공개할 필요가 없거나 해서는 안되는 데이터라면 모두 자신 내부에 숨겨 외부에서 알지 못하도록 합니다.

### 예시

객체지향 프로그래밍 관점으로 코드를 짜는 간단한 파이썬 코드 예시를 살펴봅니다. 이전 예시와 똑같이 사용자로부터 파일을 입력받아 파일을 파싱한 후, 이 내용을 저장소에 저장하는 코드입니다.

```python
class Processor:
    def __init__(self,
                file_reader: FileReader,
                data_parser: DataParser,
                repository: Repository) -> None:
        self.file_reader = file_reader
        self.data_parser = data_parser
        self.repository = repository

    def execute(self, file_path: str) -> None:
        data = self.file_reader.read(file_path)
        parsed_data = self.data_parser.parse(data)
        self.repository.save(parsed_data)

class FileReader:
    def __init__(self) -> None:
        self.file_types = ["txt"]
        self.file_hisotry = []

    def read(self, file_path: str) -> str:
        self._validate(file_path)
        ...

    def _validate(self, file_path: str) -> None:
        for file_type in self.file_types:
            if file_path.endwith(file_type):
                return
        raise ValueError("파일 확장자는 txt, csv, xlsx 중 하나여야 합니다.")


class DataParser:
    def parse(self, data: str) -> List[str]:
        ...

class Respository:
    def inti(self, database_url: str, ...):
        ...

    def save(self, data:List[str]) -> None:
        ...


class Main:
    @staticmethod
    def run(self) -> None:
        processor = Processor(
            file_reader=FileReader(),
            data_parser=DataParser(),
            repository=Repository()
        )
        processor.execute("input_file.txt")

if __name__ == "__main__":
    Main.run()
```

코드는 `Processor`, `FileReader` 등 여러 객체(문법적으로는 클래스)로 이루어집니다. 그리고 각 객체는 각자 자신의 역할과 기능이 있습니다. 예를 들어 `FileReader`는 파일을 읽는 역할, `DataParser` 는 데이터를 파싱하는 역할을 합니다. 프로그래밍은 전체적으로 객체와 객체 간의 메서드 호출로 이루어집니다. 그리고 각 객체는 자신의 기능을 수행하는데 필요한 데이터를 직접 가지고 있습니다. 예를 들어 `FileReader`는 `file_types`속성으로 자신이 파싱할 수 있는 파일 확장자인지 검증합니다. 이 외에 다른 객체들도 본인의 역할을 수행하는 과정에서 발생하는 데이터를 전부 관리할 수 있습니다.

코드는 조금 더 복잡해졌지만, 객체지향은 기능을 확장할 떄 효과적입니다. 위의 예시에는 input_file.txt 처럼 `txt`파일만 읽었는데, 이제는 `csv`파일이나 `xlsx`파일도 읽어야 하는 상황이 주어졌다고 해봅니다. 그럼 코드를 다음처럼 확장해볼 수 있습니다.

```python
# FileReader는 이제 추상 클래스입니다.
class FileReader(ABC):
    def read(self, file_path: str) -> str:
        self._validate(file_path)
        data = self._open_file(file_path)
        return self._read(data)

    @abstractmehtod
    def _read(slef, data: str) -> str:
        pass

    # 공통으로 사용하는 메소드입니다.
    def _validate(self, file_path: str) -> None:
        if not file_path.endwith(self.file_type):
            raise ValueError(f"파일 확장자가 {self.file_type} 아닙니다.")

    @staticmethod
    def _open_file(file_path: str) -> str:
        ...


# txt 파일을 읽는 책임을 가진 FileReader 파일 클래스입니다.
class TxtFileReader(FileReader):
    def file_type(self) -> str:
        return "txt"

    def _read(self, data: str) -> str:
        ...

    ...

# csv 파일을 읽는 책임을 가진 FileReader 파일 클래스 입니다.
class CsvFileReader(FileReader):
    def file_type(self) -> str:
        return "csv"

    def _read(self, data: str) -> str:
        ...

    ...
```

객체지향을 지원하는 대부분의 프로그래밍 언어들은 클래스 라는 문법을 제공합니다. 객체의 강력한 기능인 상속을 이용하면 한 번 정의해 놓은 메소드를 파생 클래스에서 재사용 가능합니다. 또한 상속으로 객체간의 계층 구조를 만들고 데이터와 메서드를 재사용할 수 있습니다.

객체지향의 가장 큰 특징은 같은 역할을 하는 객체를 쉽게 바꾸도록 설계할 수 있다는 것입니다. 예를 들어 위의 경우, 우리가 `txt`파일을 읽어야할 경우 다음처럼 `Main.run()` 함수 내에서 `TxtFileReader`를 사용하면 됩니다.

```python
class Main:
    def run(self) -> None:
        processor = Processor(
            file_reader=TxtFileReader(),
            data_parser=DataParser(),
            repository=Repository()
        )
```

만약 csv나 xlsx 파일을 읽어야할 경우 다음처럼 코드 한줄만 바꾸면 됩니다.

```python
class Main:
    def run(self) -> None:
        processor = Processor(
            file_reader=CsvFileReader(),
            data_parser=DataParser(),
            repository=Repository()
        )
```

이렇게 코드 한줄만으로 가능한 이유는 `TxtFileReader`, `CsvFileReader`, `XlsxFileReader` 클래스가 모두 `FileReader` 의 파생 크래스이기 떄문입니다. 이런 객체지향의 특성을 "다형성" 이라고 하며, 어떤 객체에 필요한 객체를 때에 따라 주입해주는 것을 "의존성 주입" 이라고 합니다.

## 장단점

객체지향은 여러 명의 개발자들이 협력을 해야 하거나, 확장 가능하도록 코드를 설계해야 하는 경우에 적합합니다.

하지만 확장이 가능하고 유연한 만큼, 처음 코드를 보는 사람들은 어렵고 헷갈릴 수 있습니다. 또한 실행 환경에서 입력에 따라 다양한 작업 흐름이 만들어지기 떄문에 디버깅하기가 상대적으로 어렵습니다.
