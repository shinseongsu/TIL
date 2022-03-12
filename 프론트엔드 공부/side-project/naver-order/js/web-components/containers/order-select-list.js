import { html } from "lit-element";
import { getKoreanMoneyString } from "../../utils/currency";
import SpinButton from "../templates/spin-button";
import View from "../view";

export default class OrderSelectList extends View {
  constructor(
    items = [],
    onIncreaseOrderAmount,
    onDecreaseOrderAmount,
    onDeleteCartItem
  ) {
    super();
    this.items = items;
    this.onIncreaseOrderAmount = onIncreaseOrderAmount;
    this.onDecreaseOrderAmount = onDecreaseOrderAmount;
    this.onDeleteCartItem = onDeleteCartItem;
  }

  static get properties() {
    return {
      items: {
        type: Array,
      },
      onIncreaseOrderAmount: {
        type: Function,
      },
      onDecreaseOrderAmount: {
        type: Function,
      },
      onDeleteCartItem: {
        type: Function,
      },
    };
  }

  render() {
    return html`
      <ul class="menu-list">
        ${this.items.map(
          (item) => html`
            <li class="menu-item">
              <div class="menu-img-area">
                <img
                  src="${item.menu.imageUrl}"
                  alt="${item.menu.name}"
                  class="menu-img"
                  width="74"
                  height="74"
                />
              </div>
              <div class="menu-info-area">
                <p class="menu-name-group">
                  <span class="menu-name">${item.menu.name}</span>
                </p>
                <p class="menu-desc">${item.menu.description}</p>
                <button class="btn-option">옵션변경</button>
                <div class="amount-and-price">
                  ${SpinButton({
                    count: item.amount,
                    onDecrease: () => this.onDecreaseOrderAmount(item.menu.id),
                    onIncrease: () => this.onIncreaseOrderAmount(item.menu.id),
                  })}
                  <p class="menu-price">
                    ${getKoreanMoneyString(item.menu.price)}원
                  </p>
                </div>
              </div>
              <button
                class="btn-delete"
                @click=${() => this.onDeleteCartItem(item.menu.id)}
              >
                <img
                  src="/assets/images/ico-close.svg"
                  alt="삭제"
                  class="ico-delete"
                  @click=${() => this.onDeleteCartItem(item.menu.id)}
                />
              </button>
            </li>
          `
        )}
      </ul>
    `;
  }
}
