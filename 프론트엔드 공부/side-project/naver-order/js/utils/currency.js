export const getKoreanMoneyString = (amount) => {
  if (!Number.isInteger(amount)) {
    return;
  }

  return amount.toLocaleString("ko-KR");
};
