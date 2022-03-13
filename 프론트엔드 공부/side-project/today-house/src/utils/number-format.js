const numberFormat = (inputNumber) => {
  return inputNumber.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
};

const prices = document.getElementsByClassName("price");
const reviewCounts = document.getElementsByClassName("review-count");

for (const price of prices) {
  price.innerText = numberFormat(price.innerText);
}

for (const count of reviewCounts) {
  count.innerText = numberFormat(count.innerText);
}
