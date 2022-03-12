import { html } from "lit-element";
import View from "../view";

export default class AccordionList extends View {
  constructor(items = []) {
    super();

    this.items = items.map((item) => ({ ...item, isOpen: false }));
  }

  static get properties() {
    return {
      items: {
        type: Array,
      },
    };
  }

  toggleAccordion(title) {
    const newItems = [...this.items];
    const target = newItems.find((item) => item.title === title);
    target.isOpen = !target.isOpen;

    this.items = newItems;
  }

  render() {
    return html`
      <ul class="agreement-list">
        ${this.items.map(
          (item) => html`
            <li class="agreement-item ${item.isOpen ? "is-open" : ""}">
              <div class="agreement-title">
                <span class="txt">${item.title}</span>
                <button
                  class="btn-toggle"
                  @click=${() => this.toggleAccordion(item.title)}
                >
                  <img src="/assets/images/ico-arrow-gray.svg" alt="" />
                </button>
              </div>
              <div class="agreement-content">${item.content}</div>
            </li>
          `
        )}
      </ul>
    `;
  }
}
