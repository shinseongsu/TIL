(function () {
  "use strict";

  let timerId;

  const get = (target) => {
    return document.querySelector(target);
  };

  const $progressBar = get(".progress-bar");

  const throttle = (callback, time) => {
    if (timerId) return;
    timerId = setTimeout(() => {
      callback();
      timerId = undefined;
    }, time);
  };

  const onScroll = () => {
    const scrollTop = document.documentElement.scrollTop;
    const height =
      document.documentElement.scrollHeight -
      document.documentElement.clientHeight;
    const scrollWidth = (scrollTop / height) * 100;
    $progressBar.style.width = scrollWidth + "%";
  };

  window.addEventListener("scroll", () => {
    throttle(onScroll, 100);
  });
})();
