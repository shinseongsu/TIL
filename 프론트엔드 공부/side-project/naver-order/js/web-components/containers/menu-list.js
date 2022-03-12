import { html } from "lit-html";
import View from "../view";

export default class MenuList extends View {
  constructor(menuGroup, cartItems, onMenuItemClick) {
    super();
    this.menuGroup = menuGroup;
    this.cartItems = cartItems;
    this.onMenuItemClick = onMenuItemClick;
    this.isClosed = false;
  }

  static get properties() {
    return {
      cartItems: {
        type: Array,
      },
      menuGroup: {
        type: Object,
      },
      onMenuItemClick: {
        type: Function,
      },
      isClosed: {
        type: Boolean,
      },
    };
  }

  getPackedItemCount(item) {
    return this.cartItems.reduce((acc, cartItem) => {
      if (cartItem.menu.name === item.name) {
        return acc + cartItem.amount;
      }

      return acc;
    }, 0);
  }

  toggle() {
    this.isClosed = !this.isClosed;
  }

  render() {
    return html`
      <div
        data-scroll-id=${this.menuGroup.category}
        class="menu-list-area ${this.isClosed ? "is-closed" : ""}"
      >
        <div class="common-inner">
          <div class="menu-category">
            <p class="title">${this.menuGroup.categoryName}</p>
            <button class="btn-toggle" @click=${this.toggle}>
              <img
                class="ico-arrow"
                src="./assets/images/ico-arrow.svg"
                alt=""
              />
            </button>
          </div>

          <ul class="menu-list">
            ${this.menuGroup.items.map(
              (item) => html`
                <li
                  class="menu-item"
                  @click=${() => this.onMenuItemClick(item.id)}
                >
                  <a class="menu-detail">
                    <div class="menu-img-area">
                      <img
                        src="${item.imageUrl}"
                        alt="${item.name}"
                        class="menu-img"
                        width="100"
                        height="110"
                      />
                    </div>
                    <div class="menu-info-area">
                      <p class="menu-name-group">
                        <span class="menu-name">${item.name}</span>
                        ${item.isPopular
                          ? html`<span class="badge-popular">인기</span>`
                          : ""}
                        ${item.isNew
                          ? html`<img
                              src="/assets/images/ico-new.svg"
                              alt="new"
                              class="ico-new"
                            />`
                          : ""}
                      </p>
                      <div class="menu-info-group">
                        <span class="menu-grade"
                          ><img
                            class="ico-star"
                            src="/assets/images/ico-star.svg"
                            alt=""
                          />${parseFloat(item.reviewPoint).toFixed(2)}</span
                        >
                        <span class="menu-number-of-order"
                          >주문수<em>${item.orderCount}</em></span
                        >
                      </div>
                      <p class="menu-desc">${item.description}</p>
                      <p class="menu-price">${item.price}원</p>
                    </div>
                  </a>
                  ${item.soldOut
                    ? html`<a class="btn-cart disabled"> 품절 </a>`
                    : html`<a class="btn-cart">
                        <img
                          class="ico-cart"
                          src="/assets/images/ico-cart-fill-green.svg"
                          alt="주문하기"
                        />
                        ${this.getPackedItemCount(item) === 0
                          ? ""
                          : html`<span class="num">
                              ${this.getPackedItemCount(item)}</span
                            >`}
                      </a>`}
                </li>
              `
            )}
          </ul>
        </div>
      </div>
    `;
  }
}
