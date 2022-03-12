import { html } from "lit-element";
import View from "../view";

export default class ToppingAmountOptionGroup extends View {
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
      onToggleOption: {
        type: Function,
      },
    };
  }

  render() {
    return html`
      <div class="option-group">
        <div class="option-title">
          <p class="title">
            <span class="badge required">필수</span>
            <span class="text">베이스 선택</span>
          </p>
        </div>
        <ul class="option-list">
          ${this.items.map(
            (item) => html`
              <li class="option-item">
                <input
                  type="radio"
                  id="${item.name}"
                  class="input-radio"
                  name="base"
                  @click=${() => this.onToggleOption(item.name)}
                  .checked="${item.isSelected}"
                />
                <label for="${item.name}" class="label">
                  <span class="label-txt">${item.name}</span>
                  <span class="label-icon"></span>
                </label>
              </li>
            `
          )}
        </ul>
      </div>
    </div>
    `;
  }
}
