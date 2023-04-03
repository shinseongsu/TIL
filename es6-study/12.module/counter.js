export let count = 0;
export function increase() {
  count++;
  console.log(count);
}

export function getCount() {
  return count;
}
