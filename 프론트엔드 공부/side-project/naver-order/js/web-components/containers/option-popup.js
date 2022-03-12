import { html } from "lit-element";
import { requestGetMenuOptions } from "../../apis/menu";
import { getKoreanMoneyString } from "../../utils/currency";
import { DEFAULT_MENU } from "../../utils/menu";
import SpinButton from "../templates/spin-button";
import View from "../view";

const DEFAULT_OPTION = {
  id: 1,
  baseOptions: [],
  toppingSelectOptions: [],
  toppingAmountSelectOptions: [],
};

export default class OptionPopup extends View {
  constructor(
    menu = DEFAULT_MENU,
    menuAmount,
    isPopupOpen = false,
    onPopupClose,
    onAddCartItem,
    onIncreaseAmount,
    onDecreaseAmount
  ) {
    super();
    this.menu = menu;
    this.menuAmount = menuAmount;
    this.isPopupOpen = isPopupOpen;
    this.onPopupClose = onPopupClose;
    this.onAddCartItem = onAddCartItem;
    this.option = DEFAULT_OPTION;
    this.onIncreaseAmount = onIncreaseAmount;
    this.onDecreaseAmount = onDecreaseAmount;

    requestGetMenuOptions(this.menu.id).then((option) => {
      this.option = option;
    });
  }

  static get properties() {
    return {
      onAddCartItem: {
        type: Function,
      },
      menu: {
        type: Object,
      },
      menuAmount: {
        type: Number,
      },
      isPopupOpen: {
        type: Boolean,
      },
      onPopupClose: {
        type: Function,
      },
      option: {
        type: Array,
      },
      onIncreaseAmount: {
        type: Function,
      },
      onDecreaseAmount: {
        type: Function,
      },
    };
  }

  toggleBaseOption(optionName) {
    const newOption = { ...this.option };
    newOption.baseOptions.forEach((option) => {
      if (option.name === optionName) {
        option.isSelected = true;
        return;
      }

      option.isSelected = false;
    });

    this.option = newOption;
  }

  toggleToppingSelectOption(optionName) {
    const newOption = { ...this.option };

    const targetOption = newOption.toppingSelectOptions.find(
      (option) => option.name === optionName
    );

    targetOption.isSelected = !targetOption.isSelected;
    this.option = newOption;
  }

  increaseOptionAmount(optionName) {
    const newOption = { ...this.option };

    const targetOption = newOption.toppingAmountSelectOptions.find(
      (option) => option.name === optionName
    );

    targetOption.amount += 1;
    this.option = newOption;
  }

  decreaseOptionAmount(optionName) {
    const newOption = { ...this.option };

    const targetOption = newOption.toppingAmountSelectOptions.find(
      (option) => option.name === optionName
    );

    if (targetOption.amount <= 0) {
      return;
    }

    targetOption.amount -= 1;
    this.option = newOption;
  }

  getFinalPrice() {
    let price = this.menu.price;

    this.option.toppingSelectOptions.forEach((option) => {
      if (option.isSelected) {
        price += option.price;
      }
    });

    this.option.toppingAmountSelectOptions.forEach((option) => {
      if (option.amount !== 0) {
        price += option.amount * option.price;
      }
    });

    return price * this.menuAmount;
  }

  render() {
    return html`
      <div class="option-popup-area ${this.isPopupOpen ? "show" : ""}">
        <div class="dimmed-layer light"></div>
        <div class="menu-option-popup">
          <svg class="content-top-pattern" width="100%" height="100%">
            <defs>
              <pattern
                id="pattern-triangle"
                x="0"
                y="0"
                width="10"
                height="11"
                patternUnits="userSpaceOnUse"
              >
                <polygon points="5 5, 10 10, 10 11, 0 11, 0 10"></polygon>
              </pattern>
            </defs>
            <rect
              x="0"
              y="0"
              width="100%"
              height="100%"
              fill="url(#pattern-triangle)"
            ></rect>
          </svg>

          <div class="content-top">
            <div class="common-inner">
              <div class="menu-img-area">
                <img src="${this.menu.imageUrl}" alt="" class="menu-img" />
              </div>
              <div class="menu-detail-area">
                <p class="menu-name">
                  <span class="name">${this.menu.name}</span>
                  <span class="badge">${this.menu.orderType}</span>
                </p>
                ${SpinButton({
                  count: this.menuAmount,
                  onIncrease: this.onIncreaseAmount,
                  onDecrease: this.onDecreaseAmount,
                })}
              </div>
              <button class="btn-close" @click=${this.onPopupClose}>
                <img
                  src="/assets/images/ico-close.svg"
                  alt=""
                  class="ico-close"
                />
              </button>
            </div>
          </div>

          <div class="content-body">
            <topping-base-option-group
              .items=${this.option.baseOptions}
              .onToggleOption=${this.toggleBaseOption.bind(this)}
            ></topping-base-option-group>
            <topping-select-option-group
              .items=${this.option.toppingSelectOptions}
              .onToggleOption=${this.toggleToppingSelectOption.bind(this)}
            ></topping-select-option-group>
            <topping-amount-option-group
              .items=${this.option.toppingAmountSelectOptions}
              .onItemAmountIncrease=${this.increaseOptionAmount.bind(this)}
              .onItemAmountDecrease=${this.decreaseOptionAmount.bind(this)}
            ></topping-amount-option-group>
            <div class="content-bottom">
              <button
                class="btn-order"
                @click=${() =>
                  this.onAddCartItem({
                    menu: this.menu,
                    amount: this.menuAmount,
                    option: this.option,
                    price: this.price,
                  })}
              >
                ${this.menuAmount}개 담기
                ${getKoreanMoneyString(this.getFinalPrice())}원
              </button>
            </div>
          </div>
        </div>
      </div>
    `;
  }
}
