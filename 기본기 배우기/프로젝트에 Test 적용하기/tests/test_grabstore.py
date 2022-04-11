import pytest

from main import GrabStore, Product
from unittest import mock
from tests.conftest import API_URL

## $ python -m pytest tests
# 유닛 테스트
def test_show_product(mock_api, grab_store, mock_products):
    # given
    product_id = 1
    mock_product = mock_products[product_id]

    # when

    # mock 사용하기
    # with mock.patch("requests.get") as mock_api:
    #     res = mock_api.return_value
    #     res.status_code = 200
    #     res.json.return_value = mock_product

    product = grab_store.show_product(product_id=product_id)

    # then
    assert product == Product(name=mock_product["title"], price=mock_product["price"])


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


def test_take_out_product(mock_api, grab_store, mock_products):
    product_id = 1
    mock_product = mock_products[product_id]

    product = grab_store._take_out_product(product_id=product_id)

    assert product == Product(name=mock_product["title"], price=mock_product["price"])
    # assert not grab_store._products.get(product_id, None)


## 통합 테스트
def test_sell_product_well(mock_api, grab_store, mock_products):
    product_id = 1
    pre_money = grab_store._money
    mock_product = mock_products[product_id]

    product = grab_store.show_product(product_id=product_id)
    _product = grab_store.sell_product(product_id=product_id, money=product.price)

    assert grab_store._money == product.price
    # assert not grab_store.show_product(product_id=product_id)


def test_sell_product_not_found(mock_api, grab_store, mock_products):
    product_id = 100
    mock_product = mock_products.get(product_id, None)

    # mocking
 #   requests_mock.get(f"{API_URL}/{product_id}", json=mock_product)
 #   requests_mock.delete(f"{API_URL}/{product_id}", json=mock_product)

    with pytest.raises(Exception):
        grab_store.sell_product(product_id=product_id, money=0)