# 리팩토링을 통해 객체 지향 알아보기

이번 챕터에서는 코드를 직접 리팩토링하면서 배월ㅆ던 객체 지향 개념을 적용해보겠습니다.  

## 상황

사용자가 상점에서 상품을 구매하는 코드를 구현합니다.  
사용자와 상점은 돈을 가지고 있고, 거래가 일어나면 돈을 주고받습니다.

## 리팩토링 전 코드

- 상점 코드

```python
class GrabStore:
    def __init__(self):
        self.money = 0
        self.name = "그랩마켓"
        self.products = {
            1 : {"name": "키보드", "price" : 30000},
            2 : {"name": "모니터", "price" : 50000},
        }
    
    def set_money(self, money):
        self.money = money

    def set_products(self, products):
        self.products = products

    def get_money(self):
        return self.money

    def get_products(self):
        return self.products
```

- 사용자 코드

```python
class User:
    def __init__(self):
        self.money = 0
        self.store = GabStore()
        self.belongs = []

    def set_money(self, money):
        self.money = money

    def set_belongs(self, belongs):
        self.belongs = belongs

    def get_money(self):
        return self.money

    def get_belongs(self):
        return self.belongs

    def get_store(self):
        return self.store

    def see_product(self, product_id):
        products = self.store.get_prodcuts()
        return products[product_id]

    def purchase_product(self, product_id):
        product = self.see_product(product_id)
        if self.money >= product["price"]:
            self.store.products.pop(product_id)
            self.money -= product["price"]
            self.store.money += product["price"]
            self.belongs.append(product)
            return product
        else:
            raise Exception("잔돈이 부족합니다")
```

- 실행 코드

```python
if __name__ == "__main__":
    user = User()
    user.set_money(100000)
    user.purchase_product(product_id=1)
```

## 다른 Store가 들어오면 어떻게 될까?

- 개선점
1. Store를 추상화한다.
2. 의존성을 주입을 한다.

```python
from abc import ABC, abstractmethod

class Store(ABC):
    @abstractmethod
    def __init__(self):
        self.money = 0
        self.name = ""
        self.products = {}

    @abstractmethod
    def set_money(self, money):
        pass

    @abstractmehtod
    def set_products(self, products):
        pass

    @abstractmehtod
    def get_money(self):
        pass

    @abstractmehtod
    def get_products(self):
        pass
```

- Store 추가

```python
class GrabStore(Store):
    def __init__(self):
        self.money = 0
        self.name = "그랩마켓"
        self.products = {
            1 : {"name": "키보드", "price" : 30000},
            2 : {"name": "모니터", "price" : 50000},
        }
    
    def set_money(self, money):
        self.money = money

    def set_products(self, products):
        self.products = products

    def get_money(self):
        return self.money

    def get_products(self):
        return self.products


class FruitsGStore(Store):
    def __init__(self):
        self.money = 0
        self.name = "과일마켓"
        self.products = {
            1 : {"name": "바나나", "price" : 30000},
            2 : {"name": "사과", "price" : 50000},
        }
    
    def set_money(self, money):
        self.money = money

    def set_products(self, products):
        self.products = products

    def get_money(self):
        return self.money

    def get_products(self):
        return self.products
```

- User 수정

```python
class User:
    def __init__(self, store: Store):
        self.money = 0
        self.store = store
        self.belongs = []

    def set_money(self, money):
        self.money = money

    def set_belongs(self, belongs):
        self.belongs = belongs

    def get_money(self):
        return self.money

    def get_belongs(self):
        return self.belongs

    def get_store(self):
        return self.store

    def see_product(self, product_id):
        products = self.store.get_prodcuts()
        return products[product_id]

    def purchase_product(self, product_id):
        product = self.see_product(product_id)
        if self.money >= product["price"]:
            self.store.products.pop(product_id)
            self.money -= product["price"]
            self.store.money += product["price"]
            self.belongs.append(product)
            return product
        else:
            raise Exception("잔돈이 부족합니다")
```

- 실행 부분

```python
if __name__ == "__main__":
    user_a = User(store=GrabStore())
    user_b = User(store=FruitStore())
```


## Store에 있는 상품과 돈을 마음대로 접근할 수 있다.

- 개선점

1. Store의 책임을 정의하고 캡슐화 한다.
2. User의 결제 로직을 수행한다.
3. User도 캡슐화 해보자!

```python
from abc import ABC, abstractmethod

class Store(ABC):
    @abstractmethod
    def __init__(self):
        self.money = 0
        self.name = ""
        self.products = {}
    
    @abstractmethod
    def show_product(self, product_id):
        pass

    @abstractmethod
    def give_product(self, product_id):
        pass
        
    @abstractmehtod
    def take_money(self, money):
        pass

class GrabStore(Store):
    def __init__(self, products):
        self._money = 0
        self.name = "그랩마켓"
        self._products = products
    
    def set_money(self, money):
        self._money = money

    def set_products(self, products):
        self._products = products

    def show_product(self, product_id):
        return self._products[product_id]

    def give_product(self, product_id):
        self._products.pop(product_id) # products에 product_id를 key를 가지는 value를 지웁니다.

    def take_money(self, money):
        self._money += money


class User:
    def __init__(self, money, store: Store):
        self.money = 0
        self.store = store
        self.belongs = []

    def get_money(self):
        return self.money

    def get_belongs(self):
        return self.belongs

    def get_store(self):
        return self.store

    def see_product(self, product_id):
        product = self.store.show_product(product_id=product_id)
        return product

    def purchase_product(self, product_id):
        product = self.see_product(product_id=product_id) 
        if self.money >= product["price"]:
            self.store.give_product(product_id=product_id) # 상점에서 상품 꺼내기
            self.money -= product["price"]                 # 사용자가 돈 내기
            self.store.take_money(product["price"])        # 상점에서 돈 벌기
            self.belongs.append(product)
            return product
        else:
            raise Exception("잔돈이 부족합니다")

if __name__ == "__main__":
    store = GrabStore(
        products= {
            1 : {"name": "키보드", "price": 30000},
            2 : {"name": "모니터", "price": 50000}
        }
    )
    user = User(money=100000, store=store)
    user.purchase_product(product_id=1)
    print(f"user가 구매한 상품 : {user.get_belongs()}")
```

## User가 많은 행위를 책임지고 있다. Store가 판매하는 책임을 가져야 하지 않을까?

- 개선점

1. 상점에서 상품을 판매하는 행위를 추상화하고 구체적인 로직을 해당 메서드로 옮긴다.

```python
from abc import ABC, abstractmethod

class Store(ABC):
    @abstractmethod
    def __init__(self):
        self.money = 0
        self.name = ""
        self.products = {}
    
    @abstractmethod
    def show_product(self, product_id):
        pass

    @abstractmethod
    def sell_product(self, product_id, money):
        pass
        

class GrabStore(Store):
    def __init__(self, products):
        self._money = 0
        self.name = "그랩마켓"
        self._products = products
    
    def set_money(self, money):
        self._money = money

    def set_products(self, products):
        self._products = products

    def show_product(self, product_id):
        return self._products[product_id]

    def sell_product(self, product_id, money):
        # Validation 코드는 최소화
        product = self.show_product(product_id=product-Id)
        if not product:
            raise Exception("상품이 존재하지 않는다")

        self._take_money(money=money)
        try:
            _product = self._take_out_product(product_id=product_id)
        except Exception as e:
            self._return_money(money)
            raise e
        return _product

    def._take_out_product(self, product_id):
        return self._products.pop(product_id)

    def give_product(self, product_id):
        self._products.pop(product_id) # products에 product_id를 key를 가지는 value를 지웁니다.

    def _take_money(self, money):
        self._money += money

    def _return_money(self, money):
        self._money -= money

class User:
    def __init__(self, money, store: Store):
        self._money = 0
        self.store = store
        self.belongs = []

    def get_money(self):
        return self._money

    def get_belongs(self):
        return self.belongs

    def get_store(self):
        return self.store

    def see_product(self, product_id):
        product = self.store.show_product(product_id=product_id)
        return product

    def purchase_product(self, product_id):
        product = self.see_product(product_id=product_id) 
        price = product["price"]
        if self._money >= price:
            self._give_money(money=price)
            try:
                my_product = self.store.sell_product(product_id=product_id, money=price)
                self.add_belong(product)
                return my_product
            except Exception as e:
                self._take_money(money=price)
                print("구매 중 문제가 발생했습니다 {str(e)}")
            
        else:
            raise Exception("잔돈이 부족합니다")

    def _give_money(self, money):
        self._money = -money

    def _take_money(self, money):
        self.money += money

    def _add_belong(self, product):
        self.belongs.append(product)  # List에 값을 추가할 때 append 메소드를 사용

if __name__ == "__main__":
    store = GrabStore(
        products= {
            1 : {"name": "키보드", "price": 30000},
            2 : {"name": "모니터", "price": 50000}
        }
    )
    user = User(money=100000, store=store)
    user.purchase_product(product_id=1)
    print(f"user가 구매한 상품 : {user.get_belongs()}")
```

## product가 책임을 가져야 하지 않을까?

- 개선점

1. 딕셔너리 타입을 클래스(데이터클래스) 객체로 반환하자.

```python
from abc import ABC, abstractmethod
from dataclasses import dataclass

@dataclass
class Product:
    name: str
    price: int

class Store(ABC):
    @abstractmethod
    def __init__(self):
        self._money = 0
        self.name = ""
        self._products = {}

    @abstractmethod
    def show_product(self, product_id):
        pass

    @abstractmethod
    def sell_product(self, product_id, money):
        pass


class GrabStore(Store):
    def __init__(self, products):
        self._money = 0
        self.name = "그랩마켓"
        self._products = products

    def set_money(self, money):
        self._money = money

    def set_products(self, products):
        self._products = products

    def show_product(self, product_id):
        return self._products[product_id]

    def sell_product(self, product_id, money):
        # Validation 코드는 최소화
        product = self.show_product(product_id=product_id)
        if not product:
            raise Exception("상품이 존재하지 않는다")

        self._take_money(money=money)
        try:
            _product = self._take_out_product(product_id=product_id)
        except Exception as e:
            self._return_money(money)
            raise e
        return _product

    def _take_out_product(self, product_id):
        return self._products.pop(product_id)

    def _take_money(self, money):
        self._money += money

    def _return_money(self, money):
        self._money -= money

def give_product(self, product_id):
    self._products.pop(product_id) # products에 product_id를 key를 가지는 value를 지웁니다.

def _take_money(self, money):
    self._money += money

def _return_money(self, money):
    self._money -= money

class User:
    def __init__(self, money, store: Store):
        self._money = money
        self.store = store
        self.belongs = []

    def get_money(self):
        return self._money

    def get_belongs(self):
        return self.belongs

    def get_store(self):
        return self.store

    def see_product(self, product_id):
        product = self.store.show_product(product_id=product_id)
        return product

    def purchase_product(self, product_id):
        product = self.see_product(product_id=product_id)
        price = product.price
        if self._check_money_enough(price=price):
            self._give_money(money=price)
            try:
                my_product = self.store.sell_product(product_id=product_id, money=price)
                self._add_belong(product)
                return my_product
            except Exception as e:
                self._take_money(money=price)
                print(f"구매 중 문제가 발생했습니다 {str(e)}")
        else:
            raise Exception("잔돈이 부족합니다")

    def _check_money_enough(self, price):
        return self._money >= price

    def _give_money(self, money):
        self._money -= money

    def _take_money(self, money):
        self._money += money

    def _add_belong(self, product):
        self.belongs.append(product)  # List에 값을 추가할 때 append 메소드를 사용

if __name__ == "__main__":
    store = GrabStore(
        products= {
            1 : Product(name="키보드", price=300000),
            2 : Product(name="냄장고", price=500000)
        }
    )
    user = User(money=1000000, store=store)
    user.purchase_product(product_id=1)
    print(f"user의 잔돈: {user.get_money()}")
    print(f"user가 구매한 상품 : {user.get_belongs()}")
```