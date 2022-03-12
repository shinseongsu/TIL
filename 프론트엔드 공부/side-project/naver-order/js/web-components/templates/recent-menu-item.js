import { html } from "lit-element";
import { getKoreanMoneyString } from "../../utils/currency";

const placeholderImageUrl = "https://via.placeholder.com/80";

const RecentMenuItem = ({
  name,
  imageUrl = placeholderImageUrl,
  price,
  isPopular,
  onClick,
}) => {
  return html`
    <li class="recent-menu-item is-ordered" @click=${onClick}>
      <a>
        <div class="menu-img-area">
          ${isPopular ? '<span class="badge-popular">인기</span>' : ""}
          <img class="menu-img" src="${imageUrl}" alt="메뉴사진" />
        </div>
        <p class="menu-name">${name}</p>
        <p class="menu-price">${getKoreanMoneyString(price)}원</p>
      </a>
      <a class="badge-cart">
        <img
          src="/assets/images/ico-cart.svg"
          alt="주문하기"
          class="ico-cart"
        />
      </a>
    </li>
  `;
};

export default RecentMenuItem;
