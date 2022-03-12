import { html } from "lit-element";
import { getKoreanMoneyString } from "../../utils/currency";
import SpinButton from "../templates/spin-button";
import View from "../view";

export default class MenuDetail extends View {
  constructor(
    menu,
    menuAmount,
    orderTypeIndex,
    onAddCartButtonClick,
    onIncreaseAmount,
    onDecreaseAmount
  ) {
    super();
    this.menu = menu;
    this.menuAmount = menuAmount;
    this.orderType = orderTypeIndex === 0 ? "포장" : "매장";
    this.orderTypeIndex = orderTypeIndex;
    this.onAddCartButtonClick = onAddCartButtonClick;
    this.onIncreaseAmount = onIncreaseAmount;
    this.onDecreaseAmount = onDecreaseAmount;
  }

  static get properties() {
    return {
      orderTypeIndex: {
        type: Number,
      },
      onIncreaseAmount: {
        type: Function,
      },
      onDecreaseAmount: {
        type: Function,
      },
      menu: {
        type: Object,
      },
      menuAmount: {
        type: Number,
      },
      orderType: {
        type: String,
      },
    };
  }

  render() {
    return html`
      <div class="menu-detail-area">
        <!-- 메뉴이미지영역 -->
        <div
          class="menu-img"
          style="background-image: url('${this.menu.imageUrl}');"
        ></div>

        <!-- 메뉴주문정보영역 -->
        <div class="menu-info-area">
          <div class="common-inner">
            <!-- 메뉴정보영역 -->
            <p class="menu-name-group">
              <span class="menu-name">${this.menu.name}</span>
              ${
                this.menu.isPopular
                  ? '<span class="badge-popular">인기</span>'
                  : ""
              }
            </p>

            <div class="menu-info-group">
              <span class="menu-price"
                >${getKoreanMoneyString(this.menu.price)}원</span
              >
              <span class="menu-grade"
                ><img
                  src="/assets/images/ico-star.svg"
                  alt=""
                  class="ico-star"
                />${parseFloat(this.menu.reviewPoint).toFixed(2)}</span
              >
              <span class="menu-number-of-order">주문수<em>${
                this.menu.orderCount
              }</em></span>
            </div>

            <p class="menu-desc">
              ${this.menu.description}
            </p>
            <!-- // 메뉴정보영역 -->

            <!-- 메뉴주문영역 -->
            <div class="order-type-area">
              <div class="type-select">
                <div class="title">
                  <svg viewBox="0 0 18 18" class="ico-n-logo">
                    <path
                      fill-rule="evenodd"
                      fill="currentColor"
                      d="M18 0v18H0V0h18zM7.255 4.582H4.473v9.054h2.915V8.79l3.357 4.846h2.782V4.582h-2.915v4.846L7.255 4.582z"
                    ></path>
                  </svg>
                  주문
                </div>
                <div class="tab-switch-box" role="tablist">
                  <a
                    @click=${() => {
                      this.orderType = "포장";
                    }} 
                    class="
                      tab-switch 
                      ${this.orderType === "포장" ? "is-active" : ""} 
                      role="tab"
                    >🛍&nbsp;&nbsp;포장</a
                  >
                  <a
                    @click=${() => {
                      this.orderType = "매장";
                    }} 
                    class="
                      tab-switch 
                      ${this.orderType === "매장" ? "is-active" : ""}" 
                      role="tab"
                    >🍽&nbsp;&nbsp;매장</a
                  >
                </div>
              </div>
              <div class="type-amount">
                <div class="title">수량</div>
                ${SpinButton({
                  count: this.menuAmount,
                  onIncrease: this.onIncreaseAmount,
                  onDecrease: this.onDecreaseAmount,
                })}
              </div>
              <button class="btn-order" @click=${this.onAddCartButtonClick}>
                ${this.menuAmount}개 담기 
                ${getKoreanMoneyString(this.menu.price * this.menuAmount)}원
              </button>
            </div>
            <!-- // 메뉴주문영역 -->
          </div>
        </div>
      </div>
    `;
  }
}
