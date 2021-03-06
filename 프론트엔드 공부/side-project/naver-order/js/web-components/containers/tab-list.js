import { html } from "lit-html";
import TabListItem from "../templates/tab-list-item";
import View from "../view";

const TABS = [
  {
    text: html`๐&nbsp;&nbsp;ํฌ์ฅ`,
    imageUrl: "/assets/images/ico-check.svg",
  },
  {
    text: html`๐ฝ&nbsp;&nbsp;๋งค์ฅ`,
    imageUrl: "/assets/images/ico-check.svg",
  },
  {
    text: html`๐ต&nbsp;&nbsp;๋ฐฐ๋ฌ`,
    imageUrl: "/assets/images/ico-check.svg",
  },
];

export default class TabList extends View {
  constructor(tabIndex = 0, onTabChange) {
    super();
    this.tabIndex = tabIndex;
    this.onTabChange = onTabChange;
  }

  static get properties() {
    return {
      tabIndex: { type: Number },
      onTabChange: { type: Function },
    };
  }

  render() {
    return html`
      <div class="tab-switch-box" role="tablist">
        ${TABS.map((tab, index) =>
          TabListItem({
            text: tab.text,
            imageUrl: tab.imageUrl,
            isActive: index === this.tabIndex,
            onClick: () => this.onTabChange(index),
          })
        )}
      </div>
    `;
  }
}
