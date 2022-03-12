import { html } from "lit-element";
import { getKoreanMoneyString } from "../../utils/currency";
import View from "../view";

export default class ToppingSelectOptionGroup extends View {
  constructor(items = [], onToggleOption) {
    super();
    this.items = items;
    this.onToggleOption = onToggleOption;
  }

  static get properties() {
    return {
      items: {
        type: Array,
      },
      onToggleOptionItem: {
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
          ${this.items.map((item) => {
            return html`
              <li class="option-item">
                <input
                  type="checkbox"
                  id="${item.name}"
                  class="input-check"
                  .checked="${item.isSelected}"
                  @click=${() => this.onToggleOption(item.name)}
                />
                <label for="${item.name}" class="label">
                  <span class="label-txt">
                    ${item.name}
                    <span class="price"
                      >+${getKoreanMoneyString(item.price)}원</span
                    >
                  </span>
                  <span class="label-icon"></span>
                </label>
              </li>
            `;
          })}
        </ul>
      </div>
    `;
  }
}
