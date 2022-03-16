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
