import { html } from "lit-html";
import { getKoreanMoneyString } from "../../utils/currency";
import { ORDER_TYPE_HEADING, ORDER_TYPE_MESSAGE } from "../constants/constants";
import View from "../view";

const ACCORDION_ITEMS = [
  {
    title: "개인정보 수집 동의",
    content: `(1) 고객의 개인정보는 회원탈퇴 등 수집 및 이용목적이 달성되거나 동의철회 요청이 있는 경우 지체없이 파기됩니다. 단,「전자상거래 등에서의 소비자보호에 관한 법률」 등 관련법령의 규정에 의하여 다음과 같이 거래 관련 권리 의무 관계의 확인 등을 이유로 일정기간 보유하여야 할 필요가 있을 경우에는 그 기간동안 보유합니다. 가. 「전자상거래 등에서의 소비자보호에 관한 법률」 제6조 - 계약 또는 청약 철회 등에 관한 기록 : 5년 - 대금결재 및 재화 등의 공급에 관한 기록 : 5년 - 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년 나. 「통신비밀보호법」 제15조의2 - 방문(로그)에 관한 기록: 1년 다. 기타 관련 법령 등 
      
    (2) 회사의 개인정보 파기방법은 다음과 같습니다. 가. 파기 절차 ① 회원가입 등을 위해 입력한 정보는 목적이 달성된 후 별도의 DB로 옮겨져(종이의 경우 별도의 서류함 내부 방침 및 기타 관련 법령에 의한 일정기간 저장된 후 파기됩니다. ② 동 개인정보는 법률에 의한 경우가 아니고서는 보유되는 이외의 다른 목적으로 이용되지 않습니다. 나. 파기 방법 ① 종이에 출력된 개인정보는 분쇄기로 분쇄하거나 소각을 통하여 파기합니다. ② 전자적 파일 형태로 저장된 개인정보는 기록을 재생할 수 없는 기술적 방법을 사용하여 삭제합니다. 
        
    (3) 회사는 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」 제29조 제2항에 따라 휴면회원(최근 12개월 동안 서비스를 이용하지 아니한 회원)에 대해 회원자격 상실에 대한 안내문을 통지하고, 안내문에서 정한 기한 내에 답변이 없을 경우 회원자격을 상실시킬 수 있습니다. 이 경우, 휴면회원의 개인정보는 다른 회원의 개인정보와 분리하여 별도로 저장·관리 되며, 분리 저장된 개인정보는 법정보관기간 경과 후 파기하고 있습니다. 파기되지 않은 개인 정보 중 해당 이용자의 요청이 있는 경우 고객 정보는 서비스 이용을 재개하는 시점에 다시 제공됩니다.`,
  },
  {
    title: "개인정보 제공 동의",
    content: `(1) 회사는 고객의 개인정보를 '제1조 개인정보의 수집항목 및 이용목적'에서 고지한 범위를 넘어 이용하거나 타인 또는 타기업, 기관에 제공하지 않습니다. 
      
      (2) 다음은 예외로 합니다. 
      
      가. 관계법령에 의하여 수사상의 목적으로 관계기관으로부터의 요구가 있을 경우 
      나. 통계작성, 학술연구나 시장조사 등을 위하여 특정 개인을 식별할 수 없는 형태로 광고주, 협력사나 연구단체 등에 제공하는 경우 
      다. 기타 관계법령에서 정한 절차에 따른 요청이 있는 경우 상기사항에 의해 개인정보를 제공하는 경우에도 본래의 수집∙이용 목적에 반하여 무분별하게 정보가 제공되지 않도록 최대한 노력하겠습니다.
    `,
  },
  {
    title: "주문취소 및 환불 유의사항",
    content:
      "구분 수집시기 필수/선택 수집항목 이용목적 보유기간 회원 가입시 필수 아이디 비밀번호 비밀번호 확인 질문,답변 이메일, 회원인증값(모바일인증) 회원인증을 통한 이름,생년월일 만 14세 이상 여부 회원가입시 본인여부 확인, 서비스 이용 및 상담, 공지사항 전달 회원탈퇴시 또는 법정 의무 보유기간 선택 주소 일반전화 휴대전화 주문시 필수 주문자 정보(이름,주소,휴대전화,이메일) 수취자 정보(이름,주소,휴대전화) 결제 승인정보 주문상품의 결제 및 배송 선택 주문자 일반전화 수취자 일반전화 배송 메시지 해외배송 여부 비회원 주문시 필수 주문자 정보(이름,주소,휴대전화,이메일,주문조회 비밀번호 ,비밀번호 확인) 수취자 정보(이름,주소,휴대전화) 결제 승인정보 주문상품의 결제 및 배송 법정 의무 보유기간 선택 주문자 일반전화 수취자 일반전화 배송메세지 해외배송여부 ※ 회사는 이 외에 고객님이 이용한 서면, 문자, 게시판, 메신저 등 다양한 상담채널별 문의와 이벤트 응모시 수집 항목, 목적, 보유기간에 대한 별도 동의를 받아 개인정보를 수집할 수 있습니다. ※ 회사는 이 법 또는 다른 법률에 특별한 규정이 있는 경우 개인정보를 수집 이용할 수 있습니다.",
  },
];

export default class OrderPage extends View {
  constructor(
    cartItems = [],
    orderTypeIndex,
    onDeleteCartItem,
    onResetCartItems
  ) {
    super();

    this.cartItems = cartItems;
    this.onDeleteCartItem = onDeleteCartItem;
    this.onResetCartItems = onResetCartItems;
    this.orderTypeIndex = orderTypeIndex;

    this.requestText = "";
    this.contactText = "";
    this.isModalOpen = false;
    this.needDisposable = true;
  }

  static get properties() {
    return {
      cartItems: {
        type: Array,
      },
      orderTypeIndex: {
        type: Number,
      },
      onDeleteCartItem: {
        type: Function,
      },
      needDisposable: {
        type: Boolean,
      },
      isModalOpen: {
        type: Boolean,
      },
    };
  }

  handleRequestTextChange(event) {
    const { value } = event.target;
    this.requestText = value;
  }

  handleContactTextChange(event) {
    const { value } = event.target;
    this.contactText = value;
  }

  setNeedDisposal(needDisposable) {
    this.needDisposable = needDisposable;
  }

  moveToMenuPage() {
    history.pushState(null, null, "/");
    dispatchEvent(new PopStateEvent("popstate"));
  }

  increaseOrderAmount(menuId) {
    const newCartItems = [...this.cartItems];
    const target = newCartItems.find((cartItem) => cartItem.menu.id === menuId);
    target.amount += 1;

    this.cartItems = newCartItems;
  }

  decreaseOrderAmount(menuId) {
    const newCartItems = [...this.cartItems];
    const target = newCartItems.find((cartItem) => cartItem.menu.id === menuId);
    if (target.amount <= 1) {
      return;
    }

    target.amount -= 1;

    this.cartItems = newCartItems;
  }

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
  }

  order() {
    this.onResetCartItems();
    this.moveToMenuPage();
  }

  render() {
    const canOrderMenu =
      this.cartItems.length !== 0 && this.contactText.trim() !== "";

    const cartItemsTotalPrice = this.cartItems.reduce(
      (acc, item) => acc + item.menu.price * item.amount,
      0
    );

    return html`
      <div class="container order">
        <div class="order-form-area">
          <!-- 주문서 타이틀 -->
          <div class="page-title-area">
            <p class="title">주문서</p>
            <button class="btn-close">
              <img
                src="/assets/images/ico-close-white.svg"
                alt="닫기"
                class="ico-close"
                @click=${this.moveToMenuPage}
              />
            </button>
          </div>
          <!-- // 주문서 타이틀 -->

          <!-- 주문서 메뉴 -->
          <div class="order-content">
            <div class="common-inner">
              <div class="order-content-top">
                <p class="title">
                  ${ORDER_TYPE_HEADING[this.orderTypeIndex]}
                  <svg
                    width="18"
                    height="18"
                    viewBox="0 0 12 12"
                    class="ico-takeout"
                  >
                    <path
                      fill="currentColor"
                      fill-rule="evenodd"
                      d="M3.558 3.997a21.21 21.21 0 00-.014.682 1.194 1.194 0 101.495 1.155c0-.42-.223-.811-.582-1.025.005-.372.012-.645.018-.77.01-.186.022-.37.037-.548h2.976c.016.175.028.358.038.546.006.125.013.398.018.772a1.194 1.194 0 00.611 2.218 1.194 1.194 0 00.304-2.348c-.003-.218-.007-.49-.01-.573-.011-.228-.024-.43-.039-.615h2.102c.346 0 .629.275.629.612a.628.628 0 01-.01.102l-.782 6.443a.623.623 0 01-.62.512H2.3a.622.622 0 01-.619-.51L.869 4.203a.595.595 0 01.104-.449.627.627 0 01.516-.263h2.102c-.013.153-.023.32-.033.506zm1.058-1.345C4.774 1.708 5.057.844 6 .844c.942 0 1.226.864 1.384 1.808h-2.77zm5.896 0H8.314C8.03.768 7.357 0 6.001 0 4.64 0 3.969.768 3.686 2.652H1.489c-.081 0-.164.006-.244.02-.4.065-.746.278-.978.602-.223.313-.31.691-.246 1.066l.811 6.447C.952 11.49 1.57 12 2.3 12h7.43c.73 0 1.346-.509 1.467-1.214l.782-6.443c.015-.078.021-.159.021-.24 0-.8-.667-1.45-1.488-1.45z"
                    ></path>
                  </svg>
                </p>
                <p class="desc">${ORDER_TYPE_MESSAGE[this.orderTypeIndex]}</p>
                <p class="count">담은 메뉴: ${this.cartItems.length}개</p>
              </div>
              <div class="order-content-body">
                ${this.cartItems.length === 0
                  ? html`
                      <!-- 담은 메뉴 없음 -->
                      <div class="no-order">
                        <img
                          class="icon"
                          src="/assets/images/ico-exclaim.svg"
                          alt=""
                          aria-hidden="true"
                        />
                        <p class="txt">담은 메뉴가 없습니다.</p>
                      </div>
                      <!-- // 담은 메뉴 없음 -->
                    `
                  : html`
                      <!-- 담은 메뉴 있음 -->
                      <order-select-list
                        .items=${this.cartItems}
                        .onDeleteCartItem=${this.onDeleteCartItem}
                        .onIncreaseOrderAmount=${this.increaseOrderAmount.bind(
                          this
                        )}
                        .onDecreaseOrderAmount=${this.decreaseOrderAmount.bind(
                          this
                        )}
                      ></order-select-list>
                      <div class="order-total">
                        <span class="total-txt">총 주문금액</span>
                        <span class="total-price"
                          >${getKoreanMoneyString(cartItemsTotalPrice)}원</span
                        >
                      </div>
                      <!-- // 담은 메뉴 있음 -->
                    `}
              </div>
            </div>

            <a class="btn-menu-add" @click=${this.moveToMenuPage}
              ><i class="ico-add"></i>메뉴추가</a
            >
          </div>
          <!-- // 주문서 메뉴 -->

          <!-- 주문자 정보 -->
          <div class="order-content-extra">
            <div class="common-inner">
              <div class="orderer-info-area">
                <p class="title">주문자 정보</p>
                <ul class="info-list">
                  <li class="info-item">
                    <p class="info-title">일회용 수저, 포크</p>
                    <div class="option-group">
                      <div class="option-item">
                        <input
                          type="radio"
                          id="need"
                          class="input-radio"
                          name="disposables"
                          .checked=${this.needDisposable}
                          @click=${() => this.setNeedDisposal(true)}
                        />
                        <label for="need" class="input-radio-button need"
                          >필요해요</label
                        >
                      </div>
                      <div class="option-item">
                        <input
                          type="radio"
                          id="no-need"
                          class="input-radio"
                          name="disposables"
                          .checked=${!this.needDisposable}
                          @click=${() => this.setNeedDisposal(false)}
                        />
                        <label for="no-need" class="input-radio-button no-need"
                          >필요 없어요</label
                        >
                      </div>
                    </div>
                  </li>
                  <li class="info-item">
                    <p class="info-title">요청사항</p>
                    <input
                      type="text"
                      placeholder="(선택) 요청사항을 입력해 주세요."
                      class="input-text"
                      value=${this.requestText}
                      @change=${this.handleRequestTextChange.bind(this)}
                    />
                  </li>
                  <li class="info-item">
                    <p class="info-title">
                      주문자 연락처<span class="fw700 color-point">(필수)</span>
                    </p>
                    <input
                      type="text"
                      placeholder="연락처를 입력해 주세요."
                      class="input-text"
                      required
                      value=${this.contactText}
                      @change=${this.handleContactTextChange.bind(this)}
                    />
                  </li>
                </ul>
              </div>
              <div class="place-map-area">
                <p class="title">주문 매장 위치</p>
                <div class="map-area">
                  <div class="place-address-box">
                    <p class="place-name">샐러드 제로베이스점</p>
                    <p class="place-address">서울시 강남구 역삼동 123-4</p>
                    <p class="place-address-detail">
                      역삼역 8번 출구로 나와서 직진 410m
                    </p>
                  </div>
                  <img src="/assets/images/map.png" alt="" class="img-map" />
                </div>
              </div>

              <div class="agreement-area">
                <p class="title">개인정보 수집, 제공</p>

                <accordion-list .items=${ACCORDION_ITEMS}></accordion-list>

                <p class="agreement-info-txt">
                  주문 서비스 이용을 위한 개인정보 수집 및 제3자 제공, 취소/환불
                  규정을 확인하였으며 이에 동의합니다.
                </p>
              </div>
            </div>
          </div>
          <!-- // 주문자 정보 -->

          <!-- 주문하기 버튼 -->
          <div class="btn-order-area">
            <button class="btn-order" @click=${this.openModal}>
              <svg
                viewBox="0 0 18 18"
                width="18"
                height="18"
                class="ico-n-logo"
              >
                <path
                  fill-rule="evenodd"
                  fill="currentColor"
                  d="M18 0v18H0V0h18zM7.255 4.582H4.473v9.054h2.915V8.79l3.357 4.846h2.782V4.582h-2.915v4.846L7.255 4.582z"
                ></path>
              </svg>
              주문하기
            </button>
          </div>
          <!-- // 주문하기 버튼 -->

          <!-- 맨위로 -->
          <div class="go-to-top">
            <a href="#" class="link">Top<i class="ico-up"></i></a>
          </div>
          <!-- // 맨위로 -->
        </div>

        <!-- 모달 -->
        <div class="modal-wrapper ${this.isModalOpen ? "" : "hidden"}">
          <div class="dimmed-layer light"></div>
          <div class="modal-container">
            <div class="modal-content">
              <button class="btn-close" onClick="modalClose()">
                <svg
                  width="16"
                  height="16"
                  viewBox="0 0 16 16"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path d="M2 2L14 14" stroke="#999" stroke-width="1.5" />
                  <path d="M2 14L14 2" stroke="#999" stroke-width="1.5" />
                </svg>
              </button>
              <div class="modal-icon">
                <svg viewBox="0 0 32 32" width="38" height="38">
                  <path
                    fill="currentColor"
                    d="M15,8H17c0.6,0,1-0.4,1-1s-0.4-1-1-1H15c-0.6,0-1,0.4-1,1S14.4,8,15,8z"
                  />
                  <path
                    fill="currentColor"
                    d="M29.9,20.5C29.7,20.2,29.3,20,29,20h-1.1c-0.5-4.4-4.1-8.8-8.7-10.2c-2.1-0.7-4.4-0.7-6.5,0C8.2,11.2,4.5,15.6,4.1,20H3   c-0.3,0-0.7,0.2-0.9,0.5s-0.2,0.7,0,1C3.5,24.3,6.3,26,9.5,26h13.1c3.1,0,6-1.7,7.4-4.6C30,21.1,30,20.8,29.9,20.5z M13.3,11.7   c1.7-0.5,3.6-0.5,5.3,0c3.7,1.1,6.8,4.7,7.3,8.3H6.1C6.6,16.4,9.6,12.9,13.3,11.7z M22.5,24H9.5c-1.8,0-3.4-0.7-4.6-2h22.2   C25.9,23.3,24.3,24,22.5,24z"
                  />
                </svg>
              </div>
              <h1 class="modal-title">주문 완료</h1>
              <p class="modal-desc">주문이 완료되었습니다.</p>
            </div>
            <div class="btn-area">
              <button class="btn-cancel" @click="${this.closeModal}">
                취소
              </button>
              <button class="btn-confirm" @click="${this.order}">확인</button>
            </div>
          </div>
        </div>
        <!-- // 모달 -->
      </div>
    `;
  }
}
