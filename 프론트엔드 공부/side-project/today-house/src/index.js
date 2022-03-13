import "./utils/number-format.js";

const $sidebarToggle = document.querySelector(".side-bar-toggle");
const $sidebar = document.querySelector(".side-bar");
const $backDrop = document.querySelector(".back-drop");

$sidebarToggle.addEventListener("click", () => {
  $sidebar.classList.toggle("open");
  $backDrop.style.display = "block";
});

$backDrop.addEventListener("click", () => {
  $sidebar.classList.toggle("open");
  $backDrop.style.display = "none";
});
