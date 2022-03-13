import { requestGetPost } from "./requests/posts.js";

const $title = document.querySelector(".title");
const $content = document.querySelector(".post-content");
const $coverImage = document.querySelector(".cover-image");
const $profileImage = document.querySelector(".profile-image");
const $profileDetailNickname = document.querySelector(
  ".profile-detail-nickname"
);

const postId = new URLSearchParams(window.location.search).get("id");

requestGetPost(postId).then((post) => {
  $title.innerText = post.title;
  $content.innerText = post.content;
  $coverImage.src = post.image;
  $profileImage.src = post.authorImage;
  $profileDetailNickname.innerText = post.author;
});
