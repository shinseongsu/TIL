import { html } from "lit-element";
import View from "./view";

export default class App extends View {
  constructor() {
    super();
    this.currentPage = "menu";
    this.orderTypeIndex = 0;
    this.cartItems = [];

    window.onpopstate = () => {
      const [, page] = location.pathname.split("/");

      this.currentPage = page;
    };
  }

  static get properties() {
    return {
      currentPage: {
        type: String,
      },
      cartItems: {
        type: Array,
      },
      orderTypeIndex: {
        type: Number,
      },
    };
  }

  setOrderTypeIndex(index) {
    this.orderTypeIndex = index;
  }

  addCartItem(menu) {
    const newCartItems = [...this.cartItems];
    newCartItems.push(menu);
    this.cartItems = newCartItems;

    history.pushState(null, null, "/");
    dispatchEvent(new PopStateEvent("popstate"));
  }

  deleteCartItem(menuId) {
    const newCartItems = [...this.cartItems];
    const targetIndex = this.cartItems.findIndex(
      (cartItem) => cartItem.menu.id === menuId
    );

    if (targetIndex === -1) {
      return;
    }

    newCartItems.splice(targetIndex, 1);
    this.cartItems = newCartItems;
  }

  resetCartItems() {
    this.cartItems = [];
  }

  route() {
    switch (this.currentPage) {
      case "detail":
        return html`
          <detail-page
            orderTypeIndex=${this.orderTypeIndex}
            .onSetOrderTypeIndex=${this.setOrderTypeIndex.bind(this)}
            .onAddCartItem=${this.addCartItem.bind(this)}
          ></detail-page>
        `;
      case "order":
        return html`
          <order-page
            .cartItems=${this.cartItems}
            .onDeleteCartItem=${this.deleteCartItem.bind(this)}
            .onResetCartItems=${this.resetCartItems.bind(this)}
            orderTypeIndex=${this.orderTypeIndex}
          ></order-page>
        `;
      default:
        return html`
          <menu-page
            orderTypeIndex=${this.orderTypeIndex}
            .onSetOrderTypeIndex=${this.setOrderTypeIndex.bind(this)}
            .cartItems=${this.cartItems}
          ></menu-page>
        `;
    }
  }

  render() {
    return this.route();
  }
}
