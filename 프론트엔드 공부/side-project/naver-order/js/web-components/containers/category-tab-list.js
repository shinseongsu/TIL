import { html } from "lit-html";
import View from "../view";

export default class CategoryTabList extends View {
  constructor(selectedCategory, items = [], onItemClick) {
    super();
    this.selectedCategory = selectedCategory;
    this.items = items;
    this.onItemClick = onItemClick;
  }

  static get properties() {
    return {
      selectedCategory: {
        type: String,
      },
      items: {
        type: Array,
      },
      onItemClick: {
        type: Function,
      },
    };
  }

  render() {
    return html`
      <ul class="category-list scroll-x">
        ${this.items.map((item) => {
          return html`
            <li class="category-item">
              <a
                @click=${() => this.onItemClick(item.category)}
                href="#${item.category}"
                class="category-tab ${this.selectedCategory === item.category
                  ? "is-active"
                  : ""}"
                >${item.categoryName}</a
              >
            </li>
          `;
        })}
      </ul>
    `;
  }
}
