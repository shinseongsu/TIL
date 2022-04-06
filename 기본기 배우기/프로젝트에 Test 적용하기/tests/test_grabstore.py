from main import GrabStore, Product

## $ python -m pytest tests
def test_show_product(grab_store):

    # given
##    grab_store = GrabStore(
##        products={
##            1: Product(name="키보드", price=30000),
##           2: Product(name="냉장고", price=500000)
##        }
##    )
    product_id = 1

    # when
    product = grab_store.show_product(product_id=product_id)

    # then
    assert product == Product(name="키보드", price=30000)