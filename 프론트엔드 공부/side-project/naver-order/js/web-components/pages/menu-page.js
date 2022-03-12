import { html } from "lit-element";
import { requestGetMenuGroups, requestGetRecentOrders } from "../../apis/menu";
import { getKoreanMoneyString } from "../../utils/currency";
import { ORDER_TYPE_MESSAGE } from "../constants/constants";
import View from "../view";

export default class MenuPage extends View {
  constructor(cartItems = [], onSetOrderTypeIndex, orderTypeIndex = 0) {
    super();

    this.onSetOrderTypeIndex = onSetOrderTypeIndex;
    this.orderTypeIndex = orderTypeIndex;
    this.cartItems = cartItems;

    this.menuGroups = [];
    this.recentMenuItems = [];
    this.selectedCategory = "추천";

    requestGetRecentOrders().then(
      (recentOrders) => (this.recentMenuItems = recentOrders)
    );
    requestGetMenuGroups().then((menuGroups) => (this.menuGroups = menuGroups));
  }

  static get properties() {
    return {
      orderTypeIndex: { type: Number },
      recentMenuItems: { type: Array },
      menuGroups: { type: Array },
      cartItems: { type: Array },
      selectedCategory: { type: String },
      onSetOrderTypeIndex: { type: Function },
    };
  }

  setOrderTypeIndex(index) {
    this.orderTypeIndex = index;
  }

  handleCategorySelect(category) {
    this.selectedCategory = category;
    const y = document
      .querySelector(`[data-scroll-id=${category}]`)
      .getBoundingClientRect().top;

    window.scrollBy({
      top: y - 140,
      left: 0,
      behavior: "smooth",
    });
  }

  moveToDetailPage(id) {
    history.pushState(null, null, `/detail/${id}`);
    dispatchEvent(new PopStateEvent("popstate"));
  }

  moveToOrderPage() {
    history.pushState(null, null, `/order`);
    dispatchEvent(new PopStateEvent("popstate"));
  }

  render() {
    const categories = this.menuGroups.map((menu) => ({
      category: menu.category,
      categoryName: menu.categoryName,
    }));

    const cartItemsLength = this.cartItems.length;
    const cartItemsMenuString = this.cartItems
      .map((item) => item.menu.name)
      .join("+");
    const cartItemsTotalPrice = this.cartItems.reduce(
      (acc, item) => acc + item.menu.price * item.amount,
      0
    );

    return html`
      <div class="container">
        <!-- 고정헤더영역 -->
        <naver-order-header></naver-order-header>
        <!-- // 고정헤더영역 -->

        <!-- 주문정보영역 -->
        <div class="order-info-area">
          <div class="common-inner">
            <div class="info-main">
              <div class="info-main-title">
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
              </div>

              <!-- 주문분류 -->
              <tab-list
                tabIndex=${this.orderTypeIndex}
                .onTabChange=${this.setOrderTypeIndex.bind(this)}
              ></tab-list>

              <div class="info-main-notice">
                ${ORDER_TYPE_MESSAGE[this.orderTypeIndex]}
              </div>

              <!-- 최근 주문 내역 -->
              <div class="recent-order-area">
                <div class="recent-title">
                  <img
                    src="/assets/images/ico-clock.svg"
                    alt=""
                    class="ico-clock"
                  />최근<br />주문
                </div>
                <div class="recent-menu-area scroll-x">
                  <recent-menu-list
                    .items=${this.recentMenuItems}
                    .onItemClick=${this.moveToDetailPage}
                  ></recent-menu-list>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- // 주문정보영역 -->

        <!-- 메뉴카테고리영역 -->
        <div class="menu-category-area">
          <div class="common-inner">
            <category-tab-list
              selectedCategory=${this.selectedCategory}
              .items=${categories}
              .onItemClick=${this.handleCategorySelect.bind(this)}
            ></category-tab-list>
          </div>
        </div>
        <!-- // 메뉴카테고리영역 -->

        <!-- 메뉴리스트영역 -->
        ${this.menuGroups.map(
          (menuGroup) =>
            html`<menu-list
              .menuGroup=${menuGroup}
              .onMenuItemClick=${this.moveToDetailPage}
              .cartItems=${this.cartItems}
            ></menu-list>`
        )}
        <!-- // 메뉴리스트영역 -->

        <!-- 담은메뉴영역 -->
        ${cartItemsLength === 0
          ? ""
          : html`
              <div class="order-box-area">
                <div class="common-inner">
                  <div>
                    <p class="menu-name">${cartItemsMenuString}</p>
                    <p class="menu-price">
                      ${getKoreanMoneyString(cartItemsTotalPrice)}원
                    </p>
                  </div>
                  <a class="btn-order" @click=${this.moveToOrderPage}>
                    <span class="txt">주문하기</span>
                    <span class="icon">
                      <img
                        src="/assets/images/ico-cart-fill.svg"
                        alt=""
                        aria-hidden="true"
                        class="ico-cart"
                      />
                      <span class="num">${cartItemsLength}</span>
                    </span>
                  </a>
                </div>
              </div>
            `}
        <!-- //담은메뉴영역 -->

        <!-- 맨위로 -->
        <div class="go-to-top">
          <a href="#" class="link">Top<i class="ico-up"></i></a>
        </div>
        <!-- // 맨위로 -->
      </div>

      <div class="dimmed-layer hidden"></div>
      <div class="order-type-popup hidden">
        <p class="title">어디서 드시나요?</p>
        <div class="type-list">
          <order-type-list></order-type-list>
        </div>
      </div>
    `;
  }
}
