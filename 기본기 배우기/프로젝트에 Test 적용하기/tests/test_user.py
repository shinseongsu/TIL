import pytest

from main import Product

# Unit Test
def test_check_money(user):
    cheap_price = 5000
    expensive_price = 10000000

    can_buy = user._check_money_enough(price=cheap_price)
    assert can_buy

    can_buy = user._check_money_enough(price=expensive_price)
    assert not can_buy

def test_give_money_chapter(user):
    price = 500
    pre_money = user._money

    user._give_money(money=price)

    assert user._money == pre_money - price


def test_give_money_expensive(user):
    price = 100000

    with pytest.raises(Exception):
        user._give_money(money=price)


# 통합 테스트
def test_purchase_product_well(mock_api, user):
    # 1. 유저가 돈을 잘 냈는가?
    # 2. 유저의 주머니에 상품이 들어있는가?
    product_id = 1
    pre_user_money = user._money
    user.belongs = []

    product = user.purchase_product(product_id=product_id)

    assert user.get_money() == pre_user_money - product.price
    assert user.get_belongs() == [product]


def test_purchase_product_expensive(mock_api, user):
    product_id = 2 # price 500,000

    with pytest.raises(Exception):
        user.purchase_product(product_id=product_id)

# 테스트가 견고하게 짜져있어야 오류가 잘 나오지 않는다.
