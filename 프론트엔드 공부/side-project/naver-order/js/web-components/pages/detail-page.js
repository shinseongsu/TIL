import { html } from "lit-html";
import { requestGetMenu } from "../../apis/menu";
import { DEFAULT_MENU } from "../../utils/menu";
import View from "../view";

export default class DetailPage extends View {
  constructor(orderTypeIndex, onSetOrderTypeIndex, onAddCartItem) {
    super();
    this.orderTypeIndex = orderTypeIndex;
    this.onSetOrderTypeIndex = onSetOrderTypeIndex;
    this.onAddCartItem = onAddCartItem;
    this.menu = DEFAULT_MENU;
    this.menuAmount = 1;
    this.isPopupOpen = false;
    const [menuId] = location.pathname.split("/").splice(-1);
    requestGetMenu(menuId).then((menu) => {
      this.menu = menu;
    });
  }

  static get properties() {
    return {
      menu: { type: Object },
      menuAmount: {
        type: Number,
      },
      orderTypeIndex: {
        type: Number,
      },
      onSetOrderTypeIndex: {
        type: Function,
      },
      isPopupOpen: {
        type: Boolean,
      },
      onAddCartItem: {
        type: Function,
      },
    };
  }

  openOrderPopup() {
    this.isPopupOpen = true;
  }

  closeOrderPopup() {
    this.isPopupOpen = false;
  }

  increaseAmount() {
    this.menuAmount += 1;
  }

  decreaseAmount() {
    if (this.menuAmount <= 1) {
      return;
    }

    this.menuAmount -= 1;
  }

  render() {
    return html`
      <div class="container">
        <!-- 고정헤더영역 -->
        <naver-order-header></naver-order-header>
        <!-- // 고정헤더영역 -->

        <menu-detail
          orderTypeIndex=${this.orderTypeIndex}
          menuAmount=${this.menuAmount}
          .menu=${this.menu}
          .onAddCartButtonClick=${this.openOrderPopup.bind(this)}
          .onIncreaseAmount=${this.increaseAmount.bind(this)}
          .onDecreaseAmount=${this.decreaseAmount.bind(this)}
        ></menu-detail>
        <!-- 주문자리뷰영역 -->
        <div class="menu-review-area">
          <!-- 주문자사진 -->
          <div class="orderer-img-area">
            <div class="common-inner">
              <div class="title">
                주문자 사진<span class="num">${this.menu.pictures.length}</span>
              </div>
              <div class="scroll-x">
                <menu-picture-list
                  .pictures=${this.menu.pictures}
                ></menu-picture-list>
              </div>
            </div>
          </div>
          <!-- // 주문자사진 -->

          <!-- 주문자리뷰 -->
          <div class="orderer-review-area">
            <div class="common-inner">
              <div class="title">
                주문자 리뷰<span class="num">${this.menu.reviews.length}</span>
              </div>
              <review-list .reviews=${this.menu.reviews}></review-list>
              <button class="btn-more">더보기</button>
            </div>
          </div>
          <!-- //주문자리뷰 -->
        </div>
        <!-- // 주문자리뷰영역 -->
        <!-- 옵션팝업영역 -->
        <option-popup
          .menu=${this.menu}
          menuAmount=${this.menuAmount}
          .onAddCartItem=${this.onAddCartItem}
          .isPopupOpen=${this.isPopupOpen}
          .onPopupClose=${this.closeOrderPopup.bind(this)}
          .onIncreaseAmount=${this.increaseAmount.bind(this)}
          .onDecreaseAmount=${this.decreaseAmount.bind(this)}
        ></option-popup>
      </div>
    `;
  }
}
