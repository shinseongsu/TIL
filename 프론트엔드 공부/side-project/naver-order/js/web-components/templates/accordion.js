import { html } from "lit-element";

const Accordion = ({ count, onDecrease, onIncrease }) => {
  return html`
    <div class="amount-select">
      <button class="btn-minus" aria-label="빼기" @click=${onDecrease}></button>
      <span class="amount">${count}</span>
      <button
        class="btn-plus enabled"
        aria-label="더하기"
        @click=${onIncrease}
      ></button>
    </div>
  `;
};

export default Accordion;
