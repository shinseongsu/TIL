import pytest

from main import Product


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


def test_take_money(grab_store):
    price = 100
    pre_money = grab_store._money

    grab_store._take_money(money=price)

    assert grab_store._money == pre_money + price


def test_return_money(grab_store):
    price = 100
    pre_money = grab_store._money

    grab_store._return_money(money=price)

    assert grab_store._money == pre_money - price


def test_take_out_product(grab_store):
    product_id = 1

    product = grab_store._take_out_product(product_id=product_id)

    assert product == Product(name="키보드", price=30000)
    assert not grab_store._products.get(product_id, None)