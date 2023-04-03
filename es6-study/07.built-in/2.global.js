console.log(globalThis);
console.log(this);
console.log(Infinity);
console.log(NaN);
console.log(undefined);

eval("const num = 2; console.log(num);"); // 2
console.log(isFinite(1));
console.log(isFinite(Infinity));

console.log(parseFloat("12.43"));
console.log(parseInt("12.43")); // 12

// URL
const URL = "https://드림코딩.com";
const encoded = encodeURI(URL); // https://%EB%93%9C%EB%A6%BC%EC%BD%94%EB%94%A9.com
console.log(encoded);
const decoded = decodeURI(encoded);
console.log(decoded);

const part = "드림코딩.com";
console.log(encodeURIComponent(part)); // %EB%93%9C%EB%A6%BC%EC%BD%94%EB%94%A9.com
