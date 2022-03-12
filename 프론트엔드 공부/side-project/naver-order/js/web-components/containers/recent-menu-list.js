import { html } from "lit-html";
import RecentMenuItem from "../templates/recent-menu-item";
import View from "../view";

export default class RecentMenuList extends View {
  constructor(items = [], onItemClick) {
    super();
    this.items = items;
    this.onItemClick = onItemClick;
  }

  static get properties() {
    return {
      onItemClick: { type: Function },
      items: { type: Array },
    };
  }

  render() {
    return html`
      <ul class="recent-menu-list">
        ${this.items.map((item) =>
          RecentMenuItem({
            ...item,
            onClick: () => this.onItemClick(item.id),
          })
        )}
      </ul>
    `;
  }
}
