import pytest

from main import GrabStore, Product, User


@pytest.fixture(scope="function")
def grab_store():
    return GrabStore(
        products={
            1: Product(name="키보드", price=30000),
            2: Product(name="냉장고", price=500000)
        }
    )

@pytest.fixture(scope="function")
def user(grab_store):
    return User(money=10000, store=grab_store)