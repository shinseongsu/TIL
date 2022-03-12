import { html } from "lit-element";
import View from "../view";

export default class ReviewList extends View {
  constructor(reviews = []) {
    super();
    this.reviews = reviews;
  }

  static get properties() {
    return {
      reviews: {
        type: Array,
      },
    };
  }

  render() {
    return html`
      <ul class="review-list">
        ${this.reviews.map(
          (review) => html`
            <li class="review-item">
              <div class="review-star">
                <span class="ico-star-group">
                  <span class="ico-star-group-fill" style="width: 90%;"></span>
                </span>
                <span class="point">${review.reviewPoint}</span>
              </div>
              <p class="review-text">${review.content}</p>
              <div class="review-info">
                <span class="review-nickname">${review.reviewerId}</span>
                <span class="review-date">${review.orderDate} 주문</span>
              </div>
            </li>
          `
        )}
      </ul>
    `;
  }
}
