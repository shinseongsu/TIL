import { html } from "lit-element";

const TabListItem = ({ text, imageUrl, isActive, onClick }) => {
  return html`
    <a
      href="#"
      class="tab-switch ${isActive ? "is-active" : ""}"
      role="tab"
      @click=${onClick}
    >
      ${text}
      <img
        src="${imageUrl}"
        alt="${text}"
        class="ico-check"
        aria-hidden="${isActive}"
      />
    </a>
  `;
};

export default TabListItem;
