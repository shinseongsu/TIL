import { html } from "lit-element";
import { getKoreanMoneyString } from "../../utils/currency";
import SpinButton from "../templates/spin-button";
import View from "../view";

export default class ToppingBaseOptionGroup extends View {
  constructor(items = [], onItemAmountIncrease, onItemAmountDecrease) {
    super();
    this.items = items;
    this.onItemAmountIncrease = onItemAmountIncrease;
    this.onItemAmountDecrease = onItemAmountDecrease;
  }

  static get properties() {
    return {
      items: {
        type: Array,
      },
      onItemAmountIncrease: {
        type: Function,
      },
      onItemAmountDecrease: {
        type: Function,
      },
    };
  }

  render() {
    return html`
      <div class="option-group">
        <div class="option-title">
          <p class="title">
            <span class="badge">선택</span>
            <span class="text">토핑추가</span>
          </p>
          <p class="desc">최대 5개까지 선택할 수 있습니다.</p>
        </div>
        <ul class="option-list">
          ${this.items.map(
            (item) => html`
              <li class="option-item">
                <label class="label checked">
                  <span class="label-txt"
                    >${item.name}
                    <span class="price"
                      >+${getKoreanMoneyString(item.price)}원</span
                    ></span
                  >
                </label>
                ${SpinButton({
                  count: item.amount,
                  onDecrease: () => this.onItemAmountDecrease(item.name),
                  onIncrease: () => this.onItemAmountIncrease(item.name),
                })}
              </li>
            `
          )}
        </ul>
      </div>
    </div>
    `;
  }
}
